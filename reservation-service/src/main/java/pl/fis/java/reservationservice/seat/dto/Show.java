package pl.fis.java.reservationservice.seat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Show {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long hallId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }
}
