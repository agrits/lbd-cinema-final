package pl.fis.java.lbdcinemafinal.movie_model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.movie_model.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
