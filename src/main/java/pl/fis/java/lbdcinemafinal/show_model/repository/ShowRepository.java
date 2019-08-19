package pl.fis.java.lbdcinemafinal.show_model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.show_model.entity.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long> {
}
