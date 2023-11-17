package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.TicketOrder;

import java.util.List;

public interface ITicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, int numberOfTickets);
    List<TicketOrder> getOrders ();
    List<TicketOrder> searchOrdersByTitle(String text);
    List<TicketOrder> searchOrdersByClient(String text);
    TicketOrder editOrder(long id, long numTickets);

    void deleteOrder(long id);
}