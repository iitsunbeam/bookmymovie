package dac.movie.pojos;

import java.util.ArrayList;
import java.util.List;

public class PriceId
{
	String[] moviepriceid;
	private List<Integer> intmoviepriceid;
	
	public PriceId()
	{
	   this.intmoviepriceid=new ArrayList<Integer>();
	}

	public String[] getMoviepriceid()
	{
		return moviepriceid;
	}

	public void setMoviepriceid(String[] moviepriceid)
	{
		this.moviepriceid = moviepriceid;
	}
	
	public List<Integer> getIntmoviepriceid()
	{
		return intmoviepriceid;
	}

	public void setIntmoviepriceid(List<Integer> intmoviepriceid)
	{
		this.intmoviepriceid = intmoviepriceid;
	}

	public void convertToIntId()
	{
		for (String strId : moviepriceid) {
			int id = Integer.parseInt(strId);
			intmoviepriceid.add(id);
		}
	}
	
	
	

}
