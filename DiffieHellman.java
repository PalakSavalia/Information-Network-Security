import java.util.*;
import java.math.*;

class DiffieHellman {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int p = 23, a = 6, b = 15, g	= 0;
		g = generateRandom(p);	
		System.out.println("p = " + p + " g = " + g + " a = " + a + " b = " + b);

		BigInteger bigG = BigInteger.valueOf(g);
		BigInteger bigP = BigInteger.valueOf(p);
		
		int publicA = 0, publicB = 0, privateA = 0, privateB = 0;
		publicA = ( (bigG.pow(a)).mod(bigP) ).intValue();
		publicB = ( (bigG.pow(b)).mod(bigP) ).intValue();
		System.out.println("Message sent by Alice : " + publicA);
		System.out.println("Message sent by Bob : " + publicB);

		BigInteger bigPublicA = BigInteger.valueOf(publicA);
		BigInteger bigPublicB = BigInteger.valueOf(publicB);
		privateA = ( (bigPublicB.pow(a)).mod(bigP) ).intValue();
		privateB = ( (bigPublicA.pow(b)).mod(bigP) ).intValue();
		System.out.println("Key calculated by Alice : " + privateA);
		System.out.println("Key calculated by Bob : " + privateB);

	}

	public static int generateRandom(int p) {
		int x,y;
		BigInteger gen;
		Random rand = new Random();
		//System.out.println("p : " + p);
		while(true) {
			x = rand.nextInt(p);
			y = rand.nextInt(p);
			gen = BigInteger.valueOf(rand.nextInt(p));
			if(x!=y && x!=0 && y!=0 && x!=1 && y!=1 && x!=p && y!=p){
				if(((gen.pow(x)).mod(BigInteger.valueOf(p))) != ((gen.pow(y)).mod(BigInteger.valueOf(p))))
					break;
			}
		}
		return gen.intValue();
	}

}
