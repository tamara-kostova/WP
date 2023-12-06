package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
