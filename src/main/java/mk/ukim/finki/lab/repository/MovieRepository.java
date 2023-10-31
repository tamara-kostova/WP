package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.Movies;
    }
    public List<Movie> searchMovies(String text){
        return DataHolder.Movies.stream().filter(movie->movie.getTitle().contains(text)).collect(Collectors.toList());
    }
    public List<Movie> searchMoviesByRating(String text) {
        return DataHolder.Movies.stream().filter(movie->movie.getRating()>Double.parseDouble(text)).collect(Collectors.toList());
    }
}
