package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text);
    List<Movie> searchMoviesByRating(String text);
}
