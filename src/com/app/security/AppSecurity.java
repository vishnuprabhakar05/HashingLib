package com.app.security;

public abstract class AppSecurity {

	protected abstract String encrypt(String message);
	protected abstract String decrypt(String message);
		
}
