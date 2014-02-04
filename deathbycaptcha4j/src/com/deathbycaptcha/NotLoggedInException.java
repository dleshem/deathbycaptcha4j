package com.deathbycaptcha;

public class NotLoggedInException extends DeathbycaptchaException {
	private static final long serialVersionUID = 1L;
	
	public NotLoggedInException(Error error) {
		super(error);
    }

    public NotLoggedInException(Error error, Throwable cause) {
        super(error, cause);
    }
}
