import java.util.*;

class MonoSubCipher {

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

		String ref = "abcdefghijklmnopqrstuvwxyz";
		String plainText="", cipherText="";
		char current;
		int key = -1, oldPos = 0, newPos = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the plain text : ");
		plainText = sc.nextLine();
		plainText = plainText.toLowerCase();
		System.out.println("Enter the key : ");
		key = sc.nextInt();
		for(int i=0; i<plainText.length(); i++) {
				current = plainText.charAt(i);
				for(int j=0; j<27; j++) {
					if(Character.isWhitespace(current)) {
						cipherText = cipherText + " ";
						break;
					}
					if(current == ref.charAt(j)) {
						oldPos = j;
						newPos = (oldPos+key)%26;
						cipherText = cipherText + ref.charAt(newPos);
						break;
					}
				}
		}
		System.out.println("Encrypted text is : "+cipherText.toUpperCase());

	}

	public static void decryption() {

		String ref = "abcdefghijklmnopqrstuvwxyz";
		String plainText="", cipherText="";
		char current;
		int key = -1, oldPos = 0, newPos = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the cipher text : ");
		cipherText = sc.nextLine();
		cipherText = cipherText.toLowerCase();
		System.out.println("Enter the key : ");
		key = sc.nextInt();
		for(int i=0; i<cipherText.length(); i++) {
				current = cipherText.charAt(i);
				for(int j=0; j<27; j++) {
					if(Character.isWhitespace(current)) {
						plainText = plainText + " ";
						break;
					}
					if(current == ref.charAt(j)) {
						oldPos = j;
						newPos = (oldPos-key)%26;
						plainText = plainText + ref.charAt(newPos);
						break;
					}
				}
		}
		System.out.println("Decrypted text is : "+plainText);

	}

}