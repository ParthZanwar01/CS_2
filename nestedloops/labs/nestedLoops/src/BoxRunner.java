//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/2024
//Class - CSK 2
//Lab  -  BoxRunner

import java.util.Scanner;

import static java.lang.System.*;

public class BoxRunner
{
   public static void main( String args[] )
   {
       Scanner keyboard = new Scanner(System.in);
       String choice="";
       do{
           out.print("Enter the size of the box : ");
           int big = keyboard.nextInt();


           //instantiate a TriangleTwo object
           Box bx = new Box( big );
           //call the toString method to print the triangle
           System.out.println( bx );

           System.out.print("Do you want to enter more data? ");
           choice=keyboard.next();
       }while(choice.equals("Y")||choice.equals("y"));
	}
}