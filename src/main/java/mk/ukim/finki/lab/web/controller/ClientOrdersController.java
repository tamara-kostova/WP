package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.service.TicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientOrders")
public class ClientOrdersController {
    private final TicketOrderService ticketOrderService;

    public ClientOrdersController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }
    @GetMapping
    public String getClientOrdersPage(@RequestParam(required = false) String error, @RequestParam(required = false) String titleSearchString, @RequestParam(required = false) String clientSearchString, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        if (titleSearchString!=null && !titleSearchString.isEmpty())
            model.addAttribute("orders", ticketOrderService.searchOrdersByTitle(titleSearchString));
        else if (clientSearchString!=null&&!clientSearchString.isEmpty())
            model.addAttribute("orders", ticketOrderService.searchOrdersByClient(clientSearchString));
        else
            model.addAttribute("orders", ticketOrderService.getOrders());
        return "clientOrders";
    }
}
