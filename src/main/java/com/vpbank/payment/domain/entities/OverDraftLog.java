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
@Getter
@Setter
@Table(name = "over_draf_log")
public class OverDraftLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "account", nullable = true)
    private Account account;

    @Column(name = "OverDraftDate", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date OverDraftDate;

    @Column(name = "OverDraftAmount", nullable = true)
    private BigDecimal OverDraftAmount;
}