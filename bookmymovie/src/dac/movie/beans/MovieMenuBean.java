package dac.movie.beans;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import dac.movie.daos.MenuDao;
import dac.movie.daos.MenuDaoImpl;
import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieCustomer;
import dac.movie.pojos.MoviePricing;


public class MovieMenuBean
{
	
	@Autowired
	MenuDao dao;
	
	private String type;
	private String category;
	private List<String> typeList;
	private List<String> categoryList;
	private List<Movie> movieList;
	private Movie movie;
	int movieId;
	private List<MoviePricing> listmoviePricing;
	private MovieCustomer customer;
	
	
	
	public MovieMenuBean()
	{
		this.type = "";
		this.category = "";
		this.typeList = new ArrayList<>();
		this.categoryList = new ArrayList<>();
		this.movieList = new ArrayList<>();
		this.movie=new Movie();
		this.listmoviePricing=new ArrayList<MoviePricing>();
		this.movieId=0;
		this.customer=new MovieCustomer();
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public List<String> getTypeList()
	{
		return typeList;
	}

	public void setTypeList(List<String> typeList)
	{
		this.typeList = typeList;
	}

	public List<String> getCategoryList()
	{
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList)
	{
		this.categoryList = categoryList;
	}

	public List<Movie> getMovieList()
	{
		return movieList;
	}

	public void setMovieList(List<Movie> movieList)
	{
		this.movieList = movieList;
	}

	public Movie getMovie()
	{
		return movie;
	}

	public void setMovie(Movie movie)
	{
		this.movie = movie;
	}

	public int getItemid()
	{
		return movieId;
	}

	public void setItemid(int movieId)
	{
		this.movieId =movieId;
	}

	public List<MoviePricing> getListmoviePricing()
	{
		return listmoviePricing;
	}

	public void setListmoviePricing(List<MoviePricing> listmoviePricing)
	{
		this.listmoviePricing = listmoviePricing;
	}

	public MovieCustomer getCustomer()
	{
		return customer;
	}

	public void setCustomer(MovieCustomer customer)
	{
		this.customer = customer;
	}
	
	
	public void fetchTypes() 
	{
		System.out.println("inside  bean fetch types");
		try 
		{
			MenuDaoImpl impl=new MenuDaoImpl();
			this.typeList =dao.getTypes();
		} 
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	}
	
	
	public void fetchCategories() 
	{
		try 
		{
			
			this.typeList =dao.getCategories(type);
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		
	}
	
	
	public void fetchMovies() 
	{
		try 
		{
			this.movieList = dao.getMovie(type,category);
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		
		
	}
	
	public void fetchMovie() 
	{
		try 
		{
			this.movie=dao.findMovie(movieId);
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
	
	}
	
	
	
	public void fetchMoviePricing()
	{

		try 
		{
			Movie movie=dao.findMovie(movieId);
			this.listmoviePricing=movie.getListprizing();
			for (MoviePricing price: listmoviePricing)
			{
				System.out.println(price.toString());
			}
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		}
		
	}
		
	
	
	
	

}
