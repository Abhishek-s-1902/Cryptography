import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
/*
* @Author: Abhishek Sharma
* @Author: Yata Alankritha
*
* @Sbox: DES
*/
public class DESSbox {
	
	
	 static Integer output_y[] = {15,3,1,13,8,4,14,7,6,15,11,2,3,8,4,14,9,12,7,0,2,1,13,10,12,6,0,9,5,11,10,5,
		 							0,13,14,8,7,10,11,1,10,3,4,15,13,4,1,2,5,11,8,6,12,7,6,12,9,0,3,5,2,14,15,9}; 
	 
	 	 
	 static Integer combo_X[] =new Integer[64];
	 static String Binary_Y[][] =new String[4][16];
	 
	static BigInteger bi1 ;
	static BigInteger bi2 ;
	
	public static void genaratecombo(){
		
		 
		
		
		for(int i = 0;i<64;i++){
			
			combo_X[i] = i;
			
		}
		
	}
	
	
	
	
	
public static void main(String[] args) {
/*
* combo[]: Stores the hard coded value of i/p and o/p values
* as 8 bits combination.
*/
		genaratecombo();

	
	
int length = combo_X.length;

Integer X_Dprime,Y_Dprime,Yprime,xorcombo, Xval,Yval,temp=0, max_counter=0; 
StringBuilder sb = new StringBuilder();
Integer row,coloum,temp_j = 0, max_val = 0; 
Integer counter[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
String Y_Dp_string,Xval_string, ij_val[]= new String[5000];

Integer Xprime;

for(int i = 0;i<64;i++)
{	
	
 for(int j = 0;j<64;j++){
	 
	 temp_j = j;
	 X_Dprime = i;
	 Xval = j;
	 
	 
	 Xprime =  Xval^X_Dprime;
	 
	  
		 Yprime = output_y[Xprime];             
	 
	
	 Yval = output_y[Xval];                       
	 
	
	 
	 Y_Dprime = Yval^Yprime;
	
	
	 counter[Y_Dprime] = (counter[Y_Dprime]+1);

	
 	}	
 
 System.out.println("for xD "+i);
 System.out.print("             " );
 	for(int max=0;max<16;max++){
 		
 		
 		System.out.print(" "+counter[max]+" " );
 		counter[max] = 0;
 	}
 	
 	System.out.println();
 	
 
} 
	


 }

}


