package RSA;

import java.math.BigInteger;

import PrimeNumber.GenPrime;

/**
 * RSA.java TODO:
 * 
 * @author Kim Dinh Son Email:sonkdbk@gmail.com
 */

public class RSA {
	private BigInteger n, d, e, p, q;

	private int bitlen;

	public RSA(BigInteger new_n, BigInteger new_e) {
		n = new_n;
		e = new_e;
	}

	public RSA(int bits) {
		bitlen = bits;
		generateKeys(bitlen);
	}
	
	// generate keys (e,n) and (d,p,q)
	public synchronized void generateKeys(int bitlen) {
//		SecureRandom r = new SecureRandom();
//		BigInteger p = new BigInteger(bitlen / 2, 100, r);
//		BigInteger q = new BigInteger(bitlen / 2, 100, r);
			
		p = new GenPrime().genPrime(bitlen/2);
		q = new GenPrime().genPrime(bitlen/2);
		n = p.multiply(q);
		BigInteger m = (p.subtract(BigInteger.ONE)).multiply(q
				.subtract(BigInteger.ONE)); // m = (p-1) * (q-1)
		
		e = new BigInteger("3");
		while (m.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
//			if (m.gcd(e).intValue() > 1) {
//				d = e.modInverse(m);
//				if (d.compareTo(n.divide(new BigInteger("4"))) > 0) { // d > n/4
//					break;
//				}
//			}
		}
		d = e.modInverse(m);
		
	}

	public synchronized String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(e, n).toString();
	}

	public synchronized BigInteger encrypt(BigInteger message) {
		return message.modPow(e, n);
	}

	public synchronized String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(d, n).toByteArray());
	}

	public synchronized BigInteger decrypt(BigInteger message) {
		return message.modPow(d, n);
	}

	public synchronized BigInteger getN() {
		return n;
	}

	public synchronized BigInteger getE() {
		return e;
	}
	
	public synchronized BigInteger getD() {
		return d;
	}
	
	public synchronized BigInteger getP() {
		return p;
	}
	
	public synchronized BigInteger getQ() {
		return q;
	}
}
