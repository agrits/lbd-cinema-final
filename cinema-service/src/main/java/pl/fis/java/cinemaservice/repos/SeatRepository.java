package pl.fis.java.cinemaservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.cinemaservice.entities.Seat;


@Repository
public interface SeatRepository extends CrudRepository<Seat, Long>
{

}
