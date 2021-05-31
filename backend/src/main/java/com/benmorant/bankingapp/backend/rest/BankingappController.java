package com.benmorant.bankingapp.backend.rest;

import com.benmorant.bankingapp.backend.entity.Account;
import com.benmorant.bankingapp.backend.exception.MyEntityNotFoundException;
import com.benmorant.bankingapp.backend.service.BankingappService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "*") // authorises everyone in dev phase
@RequestMapping(value = "/rest/api", headers = "Accept=application/json")
public class BankingappController {

  @Autowired
  private BankingappService bankingappService;

  // http://localhost:8060/bankingapp/rest/api/public/account/1
  @GetMapping(value = "/public/account/{idAccount}")
  Account getAccountById(@PathVariable(name = "idAccount") Long idAccount)
      throws MyEntityNotFoundException {
    Account account = bankingappService.getAccountById(idAccount);
    if (account == null) {
      throw new MyEntityNotFoundException("no account with ID " + idAccount);
    } else {
      return account;
    }
  }

  // http://localhost:8060/bankingapp/rest/api/public/customer/A1234567/accounts
  @GetMapping(value = "/public/customer/{customerIdentifier}/accounts")
  List<Account> getAllAccountsByCustomerIdentifier(
      @PathVariable(name = "customerIdentifier") String customerIdentifier)
      throws MyEntityNotFoundException {
    List<Account> accountsByCustomerIdentifier =
        bankingappService.getAccountsByCustomerIdentifier(customerIdentifier);
    if (accountsByCustomerIdentifier == null) {
      throw new MyEntityNotFoundException("aucun compte avec l'identifier =" + customerIdentifier);
    } else {
      return accountsByCustomerIdentifier;
    }
  }

  @PostMapping(value = "/public/doBankOperation")
  public String doBankOperation(
      Long idAccount,
      Long idDestinationAccount,
      String operationType,
      @RequestParam(defaultValue = "0") double operationAmount) {
    if (operationType.equals("deposit")) {
      bankingappService.addToAccount(idAccount, operationAmount);
    } else if (operationType.equals("withdrawal")) {
      bankingappService.removeFromAccount(idAccount, operationAmount);
    } else {
      bankingappService.transferAmount(idAccount, idDestinationAccount, operationAmount);
    }
    return "redirect:/public/account/" + idAccount;
  }
}
