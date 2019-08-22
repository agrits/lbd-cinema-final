package pl.fis.java.movieservice.movie_model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @NotBlank(message = "name.notblank")
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    //@JsonBackReference
    @NotEmpty(message = "{movies.notempty}")
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return getId() == category.getId() &&
                getName().equals(category.getName()) &&
                Objects.equals(getMovies(), category.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMovies());
    }
}
