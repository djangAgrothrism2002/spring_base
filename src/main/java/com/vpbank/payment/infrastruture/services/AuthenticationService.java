package com.vpbank.payment.infrastruture.services;

import com.vpbank.payment.api.dao.requests.AuthenticationRequest;
import com.vpbank.payment.api.dao.requests.RegisterRequest;
import com.vpbank.payment.api.dao.response.CommonResponse;
import com.vpbank.payment.api.dao.response.TokenResponse;
import com.vpbank.payment.application.UserService.CustomUserDetailsService;
import com.vpbank.payment.application.auth.JwtService;
import com.vpbank.payment.application.mail.EmailService;
import com.vpbank.payment.domain.entities.*;
import com.vpbank.payment.domain.reposistories.IAccountRepo;
import com.vpbank.payment.domain.reposistories.IUserLoginsRepo;
import com.vpbank.payment.domain.reposistories.IUserRepo;
import com.vpbank.payment.infrastruture.abstractServices.IAuthenticatorService;
import com.vpbank.payment.util.enums.PassbookType;
import jakarta.mail.MessagingException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthenticationService implements IAuthenticatorService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EmailService emailService;

    @Autowired
    private IAccountRepo iAccountRepo;

    @Autowired
    private IUserLoginsRepo  iUserLoginsRepo;

    @Autowired
    private IUserRepo iUserRepo;

    /*
    * User Authentication
    * */
    public boolean checkPassword(String rawPassword, String storedEncodedPassword) {
        return passwordEncoder.matches(rawPassword, storedEncodedPassword);
    }
    @Override
    public CommonResponse<TokenResponse> registerService(RegisterRequest request){
        try {
            var userFound = iUserRepo.findByEmail(request.getEmailAddress());
            var phoneCheck = iUserRepo.findByPhone(request.getPhone());
            if (!userFound.isEmpty() || !phoneCheck.isEmpty()) {
                return new CommonResponse<TokenResponse> (401,"Email or phone's number is exited !",new TokenResponse(null, null));
            } else {
                var user = AuthenticationRequest.builder()
                        .username(request.getEmailAddress())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build();
                Customer newCustomer = new Customer();
                String hashPassword = passwordEncoder.encode(request.getPassword());
                UserLogins newUserLogins = new UserLogins(request.getUsername(), hashPassword);
                Account newAccount = new Account( Long.parseLong(request.getPhone()), 0,  PassbookType.TRANSACTION_ACCOUNT.toString());
                User newUser = new User(request.getFirstName(), request.getLastName(), request.getDateOfBirth(), request.getGender(), request.getPhone(), request.getEmailAddress(), "", "", LocalDateTime.now(), LocalDateTime.now(), newUserLogins);
                newUser.add(newAccount);
                newUser.setCustomer(newCustomer);
                iUserLoginsRepo.save(newUserLogins);
                iUserRepo.save(newUser);
                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);
                return new CommonResponse<TokenResponse> (200,"Register's successfully !",new TokenResponse(jwtToken, refreshToken));
            }
        } catch (Exception e) {
            return new CommonResponse<TokenResponse> (401,"Error: " + e.toString(),new TokenResponse(null, null));
        }
    }

    public CommonResponse<TokenResponse> authenticateService(AuthenticationRequest request) {
        try {
            var userFound = iUserLoginsRepo.findByUsername(request.getUsername()).orElseThrow();
            if (checkPassword(request.getPassword(),userFound.getPassword())) {
                var user = AuthenticationRequest.builder()
                        .username(userFound.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build();
                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);
                return new CommonResponse<TokenResponse> (200,"Login's successfully !",new TokenResponse(jwtToken, refreshToken));
            } else {
                return new CommonResponse<TokenResponse> (401,"Password's wrong!",new TokenResponse(null, null));
            }
        } catch (Exception e){
            return new CommonResponse<TokenResponse> (401,"Account or password is wrong !",new TokenResponse(null, null));
        }
    }
    /*
     * Employee Authentication
     * */
    public CommonResponse<TokenResponse> employeeAuthenticateService(AuthenticationRequest request) {
        try {
            var userFound = iUserLoginsRepo.findByUsername(request.getUsername()).orElseThrow();
            if (checkPassword(request.getPassword(),userFound.getPassword())) {
                var user = AuthenticationRequest.builder()
                        .username(userFound.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .build();
                var jwtToken = jwtService.generateToken(user);
                var refreshToken = jwtService.generateRefreshToken(user);
                return new CommonResponse<TokenResponse> (200,"Login's successfully!",new TokenResponse(jwtToken, refreshToken));
            } else {
                return new CommonResponse<TokenResponse> (401,"Password's wrong!",new TokenResponse(null, null));
            }
        } catch (Exception e){
            return new CommonResponse<TokenResponse> (401,"Account or password is wrong!",new TokenResponse(null, null));
        }
    }
    /*
     * Common Authentication
     * */
    public CommonResponse<TokenResponse> refreshToken(TokenResponse request){
        return new CommonResponse<TokenResponse> (401,"Token's undefined !",new TokenResponse(null, null));
    }
}
