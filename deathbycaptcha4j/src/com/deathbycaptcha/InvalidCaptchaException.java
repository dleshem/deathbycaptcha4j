package com.deathbycaptcha;

public class InvalidCaptchaException extends DeathbycaptchaException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCaptchaException(Error error) {
		super(error);
    }

    public InvalidCaptchaException(Error error, Throwable cause) {
        super(error, cause);
    }
}
