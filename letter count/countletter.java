import java.io.FileNotFoundException;  //importing exception  handling

import java.io.File;		// importing I/O files

import java.util.Scanner;	//untility files for scanning file

public class countletter{


 public static void x(Scanner aInputHandle  ) {      //1st program which will calculate taking each charecter and

 int counter[] = new int[50];				//incrimenting the corresponding position in the counter variable

                       while ( aInputHandle.hasNextLine() )

                       {

                         String character =  (aInputHandle.nextLine()).toLowerCase();  //converting the string into lower case

                         for(int i=0; i<character.length();i++)

                         {

 			counter[(character.charAt(i))-97]++;		incrementing the coresponding position by taking ascii value of letters a to z

                         }

                  }

                       printCounter(counter);     		//printing the O/P

           }



public static int Y(Scanner aInputHandle,int i) {		//2nd program which executes taking each characters from a to z each at a time

 int counter[] = new int[50];					//and checking the occurrences in the file

                       while ( aInputHandle.hasNextLine())

                       {

                      String  character =  (aInputHandle.nextLine()).toLowerCase();

  for(int charcount=0;charcount<character.length();charcount++)

                         {

  			int nextchar = character.charAt(charcount);

                         if( i == nextchar)
				{

 				counter[i-97]++; }   //incrementing the position of letter after each occurences

                         }

                  }

                       return(counter[i-97]);	//returning the count after counting for each letters

           }

public static void main(String[] args)  // the main program

{

long startTime=0;

long endTime=0;

long endTime2=0;

int counter1[] = new int[50];

              for ( String arg: args ) {

                      try {

                              Scanner sc;

                              startTime = System.currentTimeMillis();

                        	 System.out.println("for program 1");

                              x( sc = new Scanner( new File(arg)  ) );               // first program call and passing the file name

                              endTime = System.currentTimeMillis();

                              for(int i='a'; i<'z';i++)

                              {

                            counter1[i-97]=  Y( sc = new Scanner( new File(arg)), i );  //2nd program calling and passing
											//the file name and each letter in each execution

                              }

                              System.out.println("for program 2");

                              printCounter(counter1);

                              endTime2 = System.currentTimeMillis();

                      } catch ( FileNotFoundException e )     {			//if the file not found this will catch the error

                              System.err.println("File not found.");

                              System.exit(0);

                      } catch ( Exception e ) {					//if other any error occour

                              System.err.println("Something went wrong.");

                              System.exit(1);

                      }

              }

              System.out.println("for 1st program it took : " + (endTime - startTime));

              System.out.println("for 2nd program it took :: " + (endTime2 - startTime));

}



	public static void printCounter(int counter[])		//printing the count

           {

             for ( int index = 'a'; index <= 'z'; index ++ )

             {

             char charvalue= (char)index;

              System.out.println( charvalue + ":   " + counter[index-97]);

             }

           }

}
