package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.repository.MovieRepository;
import mk.ukim.finki.lab.repository.ProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;
    private final ProductionRepository productionRepository;

    public MovieService(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {

        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {

        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> searchMovies(String text) {

        return movieRepository.searchMovies(text);
    }
    @Override
    public List<Movie> searchMoviesByRating(String text) {
        return movieRepository.searchMoviesByRating(text);
    }

    @Override
    public Movie saveMovie(String movieTitle, String summary, double rating, long productionId) {
        if (movieTitle.isEmpty() || summary.isEmpty() || rating<0 || productionRepository.findById(productionId)==null)
            throw new IllegalArgumentException();
        return movieRepository.addMovie(new Movie(movieTitle,summary,rating,productionRepository.findById(productionId)));
    }

    @Override
    public void deleteById(long id) {
        movieRepository.deleteById(id);
    }
}