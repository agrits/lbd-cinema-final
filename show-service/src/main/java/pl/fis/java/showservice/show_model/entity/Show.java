package pl.fis.java.showservice.show_model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_id")
    private long id;

    @Column(name = "hall_id", nullable = false)
    @NotNull(message = "{hall_id.notnull}")
    private long hall_id;

    @Column(name = "movie_id", nullable = false)
    @NotNull(message = "{movie_id.notnull}")
    private long movie_id;

    @Column(name = "time", nullable = false)
    @DateTimeFormat
    @NotNull(message = "{time.notnull}")
    private LocalDateTime time;

    @Column(name = "price", nullable = false)
    @NotNull(message = "{price.notnull}")
    private double price;

    @Column(name = "cinema_id", nullable = false)
    @NotNull(message = "{cinema_id.notnull}")
    private long cinema_id;

    public Show() {}


    public long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(long cinema_id) {
        this.cinema_id = cinema_id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHall_id() {
        return hall_id;
    }

    public void setHall_id(long hall_id) {
        this.hall_id = hall_id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return getId() == show.getId() &&
                getHall_id() == show.getHall_id() &&
                getMovie_id() == show.getMovie_id() &&
                Double.compare(show.getPrice(), getPrice()) == 0 &&
                getTime().equals(show.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHall_id(), getMovie_id(), getTime(), getPrice());
    }
}
