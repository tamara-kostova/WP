package mk.ukim.finki.lab.web.controller;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.service.IMovieService;
import mk.ukim.finki.lab.service.IProductionService;
import mk.ukim.finki.lab.service.ITicketOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MovieController {
    private final IMovieService movieService;
    private final IProductionService productionService;
    private final ITicketOrderService ticketOrderService;
    public MovieController(IMovieService movieService, IProductionService productionService, ITicketOrderService ticketOrderService) {
        this.movieService = movieService;
        this.productionService = productionService;
        this.ticketOrderService = ticketOrderService;
    }
    @GetMapping("/movies")
    public String getMoviesPage(@RequestParam(required = false) String error, @RequestParam(required = false) String searchByTitle, @RequestParam(required = false) String searchByRating, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        if (searchByTitle!=null && !searchByTitle.isEmpty())
            model.addAttribute("movies", movieService.searchMovies(searchByTitle));
        else if (searchByRating!=null&&!searchByRating.isEmpty())
            model.addAttribute("movies", movieService.searchMoviesByRating(searchByRating));
        else
            model.addAttribute("movies", movieService.listAll());
        return "listMovies";
    }
    @GetMapping("/movies/add-form")
    public String getAddMoviePage(Model model){
        List<Production> productions = productionService.findAll();
        model.addAttribute("productions", productions);
        return "add-movie";
    }
    @GetMapping("/movies/edit-form/{id}")
    public String getEditMovieForm(@PathVariable Long id, Model model){
        if (this.movieService.findById(id).isPresent()) {
            Movie movie = this.movieService.findById(id).get();
            List<Production> productions = productionService.findAll();
            model.addAttribute("productions", productions);
            model.addAttribute("movie", movie);
            return "add-movie";
        }
        return "redirect:/movies";
    }
    @PostMapping("/movies/add")
    public String saveMovie(@RequestParam String movieTitle, @RequestParam String summary, @RequestParam double rating, @RequestParam long productionid){
        movieService.saveMovie(movieTitle,summary,rating,productionid);
        return "redirect:/movies";
    }
    @PostMapping("/movies/delete/{id}")
    public String deleteMovie(@PathVariable long id){
        this.movieService.deleteById(id);
        return "redirect:/movies";
    }
    @PostMapping("/movies")
    public String TicketOrder(@RequestParam String movieTitle, @RequestParam int numTickets, @RequestParam String clientName,Model model){
        ticketOrderService.placeOrder(movieTitle,clientName,numTickets);
        model.addAttribute("movieTitle",movieTitle);
        model.addAttribute("numTickets",numTickets);
        model.addAttribute("clientName",clientName);
        return "redirect:/ticketOrder?movieTitle=" + movieTitle + "&numTickets=" + numTickets+ "&clientName=" + clientName;
    }
}
