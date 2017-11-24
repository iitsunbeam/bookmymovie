package dac.movie.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dac.movie.daos.LoginDao;
import dac.movie.daos.LoginDaoImpl;
import dac.movie.daos.MenuDao;
import dac.movie.daos.MenuDaoImpl;
import dac.movie.pojos.Login;
import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieBookingDetails;
import dac.movie.pojos.MovieBookings;
import dac.movie.pojos.MovieCustomer;
import dac.movie.pojos.MoviePricing;
import dac.movie.pojos.OrderModel;
import dac.movie.pojos.PricingModel;

@Service
public class MovieServiceImpl implements MovieService
{
	@Autowired
	LoginDao dao;
	@Autowired
	MenuDao mdao;
	
	public String findLogin(Login lg)
	{
		MovieCustomer customer= dao.findLogin(lg.getEmail());
		
		System.out.println("  database customer password is "+customer.getPassword());
		System.out.println("  login password is "+lg.getPass());
		if(customer==null)
		{
			   
			System.out.println("cust is null");
		}
		
		
		if(customer!=null&&customer.getPassword().equals(lg.getPass()))
		{
			
			lg.setUser(dao.fetchuser(lg.getEmail()));
			
			lg.setCust(dao.findLogin(lg.getEmail()));
			
			if(lg.getNavid().equals("p"))
			{	
			return "loginp";
			}
			else
			{
		    return "login";
			}
		} 
		else
		{
			return "failed";
		}	
		
		
		
		
		
	}
	public void insertCustomer(MovieCustomer cust)
	{
	    dao.insertCustomer(cust);
	}
	
	public List<String> fetchTypes() 
	{
		 System.out.println("inside  bean fetch types");
	     List<String>types=mdao.getTypes();
	     return types;
	}
	
	
	@Override
	public List<String> fetchCategories(String type)
	{
		
		List<String>catgories=mdao.getCategories(type);
		return catgories;
		
	}

	public List<Movie> fetchMovies(String type,String category)
	{
		List<Movie> movieList= mdao.getMovie(type,category);
		return movieList;
		
	}
	@Override
	public Movie fetchMovie(int id)
	{
		Movie movie =mdao.findMovie(id);
		return movie;
	}
	
	
	
	@Override
	public List<MoviePricing> fetchmoviepricing(List<Integer> intmoviepriceid)
	{
	  List<MoviePricing>pricingList=new ArrayList<MoviePricing>();
	 
	  for (int id : intmoviepriceid)
	{
		 MoviePricing moviePricing=mdao.getMoviePrice(id);
		 pricingList.add(moviePricing);
		 
	}
	return pricingList;
	
	}
	
	
	@Override
	public PricingModel fetchm(List<Integer> intmoviepriceid)
	{
		PricingModel pmodel=new PricingModel();
		
		
		  for (int id : intmoviepriceid)
			{
				 MoviePricing moviePricing=mdao.getMoviePrice(id);
				 pmodel.getCartmp().add(moviePricing);
	         }
		double totaltemp=0;  //new
		for (MoviePricing moviePricing :pmodel.getCartmp()) //new
		{
			totaltemp=totaltemp+moviePricing.getPrice();  //new
		} 
	    pmodel.setTotal(totaltemp);
	    return pmodel;
	}
	@Override
	
	
	public void insertBooking(OrderModel omodel)
	{
		
		System.out.println("inside booking sevice ");
		
		MovieBookings movieBooking=new MovieBookings();
		movieBooking.setCust(omodel.getCustomerOrder());
		omodel.getCustomerOrder().getBookingList().add(movieBooking);
		for(int id:omodel.getIntidListOrder())
		{
			System.out.println("movie pricing id is: "+id);
			MovieBookingDetails bookingDetails=new MovieBookingDetails();
			
			MoviePricing pricing=mdao.getMoviePrice(id);
			
			bookingDetails.setPricing(pricing);
			movieBooking.getListodetails().add(bookingDetails);
			bookingDetails.setBooking(movieBooking);
		}
		
		mdao.insertBooking(movieBooking);
		
	}
	@Override
	public void insertMovie(Movie movie)
	{
		System.out.println("inside insertsevice movie");
		mdao.insertMovie(movie);
		
		
	}
	
	
	
	
	
	

}
