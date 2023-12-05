package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.ShoppingCart;
import mk.ukim.finki.lab.model.TicketOrder;

import java.util.List;

public interface IShoppingCartService {
    List<TicketOrder> listAllTicketOrdersInShoppingCart(Long cartId);
    ShoppingCart getShoppingCartByUsername(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);

}
