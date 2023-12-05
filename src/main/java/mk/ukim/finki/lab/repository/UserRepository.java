package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
