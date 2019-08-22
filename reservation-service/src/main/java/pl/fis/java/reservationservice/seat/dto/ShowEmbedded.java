package pl.fis.java.reservationservice.seat.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShowEmbedded {


    private List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
