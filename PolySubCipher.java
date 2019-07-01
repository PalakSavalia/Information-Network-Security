import java.util.*;

class PolySubCipher {

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
		int j=0;
		System.out.println("Enter the plain text : ");
		plainText = sc.nextLine();
		plainText = plainText.toUpperCase();
		System.out.println("Enter the key string : ");
		key = sc.nextLine();
		key = key.toUpperCase();
		for(int i=0; i<plainText.length(); i++) {
			current = plainText.charAt(i);
			if(Character.isWhitespace(current)) {
				cipherText = cipherText + " ";
			}
			else if(!Character.isWhitespace(current) && (current<'A' || current>'Z')) {
				continue;
			}
			else {
				cipherText = cipherText + (char) ( (current+key.charAt(j)-(2*65)) % 26 + 65);
				j = (j+1)%key.length();
			}
		}
		System.out.println("Encrypted text is : "+cipherText.toUpperCase());

	}

	public static void decryption() {

		Scanner sc = new Scanner(System.in);
		String plainText = "", key="", cipherText = "";
		char current;
		int j=0;
		System.out.println("Enter the cipher text : ");
		cipherText = sc.nextLine();
		cipherText = cipherText.toUpperCase();
		System.out.println("Enter the key string : ");
		key = sc.nextLine();
		key = key.toUpperCase();
		for(int i=0; i<cipherText.length(); i++) {
			current = cipherText.charAt(i);
			if(Character.isWhitespace(current)) {
				plainText = plainText + " ";
			}
			else if(!Character.isWhitespace(current) && (current<'A' || current>'Z')) {
				continue;
			}
			else {
				plainText = plainText + (char) ( (current-key.charAt(j)+26) % 26 + 65);
				j = (j+1)%key.length();
			}
		}
		System.out.println("Decrypted text is : "+plainText.toLowerCase());

	}

}