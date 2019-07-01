import java.util.*;

class AffineCipher {

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
		String plainText = "", key="", cipherText = "";
		char current;
		int a=3, b=6;                     //a should be coprime with 26 i.e. m
		System.out.println("Enter the plain text : ");
		plainText = sc.nextLine();        //a nad b are keys for this cipher
		plainText = plainText.toUpperCase();
		
		for(int i=0; i<plainText.length(); i++) {
			current = plainText.charAt(i);
			if(Character.isWhitespace(current)) {
				cipherText = cipherText + " ";
			}
			else if(!Character.isWhitespace(current) && (current<'A' || current>'Z')) {
				continue;
			}
			else {
				cipherText = cipherText + (char) ( (a*current+b) % 26 + 65);
				//cipherText = cipherText + (char) ( (a*(current-65)) % 26 + 65);
			}
		}

		System.out.println("Encrypted text is : "+cipherText.toUpperCase());

	}

	public static void decryption() {

		Scanner sc = new Scanner(System.in);
		String plainText = "", key="", cipherText = "";
		char current;
		int a=3, b=6, a_inv = -1;
		System.out.println("Enter the cipher text : ");
		cipherText = sc.nextLine();
		cipherText = cipherText.toUpperCase();
		
		for(int i=0; i<26; i++) {
			if(a*i%26 == 1) {
				a_inv = i;
				break;
			}
		}

		System.out.println(a_inv);

		for(int i=0; i<cipherText.length(); i++) {
			current = cipherText.charAt(i);
			if(Character.isWhitespace(current)) {
				plainText = plainText + " ";
			}
			else if(!Character.isWhitespace(current) && (current<'A' || current>'Z')) {
				continue;
			}
			else {
				plainText = plainText +  (char) ( (a_inv*(current-b)) % 26 + 65);
				//plainText = plainText +  (char) ( (a_inv*(current-65)) % 26 + 65);
			}
		}
		System.out.println("Decrypted text is : "+plainText.toLowerCase());

	}

}