package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Long> {
}
