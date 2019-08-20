package pl.fis.java.lbdcinemafinal.cinema_service.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.fis.java.lbdcinemafinal.cinema_service.entities.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long>
{

}
