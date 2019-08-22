package pl.fis.java.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.fis.java.userservice.entity.CinemaUser;

import java.util.Optional;

@Repository
public interface CinemaUserRepository extends CrudRepository<CinemaUser, Long> {
    boolean existsByEmail(String email);
    Optional<CinemaUser> findByEmail(String email);
}
