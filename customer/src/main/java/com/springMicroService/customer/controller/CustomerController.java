package com.springMicroService.customer.controller;

import com.springMicroService.customer.dao.Customer;
import com.springMicroService.customer.repo.CustomerRepo;
import com.springMicroService.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CustomerService customerService;


    @PostMapping("/register")
    public void registerCustomer(@RequestBody Customer customer){
        //log.info("New customer registration {}", customer);
        customerService.registerCustomer(customer);
    }
}
