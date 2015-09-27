package linearCA;

import java.util.Random;

public class decrypt {
	
	static String Y[] = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011","1100","1101","1110","1111"};
	static  String X[] = {"1110","0100","1101","0001","0010","1111","1011","1000","0011","1010","0110","1100","0101","1001","0000","0111"};
	static int round[]= {0,4,8,12,1,5,9,13,2,6,10,14,3,7,11,15};
	
	static String en = "01001000001100110100100001011011"; 
	static String en1 = new String();
	static String en2 = new String();
	static String en3 = new String();
	
public static String random(){
		
		Random r = new Random();
		
		return Integer.toBinaryString(r.nextInt(256));
	}
	

	public static void main(String[] args) {
		
		String KEY = new String();
		String tempPT = new String();
		String temp = new String();
		
		
	
		
		KEY = random();
		
		for(int i=0;i<4;i++){
			int length = KEY.length();
		for(int j =16-length;j>0;j--)
		{
		KEY = "0"+KEY;
		}
		}
		
		System.out.println(KEY);
		
		for(int i=0;i<16;i++){
			System.out.print(en.charAt(i));
			tempPT = tempPT + Integer.toString(KEY.charAt(i)^en.charAt(i));
	   }
	
		System.out.println();
		System.out.println(KEY);
		en = tempPT;
		
		tempPT = "";
		
		for(int i=0;i<16;i=i+4){
			temp = en.substring(i,i+4);
			for(int j=0; j<16;j++){
				if(temp == X[j]){
				tempPT = tempPT +Y[j];
				break;}
			}
			
		}
		
		
		en = tempPT;
		tempPT ="";
		
		System.out.println(en);
		
		/*
		 * for next 3 rounds
		 */
		
	/*	for(int round = 0;round<3;round++ ){
		
		KEY = random();
		

		for(int i=0;i<4;i++){
			int length = KEY.length();
		for(int j =16-length;j>0;j--)
		{
		KEY = "0"+KEY;
		}
		}
		
		for(int i=0;i<16;i++){
			
			tempPT = tempPT + Integer.toString(KEY.charAt(i)^en.charAt(i));
		}
		//System.out.println(tempPT);
		en = tempPT;
		tempPT="";
		
		
		
		for(int i=0;i<16;i=i+4){
			temp = en.substring(i,i+4);
			for(int j=0; j<16;j++){
				if(temp == X[j]){
				tempPT = tempPT +Y[j];
				break;}
			}
			
		}
		
		
		en = tempPT;
		tempPT ="";
		
		System.out.println(en);
		
		}
		
		*/
		

	}

}
