package com.deathbycaptcha;

public class DeathbycaptchaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public final Error error;
	
	public DeathbycaptchaException(Error error) {
		super(error.status + "|" + error.error);
		this.error = error;
    }

    public DeathbycaptchaException(Error error, Throwable cause) {
        super(error.status + "|" + error.error, cause);
        this.error = error;
    }
}
