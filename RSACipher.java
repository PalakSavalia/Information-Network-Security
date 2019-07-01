import java.util.*;
import java.math.*;

class RSACipher {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("\nPress: 1) Encryption 2) Decryption 3) Exit");
			choice = sc.nextInt();
			if(choice == 1) {
				encryption();
			}
			if(choice == 2) {
				decryption();
			}
			if(choice == 3) {
				break;
			}
		}while(choice!=3);

	}

	public static void encryption() {

		Scanner sc = new Scanner(System.in);
		int plainText = 0, p = 97, q = 101, phi, n;
		int e = 0;
		n = p * q;
		phi = (p-1)*(q-1);

		System.out.println("Enter the plain text : ");
		plainText = sc.nextInt();
		/*System.out.print("\nThe Actual PlainText is : ");
		for(int i=0;i<plaintext.length();i++) {
			a = plaintext.charAt(i);
			for(int j=0;j<27;j++) {
				if(a == ref.charAt(j)) {
					pos = j;
					break;
				}
			}
			plainText[i] = pos;
			System.out.print(plainText[i]+" ");
			pos = 0;
		}*/
		System.out.println("p = " + p + ", q = " + q + ", n = " + n + ", phi(n) = " + phi);
		for(e = 2; e < phi; e++) {
			if(calGCD(e,phi) == 1){
				break;
			}
		}
		System.out.println("Encryption Key = " + e);

		BigInteger bigPlain = BigInteger.valueOf(plainText);
		BigInteger bigN = BigInteger.valueOf(n);
		BigInteger cipher = (bigPlain.pow(e)).mod(bigN);
		System.out.println("Encrypted text is : " + cipher.intValue()); 
		
	}

	public static void decryption() {

		Scanner sc = new Scanner(System.in);
		int cipherText = 0, p = 97, q = 101, phi, n;
		int e = 0, d;
		n = p * q;
		phi = (p-1)*(q-1);

		System.out.println("Enter the cipher text : ");
		cipherText = sc.nextInt();
		System.out.println("p = " + p + ", q = " + q + ", n = " + n + ", phi(n) = " + phi);
		for(e = 2; e < phi ; e++) {
			if(calGCD(e,phi) == 1){
				break;
			}
		}
		System.out.println("Encryption Key = " + e);
		for(d = 1 ; d < phi ; d++){
			if((e * d) % phi == 1){
				break;
			}
		}
		System.out.println("Decryption Key = " + d);

		BigInteger bigCipher = BigInteger.valueOf(cipherText);
		BigInteger bigN = BigInteger.valueOf(n);
		BigInteger plain = (bigCipher.pow(d)).mod(bigN);
		System.out.println("Decrypted text is : " + plain.intValue()); 
		
	}

	public static int calGCD(int a, int b) {
		int gcd = 1;
		for(int i = 1 ; i <= a && i <= b ; i++){
			if(a % i ==0 && b % i == 0)
				gcd = i;
			}
		return gcd;
	}

}