package mk.ukim.finki.lab.model;

import lombok.Data;

@Data
public class TicketOrder {
    private Long id;
    private String movieTitle;
    private String clientName;
    private Long numberOfTickets;

    public TicketOrder(String movieTitle, String clientName, Long numberOfTickets) {
        id = (long)(Math.random()*1000);
        this.movieTitle = movieTitle;
        this.clientName = clientName;
        this.numberOfTickets = numberOfTickets;
    }
}
