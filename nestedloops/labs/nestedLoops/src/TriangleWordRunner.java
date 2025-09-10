//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/24
//Class - CSK 2
//Lab  - TriangleWordRunner

import java.util.Scanner;

import static java.lang.System.*;

public class TriangleWordRunner
{
   public static void main(String args[])
   {
       Scanner keyboard = new Scanner(System.in);
       String choice="";
       do{
           out.print("Enter a word : ");
           String value = keyboard.next();

           //instantiate a TriangleTwo object
           TriangleWord tw = new TriangleWord( value );
           //call the toString method to print the triangle
           System.out.println( tw );

           System.out.print("Do you want to enter more data? ");
           choice=keyboard.next();
       }while(choice.equals("Y")||choice.equals("y"));
   }
}