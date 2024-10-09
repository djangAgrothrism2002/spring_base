package com.vpbank.payment.api.controller;

import com.vpbank.payment.api.dao.requests.AuthenticationRequest;
import com.vpbank.payment.api.dao.requests.RegisterRequest;
import com.vpbank.payment.api.dao.response.CommonResponse;
import com.vpbank.payment.api.dao.response.TokenResponse;
import com.vpbank.payment.infrastruture.abstractServices.IAuthenticatorService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/v1/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticatorService authenticatorService;

    @Validated
    @RequestMapping(path = "/login", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<CommonResponse<TokenResponse>> Login (@RequestBody @Validated AuthenticationRequest authenticationRequest, BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new CommonResponse<TokenResponse>(400, "Error: Invalid request body", null));
        } else {
            try {
                CommonResponse<TokenResponse> res = authenticatorService.authenticateService(authenticationRequest);
                return ResponseEntity.ok(res);
            }
            catch (Exception e) {
                return ResponseEntity.internalServerError().body(new CommonResponse<TokenResponse>(500, "Error: something went wrong", null));
            }
        }
    }

    @Validated
    @RequestMapping(path = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<CommonResponse<TokenResponse>>  Register (@RequestBody @Validated RegisterRequest registerRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(new CommonResponse<TokenResponse>(400, "Error: Invalid request body", null));
        } else {
            try {
                CommonResponse<TokenResponse>  res = authenticatorService.registerService(registerRequest);
                return ResponseEntity.ok(res);
            }
            catch (Exception e) {
                return ResponseEntity.internalServerError().body(new CommonResponse<TokenResponse>(500, "Error: something went wrong", null));
            }
        }
    }

    @RequestMapping(path = "/refresh-token", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    private CommonResponse<TokenResponse> RefreshTokenAuth () {
        return new CommonResponse<TokenResponse> (200, "Login successfully!", new TokenResponse("dfioufidsu","sdfiidosfio8dfs"));
    }

    @RequestMapping(path = "/validate-otp", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    private CommonResponse<Boolean> ValidateOtp () {
        return new CommonResponse<Boolean> (200, "Login successfully!", true );
    }

    @RequestMapping(path = "/validate-otp", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    private CommonResponse<Boolean> ChangePassword () {
        return new CommonResponse<Boolean> (200, "Login successfully!", true );
    }


}

