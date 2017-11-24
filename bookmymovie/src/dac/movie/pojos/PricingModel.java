package dac.movie.pojos;

import java.util.ArrayList;
import java.util.List;

public class PricingModel
{
List<MoviePricing>cartmp;
List<Double>totallist;
double total;


public PricingModel()
{
	cartmp=new ArrayList<MoviePricing>();
	this.totallist=new ArrayList<Double>();
	this.total=0.0;
}


public List<MoviePricing> getCartmp()
{
	return cartmp;
}


public void setCartmp(List<MoviePricing> cartmp)
{
	this.cartmp = cartmp;
}


public List<Double> getTotallist()
{
	return totallist;
}


public void setTotallist(List<Double> totallist)
{
	this.totallist = totallist;
}


public double getTotal()
{
	return total;
}


public void setTotal(double total)
{
	this.total = total;
}


@Override
public String toString()
{
	return "PricingModel [cartmp=" + cartmp + ", totallist=" + totallist
			+ ", total=" + total + "]";
}

}