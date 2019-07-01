import java.util.*;

class RC4Cipher {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int key[] = new int[4];
		int keyStream[] = new int[4];
		int s[] =  new int[8];
		int k[] = new int[8];
		int i = 0, j = 0, temp, index = 0;

		System.out.print("\nEnter the key : ");
		for(i=0; i<4; i++) {
			key[i] = sc.nextInt();
		}

		for(i=0; i<8; i++) {
			s[i] = i;
			k[i] = key[i%4];
		}


		System.out.println("\nThe value of S in each itearation :");
		for(i=0; i<8; i++) {
			j = (j + s[i] + k[i])%8;
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			System.out.print("i="+(i+1)+" : ");
			for(int a=0; a<8; a++)
				System.out.print(s[a]+" ");
			System.out.print("\n");
		}

		j = 0;        // *****very important*****
		for(int a=0; a<4; a++) {
			i = (i+1)%8;
			j = (j + s[i])%8;
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			index = (s[i] + s[j])%8;
			keyStream[a] = s[index];
		}

		System.out.print("\nKey Stream is : ");
		for(i=0;i<4;i++){
			System.out.print(keyStream[i]+" ");
		}

		encryptAndDecrypt(keyStream);

	}

	public static void encryptAndDecrypt(int ans[]) {

		Scanner sc = new Scanner(System.in);
		int plainText[] = new int[4];
		int cipherText[] = new int[4];
		int decryptedCipher[] = new int[4];

		System.out.print("\nEnter the plain text : ");
		for(int i=0; i<4; i++) {
			plainText[i] = sc.nextInt();
		}

		for(int i=0; i<4; i++) {
			cipherText[i] = plainText[i]^ans[i];
			decryptedCipher[i] = cipherText[i]^ans[i];
		}

		System.out.print("\nEncrypted text is : ");
		for(int i=0;i<4;i++){
			System.out.print(cipherText[i]+" ");
		}

		System.out.print("\nDecrypted text is : ");
		for(int i=0;i<4;i++){
			System.out.print(decryptedCipher[i]+" ");
		}
		System.out.print("\n");

	}

	public static void swap(int x, int y) {
		int temp = 0;
		temp = x;
		x = y;
		y = temp;
	}
	
}