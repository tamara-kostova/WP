package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> listAll();
    Optional<Movie> findById(long id);
    List<Movie> searchMovies(String text);
    List<Movie> searchMoviesByRating(String text);
    Movie saveMovie(String movieTitle, String summary, double rating, long productionId);
    void deleteById(long id);
}
