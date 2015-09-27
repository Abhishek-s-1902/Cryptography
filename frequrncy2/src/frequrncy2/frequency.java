package frequrncy2;

/*
 * @Author: Abhishek Sharma
 * @Author: Yata Alankritha 
 * 
 * This code is to calculate Mg value for one line at a time 
 * Need to provide the frequency for each Fg+i 
 * 
 */
import java.util.Scanner;


public class frequency {
	
	static double pi[] = {.082,.015,.028,.043,.127,.022,
							.020,.061,.070,.002,.008,.040,
							.024,.067,.075,.019,.001,.060,.063,.091,
							.028,.010,.023,.001,.020,.001};
	static double tempfq = 0.0;
	static double freqtotal[] = new double[26];
	double frequency;
	static double fq; 
	static int length;
	public static void main(String[] args) {
		
	/*
	 * taking the length of each line to use it in the formula
	 * to compute Mg. 
	 */
		
		System.out.println("enter the length of line");
		Scanner kb = new Scanner(System.in);
		int length = kb.nextInt();
		int g;
	/*
	 * @outer for loop: to check by taking key from a to z
	 * @inner for loop: to take frequency for each value 
	 * corresponding to g+i
	 *  	
	 */
		for(int k=0;k<26;k++){
			
			System.out.println("enter the frequency for "+ k%26 + " th char");	
			freqtotal[k] = kb.nextDouble();
		}
		
		for(g=0;g<26;g++){
			System.out.println("for g="+ g);	
			for(int i=0;i<26;i++){
		
		System.out.println(freqtotal[g]);
		System.out.println(pi[i]);
		tempfq =  pi[i]*freqtotal[g] + tempfq;
		}
		fq = tempfq/length;
		System.out.println("Mg for"+ g +" ="+ fq);
	}
		
}
}
