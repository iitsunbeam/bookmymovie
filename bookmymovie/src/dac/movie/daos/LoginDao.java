package dac.movie.daos;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dac.movie.pojos.MovieCustomer;


@Repository
public interface LoginDao
{

	public MovieCustomer findLogin(String email);
	public void insertCustomer(MovieCustomer cust);
	public String fetchuser(String emailid);
	
	
}
