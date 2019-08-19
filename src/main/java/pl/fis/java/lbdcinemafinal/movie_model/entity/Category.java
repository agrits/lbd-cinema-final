package pl.fis.java.lbdcinemafinal.movie_model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Movie> movies = new HashSet<>();

    public Category() {}

    public void addMovieToCategory(Movie movie) {
        movie.setCategory(this);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


}
