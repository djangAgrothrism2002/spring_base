package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FailedTransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FailedTransactionID;

    @ManyToOne
    @JoinColumn(name = "FailedTransactionErrorTypeID", nullable = true)
    private FailedTransactionErrorType failedTransactionErrorType;

    @Column(name = "FailedTransactionErrorTime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date FailedTransactionErrorTime;


}