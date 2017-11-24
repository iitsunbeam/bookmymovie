package dac.movie.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieBookings;
import dac.movie.pojos.MoviePricing;


@Repository
public interface MenuDao
{
	public List<String> getTypes();
	public List<String> getCategories(String type);
	public List<Movie> getMovie(String type, String categories);
	public Movie findMovie(int movieId);
	public List<MoviePricing> findMoviePrice(int moviePriceId);
	public MoviePricing getMoviePrice(int priceId);
	public void insertBooking(MovieBookings mbooking);
	public void insertMovie(Movie movie);
	
	

}
