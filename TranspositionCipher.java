import java.util.*;

class TranspositionCipher {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String plainText;
		int noOfColums, noOfRows;

		System.out.print("Enter the plaintext : ");
		plainText = sc.nextLine();
		char[] pt = plainText.toCharArray();
		System.out.print("Enter the Key Size : ");
		noOfColums = sc.nextInt();
		int[] key = new int[noOfColums];
		System.out.print("Enter the Key Value : ");
		for(int i = 0 ; i < noOfColums ; i++){
			key[i] = sc.nextInt() % (noOfColums + 1);
		}
		if(plainText.length()%noOfColums != 0)
			noOfRows = ( plainText.length() / noOfColums ) + 1;
		else
			noOfRows = plainText.length() / noOfColums;

		char[][] encrypt = new char[noOfRows][noOfColums];
		int count = 0;

		System.out.println("Plain Text in Matrix Form :");
		for(int i=0; i<noOfRows; i++) {
			for(int j=0; j<noOfColums; j++) {
				if(count<plainText.length()) {
					encrypt[i][j] = pt[count];
					count++;
					System.out.print(encrypt[i][j]+" ");
				}
			}
			System.out.print("\n");
		}

		char cipherText[] = new char[count];
		count = 0;
		for(int k=0; k<noOfRows; k++) {
			for(int i=0; i<noOfColums; i++) {
				for(int j=0; j<noOfColums; j++) {
					if((i+1)==key[j]) {
					
						cipherText[count] = encrypt[k][j];
						count++;
					
					}
				}
			}
		}
		
		System.out.print("Encrypted Message is : ");
		for(int i = 0 ; i < cipherText.length ; i++)
			System.out.print(cipherText[i]);


	}


}