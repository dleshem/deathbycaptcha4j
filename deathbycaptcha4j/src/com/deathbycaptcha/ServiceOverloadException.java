package com.deathbycaptcha;

public class ServiceOverloadException extends DeathbycaptchaException {
	private static final long serialVersionUID = 1L;
	
	public ServiceOverloadException(Error error) {
		super(error);
    }

    public ServiceOverloadException(Error error, Throwable cause) {
        super(error, cause);
    }
}
