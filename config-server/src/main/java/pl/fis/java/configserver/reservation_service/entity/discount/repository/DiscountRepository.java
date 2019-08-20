package pl.fis.java.lbdcinemafinal.reservation_service.entity.discount.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pl.fis.java.lbdcinemafinal.reservation_service.entity.discount.model.Discount;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {
}
