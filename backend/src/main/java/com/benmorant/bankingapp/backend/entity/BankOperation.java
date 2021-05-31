package com.benmorant.bankingapp.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class BankOperation implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_operation")
  private Long idOperation;

  @Column(name = "operation_type")
  private String operationType;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @Column(name = "operation_date")
  private LocalDateTime operationDate;

  @Column(name = "operation_amount")
  private double amount;

  @ManyToOne
  @JoinColumn(name = "id_account")
  @JsonIgnore
  private Account account;

  public BankOperation() {
  }

  public BankOperation(
      LocalDateTime operationDate, double amount, Account account, String operationType) {
    this.operationDate = operationDate;
    this.amount = amount;
    this.account = account;
    this.operationType = operationType;
  }

  public Long getIdOperation() {
    return idOperation;
  }

  public void setIdOperation(Long idOperation) {
    this.idOperation = idOperation;
  }

  public LocalDateTime getOperationDate() {
    return operationDate;
  }

  public void setOperationDate(LocalDateTime operationDate) {
    this.operationDate = operationDate;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
