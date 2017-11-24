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

import dac.movie.pojos.MovieCustomer;


@org.springframework.transaction.annotation.Transactional
@Repository
public class LoginDaoImpl implements LoginDao
{
	@Autowired
	SessionFactory factory;
	
	
	public MovieCustomer findLogin(String email)
	{
	    Session hbSession=factory.getCurrentSession();
		Criteria cr = hbSession.createCriteria(MovieCustomer.class);
		cr.add(Restrictions.eq("email",email));
		return (MovieCustomer)cr.list().get(0);
		
}

    
	public void insertCustomer(MovieCustomer cust)
	{
		System.out.println("customer is "+cust.toString());
		Session session=factory.getCurrentSession();
		session.save(cust);
	}


	@Override
	public String fetchuser(String emailid) 
	{
		Session session=factory.getCurrentSession();
		String sql="SELECT NAME FROM MOVIE_CUSTOMERS WHERE EMAIL=:P_TYPE";
    	SQLQuery q=session.createSQLQuery(sql);
 		q.setString("P_TYPE",emailid);
 		return (String) q.list().get(0);
		
	}
	

}
