package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketOrderRepository extends JpaRepository<TicketOrder, Long> {
    List<TicketOrder> findByMovieTitleLike(String text);
    List<TicketOrder> findByUserUsernameLike(String text);
    List<TicketOrder> findByDateCreatedBetween(LocalDateTime from, LocalDateTime to);
}
