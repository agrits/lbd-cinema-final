package pl.fis.java.lbdcinemafinal.cinema_service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.fis.java.lbdcinemafinal.cinema_service.entities.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, Long>
{

}
