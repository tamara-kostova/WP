package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.TicketOrder;
import mk.ukim.finki.lab.service.TicketOrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/clientOrders")
public class ClientOrdersController {
    private final TicketOrderService ticketOrderService;

    public ClientOrdersController(TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
    }
    @GetMapping
    public String getClientOrdersPage(@RequestParam(required = false) String error, @RequestParam(required = false) String titleSearchString, @RequestParam(required = false) String clientSearchString, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateFrom, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime dateTo, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        if (titleSearchString!=null && !titleSearchString.isEmpty())
            model.addAttribute("orders", ticketOrderService.searchOrdersByTitle(titleSearchString));
        else if (clientSearchString!=null&&!clientSearchString.isEmpty())
            model.addAttribute("orders", ticketOrderService.searchOrdersByClient(clientSearchString));
        else if (dateFrom!=null && dateTo!=null)
            model.addAttribute("orders",ticketOrderService.searchOrdersBetweenDates(dateFrom,dateTo));
        else
            model.addAttribute("orders", ticketOrderService.getOrders());
        return "clientOrders";
    }
    @PostMapping("/edit/{id}")
    public String editOrder(@PathVariable long id, @RequestParam int numTickets){
        ticketOrderService.editOrder(id,numTickets);
        return "redirect:/clientOrders";
    }
    @PostMapping("/delete/{id}")
    public String deleteOrder(@PathVariable long id){
        ticketOrderService.deleteOrder(id);
        return "redirect:/clientOrders";
    }
}
