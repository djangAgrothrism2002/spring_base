package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CustomerID;

    @Column(name = "CustomerAddress1", length = 30)
    private String CustomerAddress1;

    @Column(name = "CustomerAddress2", length = 30)
    private String CustomerAddress2;

    @Column(name = "CustomerFirstName", length = 30, nullable = true)
    private String CustomerFirstName;

    @Column(name = "CustomerMiddleInitial", length = 1)
    private String CustomerMiddleInitial;

    @Column(name = "CustomerLastName", length = 30, nullable = true)
    private String CustomerLastName;

    @Column(name = "City", length = 30, nullable = true)
    private String City;

    @Column(name = "State", length = 2, nullable = true)
    private String State;

    @Column(name = "ZipCode", length = 10, nullable = true)
    private String ZipCode;

    @Column(name = "EmailAddress", length = 1)
    private String EmailAddress;

    @Column(name = "HomePhone", length = 10)
    private String HomePhone;

    @Column(name = "CellPhone", length = 10)
    private String CellPhone;

    @Column(name = "WorkPhone", length = 10)
    private String WorkPhone;

    @Column(name = "SSN", length = 10)
    private String SSN;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}