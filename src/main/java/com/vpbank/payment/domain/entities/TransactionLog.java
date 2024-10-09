package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TransactionLog")
@Getter
@Setter
public class TransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int TransactionID;

    @Column(name = "TransactionDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date TransactionDate;

    @ManyToOne
    @JoinColumn(name = "transaction_type", nullable = true)
    private TransactionType transactionType;

    @Column(name = "TransactionAmount", nullable = true)
    private BigDecimal TransactionAmount;

    @Column(name = "NewBalance", nullable = true)
    private BigDecimal NewBalance;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;

    @Column(name = "employee", nullable = true)
    private long employeeId;
}