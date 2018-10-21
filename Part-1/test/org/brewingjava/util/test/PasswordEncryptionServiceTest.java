package org.brewingjava.util.test;

import static org.junit.Assert.*;

import org.brewingjava.util.PasswordEncryptionService;
import org.junit.Test;

public class PasswordEncryptionServiceTest {
	@Test
	public void generateSecurePasswordTest(){
		String password= "test";
		String encryptedPass = PasswordEncryptionService.generateSecurePassword(password, PasswordEncryptionService.salt);
		assertEquals("Test Encryption", "D0Nq6BBoMlrfNFaZePRFWn0QJcJUC8c1jmerGVml1pE=", encryptedPass);	
	}

}
