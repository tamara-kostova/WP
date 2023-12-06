package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.TicketOrder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ITicketOrderService {
    TicketOrder save(String movieTitle, String clientName, int numberOfTickets, LocalDateTime date);
    List<TicketOrder> getOrders ();
    List<TicketOrder> searchOrdersByTitle(String text);
    List<TicketOrder> searchOrdersByClient(String text);
    Optional<TicketOrder> searchOrdersById(Long id);
    Optional<TicketOrder> editOrder(Long id, long numTickets);
    void deleteOrder(Long id);
    List<TicketOrder> searchOrdersBetweenDates(LocalDateTime from, LocalDateTime to);
    Optional<TicketOrder> discountTicketOrder(Long TicketOrderId, Long discountId);
}