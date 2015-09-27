package cypher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * @author: Abhishek Sharma
 * Date:06/02/2014
 * This program provides the frequency for each letters in the text
 * it takes file name i/p from argument line
 * 
 */
public class cypher {
/*
 * @var: arr1: to stores letters from a to z
 * @var: arr2: to store the frequency of each letters in the text provided
 *  	
 */
	
	static char arr1[] = new char[26];
	static Double arr2[] = new Double[26];
	
	/*
	 * @fun: Sort: to sort the letters in descending order
	 * 		of their frequency	
	 *
	 */
	
	public static void sort()
	{
		 int j = 0;
         double tmp;
         char c;
		boolean swapped = true;
		while (swapped) {
            swapped = false;
           j++;
           
            for (int i = 0; i < arr2.length - j; i++) {                                       
                  if (arr2[i] < arr2[i+1]) {                          
                        tmp = arr2[i];
                         c = arr1[i];      
                        arr2[i] = arr2[i+1];
                        arr1[i] = arr1[i+1];
                        arr2[i+1] = tmp;
                        arr1[i+1] = c;
                        swapped = true;
                  }
            }         
	}
	
	}
	
	/*
	 * @fun: main: check frequency for each letter and stores in
	 * 		vector array and call sort function for that array 
	 */

	public static void main(String[] args) {   
		
		cypher decyper = new cypher();
		if(args.length==0)
		{
			System.out.println("you have not entered any file");
			return;
		}
		else
		{
			char frequency[] = {'e','t','a','o','i','n','s','h','r'
								,'d','l','c','u','m','w','f','g','y',
								'p','b','v','k','j','x','q','z'};
			
			File inFile = new File(args[0]);
			
			double size= inFile.length();
						
			int index = 0; 
			double counter = 0;
			
			BufferedReader readerfile1 = null;
			BufferedReader readfile2 = null;

		    try {

		    	int c,d;
		    	
		    	/*
		    	 * for loop: to extract the letters from the file and 
		    	 * check the frequency for that letter	
		    	 */
		    	for(int i='a'; i<='z';i++)
		    		{
		    			char char1 = (char)i;
		    			arr1[index] = Character.toLowerCase(char1);
		    			
		    			counter = 0;
		    			
		    			readerfile1 = new BufferedReader(
				    		    new InputStreamReader(
				    		        new FileInputStream(inFile),
				    		        Charset.forName("UTF-8")));
		    		/*
		    		 * While not EOF check against each character which extracted	
		    		 * if char is equal increase the counter by 1 for that char
		    		 */
		    		while((c = readerfile1.read())!= -1) {
		    			
		    			char char2 = (char) c;
		    			
		    			
		    			if(char1 == Character.toLowerCase(char2))
		    				{
		    					counter++;
		    					continue;
		    				}else
		    				{
		    					continue;
		    				}
		    				
		    				
		    			}
		    		
		    		arr2[index] = (counter/size)*100;
		    		index++;
		    		  
		    		}
		    /*
		     * calling sort func to sort the vector array	
		     */
		    	
		    	 decyper.sort();
	    		  
	    		  for(int k=0;k<26;k++)
	    		  {
	    			  System.out.println(arr1[k] +" with frequency"+ arr2[k]+" "+"may be equivalent to"+ " "+ frequency[k]);
	    		  }
		    		
		    }
		    		
		  catch (IOException e) {
		        e.printStackTrace();
		    } 

		    finally {
		        try {
		            if (readerfile1 != null)readerfile1.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		    }
		    
		} 

}
}	
