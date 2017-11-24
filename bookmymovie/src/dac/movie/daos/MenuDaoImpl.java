package dac.movie.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieBookings;
import dac.movie.pojos.MoviePricing;


@Transactional
@Repository 
public class MenuDaoImpl implements MenuDao
{
	@Autowired
	SessionFactory factory;

	
	public List<String> getTypes()
	{
		System.out.println("inside dao fetch types");
		Session session=factory.getCurrentSession();
        String sql="SELECT DISTINCT TYPE FROM MOVIE";
		SQLQuery q=session.createSQLQuery(sql);
		return q.list();
	}

	
	public List<String> getCategories(String type)
	{
		Session session=factory.getCurrentSession();
		String sql="SELECT DISTINCT CATEGORY FROM MOVIE WHERE TYPE=:P_TYPE";
		SQLQuery q=session.createSQLQuery(sql);
		q.setString("P_TYPE",type);
		return q.list();
		
		
	}

	
	public List<Movie> getMovie(String type, String categories)
	{
		System.out.println("inside menudao get movies  type :"+type+"categories :"+categories);
		 Session session=factory.openSession();
		 Criteria criteria=session.createCriteria(Movie.class);
		 criteria.add(Restrictions.like("type",type));
		 criteria.add(Restrictions.like("category",categories));
		 return criteria.list();
	}

	
	public Movie findMovie(int movieId)
	{
		Session session=factory.openSession();  
		Movie movie=(Movie) session.get(Movie.class,movieId);
		return movie;
	}

	
	public List<MoviePricing> findMoviePrice(int moviePriceId)
	{
		/*Session session=factory.getCurrentSession(); 
		 String sql="SELECT ID,MOVIEID,PRICINGTYPE,PRICE FROM MOVIE_PRICING WHERE MOVIEID:p_id";
         SQLQuery q=session.createSQLQuery(sql);
         q.setInteger("p_id", moviePriceId);
         return q.list();*/
         
        Session session=factory.getCurrentSession();
        String sql="SELECT ID,MOVIEID,PRICINGTYPE,PRICE FROM MOVIE_PRICING WHERE MOVIEID:p_id";
        SQLQuery q=session.createSQLQuery(sql);
        q.setInteger("p_id",moviePriceId);
        return q.list();
        
        
	}
	
	
	

	
	public MoviePricing getMoviePrice(int priceId)
	{
		Session session=factory.openSession();
		MoviePricing moviePricing=(MoviePricing) session.get(MoviePricing.class,priceId);
	    return moviePricing;
	}


	@Override
	public void insertBooking(MovieBookings mbooking)
	{
		
		System.out.println("booking details is :"+mbooking.toString());
		
		Session session=factory.openSession();
		
		System.out.println("inside insert dao ");
		
		session.merge(mbooking);
		session.flush();
		
		System.out.println("inserted sucessfully");
	}


	@Override
	public void insertMovie(Movie movie)
	{
		System.out.println("inside insertmovie dao");
		Session session=factory.openSession();
		session.save(movie);
		session.flush(); 
		
	}



}
