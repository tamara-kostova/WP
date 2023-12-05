package mk.ukim.finki.lab.repository.InMemory;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryTicketOrderRepository {

    public TicketOrder placeOrder(TicketOrder ticketOrder) {
        DataHolder.ticketOrders.removeIf(t->t.getMovieTitle().equals(ticketOrder.getMovieTitle()));
        DataHolder.ticketOrders.add(ticketOrder);
        return ticketOrder;
    }

    public List<TicketOrder> getOrders() {
        return DataHolder.ticketOrders;
    }

    public TicketOrder searchOrdersById(long id) {
        return DataHolder.ticketOrders.stream().filter(order->order.getId().equals(id)).findFirst().orElse(null);
    }

    public List<TicketOrder> searchOrdersByTitle(String text) {
        return DataHolder.ticketOrders.stream().filter(order->order.getMovieTitle().contains(text)).collect(Collectors.toList());
    }

    public List<TicketOrder> searchOrdersByClient(String text) {
        return DataHolder.ticketOrders.stream().filter(order->order.getUser().getUsername().contains(text)).collect(Collectors.toList());
    }

    public TicketOrder editOrder(long id, long numTickets) {
        TicketOrder ticketOrder = searchOrdersById(id);
        ticketOrder.setNumberOfTickets(numTickets);
        placeOrder(ticketOrder);
        return ticketOrder;
    }

    public void deleteById(long id) {
        DataHolder.ticketOrders.removeIf(t->t.getId().equals(id));
    }
}
