package com.app.security;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

public class HashGenerator extends AppSecurity{

	private static Random rand = new Random((new Date()).getTime());
	
	@Override
	public String encrypt(String message) {
		byte[] salt = new byte[8];
		rand.nextBytes(salt);
		String Base64Str = Base64.getEncoder().encodeToString(salt) + Base64.getEncoder().encodeToString(message.getBytes()); // 
		return Base64Str;
	}
	
	@Override
	protected String decrypt(String message) {
		String actualString = null;
		 if (message.length() > 12) {
			String cipher = message.substring(12);
			byte[] actualByte;
			try {
				actualByte = Base64.getDecoder().decode(cipher);
				actualString = new String(actualByte); 
			} catch (Exception e) {
				e.printStackTrace();
			} 
		 }
		return actualString;
	}
}
