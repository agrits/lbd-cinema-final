package pl.fis.java.cinemaservice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cinema
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "cinema name cannot be empty")
	@Column(nullable = false)
	private String name;

	@NotNull(message = "location cannot be null")
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "location_id", nullable = false)
	@JsonBackReference
	private Location location;

	@OneToMany(mappedBy = "cinema", cascade= CascadeType.PERSIST)
	@JsonManagedReference
	private List<Hall> halls;

	public List<Hall> getHalls()
	{
		return halls;
	}

	public void setHalls(List<Hall> halls)
	{
		this.halls = halls;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Location getLocation()
	{
		return location;
	}

	public void setLocation(Location location)
	{
		this.location = location;
	}

}
