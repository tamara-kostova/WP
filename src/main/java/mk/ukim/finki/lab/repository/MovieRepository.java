package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByRatingGreaterThanEqual(double rating);

    List<Movie> findByTitleLike(String text);
}
