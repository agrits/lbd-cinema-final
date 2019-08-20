package pl.fis.java.lbdcinemafinal.cinema_service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.fis.java.lbdcinemafinal.cinema_service.entities.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long>
{

}
