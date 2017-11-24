package dac.movie.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dac.movie.pojos.Login;
import dac.movie.pojos.Movie;
import dac.movie.pojos.MovieCustomer;
import dac.movie.pojos.MoviePricing;
import dac.movie.pojos.OrderModel;
import dac.movie.pojos.PriceId;
import dac.movie.pojos.PricingModel;
import dac.movie.services.MovieService;
import dac.movie.services.MovieServiceImpl;


@SessionAttributes({"listPricing","email","IntId","customer"})
@Controller
public class MovieController
{
@Autowired	
MovieService service;


@RequestMapping("/index")
public String Login(@ModelAttribute Login lg,HttpServletRequest req)
{
	return "index";	
}

@RequestMapping("/menu")
public String mainMenu(Model model, HttpServletRequest request,HttpServletResponse response)throws IOException
{
	
	List<String>types=service.fetchTypes();
	model.addAttribute("types", types);
	return "menu";
	

}



@RequestMapping("/purchase")
public ModelAndView doPurchase(HttpServletRequest request,HttpServletResponse response)throws IOException
{
	
	OrderModel orderModel=new OrderModel();
    HttpSession session= request.getSession();
    PricingModel pmodel=(PricingModel) session.getAttribute("listPricing");
    System.out.println("pmodel is :"+pmodel.toString());
    MovieCustomer customer= (MovieCustomer) session.getAttribute("customer");
    List<Integer>ilist =(List<Integer>) session.getAttribute("IntId");    
    //System.out.println("selected pricing list is"+);
    
    orderModel.setPricingListOrder(pmodel.getCartmp());
    orderModel.setCustomerOrder(customer);
    orderModel.setIntidListOrder(ilist);
    
    service.insertBooking(orderModel);
    
    
    System.out.println("final model is"+orderModel.toString());
    ModelAndView modelAndView=new ModelAndView();
	modelAndView.setViewName("purchase"); 
	modelAndView.addObject("pmodel",pmodel);
	
	
	
	
	return modelAndView;
	

}




@RequestMapping("/signup_background_image")
public void signup_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/icici.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}



@RequestMapping("/menu_background_image")
public void menu_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/mainimg.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}



@RequestMapping("/purchase_background_image")
public void purchase_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/purchase.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}


@RequestMapping("/admin_background_image")
public void admin_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/admin.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}







@RequestMapping("/movie_background_image")
public void movie_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/page2back.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}

@RequestMapping("/Booked_movie_background_image")
public void Booked_movie_background_image(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/page3back.jpg");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}







@RequestMapping("/bookmyshowlogo")
public void bookmyshowlogo(HttpServletRequest request,HttpServletResponse response) throws IOException {
    response.setContentType("image/jpeg");
    ServletContext servletContext=request.getServletContext(); 
    InputStream in = servletContext.getResourceAsStream("/images/bookmyshowlogo.png");
    IOUtils.copy(in, response.getOutputStream());
    in.close();
}

@RequestMapping("/login")
public ModelAndView doLogin( @ModelAttribute Login lg,HttpServletRequest req)
{
	
	ModelAndView modelAndView=new ModelAndView();
	System.out.println("lg before login is "+lg.toString());
	String status=service.findLogin(lg);
	System.out.println("lg after suceessful login"+lg.toString());
	//model.addAttribute("lg",lg);
	modelAndView.addObject("lg",lg);
	modelAndView.addObject("customer",lg.getCust());
	System.out.println("status is"+status);
	modelAndView.setViewName(status);
	return modelAndView;
	//return status;
	
}

@RequestMapping("/insertmovie")
public ModelAndView doInsertMovie(@ModelAttribute  Movie movie,HttpServletRequest req)
{
	ModelAndView modelAndView=new ModelAndView();
	System.out.println("movie details is :"+movie.toString());
	service.insertMovie(movie);
	modelAndView.addObject("message","movie added sucessfully");
	modelAndView.setViewName("admin");
	modelAndView.addObject("stat","success");
	return modelAndView;
}



@RequestMapping("/signup")
public String doSignup(@ModelAttribute MovieCustomer cust,HttpServletRequest req)
{
	
	return "signup";
}

@RequestMapping("/logout")
public String doLogout(@ModelAttribute MovieCustomer cust,HttpServletRequest req)
{
	
	return "logout";
}

@RequestMapping("/default")
public String doDefault(@ModelAttribute MovieCustomer cust,HttpServletRequest req)
{
	
	return "default";
}


@RequestMapping("/bookedmoviep")
public String doBookedMovieP(@ModelAttribute MovieCustomer cust,HttpServletRequest req)
{
	
	return "bookedmovie";
}





@RequestMapping("/register")
public String doRegister(@ModelAttribute MovieCustomer cust,HttpServletRequest req)
{
	System.out.println("movie customer is"+cust);
	service.insertCustomer(cust);
	return "index";
}




@RequestMapping(value="/menu1")
public String getMovieCategories(Model model) 
{
	List<String>categories=service.fetchCategories("Bollywood");
	model.addAttribute("categories", categories);
	return "menu";
}


/*@RequestMapping(value="/bookedmovie")
public ModelAndView getPriceId(Model model, @ModelAttribute PriceId moviepriceid)
{
	moviepriceid.convertToIntId();
	List<MoviePricing> listpricing=service.fetchmoviepricing(moviepriceid.getIntmoviepriceid());
	//model.addAttribute("listPricing",listPricing);
	 ModelAndView modelAndView = new ModelAndView();
	 modelAndView.setViewName("bookedmovie");
	 modelAndView.addObject("listPricing",listpricing);
	//return "bookedmovie";
	 return modelAndView;
}*/




@RequestMapping(value="/bookedmovie")
public ModelAndView getPriceId(Model model, @ModelAttribute PriceId moviepriceid)
{
	
	  moviepriceid.convertToIntId();
	  PricingModel pmodel =service.fetchm(moviepriceid.getIntmoviepriceid());
	  ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("bookedmovie");
	  model.addAttribute("IntId",moviepriceid.getIntmoviepriceid());
	  modelAndView.addObject("listPricing",pmodel);
	  return modelAndView;
}



	

}
