//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth
//Date - 8/21/24
//Class - CSK 2
//Lab  - TriangleFourRunner
import java.util.Scanner;

import static java.lang.System.*;

public class TriangleFourRunner
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
         TriangleFour fr = new TriangleFour( big, value );
         //call the toString method to print the triangle
         System.out.println( fr );

         System.out.print("Do you want to enter more data? ");
         choice=keyboard.next();
      }while(choice.equals("Y")||choice.equals("y"));
   }
}