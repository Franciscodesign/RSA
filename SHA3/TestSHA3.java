package SHA3;

/**
 * TestSHA3.java
 * TODO: 
 *
 * @author Kim Dinh Son
 * Email:sonkdbk@gmail.com
 */

public class TestSHA3 {
	private static int bitrate = 256;
	private static int diversifier = 0;
	
	public static void main(String[] args){
		Keccak sha3 = new Keccak();
		sha3.setBitRate(bitrate);
		sha3.setDiversifier(diversifier);
		
		sha3.init(bitrate);
		byte[] mData = "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq".getBytes();
		sha3.update(mData, mData.length);
		byte[] hash = sha3.getHash(new byte[0]);

		Printer.printVector(hash);
		System.out.println();
	
	}
}
