package az.kapitalbank.kapitalbank.demo.repository;

import az.kapitalbank.kapitalbank.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
