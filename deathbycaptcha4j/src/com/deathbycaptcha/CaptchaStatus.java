package com.deathbycaptcha;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaStatus extends Error {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CaptchaStatus() {}
    
    @JsonInclude(Include.NON_NULL)
    public Long captcha;

    @JsonInclude(Include.NON_NULL)
    public Boolean is_correct;

    @JsonInclude(Include.NON_NULL)
    public String text;
}
