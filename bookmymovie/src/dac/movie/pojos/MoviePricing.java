package dac.movie.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name="movie_pricing")
public class MoviePricing
{
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ID")
	int id;
	@Column(name="PRICINGTYPE")
	String pricingtype;
	@Column(name="PRICE")
	double price;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="MOVIEID",referencedColumnName="ID")
	Movie movie;
	
	
	@OneToMany(mappedBy="pricing", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	List<MovieBookingDetails>listbookingdetails;
	
	public MoviePricing()
	{
		this(0,"",0.0);
	}
	public  MoviePricing(int id, String pricingtype, double price)
	{
		this.id=id;
		this.pricingtype=pricingtype;
		this.price=price;
		this.listbookingdetails=new ArrayList<MovieBookingDetails>();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getPricingtype()
	{
		return pricingtype;
	}
	public void setPricingtype(String pricingtype)
	{
		this.pricingtype = pricingtype;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public Movie getMovie()
	{
		return movie;
	}
	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}
	@Override
	public String toString()
	{
		return "MoviePricing [id=" + id + ", pricingtype=" + pricingtype
				+ ", price=" + price + "]";
	}
	

	
	
}
