package com.klef.jfsd.springboot.service;




import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Booking;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.BookingRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HttpSession httpSession;
	

	@Override
	public String addcustomer(Customer c) {
		
		customerRepository.save(c);
		
		return "Registration Successfull......!";
	}


	@Override
	public Customer checkcustomerlogin(String username, String password) {
		
		return customerRepository.checkcustomerlogin(username, password);
	}


	@Override
	public Customer viewprofile(int id) 
	{
       Optional<Customer> obj = customerRepository.findById(id);    
	    
	    if(obj.isPresent())
	    {
	      Customer c = obj.get();
	      return c;
	    }
	    else
	    {
	      return null;
	    }
	}


	@Override
	public String bookService(Booking booking) {
	    
	    Integer customerId = (Integer) httpSession.getAttribute("cid");
	    if (customerId != null) {
	        
	        Optional<Customer> customerOpt = customerRepository.findById(customerId);
	        if (customerOpt.isPresent()) {
	            Customer customer = customerOpt.get();
	            
	            booking.setCustomer(customer);
	            
	            bookingRepository.save(booking);
	            return "Booking Successful";
	        }
	    }
	    return "Booking Failed because You are not logged in Please login and try again";
	}




	@Override
	public Customer findbyid(int id) 
	{
		Optional<Customer> obj = customerRepository.findById(id);
		
		Customer c  = obj.get();
		
		return c;
	}


	@Override
    public List<Booking> getBookingsForCustomer(int customerId) 
	{
        Optional<Customer> customerOpt = customerRepository.findById(customerId);

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            return customer.getBookings();
        }

        return new ArrayList<>(); // Return an empty list if the customer doesnt exist or has no bookings.
    }


	@Override
	public String updateprofile(Customer c) 
	{
		Customer cus = customerRepository.findById(c.getId()).get();
		
		cus.setUsername(c.getUsername());
		cus.setEmail(c.getEmail());
		cus.setPhonenumber(c.getPhonenumber());
	
		customerRepository.save(cus);
		
		return "Updated successfully....!";
		
	}

}
