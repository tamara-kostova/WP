package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.*;
import mk.ukim.finki.lab.repository.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movies = null;
    public static List<TicketOrder> ticketOrders = null;
    public static List <Production> productions = null;
    public static List<User> users = null;

    public static List<ShoppingCart> shoppingCarts = null;
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;
    private final TicketOrderRepository ticketOrderRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;

    public DataHolder(MovieRepository movieRepository, ProductionRepository productionRepository, TicketOrderRepository ticketOrderRepository, ShoppingCartRepository shoppingCartRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
        this.ticketOrderRepository = ticketOrderRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
    }


    @PostConstruct
    public void init(){
        movies = new ArrayList<>();
        productions = new ArrayList<>();
        ticketOrders = new ArrayList<>();
        users = new ArrayList<>();
        shoppingCarts = new ArrayList<>();
        if (userRepository.count()==0){
            users.add(new User("tamara.kostova", "Tamara", "Kostova", "tk"));
            users.add(new User("aleksandra.nastoska", "Aleksandra", "Nastoska", "an"));
            users.add(new User("dina.galevska", "dg", "Galevska", "dg"));
            userRepository.saveAll(users);
        }
        if (productionRepository.count()==0){
            productions.add(new Production("Universal Pictures","USA", "100 Universal City Plaza, Universal City, California 91608"));
            productions.add(new Production("Paramount Pictures","USA","5555 Melrose Avenue, Hollywood, California"));
            productions.add(new Production("Warner Bros. Pictures","USA"," WBSF, 4000 Warner Blvd., Burbank, CA 91522"));
            productions.add(new Production("Walt Disney Studios","USA","500 South Buena Vista Street, Burbank"));
            productions.add(new Production("Sony Pictures","USA","10202 W WASHINGTON BLVD, Culver City, California"));
            productionRepository.saveAll(productions);
        }
        if (movieRepository.count()==0){
            movies.add(new Movie("The Godfather","Widely regarded as one of the greatest films of all time, this mob drama, based on Mario Puzo's novel of the same name, focuses on the powerful Italian-American crime family of Don Vito Corleone (Marlon Brando).",9.2,productions.get(1)));
            movies.add(new Movie("Goodfellas","Henry grows up idolising mobsters in his impoverished neighbourhood. Things take a turn for the worse when he along with his friends Jimmy and Tommy decide to make their way up the mob hierarchy.",9.0,productions.get(1)));
            movies.add(new Movie("Oppenheimer","During World War II, Lt. Gen. Leslie Groves Jr. appoints physicist J. Robert Oppenheimer to work on the top-secret Manhattan Project. Oppenheimer and a team of scientists spend years developing and designing the atomic bomb. ",8.9,productions.get(4)));
            movies.add(new Movie("Pulp Fiction","In the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals.",9.3,productions.get(3)));
            movies.add(new Movie("Seven","Detectives Somerset and Mills, one a seasoned cop, the other a relatively new one, are paired up to solve murders. Together they attempt to find a killer who is inspired by the seven deadly sins.",9.0,productions.get(1)));
            movies.add(new Movie("Interstellar","When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.",8.8,productions.get(2)));
            movies.add(new Movie("Back To The Future","In the 1980s, an experiment by a weird scientist turns out to be faulty. It leads to his teenaged pal going back in time to the 1950s where he is forced to reunite the younger version of his parents.",8.4,productions.get(3)));
            movies.add(new Movie("One Flew Over The Cuckoo's Nest","In order to escape the prison labour, McMurphy, a prisoner, fakes insanity and is shifted to the special ward for the mentally unstable. In this ward, he must rise up against a cruel nurse, Ratched.",8.6,productions.get(4)));
            movies.add(new Movie("Inception ","Cobb steals information from his targets by entering their dreams. He is wanted for his alleged role in his wife's murder and his only chance at redemption is to perform a nearly impossible task.",8.9,productions.get(0)));
            movies.add(new Movie("Forrest Gump","Forrest, a man with low IQ, recounts the early years of his life when he found himself in the middle of key historical events. All he wants now is to be reunited with his childhood sweetheart, Jenny.",8.7,productions.get(2)));
            movieRepository.saveAll(movies);
        }
        }

}
