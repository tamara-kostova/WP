package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.stereotype.Service;

@Service
public class TicketOrderService implements ITicketOrderService{
    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets) {
        if (movieTitle!=null && clientName!=null && address!=null && numberOfTickets!=0){
            TicketOrder ticketOrder = new TicketOrder(movieTitle,clientName,address,Long.valueOf(numberOfTickets));
            return ticketOrder;
        }
        else
            throw new IllegalArgumentException();
    }
}
