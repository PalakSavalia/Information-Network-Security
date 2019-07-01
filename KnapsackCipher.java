import java.util.*;

class KnapsackCipher {

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int sik[] = {2,3,7,14,30,57,120,251};
		int gk[] = new int[sik.length];
		int m = 41, n = 491;
		for(int i=0; i<sik.length; i++) {
			gk[i] = (sik[i]*m)%n;
		}

		System.out.print("\nSuperIncreasing Knapsack (decryption key) : ");
		for(int i=0; i<sik.length; i++) {
			System.out.print(sik[i]+" ");
		}
		System.out.print("\nGeneral Knapsack (encryption key) : ");
		for(int i=0; i<sik.length; i++) {
			System.out.print(gk[i]+" ");
		}

		System.out.print("\nEnter the plaintext (int) : ");
		int plainText = sc.nextInt();
		String msg = Integer.toBinaryString(plainText);
		
		if(msg.length() < 8)
			msg = "0" + msg.substring(0);

		if(msg.length()%sik.length == 0) {

			//Encryption part
			int noOfGroups = msg.length()/sik.length;
			int cipherText[] = new int[noOfGroups];
			for(int i=0; i<cipherText.length; i++) {
				String current = msg.substring(i*gk.length,(i+1)*gk.length);
				for(int j=0; j<current.length(); j++) {
					if(current.charAt(j) == '1') {
						cipherText[i] = cipherText[i] + gk[j];    //****** Note gik[j] *****
					}
				}
				//System.out.print(cipherText[i]+" ");
			}

			//Decryption part
			int mInverse=0, decryptedText;
			String orgMsg = "";

			for(mInverse = 0 ; mInverse < m ; mInverse++){
				if((mInverse * m) % n == 1)
					break;
			}

			for(int i=0; i<cipherText.length; i++) {
				decryptedText = (cipherText[i]*mInverse)%n;
				int sum = decryptedText;
				for(int j=sik.length-1; j>=0; j--) {
					if(sum >= sik[j] && sum!=0) {
						sum = sum - sik[j];
						orgMsg = orgMsg + "1";
					}
					else {
						orgMsg = orgMsg + "0";
					}
				}
			}

			StringBuilder orgMsgBuilder = new StringBuilder();
			orgMsgBuilder.append(orgMsg);
			orgMsgBuilder = orgMsgBuilder.reverse();

			System.out.println("Decrypted text : "+Integer.parseInt(orgMsgBuilder.toString(),2));


		}

	}


}