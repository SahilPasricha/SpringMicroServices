package com.springMicroService.fraud.repo;

import com.springMicroService.fraud.dao.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepo extends JpaRepository<FraudCheckHistory, Integer> {
}
