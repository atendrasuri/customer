package com.restful.customer.service;

import com.restful.customer.model.Customer;
import com.restful.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */


public interface CustomerService {

    public List<Customer> getAllCustomer();

    public Customer getCustomerById(Long id) ;

    public boolean addCustomer(Customer customer) ;

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Long id) ;

}