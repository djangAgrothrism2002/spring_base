package com.vpbank.payment.api.dao.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse<T> {
    @JsonProperty("code")
    private int code;
    @JsonProperty("message")
    private String message;
    @JsonProperty("body")
    private T body;

    public CommonResponse() {}
    public CommonResponse(int code, String message, T body){
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
