package pl.fis.java.lbdcinemafinal.movie_model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private long id;

    @Column(name = "title", nullable = false)
    @NotBlank(message = "{title.notblank}")
    private String title;

    @Column(name = "description", nullable = false)
    @NotBlank(message = "{description.notblank}")
    private String description;

    @Column(name = "duration", nullable = false, length = 4096)
    @NotNull(message = "{range.notnull}")
    private int duration;

    @Column(name = "pegi", nullable = false)
    @NotBlank(message = "{pegi.notblank}")
    private String pegi;

    @Column(name = "rating", nullable = false)
    @NotBlank(message = "{rating.notblank}")
    private String rating;

    @RestResource(exported = false)
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull(message = "{category.notnull}")
    //@JsonManagedReference
    private Category category;

    public Movie() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPegi() {
        return pegi;
    }

    public void setPegi(String pegi) {
        this.pegi = pegi;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId() &&
                getDuration() == movie.getDuration() &&
                getTitle().equals(movie.getTitle()) &&
                getDescription().equals(movie.getDescription()) &&
                getPegi().equals(movie.getPegi()) &&
                getRating().equals(movie.getRating()) &&
                getCategory().equals(movie.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDescription(), getDuration(), getPegi(), getRating(), getCategory());
    }
}
