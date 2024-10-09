package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long TransactionTypeID;

    @Column(name = "TransactionTypeName", length = 10, nullable = true)
    private String TransactionTypeName;

    @Column(name = "TransactionTypeDescription", length = 50, nullable = true)
    private String TransactionTypeDescription;

    @Column(name = "TransactionFeeAmount", nullable = true)
    private BigDecimal TransactionFeeAmount;
}