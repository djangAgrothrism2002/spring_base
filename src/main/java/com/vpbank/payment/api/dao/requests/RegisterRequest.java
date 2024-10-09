package com.vpbank.payment.api.dao.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "Username is required")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "firstName is required")
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @JsonProperty("lastName")
    private String lastName;

    @NotBlank(message = "password is required")
    @JsonProperty("password")
    private String password;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("gender")
    private String gender;

    @NotBlank(message = "phone is required")
    @JsonProperty("phone")
    private String phone;

    @NotBlank(message = "email's address is required")
    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;
}
