package pl.fis.java.cinemaservice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class Hall
{
	@Id
	@GeneratedValue
	private Long id;

	@NotNull(message = "number of seats cannot be null")
	@Positive(message = "number of seats must be positive")
	@Column(name = "number_of_seats", nullable = false)
	private Integer numberOfSeats;

	@NotNull(message = "hall number cannot be blank")
	@Positive(message = "hall number must be positive")
	@Column(name = "number", nullable = false)
	private Integer number;

	@ManyToOne
	@NotNull(message = "cinema cannot be null")
	@JoinColumn(name = "cinema_id", nullable = false)
	private Cinema cinema;

	@OneToMany(mappedBy = "hall", cascade = CascadeType.PERSIST)
	private List<Seat> seats;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getNumberOfSeats()
	{
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats)
	{
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumber()
	{
		return number;
	}

	public void setNumber(int number)
	{
		this.number = number;
	}

	public Cinema getCinema()
	{
		return cinema;
	}

	public void setCinema(Cinema cinema)
	{
		this.cinema = cinema;
	}

	public List<Seat> getSeats()
	{
		return seats;
	}

	public void setSeats(List<Seat> seats)
	{
		this.seats = seats;
	}

}
