package dac.movie.pojos;

import java.util.ArrayList;
import java.util.List;

public class OrderModel
{
	
List<MoviePricing>pricingListOrder;
MovieCustomer customerOrder;
List<Integer>intidListOrder;
 

public OrderModel()
{
 this.pricingListOrder=new ArrayList<MoviePricing>();
 this.customerOrder= new MovieCustomer();
 this.intidListOrder=new ArrayList<Integer>();
}


public List<MoviePricing> getPricingListOrder()
{
	return pricingListOrder;
}


public void setPricingListOrder(List<MoviePricing> pricingListOrder)
{
	this.pricingListOrder = pricingListOrder;
}


public MovieCustomer getCustomerOrder()
{
	return customerOrder;
}


public void setCustomerOrder(MovieCustomer customerOrder)
{
	this.customerOrder = customerOrder;
}


public List<Integer> getIntidListOrder()
{
	return intidListOrder;
}


public void setIntidListOrder(List<Integer> intidListOrder)
{
	this.intidListOrder = intidListOrder;
}

@Override
public String toString()
{
	return "OrderModel [pricingListOrder=" + pricingListOrder
			+ ", customerOrder=" + customerOrder + ", intidListOrder="
			+ intidListOrder + "]";
}

}
