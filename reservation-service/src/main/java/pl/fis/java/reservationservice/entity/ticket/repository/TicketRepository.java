package pl.fis.java.reservationservice.entity.ticket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.fis.java.reservationservice.entity.reservation.model.Reservation;
import pl.fis.java.reservationservice.entity.ticket.model.Ticket;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Optional<Set<Ticket>> findAllByReservationId(long reservationId);
}
