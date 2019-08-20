package pl.fis.java.lbdcinemafinal.reservation_service.entity.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.reservation_service.entity.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
