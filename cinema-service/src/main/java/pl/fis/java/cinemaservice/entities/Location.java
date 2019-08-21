package pl.fis.java.cinemaservice.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Location
{
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "city name cannot be empty")
	private String city;

	@NotEmpty(message = "address cannot be empty")
	private String address;

	@NotNull(message = "longitude cannot be empty")
	private Double longitude;

	@NotNull(message = "latitude cannot be empty")
	private Double latitude;

	@OneToOne(mappedBy= "location", cascade = CascadeType.PERSIST)
	private Cinema cinema;

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public Double getLongitude()
	{
		return longitude;
	}

	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	public Double getLatitude()
	{
		return latitude;
	}

	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

}
