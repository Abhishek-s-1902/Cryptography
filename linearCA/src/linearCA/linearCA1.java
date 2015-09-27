package linearCA;

import java.util.Random;

public class linearCA1 {
	
/*
 * @X,Y: from table i/p and o/p combination 
 */
	
	static String X[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static  String Y[] = {"1110","0100","1101","0001","0010","1111","1011","1000","0011","1010","0110","1100","0101","1001","0000","0111"};
	
	/*
	 * round: for S-box- permutation 
	 */
	static int round[]= {0,4,8,12,1,5,9,13,2,6,10,14,3,7,11,15};
							
	 
	/*
	 * for generating the random fun
	 */
	public static String random(){
		
		Random r = new Random();
		
		return Integer.toBinaryString(r.nextInt(256));
	}

	
	public static void main(String[] args) {
		
		/*
		 * PT: plain text
		 * KEY: random generated key
		 * tempPT, temp: temporary variable 
		 */
				String PT = new String();
				PT = "1111111000011111";
				String KEY = new String();
				String tempPT = new String();
				String temp = new String();
				
			/*
			 * For 3 rounds we do the random key generation XOR with plain text
			 * passing these bits through the S-BOX and the permuting the bit 
			 * according to the diagram
			 * 	
			 */
				
				System.out.println("plain text "+ PT);	
			for(int r =0;r<3;r++){
					
				
				KEY = random(); 
				
				
				
				for(int i=0;i<4;i++){
					int length = KEY.length();
				for(int j =16-length;j>0;j--)
				{
				KEY = "0"+KEY;
				}
				}
				
				/*
				 * XORING the key and PT
				 */
				for(int i=0;i<16;i++){
					
						tempPT = tempPT + Integer.toString(KEY.charAt(i)^PT.charAt(i));
				}
					
					PT = tempPT;
			
			/*
			 * S-BOX i/p to corresponding o/p
			 */
			
			
			temp = "";
			for(int i=0;i<16;i=i+4){
				temp = PT.substring(i,i+4);
				for(int j=0; j<16;j++){
					if(temp == X[j]){
					tempPT = tempPT +Y[j];
					break;}
				}
				
			}
			
			PT = tempPT;
			tempPT ="";
			
			
			/*
			 * bit shifting for next round S-box
			 * 
			 */
			
			
			for(int i=0; i<16;i++){
				int j = round[i];	
				
				tempPT = tempPT +  PT.charAt(j);
				
				
			}
				
			PT = tempPT;	
			
				
			}
				
			
				
		/*
		 *same step as above  for 4th round onwards
		 *
		 */
				
	KEY = random(); 
	
	
	
	for(int i=0;i<4;i++){
		int length = KEY.length();
	for(int j =16-length;j>0;j--)
	{
	KEY = "0"+KEY;
	}
	}
	
	for(int i=0;i<16;i++){
		
			tempPT = tempPT + Integer.toString(KEY.charAt(i)^PT.charAt(i));
	}
		
		PT = tempPT;

/*
 * S-BOX
 */

temp = new String();
temp = "";
for(int i=0;i<16;i=i+4){
	temp = PT.substring(i,i+4);
	for(int j=0; j<16;j++){
		if(temp == X[j]){
		tempPT = tempPT +Y[j];
		break;}
	}
	
}

PT = tempPT;
tempPT ="";

KEY = random(); 



for(int i=0;i<4;i++){
	int length = KEY.length();
for(int j =16-length;j>0;j--)
{
KEY = "0"+KEY;
}
}

for(int i=0;i<16;i++){
	
		tempPT = tempPT + Integer.toString(KEY.charAt(i)^PT.charAt(i));
}
	
	PT = tempPT;


System.out.println("encrypted key " + PT);

			
	}
	
}
