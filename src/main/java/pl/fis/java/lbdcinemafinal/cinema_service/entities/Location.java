package pl.fis.java.lbdcinemafinal.cinema_service.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Location
{
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String city;

	@NotEmpty
	private String address;

	@NotNull
	private Double longitude;

	@NotNull
	private Double latitude;

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
