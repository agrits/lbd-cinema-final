package pl.fis.java.lbdcinemafinal.reservation_service.entity.ticket.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.reservation_service.entity.ticket.model.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
