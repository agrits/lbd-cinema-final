package pl.fis.java.cinemaservice.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.cinemaservice.entities.Hall;


@Repository
public interface HallRepository extends CrudRepository<Hall, Long>
{

}
