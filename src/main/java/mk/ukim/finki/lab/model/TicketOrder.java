package mk.ukim.finki.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
public class TicketOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String movieTitle;
    private Long numberOfTickets;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreated;
    private Double price;
    @ManyToOne
    private Discount discount;
    public TicketOrder(){

    }

    public TicketOrder(String movieTitle, Long numberOfTickets, User user, LocalDateTime dateCreated) {
        this.movieTitle = movieTitle;
        this.numberOfTickets = numberOfTickets;
        this.user = user;
        this.dateCreated = dateCreated;
    }
}
