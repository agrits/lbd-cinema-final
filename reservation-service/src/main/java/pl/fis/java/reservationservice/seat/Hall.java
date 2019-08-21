package pl.fis.java.reservationservice.seat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hall {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long showId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
