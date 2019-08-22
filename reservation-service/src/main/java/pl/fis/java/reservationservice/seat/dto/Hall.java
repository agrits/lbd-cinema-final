package pl.fis.java.reservationservice.seat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Hall extends ResourceSupport {

    @JsonProperty
    private Long showId;

    public Hall() {

    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }
}
