package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FailedTransactionErrorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FailedTransactionErrorTypeID;

    @Column(name = "FailedTransactionDescription", length = 50, nullable = true)
    private String FailedTransactionDescription;
}