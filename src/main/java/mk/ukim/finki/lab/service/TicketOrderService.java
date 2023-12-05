package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.TicketOrder;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.repository.ShoppingCartRepository;
import mk.ukim.finki.lab.repository.TicketOrderRepository;
import mk.ukim.finki.lab.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketOrderService implements ITicketOrderService{
    TicketOrderRepository ticketOrderRepository;
    UserRepository userRepository;
    ShoppingCartRepository shoppingCartRepository;

    public TicketOrderService(TicketOrderRepository ticketOrderRepository, UserRepository userRepository, ShoppingCartRepository shoppingCartRepository) {
        this.ticketOrderRepository = ticketOrderRepository;
        this.userRepository = userRepository;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public TicketOrder save(String movieTitle, String username, int numberOfTickets, LocalDateTime dateCreated) {
        if (movieTitle!=null && username!=null && numberOfTickets!=0){
            User user = userRepository.findById(username).orElseThrow();
            TicketOrder ticketOrder = new TicketOrder(movieTitle,(long) numberOfTickets, user, dateCreated);
            ShoppingCart shoppingCart = null;
            if (shoppingCartRepository.findByUserUsername(username).isPresent()){
                shoppingCart = shoppingCartRepository.findByUserUsername(username).get();
                shoppingCart.getTicketOrders().add(ticketOrder);
            }
            else{
                List<TicketOrder> ticketOrders = new ArrayList<>();
                ticketOrders.add(ticketOrder);
                shoppingCart = new ShoppingCart(user, dateCreated, ticketOrders);
                shoppingCart.getTicketOrders().add(ticketOrder);
            }
            shoppingCartRepository.save(shoppingCart);
            return ticketOrderRepository.save(ticketOrder);
        }
        else
            throw new IllegalArgumentException();
    }
    @Override
    public List<TicketOrder> getOrders (){
        return ticketOrderRepository.findAll();
    }
    @Override
    public List<TicketOrder> searchOrdersByTitle(String text) {

        return ticketOrderRepository.findByMovieTitleLike(text);
    }
    @Override
    public List<TicketOrder> searchOrdersByClient(String text) {
        return ticketOrderRepository.findByUserUsernameLike(text);
    }

    @Override
    public Optional<TicketOrder> searchOrdersById(Long id) {
        return ticketOrderRepository.findById(id);
    }

    @Override
    public Optional<TicketOrder> editOrder(Long id, long numTickets) {
        TicketOrder ticketOrder = ticketOrderRepository.findById(id).orElseThrow();
        ticketOrder.setNumberOfTickets(numTickets);
        return Optional.of(ticketOrderRepository.save(ticketOrder));
    }

    @Override
    public void deleteOrder(Long id) {
        ticketOrderRepository.deleteById(id);
    }

    @Override
    public List<TicketOrder> searchOrdersBetweenDates(LocalDateTime from, LocalDateTime to) {
        return ticketOrderRepository.findByDateCreatedBetween(from, to);
    }
}
