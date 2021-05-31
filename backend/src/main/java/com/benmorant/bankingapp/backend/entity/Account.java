package com.benmorant.bankingapp.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Account implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_account")
  private Long idAccount;

  @Column(name = "balance")
  private double balance;

  @Column(name = "interest_rate")
  private double interestRate;

  @Column(name = "overdraft")
  private double overdraft;

  @ManyToOne
  @JoinColumn(name = "id_customer")
  @JsonIgnore
  private Customer customer;

  @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
  private List<BankOperation> bankOperations;

  public Account() {
  }

  public Account(double balance, Customer customer, double interestRate, double overdraft) {
    this.balance = balance;
    this.customer = customer;
    this.interestRate = interestRate;
    this.overdraft = overdraft;
  }

  public Long getIdAccount() {
    return idAccount;
  }

  public void setIdAccount(Long idAccount) {
    this.idAccount = idAccount;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<BankOperation> getBankOperations() {
    return bankOperations;
  }

  public void setBankOperations(List<BankOperation> bankOperations) {
    this.bankOperations = bankOperations;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public double getOverdraft() {
    return overdraft;
  }

  public void setOverdraft(double overdraft) {
    this.overdraft = overdraft;
  }
}
