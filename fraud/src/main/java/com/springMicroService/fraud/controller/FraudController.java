package com.springMicroService.fraud.controller;

import com.springMicroService.fraud.dao.FraudCheckHistory;
import com.springMicroService.fraud.service.FraudCheckHistoryService;
import com.springMicroService.fraud.service.FraudCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    @Autowired
    private FraudCheckHistoryService fraudCheckHistoryService;
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId){
        //return new ResponseEntity<>(fraudCheckHistoryService.isFraudulentCustomer(customerId),HttpStatus.ACCEPTED);
        boolean isFraudCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isFraudCustomer);
    }
}
