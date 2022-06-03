package com.springMicroService.fraud.service;

import com.springMicroService.fraud.dao.FraudCheckHistory;
import com.springMicroService.fraud.repo.FraudCheckHistoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {
    private FraudCheckHistoryRepo fraudCheckHistoryRepo;

    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepo.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build()
        );
        return false;
    }
}


