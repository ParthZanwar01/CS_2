//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/21/2024
//Class - CSK 2
//Lab  - TriangleThreeRunner

import java.util.Scanner;

import static java.lang.System.*;

public class TriangleThreeRunner
{
   public static void main( String args[] )
   {
      Scanner keyboard = new Scanner(System.in);
      String choice="";
      do{
         out.print("Enter the size of the triangle : ");
         int big = keyboard.nextInt();
         out.print("Enter a letter : ");
         String value = keyboard.next();

         //instantiate a TriangleTwo object
         TriangleThree three = new TriangleThree( big, value );
         //call the toString method to print the triangle
         System.out.println( three );

         System.out.print("Do you want to enter more data? ");
         choice=keyboard.next();
      }while(choice.equals("Y")||choice.equals("y"));
   }
}