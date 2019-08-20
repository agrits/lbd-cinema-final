package pl.fis.java.lbdcinemafinal.cinema_service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Seat
{
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(name = "seat_row", nullable = false)
	private int row;

	@NotNull
	@Column(name = "seat_column", nullable = false)
	private int column;

	@NotNull
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
