package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;

import java.util.List;
import java.util.Optional;

public interface IMovieService {
    List<Movie> listAll();
    Optional<Movie> findById(Long id);
    List<Movie> searchMovies(String text);
    List<Movie> searchMoviesByRatingHigherThan(double rating);
    Movie saveMovie(String movieTitle, String summary, double rating, long productionId);
    void deleteById(Long id);
    Optional<Movie> edit(Long id, String movieTitle, String summary, double rating, long productionid);
}
