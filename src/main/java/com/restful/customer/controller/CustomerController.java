package com.restful.customer.controller;

import com.restful.customer.model.Customer;
import com.restful.customer.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * @Author: atekumar
 * @Current-Version: 1.0.0
 * @Creation-Date: 06/03/19
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomer();

    }


    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public ResponseEntity<Void> addCustomers(@RequestBody Customer customerInfo, UriComponentsBuilder builder)
    {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerInfo, customer);
        boolean flag = customerService.addCustomer(customer);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerInfo, @PathVariable String id) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerInfo,customer);
        customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);


    }
}