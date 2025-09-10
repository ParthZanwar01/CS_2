//© A+ Computer Science  -  www.apluscompsci.com
//Name - PARTH ZANWAR
//Date - 8/22/24
//Class - CSK 2
//Lab  - BoxWordRunner

import java.util.Scanner;

import static java.lang.System.*;

public class BoxWordRunner
{
   public static void main( String args[] )
   {
       Scanner keyboard = new Scanner(System.in);
       String choice="";
       do{
           out.print("Enter a word : ");
           String value = keyboard.next();

           BoxWord bw = new BoxWord(value);
           //static methods can be called using the class name
           System.out.println(bw);

           System.out.print("Do you want to enter more data? ");
           choice=keyboard.next();
       }while(choice.equals("Y")||choice.equals("y"));
	}
}