package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserUsername(String username);
}
