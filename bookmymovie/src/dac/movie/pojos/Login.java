package dac.movie.pojos;



public class Login
{
	String email;
	String pass;
	
	private String user;
	private MovieCustomer cust;
	
	String navid;
	
	public Login()
	{
		this.email = "";
		this.pass = "";
		this.user = "annonymous";
		this.cust=new MovieCustomer();
		this.navid="";
		
	}
	public String getNavid() {
		return navid;
	}
	public void setNavid(String navid) {
		this.navid = navid;
	}
	public Login(String email,String pass)
	{
		this.email=email;
		this.pass=pass;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getUser()
	{
		return user;
	}
	public void setUser(String user)
	{
		this.user = user;
	}
	public MovieCustomer getCust()
	{
		return cust;
	}
	public void setCust(MovieCustomer cust)
	{
		this.cust = cust;
	}
	@Override
	public String toString()
	{
		return "Login [email=" + email + ", pass=" + pass + ", user=" + user
				+ ", cust=" + cust + ", navid=" + navid + "]";
	}
	
	
	
	
	
	
	
	
	
	


}
