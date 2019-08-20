package pl.fis.java.cinemaservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.cinemaservice.entities.Location;


@Repository
public interface LocationRepository extends CrudRepository<Location, Long>
{

}
