package pl.fis.java.reservationservice.seat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class Seat extends ResourceSupport {

    @JsonProperty
    private Hall hall;

    @JsonProperty
    private Integer row;

    @JsonProperty
    private Integer column;

    @JsonProperty
    private Boolean available = false;


    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
