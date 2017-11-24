package dac.movie.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;



@Entity
@Table(name="movie_customers")
public class MovieCustomer implements Serializable
{

	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ID")
	int id;
	@Column(name="Name")
	String name;
	@Column(name="Password")
	String password;
	@Column(name="Mobile")
	String mobile;
	@Column(name="Address")
	String address;
	@Column(name="Email")
	String email;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="cust",cascade=CascadeType.ALL,targetEntity=MovieBookings.class )
	private List<MovieBookings>bookingList;
	
	public MovieCustomer()
	{
		this(0,"","","","","");
	}

	public MovieCustomer(int id, String name, String password, String mobile,
			String address, String email)
	{
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		bookingList=new ArrayList<MovieBookings>();
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<MovieBookings> getBookingList()
	{
		return bookingList;
	}

	public void setBookingList(List<MovieBookings> bookingList)
	{
		this.bookingList = bookingList;
	}

	@Override
	public String toString()
	{
		return String
				.format("MovieCustomer [id=%s, name=%s, password=%s, mobile=%s, address=%s, email=%s, bookingList=%s]",
						id, name, password, mobile, address, email, bookingList);
	}

	
	
	

}
