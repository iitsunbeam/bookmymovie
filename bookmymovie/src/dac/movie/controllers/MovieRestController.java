package dac.movie.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dac.movie.pojos.Login;
import dac.movie.pojos.Movie;
import dac.movie.services.MovieService;


@Controller
public class MovieRestController
{
	@Autowired	
	MovieService service;
	
@RequestMapping(value="/menu/{type}", method=RequestMethod.GET)
	public String getMovieCategories(Model model,@PathVariable("type") String type) 
	{
	    String str="";
		System.out.println("inside rest controller " +type);
		List<String>categories=service.fetchCategories(type);
		model.addAttribute("res",categories);
		 String redirectUrl = "./";
		return "redirect:"+redirectUrl;
		
 }

@RequestMapping(value="/menu2", method=RequestMethod.GET)
public String ShowMovieList(Model model,@RequestParam("category")String cat,@RequestParam("type")String type)
{
System.out.println("inside rest controller  type :"+type+"category :"+cat);
List<Movie>listMovie=service.fetchMovies(type, cat);
for (Movie movie : listMovie)
{
	System.out.println("movie is :"+movie.toString());
}

model.addAttribute("movies",listMovie);
return "menu";
}


@RequestMapping(value="/showmovie", method=RequestMethod.GET)
public String ShowMovieDescription(Model model,@RequestParam("id")String ids)
{
int id=Integer.parseInt(ids);
System.out.println("inside rest controller id in int is="+id);
Movie movie=service.fetchMovie(id);
model.addAttribute("movie",movie);
return "showmovie";
}


@RequestMapping(value="/indexp",method=RequestMethod.GET)
public String Loginp(Model model,@RequestParam("id")String ids)
{
	System.out.println("inside rest Login purchase id ="+ids);
	model.addAttribute("ids",ids);
	return "index";	
}

@RequestMapping(value="/indexm",method=RequestMethod.GET)
public String Loginm(Model model,@RequestParam("id")String ids)
{
	
	model.addAttribute("id",ids);
	return "index";	
}







}
