package mk.ukim.finki.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.model.TicketOrder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> Movies = new ArrayList<>();
    public static List<TicketOrder> ticketOrders = new ArrayList<>();
    public static List <Production> Productions = new ArrayList<>();
    @PostConstruct
    public void init(){
        Productions.add(new Production("Universal Pictures","USA", "100 Universal City Plaza, Universal City, California 91608"));
        Productions.add(new Production("Paramount Pictures","USA","5555 Melrose Avenue, Hollywood, California"));
        Productions.add(new Production("Warner Bros. Pictures","USA"," WBSF, 4000 Warner Blvd., Burbank, CA 91522"));
        Productions.add(new Production("Walt Disney Studios","USA","500 South Buena Vista Street, Burbank"));
        Productions.add(new Production("Sony Pictures","USA","10202 W WASHINGTON BLVD, Culver City, California"));
        Movies.add(new Movie("The Godfather","Widely regarded as one of the greatest films of all time, this mob drama, based on Mario Puzo's novel of the same name, focuses on the powerful Italian-American crime family of Don Vito Corleone (Marlon Brando).",9.2,Productions.get(1)));
        Movies.add(new Movie("Goodfellas","Henry grows up idolising mobsters in his impoverished neighbourhood. Things take a turn for the worse when he along with his friends Jimmy and Tommy decide to make their way up the mob hierarchy.",9.0,Productions.get(1)));
        Movies.add(new Movie("Oppenheimer","During World War II, Lt. Gen. Leslie Groves Jr. appoints physicist J. Robert Oppenheimer to work on the top-secret Manhattan Project. Oppenheimer and a team of scientists spend years developing and designing the atomic bomb. ",8.9,Productions.get(4)));
        Movies.add(new Movie("Pulp Fiction","In the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals.",9.3,Productions.get(3)));
        Movies.add(new Movie("Seven","Detectives Somerset and Mills, one a seasoned cop, the other a relatively new one, are paired up to solve murders. Together they attempt to find a killer who is inspired by the seven deadly sins.",9.0,Productions.get(1)));
        Movies.add(new Movie("Interstellar","When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.",8.8,Productions.get(2)));
        Movies.add(new Movie("Back To The Future","In the 1980s, an experiment by a weird scientist turns out to be faulty. It leads to his teenaged pal going back in time to the 1950s where he is forced to reunite the younger version of his parents.",8.4,Productions.get(3)));
        Movies.add(new Movie("One Flew Over The Cuckoo's Nest","In order to escape the prison labour, McMurphy, a prisoner, fakes insanity and is shifted to the special ward for the mentally unstable. In this ward, he must rise up against a cruel nurse, Ratched.",8.6,Productions.get(4)));
        Movies.add(new Movie("Inception ","Cobb steals information from his targets by entering their dreams. He is wanted for his alleged role in his wife's murder and his only chance at redemption is to perform a nearly impossible task.",8.9,Productions.get(0)));
        Movies.add(new Movie("Forrest Gump","Forrest, a man with low IQ, recounts the early years of his life when he found himself in the middle of key historical events. All he wants now is to be reunited with his childhood sweetheart, Jenny.",8.7,Productions.get(2)));
    }

}
