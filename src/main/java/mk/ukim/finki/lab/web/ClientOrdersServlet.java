package mk.ukim.finki.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/clientOrders")
public class ClientOrdersServlet extends HttpServlet {
    private final TicketOrderService ticketOrderService;
    private final SpringTemplateEngine springTemplateEngine;

    public ClientOrdersServlet(SpringTemplateEngine springTemplateEngine, TicketOrderService ticketOrderService) {
        this.ticketOrderService = ticketOrderService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req,resp);
        WebContext webContext = new WebContext(webExchange);
        String titleSearchString = req.getParameter("searchByTitle");
        String clientSearchString = req.getParameter("searchByClient");
        if (titleSearchString!=null && !titleSearchString.isEmpty()){
            webContext.setVariable("orders",ticketOrderService.searchOrdersByTitle(titleSearchString));
            springTemplateEngine.process(
                    "clientOrders.html",
                    webContext,
                    resp.getWriter()
            );
        }else if (clientSearchString!=null && !clientSearchString.isEmpty()) {
            webContext.setVariable("orders", ticketOrderService.searchOrdersByClient(clientSearchString));
            springTemplateEngine.process(
                    "clientOrders.html",
                    webContext,
                    resp.getWriter()
            );
        }
        else {
            webContext.setVariable("orders", ticketOrderService.getOrders());
            springTemplateEngine.process("clientOrders.html", webContext, resp.getWriter());
        }
    }
}
