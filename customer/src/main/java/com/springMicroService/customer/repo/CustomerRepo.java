package com.springMicroService.customer.repo;

import com.springMicroService.customer.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
