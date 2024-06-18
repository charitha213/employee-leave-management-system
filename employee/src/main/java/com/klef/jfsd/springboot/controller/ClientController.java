package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired
;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Booking;
import com.klef.jfsd.springboot.model.BookingDetails;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.service.AdminService;
import com.klef.jfsd.springboot.service.CustomerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
    private HttpSession httpSession;
	
	
	
	@GetMapping("/")
	public String main() 
	{
		return "index";
	}
	
	@GetMapping("cards")
	public String cards() 
	{
		return "cardscheck";
	}
	
	@GetMapping("logininterface")
	public String logininterface() 
	{
		return "logininterface";
	}
    
	@GetMapping("userloginform")
	public String userloginform() 
	{
		return "userloginform";
	}
	
	@GetMapping("customerregistration")
	public String customerregistration() 
	{
		return "customerregistration";
	}
	
	
	@PostMapping("insertcustomer")
	public ModelAndView insertaction(HttpServletRequest request) 
	{
		String msg = null;
		ModelAndView mv = new ModelAndView();
		
		try 
		{
			String fullname = request.getParameter("fullname");
			String username = request.getParameter("username");
		    String gender = request.getParameter("gender");
		    String email = request.getParameter("email");
		    String password = request.getParameter("password");
		    String phonenumber = request.getParameter("phonenumber");
			
		    
		      Customer c = new Customer();
		      c.setFullname(fullname);
		      c.setUsername(username);
		      c.setGender(gender);
		      c.setEmail(email);
		      c.setPassword(password);
		      c.setPhonenumber(phonenumber);
		      
		    
		      msg = customerService.addcustomer(c);
		      mv.setViewName("displaymsg");
			  mv.addObject("message",msg);
		        
		} 
		catch (Exception e) 
		{
			msg = e.getMessage();
			mv.setViewName("displaymsg");
			mv.addObject("message",msg);
		}
	   
		return mv;
	    
	}
	
	
	@PostMapping("checkcustomerlogin")
	public ModelAndView checkemplogin(HttpServletRequest request) 
	{
		 ModelAndView mv = new ModelAndView();
	
		 String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     
	    Customer c = customerService.checkcustomerlogin(username, password);
	    
	    if(c!=null)
	    {
	    	//session
	    	
	    	HttpSession session = request.getSession();
	    	
	    	session.setAttribute("cid", c.getId()); // eid is a session variable
	    	session.setAttribute("cname",c.getFullname()); // ename is a session variable
	    	
	    	//session
	    	
	    	mv.setViewName("customerhome");
	      
	    }
	    else
	    {
	      mv.setViewName("forbiddenpage");
	      mv.addObject("message","Login Failed");
	    }
		
	    return mv;
	}
	
	@GetMapping("viewprofile")
    public ModelAndView updateemp(HttpServletRequest request)
    {
		  ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      
	      mv.setViewName("customerprofile");
	      
	      mv.addObject("cid", session.getAttribute("cid"));
	      mv.addObject("cname", session.getAttribute("cname"));
	      
	      int id =  (int) session.getAttribute("cid");
	      
	      Customer c = customerService.viewprofile(id);
	      
	      mv.addObject("c", c);
	      
	      return mv;
    }
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	} 
	
	
	@GetMapping("customerhome")
	public ModelAndView customerhome(HttpServletRequest request) 
	{
    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("customerhome");
    	
    	return mv ;
	}
	
	
	@GetMapping("updateprofile")
	public ModelAndView updateprofile(HttpServletRequest request) 
	{
		  ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      
	      mv.setViewName("updatecustomerprofile");
	      
	      
	      mv.addObject("cid", session.getAttribute("cid"));
	      mv.addObject("cname", session.getAttribute("cname"));
	      
	      int id = (int) session.getAttribute("cid");
	      
	      Customer c = customerService.findbyid(id);
	      
	      
	      mv.addObject("customer", c);
	      
	      
		
		return mv;
		
	}
	
	@PostMapping("updatecustomerdetails")
	public ModelAndView updatecustomerdetails(HttpServletRequest request) 
	{
		 String msg = null;
	      
	      ModelAndView mv = new ModelAndView();
	      
	      HttpSession session = request.getSession();
	      mv.addObject("cid", session.getAttribute("cid"));
	      mv.addObject("cname", session.getAttribute("cname"));
	     
	      
	      int id = (int) session.getAttribute("cid");
	      
	      try 
	      {
	    	  String username = request.getParameter("username");
	    	  String email = request.getParameter("email");
	    	  String phonenumber = request.getParameter("phonenumber");
	    	  
	    	  
	    	  Customer cus = new Customer();
	    	  cus.setId(id);
	    	  cus.setUsername(username);
	    	  cus.setEmail(email);
	    	  cus.setPhonenumber(phonenumber);
	    	  
	    	  msg = customerService.updateprofile(cus);
	    	  
	    	  mv.setViewName("customerprofile");
	    	 
		      
		      Customer c = customerService.viewprofile(id);
		      
		      mv.addObject("c", c);
		      
	    	  mv.addObject("message", msg);
			
		  } 
	      catch (Exception e) 
	      {
	    	  msg = e.getMessage();
	    	  
	    	  mv.setViewName("customerprofile");
	    	  mv.addObject("message", msg);
		 }
		
		
		return mv;
		
	}
	
	
	
	//--------------------------> Admin <----------------------------------------------//
	
	@GetMapping("adminhome")
	public String adminhome() 
	{
		return "adminhome";
	}
	
	@GetMapping("adminlogin")  // URI & METHOD NAMR CAN BE DIFFERENT 
	public ModelAndView adminlogin() 
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		
		return mv;
		
	}
	
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request) 
	{
		 ModelAndView mv = new ModelAndView();
	
		String auname = request.getParameter("auname");
	    String apwd = request.getParameter("apwd");
	     
	    Admin admin = adminService.checkadminlogin(auname, apwd);
	    
	    if(admin!=null)
	    {
	    	
	    	mv.setViewName("adminhome");
	      
	    }
	    else
	    {
	      mv.setViewName("adminlogin");
	      mv.addObject("message","Login Failed");
	    }
		
	    return mv;
	}
	
	
	
	
	
	
	//--------------------------> Admin operation on Employee <----------------------------------------------//
	
	
	@GetMapping("viewallcustomers")
	public ModelAndView viewemps()
	{
		List<Customer> customer = adminService.viewallemps();
		
		ModelAndView mv = new  ModelAndView("viewallcustomers");
		mv.addObject("cdata",customer);
		
		
		
		
		return mv;
		
	}
	
	@GetMapping("view")
	  public ModelAndView viewempdemo(@RequestParam("id") int eid)
	  {
	    Customer c = adminService.viewempbyid(eid);
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("viewcustomerbyid");
	    mv.addObject("customer", c);
	    return mv;
	  }
	
	//********************************---------************************************************///
	
	@GetMapping("booking")
	  public ModelAndView booking()
	  {
	  
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("booking");
	    
	    return mv;
	  }
	
	@PostMapping("bookService")
    public ModelAndView bookService(HttpServletRequest request) 
	{
        ModelAndView mv = new ModelAndView();
        
        
        String pickupLocation = request.getParameter("pickupLocation");
        String dropOffLocation = request.getParameter("dropOffLocation");
        String pickupdate = request.getParameter("pickupDate");
        String dropOffdate = request.getParameter("dropoffdate");
        
        Booking booking = new Booking();
        booking.setPickupLocation(pickupLocation);
        booking.setDropOffLocation(dropOffLocation);
        booking.setPickupDate(pickupdate);
        booking.setDropOffDate(dropOffdate);
        
        String bookingResult = customerService.bookService(booking);
        
        if ("Booking Successful".equals(bookingResult)) {
            mv.setViewName("bookingConfirmation"); 
            mv.addObject("message", bookingResult);
        } else {
            mv.setViewName("bookingConfirmation"); 
            mv.addObject("message", bookingResult);
        }

        return mv;
    }

	
	@GetMapping("viewAllBookings")
	public ModelAndView viewAllBookings() {
	    ModelAndView mv = new ModelAndView("viewAllBookings"); 

	    List<BookingDetails> bookingDetailsList = adminService.viewAllBookingsWithCustomerDetails();
	    mv.addObject("bookingDetailsList", bookingDetailsList);

	    return mv;
	}

	@GetMapping("customerbookings")
    public ModelAndView getBookingsForLoggedInCustomer() {
        ModelAndView modelAndView = new ModelAndView("customerbookings");

        Integer customerId = (Integer) httpSession.getAttribute("cid");

        if (customerId != null) {
            List<Booking> bookings = customerService.getBookingsForCustomer(customerId);
            modelAndView.addObject("bookings", bookings);
        } else {
            
        }

        return modelAndView;
    }
	
	
	
	
}
