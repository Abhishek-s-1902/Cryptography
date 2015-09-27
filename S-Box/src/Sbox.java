import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
/*
* @Author: Abhishek Sharma
* @Author: Yata Alankritha
*
* @Sbox: This program provides the Linear Approximation Table of 4*4 S-Box
* the X(i/p) and Y(o/p) values are hard coded in 8 bit string matrix and it calculates
* the bias values for each combination of X and Y equations
*/
public class Sbox {
public static void main(String[] args) {
/*
* combo[]: Stores the hard coded value of i/p and o/p values
* as 8 bits combination.
*/
String combo[] = {"00001000","00010100","00100010","00110001",
"01001100","01010110","01100011","01111101",
"10001010","10010101","10101110","10110111",
"11001111","11011011", "11101001", "11110000"};
Integer localxor,line;
String xorcombo;
for(int i = 0;i<256;i++)
{
localxor=0;
line = i+1;
Integer loopno = new Integer(i);
Integer xybinary[] = new Integer[8];
/*
* @binary: getting the binary value of each number from 1 to 256
* which signifies the combination of equations (for X and Y)
*/
String binary = Integer.toBinaryString(loopno);
int length = binary.length();
/*
* this for loop appends the 0's behind the
* string
*/
for(int j =8-length;j>0;j--)
{
binary = "0"+binary;
}
/*
* this for loop doing the XOR operation using the inbuild java
* function.
*/
for(int k = 0;k<16;k++)
{
int tempxor =0 ;
for(int l=0;l<8;l++)
{
if(binary.charAt(l)=='1'){
tempxor = tempxor^Character.getNumericValue(combo[k].charAt(l));
}
}
if(tempxor==0)
{
localxor = localxor+1;
}
}
/*
* getting the final value for each column
*/
System.out.print("for"+ i +" "+ binary + "="+ (localxor-8) +" ");
if(line%16==0)
System.out.println();
}
}
}
