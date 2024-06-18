package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Booking;
import com.klef.jfsd.springboot.model.Customer;

public interface CustomerService 
{
	
	public String addcustomer(Customer c);
	
	public String updateprofile(Customer c);
	
	public Customer checkcustomerlogin(String username,String password);
	
	public Customer viewprofile(int id);
	
	public String bookService(Booking booking);
	
	public Customer findbyid(int id);
	
	public List<Booking> getBookingsForCustomer(int customerId);

}
