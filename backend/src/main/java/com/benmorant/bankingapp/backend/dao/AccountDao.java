package com.benmorant.bankingapp.backend.dao;


import com.benmorant.bankingapp.backend.entity.Account;
import com.benmorant.bankingapp.backend.entity.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

  List<Account> findByCustomer(Customer customer);
}
