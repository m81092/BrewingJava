package org.brewingjava.util; 

import java.security.NoSuchAlgorithmException; 
import java.security.SecureRandom; 
import java.security.spec.InvalidKeySpecException; 
import java.security.spec.KeySpec; 
import java.util.Arrays; 
import javax.crypto.SecretKeyFactory; 
import javax.crypto.spec.PBEKeySpec; 
/**
 * This class is used to encrypt password and validate password
 * Reference: https://www.javacodegeeks.com/2012/05/secure-password-storage-donts-dos-and.html 
 * 
 */
public class PasswordEncryptionService { 
 
	public boolean validatePassword(String password, byte[] storedPassword, byte[] salt) 
			throws NoSuchAlgorithmException, InvalidKeySpecException { 
		// Encrypt password text
		byte[] encryptedPassword = getEncryptedValue(password, salt); 
		// Login succeeds 
		return Arrays.equals(storedPassword, encryptedPassword); 
	} 
 
	public byte[] getEncryptedValue(String password, byte[] salt) 
			throws NoSuchAlgorithmException, InvalidKeySpecException { 
		// Algorithm key 
		String algorithm = "PBKDF2WithHmacSHA1"; 
		int derivedKeyLength = 160; 
		// Iteration count 
		int iterations = 20000; 
 
		KeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength); 
 
		SecretKeyFactory skfactory = SecretKeyFactory.getInstance(algorithm); 
 
		return skfactory.generateSecret(keyspec).getEncoded(); 
	} 
 
	public byte[] getSaltValue() throws NoSuchAlgorithmException { 
		// Use SecureRandom 
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG"); 
		// Generate a 8 byte salt 
		byte[] salt = new byte[8]; 
		random.nextBytes(salt); 
		return salt; 
	} 
	
	public static void main(String[] args) {
		PasswordEncryptionService service = new PasswordEncryptionService();
		try {
			byte[] salt = service.getSaltValue();
			System.out.println("Salt :"+salt);
			byte[] encryptedPassword = service.getEncryptedValue("test", salt);
			System.out.println("Encrypted Password :"+new String(encryptedPassword));
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
} 
