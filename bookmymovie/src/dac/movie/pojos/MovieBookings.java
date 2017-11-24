package dac.movie.pojos;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name="movie_bookings")
public class MovieBookings
{
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ID")
    int id;
	@Column(name="BookingTime")
	Date bookingtime;
	@Column(name="STATUS")
	String status;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	
	@JoinColumn(name="CustomerID",referencedColumnName="ID")
	private MovieCustomer cust;
	
	@OneToMany(mappedBy="booking", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	List<MovieBookingDetails>listodetails;
	
	public MovieBookings()
	{
		this(0,new Date(0,0,0),"waiting");
	}
	
	
	public MovieBookings(int id,Date bookingTime,String status)
	{
		this.id=id;
		this.bookingtime=new Date();
		this.status=status;
		listodetails=new ArrayList<MovieBookingDetails>();
		cust=new MovieCustomer();
		
	}
	
	
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Date getBookingtime()
	{
		return bookingtime;
	}
	public void setBookingtime(Date bookingtime)
	{
		this.bookingtime = bookingtime;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public MovieCustomer getCust()
	{
		return cust;
	}
	public void setCust(MovieCustomer cust)
	{
		this.cust = cust;
	}
	public List<MovieBookingDetails> getListodetails()
	{
		return listodetails;
	}
	public void setListodetails(List<MovieBookingDetails> listodetails)
	{
		this.listodetails = listodetails;
	}


	@Override
	public String toString()
	{
		return "MovieBookings [id=" + id + ", bookingtime=" + bookingtime
				+ ", status=" + status + ", listodetails=" + listodetails + "]";
	}


	
	
	

}
