package RSA;

import java.math.BigInteger;

import SHA3.Printer;

/**
 * TestShareFile.java
 * TODO: 
 *
 * @author Kim Dinh Son
 * Email:sonkdbk@gmail.com
 */

public class TestRSA {

	public static void main(String[] args) throws Exception {
		RSA rsa = new RSA(6142);

		String text1 = "I am madly, deeply, truly, passionately in love with you"; //test
		System.out.println("Plaintext: " + text1);
		BigInteger plaintext = new BigInteger(text1.getBytes());

		// encryption
		BigInteger ciphertext = rsa.encrypt(plaintext);
		System.out.println("Ciphertext: " + ciphertext);
		
		// decryption
		plaintext = rsa.decrypt(ciphertext);
		String text2 = new String(plaintext.toByteArray());
		System.out.println("Plaintext: " + text2);
		
		// OAEP test
		System.out.println("OAEP test.");
		String myMessage = "I am madly, deeply, truly, passionately in love with you";
		byte[] em = null;
		RSA rsa_1 = new RSA(2048);
		// Encode
		while (em == null) {
			rsa_1 = new RSA(2048);
			BigInteger ciphertext_1 = rsa_1.encrypt(new BigInteger(myMessage
					.getBytes()));
			em = OAEP.encrypt(ciphertext_1.toByteArray(), rsa_1, rsa_1.getN()
					.bitLength() / 8); // RSA: 2048 bits			
		}
		if (em != null)
			Printer.printVector(em);
		System.out.println();
		
		// Decode
		Printer.printVector(OAEP.decrypt(em, rsa, rsa_1.getN().bitLength() / 8));
		
	}
}
