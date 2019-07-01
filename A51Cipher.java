import java.util.*;

class A51Cipher {

	public static void main(String args[]) {

		int x[] = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,1,0};
		int y[] = {1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1};
		int z[] = {1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0};

		int ans[] = new int[8];
		int temp, majority, zeroBit;

		for(int i=0; i<8; i++) {

			majority = 0;
			temp = x[8]+y[10]+z[10];
			if(temp>1)
				majority = 1;
			
			if(x[8]==majority) {
				zeroBit = x[13]^x[16]^x[17]^x[18];
				shiftBits(x,zeroBit);
			}

			if(y[10]==majority) {
				zeroBit = y[20]^y[21];
				shiftBits(y,zeroBit);
			}

			if(z[10]==majority) {
				zeroBit = z[7] ^ z[20] ^ z[21] ^ z[22];
				shiftBits(z,zeroBit);
			}

			ans[i] = x[18]^y[21]^z[22];

		}

		System.out.print("\nKey Stream is : ");
		for(int i=0;i<8;i++){
			System.out.print(ans[i]+" ");
		}

		encryptAndDecrypt(ans);

	}

	public static void encryptAndDecrypt(int ans[]) {

		Scanner sc = new Scanner(System.in);
		int plainText[] = new int[8];
		int cipherText[] = new int[8];
		int decryptedCipher[] = new int[8];

		System.out.print("\nEnter the plain text : ");
		for(int i=0; i<8; i++) {
			plainText[i] = sc.nextInt();
		}

		for(int i=0; i<8; i++) {
			cipherText[i] = plainText[i]^ans[i];
			decryptedCipher[i] = cipherText[i]^ans[i];
		}

		System.out.print("\nEncrypted text is : ");
		for(int i=0;i<8;i++){
			System.out.print(cipherText[i]+" ");
		}

		System.out.print("\nDecrypted text is : ");
		for(int i=0;i<8;i++){
			System.out.print(decryptedCipher[i]+" ");
		}
		System.out.print("\n");

	}

	public static void shiftBits(int arr[], int zeroBit) {
		for(int i=arr.length-1; i>=1; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = zeroBit;
	}

}