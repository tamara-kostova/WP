package mk.ukim.finki.lab.model;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String summary;
    private double rating;
    private Production production;
    public Movie(String title, String summary, double rating, Production production) {
        id = (long)(Math.random()*1000);
        this.title = title;
        this.summary = summary;
        this.rating = rating;
        this.production = production;
    }
}
