package mk.ukim.finki.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="shoppingcarts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreated;
    @OneToMany
    @JoinColumn(name = "ticketorders_carts")
    private List<TicketOrder> ticketOrders;

    public ShoppingCart(){

    }
    public ShoppingCart(User user, LocalDateTime dateCreated, List<TicketOrder> ticketOrders) {
        this.user = user;
        this.dateCreated = dateCreated;
        this.ticketOrders = ticketOrders;
    }
}
