package com.klef.jfsd.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Booking;
import com.klef.jfsd.springboot.model.BookingDetails;
import com.klef.jfsd.springboot.model.Customer;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.BookingRepository;
import com.klef.jfsd.springboot.repository.CustomerRepository;


@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
    private BookingRepository bookingRepository;

	@Override
	public List<Customer> viewallemps() {
		
		return customerRepository.findAll();
	}

	@Override
	public String deleteemp(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewempbyid(int cid) 
	{
         
		Optional<Customer> obj = customerRepository.findById(cid);    
	    
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
	public Admin checkadminlogin(String auname, String apwd) {
		
		return adminRepository.checkadminlogin(auname, apwd);
	}

	
	public List<BookingDetails> viewAllBookingsWithCustomerDetails() 
	{
	    List<BookingDetails> bookingDetailsList = new ArrayList<>();

	    List<Booking> bookings = bookingRepository.findAll(); // Retrieve all bookings
	    for (Booking booking : bookings) {
	        Customer customer = booking.getCustomer(); // Get the customer associated with the booking

	        BookingDetails bookingDetails = new BookingDetails();
	        bookingDetails.setBooking(booking);
	        bookingDetails.setCustomer(customer);

	        bookingDetailsList.add(bookingDetails);
	    }

	    return bookingDetailsList;
	}

}
