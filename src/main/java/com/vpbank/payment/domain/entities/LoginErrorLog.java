package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ErrorLogID;

    @Column(name = "ErrorDatetime", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ErrorDatetime;

    @Column(name = "ErrorDescription", columnDefinition = "TEXT", nullable = true)
    private String ErrorDescription;
}