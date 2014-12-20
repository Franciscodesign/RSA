package PrimeNumber;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * ProbablePrime.java TODO:
 * 
 * @author Kim Dinh Son Email:sonkdbk@gmail.com
 */

public class ProbablePrime {
	public static final BigInteger ZERO = BigInteger.ZERO;
	public static final BigInteger ONE = BigInteger.ONE;
	public static final BigInteger TWO = BigInteger.valueOf(2);
	public static final int[] aValues = First_1000_Primes.getPrimes();
	
	public static boolean testPrime(BigInteger n, BigInteger a, int s, BigInteger d) {
		for (int i = 0; i < s; i++) {
			BigInteger exp = TWO.pow(i);
			exp = exp.multiply(d);
			BigInteger res = a.modPow(exp, n);
			if (res.equals(n.subtract(ONE)) || res.equals(ONE)) {
				return true;
			}
		}
		return false;
	}

	public static boolean millerRabin(BigInteger n, int numValues) { 
		BigInteger d = n.subtract(ONE);
		int s = 0;
		while (d.mod(TWO).equals(ZERO)) {
			s++;
			d = d.divide(TWO);
		}
		
		for (int i = 0; i < aValues.length; i++) {
			if(n.compareTo(BigInteger.valueOf(aValues[i]))==0)
				return true;
			if (n.mod(BigInteger.valueOf(aValues[i]))
					.compareTo(BigInteger.ZERO) == 0)
				return false;
		}
		
		System.out.println("Base Over");
		for (int i = 0; i < numValues; i++) {
			//BigInteger a = BigInteger.valueOf(aValues[i]);// random
			BigInteger a =  randomBigInteger(n);
			boolean r = testPrime(n, a, s, d);
			if (!r) {
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger randomBigInteger(BigInteger n) {
		SecureRandom rnd = new SecureRandom();
		int maxNumBitLength = n.bitLength();
		BigInteger aRandomBigInt = ZERO;
		while(aRandomBigInt.compareTo(ONE) <= 0)
			aRandomBigInt = new BigInteger(maxNumBitLength, rnd);	
		return aRandomBigInt.mod(n.subtract(ONE));
	}
}
