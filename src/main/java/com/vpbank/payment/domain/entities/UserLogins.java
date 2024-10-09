package com.vpbank.payment.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_logins")
public class UserLogins  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userID;

    public UserLogins(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "password", nullable = true)
    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}