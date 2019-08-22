package pl.fis.java.cinemaservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Seat
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "seat row cannot be empty")
	@Column(name = "seat_row", nullable = false)
	private Integer row;

	@NotNull(message = "seat column cannot be empty")
	@Column(name = "seat_column", nullable = false)
	private Integer column;

	@NotNull(message = "hall cannot be empty")
	@ManyToOne
	@JoinColumn(name = "hall_id")
	private Hall hall;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public int getRow()
	{
		return row;
	}

	public void setRow(int row)
	{
		this.row = row;
	}

	public int getColumn()
	{
		return column;
	}

	public void setColumn(int column)
	{
		this.column = column;
	}

	public Hall getHall()
	{
		return hall;
	}

	public void setHall(Hall hall)
	{
		this.hall = hall;
	}

}
