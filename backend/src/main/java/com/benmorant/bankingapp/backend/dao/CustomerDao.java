package com.benmorant.bankingapp.backend.dao;

import com.benmorant.bankingapp.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Long> {

  Customer findByCustomerIdentifier(String customerIdentifier);
}
