package mk.ukim.finki.lab.web.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab.service.MovieService;
import mk.ukim.finki.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/servlet/movies")
public class MovieListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;
    private final TicketOrderService ticketOrderService;

    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService, TicketOrderService ticketOrderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
        this.ticketOrderService = ticketOrderService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context =  new WebContext(webExchange);
        context.setVariable("ipAddress", req.getRemoteAddr());
        String titleSearchString = req.getParameter("searchByTitle");
        String ratingSearchString = req.getParameter("searchByRating");
        if (titleSearchString!=null && !titleSearchString.isEmpty()){
            context.setVariable("movies",movieService.searchMovies(titleSearchString));
            springTemplateEngine.process(
                    "listMovies.html",
                    context,
                    resp.getWriter()
            );
        }else if (ratingSearchString!=null && !ratingSearchString.isEmpty()) {
            context.setVariable("movies", movieService.searchMoviesByRatingHigherThan(Double.parseDouble(ratingSearchString)));
            springTemplateEngine.process(
                    "listMovies.html",
                    context,
                    resp.getWriter()
            );
        }
        else{
            context.setVariable("movies", movieService.listAll());
            springTemplateEngine.process(
                    "listMovies.html",
                    context,
                    resp.getWriter()
            );
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String movieTitle = req.getParameter("movieTitle");
        String numberOfTickets = req.getParameter("numTickets");
        String clientName = req.getParameter("clientName");
        LocalDateTime dateCreated = LocalDateTime.parse(req.getParameter("dateCreated"));
        ticketOrderService.save(movieTitle,clientName,Integer.parseInt(numberOfTickets), dateCreated);
        resp.sendRedirect("/ticketOrder?movieTitle=" + movieTitle + "&numTickets=" + numberOfTickets+ "&clientName=" + clientName);
    }
}
