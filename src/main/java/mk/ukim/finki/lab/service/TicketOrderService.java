package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.TicketOrder;
import mk.ukim.finki.lab.repository.TicketOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderService implements ITicketOrderService{
    TicketOrderRepository ticketOrderRepository;

    public TicketOrderService(TicketOrderRepository ticketOrderRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
    }

    @Override
    public TicketOrder placeOrder(String movieTitle, String clientName, int numberOfTickets) {
        if (movieTitle!=null && clientName!=null && numberOfTickets!=0){
            TicketOrder ticketOrder = new TicketOrder(movieTitle,clientName, (long) numberOfTickets);
            return ticketOrderRepository.placeOrder(ticketOrder);
        }
        else
            throw new IllegalArgumentException();
    }
    @Override
    public List<TicketOrder> getOrders (){
        return ticketOrderRepository.getOrders();
    }
    @Override
    public List<TicketOrder> searchOrdersByTitle(String text) {

        return ticketOrderRepository.searchOrdersByTitle(text);
    }
    @Override
    public List<TicketOrder> searchOrdersByClient(String text) {
        return ticketOrderRepository.searchOrdersByClient(text);
    }

    @Override
    public TicketOrder editOrder(long id, long numTickets) {
        return ticketOrderRepository.editOrder(id, numTickets);
    }

    @Override
    public void deleteOrder(long id) {
        ticketOrderRepository.deleteById(id);
    }
}
