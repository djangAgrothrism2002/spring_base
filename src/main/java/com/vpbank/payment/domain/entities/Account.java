package com.vpbank.payment.domain.entities;

import com.vpbank.payment.util.enums.PassbookType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "account")
public class Account {

    public Account(long accountID, long currentBalance, String accountStatusType) {
        AccountID = accountID;
        CurrentBalance = currentBalance;
        this.accountStatusType = String.valueOf(accountStatusType);
    }

    @Id
    private long AccountID;

    @Column(name = "CurrentBalance", nullable = true)
    private long CurrentBalance;



    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    private String accountStatusType;

}