package com.springMicroService.customer.service;

import com.springMicroService.customer.dao.Customer;
import com.springMicroService.customer.repo.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor

public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CustomerRepo customerRepo;

    public void registerCustomer(Customer customer){
        //TODO: check if customer is fraudster
        customerRepo.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
        FraudCheckResponse.class,
                customer.getId());

        if (!fraudCheckResponse.isFraudster())
                customerRepo.save(customer);
        else
            throw new IllegalStateException("Fraudster");
    }
}
