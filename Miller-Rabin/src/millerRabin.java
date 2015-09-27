import java.awt.List;
import java.util.Random;
import java.util.Vector;
/*
 * @Author: Abhishek Sharma
 * @Author: Alankrita yata
 */

public class millerRabin {
	
	/*
	 * @findFactors: for factoring the number
	 */
	 private static Vector<Integer> findFactors(Integer n)
	    {
		 	Integer increment; 
	        if (n % 2 != 0)
	            increment = 2; 
	        else
	        	increment =1;
	        
	        Vector<Integer> factors = new Vector<Integer>();
	       
	        for (int i = 1; i <= n/2; i=i+increment)
	        {
	            if (n % i == 0)
	            {
	            	factors.add(i);
	            }
	        }
	        //factors.add(n);
	        return factors;
	    }
	
	public static boolean Check_prime(Integer n){
		
		if (n < 4)
            return true;
        if (n % 2 == 0)
            return false;

        int loop = (int)Math.sqrt(n);
        for (int i = 2; i <= loop; i++)
            if (n % i == 0)
                return false;

        return true;
		
	}
	
	/*
	 * @modulo: to calculate modulo
	 */
	public static Integer modulo(Integer A_element,Integer exponent,Integer n ){
		
		String expo_binary = Integer.toBinaryString(exponent);
		
		Integer size = expo_binary.length();
		Integer R = A_element;
		
		for(int t=0;t<=size-1;t++){
			
			R = (R*R)%n;
			
			if(expo_binary.charAt(t)=='1'){
				R = (R*A_element)%n;
				//System.out.println("R:"+ R + "n"+ n);
			}	
		} 
		
		return R;
	}
	
	/*
	 * @Miller_Rabin: Miller_Rabiin algo
	 */
	public static void Miller_Rabin(Integer n){
		Vector<Integer> factor_list = new Vector<Integer>();
		 Random randomGenerator = new Random();	
		 Integer cout_for_k=0;
		Integer M = 1, B, random;
		Integer counter=0;
		
		factor_list = findFactors(n-1);
		
		//random = randomGenerator.nextInt(n);	
		
		
		
		for(int i=0;i<factor_list.size();i++){
			if(factor_list.elementAt(i)==2)
				cout_for_k++;
			else
				M = M*factor_list.elementAt(i);
		}
	
		for(int j=0;j<n-1;j++){
			
		B = modulo(j,M,n);
		if(B == 1)
			counter++;
		else
		{
			for(int i = 0;i<cout_for_k;i++){
				
				B = (B+1)%n;                   
				if(B == 0){
					counter++;
					break;
					}
				else{
				B = (B*B)%n;                    
				}
			}
		}
		
		}
		System.out.println("probability for n = " + n+"is "+ (float)(counter/(n-1)));
			
		
	}
	
	
	public static void main(String[] args) {
	
		
		Integer base = 5;
		Integer m = 2;
		Integer n = 3;
		Integer cout_for_2=0;
		Vector<Integer> facor_list = new Vector<Integer>();
		Vector<Integer> odd_List = new Vector<Integer>();
		Integer odd_element = 1;
	
				
		
		System.out.println("cout_for_2: "+cout_for_2+ "odd_element"+ odd_element);
		
		for(int i =200000;i<=201000;i++)
		{
		 Miller_Rabin(i);
		
		}
	}


}
