import java.util.Random;
import java.util.Scanner;

/*
 * @Author: Abhishek Sharma/ Jie yuan
 * Date: 10/12/2014
 * project: POP3
 * 
 */

/*
 * @encrypt: This class is implementation of SPN (substitution and permutation cipher) cipher
 *  and can be use to encrypt any plain text. 
 * 
 */
public class encrypt {

	
	
		
		String plaintext = new String();
		
		static final int permute[]= {0,4,8,12, 1,5,9,13, 2,6,10,14,3,7,11,15};
	
		/*
		 *@in[] and out[]: stores input and output of S-box
		 */
		static final String in[] = {"0000","0001","0010","0011",
									"0100","0101","0110","0111",
								"1000","1001","1010","1011","1100","1101","1110","1111"};
		
		static final String out[] = {"1110","0100","1101","0001", "0010","1111","1011","1000",
								"0011","1010","0110","1100","0101","1001","0000","0111"};
		
		String key_atRound   =  new String();
		
	
	
	/*
	 * @permute_it: gives plain text after making permutation to S-box output 
	 * 
	 */
		
		
		public String permute_it(String temp_at_round, String temp_text)
		{
			
			String at_round_plaintext = new String();  
			String temp_plaintext = new String(); 
			
			
			for(int i=0; i<16;i++)
			{
				
				at_round_plaintext = at_round_plaintext +  plaintext.charAt(permute[i]);
				
			}
				
			return at_round_plaintext;
		}
	
		/*
		 * @permute_it: gives corresponding text O/P from respective I/P to S-box. 
		 * 
		 */
		
		public String get_Sbox_out(String temp_at_round, String temp_text)
		{
			
			String at_round_plaintext = new String();  
			String temp_plaintext = new String(); 
			System.out.println("pt in s box  "+ plaintext);
			for(int i=0;i<16;i=i+4)
			{
				  temp_plaintext = plaintext.substring(i,i+4);
				
					for(int j=0; j<16;j++)
					{
						if(temp_plaintext.equals(in[j]))
						{
							at_round_plaintext = at_round_plaintext + out[j];
							break;
						}
					}
			}
			
		   return at_round_plaintext;
		}
		
		/*
		 * @pad_key: if the key generated is less than 16 in length than its pad 0 in the begining. 
		 * 
		 */
		
		public String pad_key()
		{
			
			int key_size = 0; 	
			for(int i=0;i<4;i++)
			{
				key_size = key_atRound.length();
				for(int j =16-key_size;j>0;j--)
				{
					key_atRound = "0"+key_atRound;
				}
			}
			return key_atRound;
			
		}
		
		/*
		 * @get_key: provides random key for any level. 
		 * 
		 */
		
		public static String get_key(){
			
			Random key = new Random();
			
			String key1 = Integer.toBinaryString(key.nextInt(256));
			
			return key1;
		}
		
		/*
		 * @encrypt_plaintext: implements each round of SPN and gives the encrypted text
		 */
		
		public void encrypt_plaintext()
		{
			String at_round_plaintext = new String(); 
			String temp_plaintext = new String(); 	  
			
		for(int round =0;round<4;round++){
					
					key_atRound =  get_key(); 
					
					key_atRound = pad_key();
					
					
					System.out.println("key_atRound "+(round+1)+ " "+ key_atRound);
					System.out.println("PT before xor "+plaintext);
					
					for(int i=0;i<16;i++)
					{
						
						at_round_plaintext = at_round_plaintext + Integer.toString(key_atRound.charAt(i)^plaintext.charAt(i));
					}
						
						plaintext = at_round_plaintext;
						
						
						System.out.println("PT after xor "+ plaintext);
					
						
						
						temp_plaintext = "";
						
						plaintext = get_Sbox_out( at_round_plaintext,  temp_plaintext);
						
						 
						at_round_plaintext ="";	
					
						System.out.println("after sbox "+plaintext);
						
						
						plaintext = permute_it(at_round_plaintext,  temp_plaintext);
						
						
						System.out.println("after permutation  pt: "+ plaintext);
						
			}
			
			
			key_atRound = get_key(); 
			
			key_atRound = pad_key();
			
			System.out.println("key_atRound 4"+ key_atRound);
			
			
			
			for(int i=0;i<16;i++){
				
				at_round_plaintext = at_round_plaintext + Integer.toString(key_atRound.charAt(i)^plaintext.charAt(i));
			}
				
				plaintext = at_round_plaintext;
				
				System.out.println("PT after xor "+ plaintext);
				
				at_round_plaintext = "";
				temp_plaintext = "";
				
				plaintext = get_Sbox_out( at_round_plaintext,  temp_plaintext);
				
				at_round_plaintext = "";	
			
				System.out.println("PT after sbox "+ plaintext);
			
				
				key_atRound = get_key(); 

				
				
				key_atRound = pad_key();
				
				System.out.println("key at last round "+ key_atRound);
				
				for(int i=0;i<16;i++){
					
					at_round_plaintext = at_round_plaintext + Integer.toString(key_atRound.charAt(i)^plaintext.charAt(i));
				}
					
				plaintext = at_round_plaintext;

					
				System.out.println("encrypted plaintext is" + plaintext);	
				
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		encrypt e1 = new encrypt();
		
		Scanner s1 = new Scanner(System.in);
		
		String input = s1.nextLine();
		
		while(input.length()>16 || input.length()<16)
		{
			System.out.println("size should be 16 bits");
			input = s1.nextLine();
		}
			
		e1.plaintext = input;
		
		e1.encrypt_plaintext();

		
		
	}

}
