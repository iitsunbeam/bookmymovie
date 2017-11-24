package dac.movie.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name="movie")
public class Movie
{
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="ID")
	int id;
	@Column(name="Name")
	String name;
	@Column(name="Type")
	String type;
	@Column(name="Category")
	String category;
	@Column(name="Description")
	String description;
	@OneToMany(mappedBy="movie", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	List<MoviePricing>listprizing;
	
	public Movie()
	{
		this(0,"","","","");	
	}
	
	public Movie(int id, String name, String type, String category,String description)
	{
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
		listprizing=new ArrayList<MoviePricing>();
	
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<MoviePricing> getListprizing()
	{
		return listprizing;
	}

	public void setListprizing(List<MoviePricing> listprizing)
	{
		this.listprizing = listprizing;
	}

	@Override
	public String toString()
	{
		return String
				.format("Movie [id=%s, name=%s, type=%s, category=%s, description=%s, listprizing=%s]",
						id, name, type, category, description, listprizing);
	}
	
	
	
	
	

}
