package dac.movie.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dac.movie.pojos.Login;
import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieCustomer;
import dac.movie.pojos.MoviePricing;
import dac.movie.pojos.OrderModel;
import dac.movie.pojos.PriceId;
import dac.movie.pojos.PricingModel;

@Service
public interface MovieService
{

	public  String findLogin(Login lg);
	public void insertCustomer(MovieCustomer cust);
	public List<String> fetchTypes();
	public List<String> fetchCategories(String type);
	public List<Movie>  fetchMovies(String type,String category);
	public Movie fetchMovie(int id);
	public  List<MoviePricing> fetchmoviepricing(List<Integer> intmoviepriceid);
	public PricingModel fetchm(List<Integer> intmoviepriceid);
	public void insertBooking(OrderModel omodel);
	public void insertMovie(Movie movie);
	
	
}
