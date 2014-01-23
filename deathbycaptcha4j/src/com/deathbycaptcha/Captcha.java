package com.deathbycaptcha;

public class Captcha {
	public final String filename;
	public final String contentType;
    public final byte[] content;
    
    public Captcha(String filename, String contentType, byte[] content) {
    	this.filename = filename;
    	this.contentType = contentType;
        this.content = content;
    }
}
