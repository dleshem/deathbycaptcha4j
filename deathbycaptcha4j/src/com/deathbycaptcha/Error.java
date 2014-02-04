package com.deathbycaptcha;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String ERROR_NOT_LOGGED_IN = "not-logged-in";
    public static final String ERROR_INVALID_CAPTCHA = "invalid-captcha";
    public static final String ERROR_SERVICE_OVERLOAD = "service-overload";
    
    /** Default constructor for JSON deserialization. */
    public Error() {}
    
    @JsonInclude(Include.NON_NULL)
    public Integer status;
    
    @JsonInclude(Include.NON_NULL)
    public String error;
}
