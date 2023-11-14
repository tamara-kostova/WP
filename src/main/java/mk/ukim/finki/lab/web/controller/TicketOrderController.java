package mk.ukim.finki.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ticketOrder")
public class TicketOrderController {
    @GetMapping
    public String getTicketOrderPage(@RequestParam String movieTitle, @RequestParam int numTickets, @RequestParam String clientName, Model model){
        model.addAttribute("movieTitle",movieTitle);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("clientName", clientName);
        return "orderConfirmation";
    }
}
