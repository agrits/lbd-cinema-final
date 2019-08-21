package pl.fis.java.reservationservice.seat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.fis.java.reservationservice.entity.reservation.model.Reservation;
import pl.fis.java.reservationservice.entity.reservation.repository.ReservationRepository;
import pl.fis.java.reservationservice.entity.ticket.model.Ticket;
import pl.fis.java.reservationservice.mock.DumpService;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
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
    DumpService dumpService;

    @GetMapping(value = "/for-show/{show_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Seat>> getSeatsByShowId(@PathVariable(name = "show_id") Long showId) {

        List<Seat> results = null;

        final String showsResourceUri = "http://localhost:3000/shows";
        final String hallsResourceUri = "http://localhost:3000/halls";
        final String seatsResourceUri = "http://localhost:3000/seats";
        final String reservationResourceUri = "http://localhost:3000/reservations";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Reservation>> response = restTemplate.exchange(
                reservationResourceUri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reservation>>(){}
        );

//
//        //find all reservations assigned to the given show
//        List<Reservation> reservations = StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
//                .filter(reservation -> reservation.getShowId().equals(showId))
//                .collect(Collectors.toList());
//
//        //get all tickets from reservations
//        List<Ticket> tickets = new LinkedList<>();
//        reservations.forEach(reservation -> tickets.addAll(reservation.getTickets()));
//
//        //map seatIds from tickets
//        List<Long> reservedSeatIds = tickets
//                .stream()
//                .map(ticket -> ticket.getSeatId())
//                .collect(Collectors.toList());

        dumpService.dump();

        return new ResponseEntity<>(results, HttpStatus.OK);

    }
}