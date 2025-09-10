//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth
//Date - 8/21/24
//Class - CSK 2
//Lab  - TriplesRunner

import java.util.Scanner;

import static java.lang.System.*;

public class TriplesRunner
{
   public static void main(String args[])
   {
       Scanner keyboard = new Scanner(System.in);
       String choice="";
       do{
           out.print("Enter limit : ");
           int big = keyboard.nextInt();


           //instantiate a TriangleTwo object
           Triples tp = new Triples( big );
           //call the toString method to print the triangle
           System.out.println( tp );

           System.out.print("Do you want to enter more data? ");
           choice=keyboard.next();
       }while(choice.equals("Y")||choice.equals("y"));

   }
}