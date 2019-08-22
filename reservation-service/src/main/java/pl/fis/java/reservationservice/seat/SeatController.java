package pl.fis.java.reservationservice.seat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.fis.java.reservationservice.entity.discount.repository.DiscountRepository;
import pl.fis.java.reservationservice.entity.reservation.model.Reservation;
import pl.fis.java.reservationservice.entity.reservation.repository.ReservationRepository;
import pl.fis.java.reservationservice.entity.ticket.repository.TicketRepository;
import pl.fis.java.reservationservice.mock.DumpService;
import pl.fis.java.reservationservice.seat.dto.Hall;
import pl.fis.java.reservationservice.seat.dto.Seat;
import pl.fis.java.reservationservice.seat.dto.Show;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/seats")
@Transactional
public class SeatController {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    DumpService dumpService;

    private void doDumpIfRepoEmpty() {
        boolean reservationRepoEmpty = StreamSupport
                .stream(reservationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()).isEmpty();

        boolean discountRepoEmpty = StreamSupport
                .stream(discountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()).isEmpty();

        boolean ticketRepoEmpty = StreamSupport
                .stream(ticketRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()).isEmpty();

        if (reservationRepoEmpty || discountRepoEmpty || ticketRepoEmpty)
            dumpService.dump();
    }



    @GetMapping(value = "/for-show/{show_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seat>> getSeatsByShowId(@PathVariable(name = "show_id") Long showId) {

        List<Seat> results = new ArrayList<>();

        Seat seat;



        final String showsResourceUri = "http://localhost:3000/shows" + "/" + showId.toString();

        final String seatsResourceUri = "http://localhost:3000/seats";

        RestTemplate restTemplate = new RestTemplate();

        final Logger logger = Logger.getLogger("SeatController");

        //all reserved seatIds for the given show
        List<Long> reservedSeatids = ticketRepository.findAllReservedSeatsForShow(showId);

        ResponseEntity<Show> show = restTemplate.getForEntity(showsResourceUri, Show.class);

        if (!Optional.ofNullable(show.getBody()).isPresent()) {
            return new ResponseEntity<>(results, HttpStatus.OK);
        }

        Long hallId = show.getBody().getHallId();

        //get all seats
        ResponseEntity<List<Seat>> allSeats = restTemplate.exchange(
                seatsResourceUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Seat>>() {
                }
        );

        //get all seats assigned to the given hall
        List<Seat> allSeatsForHall = allSeats.getBody()
                .stream()
                .filter(seat -> hallId.equals(seat.getHall().getId()))
                .collect(Collectors.toList());


        for (Seat seat : allSeatsForHall) {

            seat.setAvailable(false);
            reservedSeatids
                    .stream()
                    .filter(id -> seat.equals(id))
                    .findAny()
                    .ifPresentOrElse(id -> seat.setAvailable(false), () -> seat.setAvailable(true));
        }

        results.addAll(allSeatsForHall);


        return new ResponseEntity<>(results, HttpStatus.OK);

    }
}
