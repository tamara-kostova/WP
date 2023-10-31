package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {

        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> listAll() {

        return movieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text) {

        return movieRepository.searchMovies(text);
    }
    @Override
    public List<Movie> searchMoviesByRating(String text) {
        return movieRepository.searchMoviesByRating(text);
    }
}