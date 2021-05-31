package com.benmorant.bankingapp.backend.dao;

import com.benmorant.bankingapp.backend.entity.BankOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankOperationDao extends JpaRepository<BankOperation, Long> {

}
