package dac.movie.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="movie_bookingdetails")
public class MovieBookingDetails
{
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ID")
	int id;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="BookingID",referencedColumnName="ID")
	MovieBookings booking;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="PriceID",referencedColumnName="ID")
	MoviePricing pricing;
	
	
	public MovieBookingDetails()
	{
		this(0,new MovieBookings(),0.0);
	}
	
	public MovieBookingDetails(int id,MovieBookings booking, double priceid)
	{
		super();
		this.id=id;
		this.booking=booking;
		this.pricing=new MoviePricing();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public MovieBookings getBooking()
	{
		return booking;
	}

	public void setBooking(MovieBookings booking)
	{
		this.booking = booking;
	}

	public MoviePricing getPricing()
	{
		return pricing;
	}

	public void setPricing(MoviePricing pricing)
	{
		this.pricing = pricing;
	}

	@Override
	public String toString()
	{
		return "MovieBookingDetails [id=" + id + ", pricing=" + pricing + "]";
	}


	

	

	
	
}
