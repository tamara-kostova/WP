package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.TicketOrder;

public interface ITicketOrderService {
    TicketOrder placeOrder(String movieTitle, String clientName, String address, int numberOfTickets);
}