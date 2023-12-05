package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Movie;
import mk.ukim.finki.lab.model.Production;
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
    public Optional<Movie> findById(Long id) {

        return movieRepository.findById(id);
    }

    @Override
    public List<Movie> searchMovies(String text) {

        return movieRepository.findByTitleLike(text);
    }
    @Override
    public List<Movie> searchMoviesByRatingHigherThan(double rating) {

        return movieRepository.findByRatingGreaterThanEqual(rating);
    }

    @Override
    public Movie saveMovie(String movieTitle, String summary, double rating, long productionId) {
        if (movieTitle.isEmpty() || summary.isEmpty() || rating<0 || productionRepository.findById(productionId)==null)
            throw new IllegalArgumentException();
        return movieRepository.save(new Movie(movieTitle,summary,rating, productionRepository.findById(productionId).get()));
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> edit(Long id, String movieTitle, String summary, double rating, long productionid) {
        Movie movie = movieRepository.findById(id).orElseThrow();
        Production production = productionRepository.findById(productionid).orElseThrow();
        movie.setTitle(movieTitle);
        movie.setSummary(summary);
        movie.setRating(rating);
        movie.setProduction(production);
        movieRepository.save(movie);
        return Optional.of(movie);
    }
}