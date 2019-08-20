package pl.fis.java.lbdcinemafinal.cinema_service.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hall
{
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number_of_seats", nullable = false)
	private int numberOfSeats;

	@Column(name = "number", nullable = false)
	private int number;

	@ManyToOne
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
