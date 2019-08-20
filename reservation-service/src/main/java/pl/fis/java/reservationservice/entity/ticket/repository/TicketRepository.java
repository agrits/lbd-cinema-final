package pl.fis.java.reservationservice.entity.ticket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.fis.java.reservationservice.entity.ticket.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
