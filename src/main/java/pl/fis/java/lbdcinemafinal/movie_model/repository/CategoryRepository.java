package pl.fis.java.lbdcinemafinal.movie_model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.movie_model.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
