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

    @NotNull
    private boolean subtitles;

    @NotNull
    private boolean threeD;

    @NotNull
    private boolean lector;

    @NotNull
    private boolean dubbing;


    public Show() {}

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

    public long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(long cinema_id) {
        this.cinema_id = cinema_id;
    }

    public boolean isSubtitles() {
        return subtitles;
    }

    public void setSubtitles(boolean subtitles) {
        this.subtitles = subtitles;
    }

    public boolean isLector() {
        return lector;
    }

    public void setLector(boolean lector) {
        this.lector = lector;
    }

    public boolean isDubbing() {
        return dubbing;
    }

    public void setDubbing(boolean dubbing) {
        this.dubbing = dubbing;
    }

    public boolean isThreeD() {
        return threeD;
    }

    public void setThreeD(boolean threeD) {
        this.threeD = threeD;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Show show = (Show) object;
        return id == show.id &&
                hall_id == show.hall_id &&
                movie_id == show.movie_id &&
                Double.compare(show.price, price) == 0 &&
                cinema_id == show.cinema_id &&
                subtitles == show.subtitles &&
                lector == show.lector &&
                dubbing == show.dubbing &&
                java.util.Objects.equals(time, show.time);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), id, hall_id, movie_id, time, price, cinema_id, subtitles, lector, dubbing);
    }
}

