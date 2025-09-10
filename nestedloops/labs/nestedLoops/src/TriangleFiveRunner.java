//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/24
//Class - CSK 2
//Lab  - TriangleFiveRunner

import java.util.Scanner;

import static java.lang.System.*;

public class TriangleFiveRunner
{
   public static void main(String args[])
   {
       Scanner keyboard = new Scanner(System.in);
       String choice="";
       do{
           out.print("Enter the size of the triangle : ");
           int big = keyboard.nextInt();
           out.print("Enter a letter : ");
           String value = keyboard.next();

           TriangleFive fv = new TriangleFive(value.charAt(0), big);
           //static methods can be called using the class name
           System.out.println( fv);

           System.out.print("Do you want to enter more data? ");
           choice=keyboard.next();
       }while(choice.equals("Y")||choice.equals("y"));
	}
}