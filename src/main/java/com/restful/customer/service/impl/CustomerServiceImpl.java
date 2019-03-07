package com.restful.customer.service.impl;

import com.restful.customer.model.Customer;
import com.restful.customer.repository.CustomerRepository;
import com.restful.customer.service.CustomerService;
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


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {

        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll()
                .forEach(customers::add);
        return customers;
    }


    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).get();

    }


    @Override
    public boolean addCustomer(Customer customer) {

        Optional<Customer> list = customerRepository.findById(customer.getId());
        if (list.isPresent()) {
            return false;
        } else {
            customerRepository.save(customer);
            return true;
        }

    }

    @Override
    public void updateCustomer(Customer customer) {

        customerRepository.save(customer);

    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}