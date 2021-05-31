package com.benmorant.bankingapp.backend.service;


import com.benmorant.bankingapp.backend.dao.AccountDao;
import com.benmorant.bankingapp.backend.dao.BankOperationDao;
import com.benmorant.bankingapp.backend.dao.CustomerDao;
import com.benmorant.bankingapp.backend.entity.Account;
import com.benmorant.bankingapp.backend.entity.BankOperation;
import com.benmorant.bankingapp.backend.entity.Customer;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankingappServiceImpl implements BankingappService {

  @Autowired
  private AccountDao accountDao;

  @Autowired
  private CustomerDao customerDao;

  @Autowired
  private BankOperationDao bankOperationDao;

  public BankingappServiceImpl() {
  }

  public BankingappServiceImpl(AccountDao accountDao, CustomerDao customerDao,
      BankOperationDao bankOperationDao) {
    this.accountDao = accountDao;
    this.customerDao = customerDao;
    this.bankOperationDao = bankOperationDao;
  }

  @Override
  public Account getAccountById(Long idAccount) {
    return accountDao.findById(idAccount).get();
  }

  @Override
  public List<Account> getAccountsByCustomerIdentifier(String customerIdentifier) {
    Customer customer = customerDao.findByCustomerIdentifier(customerIdentifier);
    return accountDao.findByCustomer(customer);
  }

  @Override
  public void addToAccount(Long idAccount, double amount) {
    Account currentAccount = getAccountById(idAccount);
    BankOperation deposit =
        new BankOperation(LocalDateTime.now(), amount, currentAccount, "deposit");
    bankOperationDao.save(deposit);
    currentAccount.setBalance(currentAccount.getBalance() + amount);
    accountDao.save(currentAccount);
  }

  @Override
  public void removeFromAccount(Long idAccount, double amount) {
    Account currentAccount = getAccountById(idAccount);
    BankOperation withdrawal =
        new BankOperation(LocalDateTime.now(), amount, currentAccount, "withdrawal");
    bankOperationDao.save(withdrawal);
    currentAccount.setBalance(currentAccount.getBalance() - amount);
    accountDao.save(currentAccount);
  }

  @Override
  public void transferAmount(Long idOriginAccount, Long idDestinationAccount, double amount) {
    removeFromAccount(idOriginAccount, amount);
    addToAccount(idDestinationAccount, amount);
  }
}
