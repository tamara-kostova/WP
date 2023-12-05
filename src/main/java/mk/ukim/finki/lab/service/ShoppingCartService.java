package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.TicketOrder;
import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.repository.ShoppingCartRepository;
import mk.ukim.finki.lab.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService implements IShoppingCartService{
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final TicketOrderService ticketOrderService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, TicketOrderService ticketOrderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    public List<TicketOrder> listAllTicketOrdersInShoppingCart(Long cartId) {
        ShoppingCart shoppingCartOptional = this.shoppingCartRepository.findById(cartId).orElseThrow();

        return shoppingCartOptional.getTicketOrders();

    }

    @Override
    public ShoppingCart getShoppingCartByUsername(String username) {
        return this.shoppingCartRepository
                .findByUserUsername(username)
                .orElseThrow();

    }

    @Override
    public ShoppingCart addProductToShoppingCart(String username, Long ticketOrderId) {
        TicketOrder ticketOrder = this.ticketOrderService.searchOrdersById(ticketOrderId)
                .orElseThrow();
        ShoppingCart shoppingCart = this.getShoppingCartByUsername(username);

        shoppingCart.getTicketOrders().add(ticketOrder);
        return this.shoppingCartRepository.save(shoppingCart);

    }
}
