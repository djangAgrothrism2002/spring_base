package com.vpbank.payment.infrastruture.abstractServices;

import com.vpbank.payment.api.dao.requests.AuthenticationRequest;
import com.vpbank.payment.api.dao.requests.RegisterRequest;
import com.vpbank.payment.api.dao.response.CommonResponse;
import com.vpbank.payment.api.dao.response.TokenResponse;

public interface IAuthenticatorService {
    CommonResponse<TokenResponse>  registerService(RegisterRequest request);
    CommonResponse<TokenResponse> authenticateService(AuthenticationRequest request);
}
