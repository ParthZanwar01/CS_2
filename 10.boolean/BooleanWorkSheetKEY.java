//© A+ Computer Science  -  www.apluscompsci.com

//boolean worksheet key   

import static java.lang.System.*;

class BooleanWorkSheetKEY
{
   public static void main( String args[] )
   {
		//BOOLEAN QUIZ 1A

		out.println("\n\n");

		boolean x = true;
		boolean y = false;
		out.println(x&&y);
		out.println(x||y);
		out.println(!(x&&y));
		out.println(!(x||y));
		
		out.println("\n\n");		
		
		
		int a = 3;
		int b = 7;
		if(a>5 && b>5)
		   out.println("both are >5");
		out.println("testing");
		
		
		out.println("\n\n");		
		
		
		int c = 9;
		int d = 10;
		if(c>5 && d>5)
		   out.println("both are >5");
		out.println("testing");
		
		
		out.println("\n\n");		
		
		
		int e=8;
		int f=6;
		do{
		   e--;
		   f--;
		}while(e>5 && f>5);
		out.println(e + " - " + f);
		
		
		out.println("\n\n");	
		
		
		int g = 14;
		int h = 12;
		do{
		   g--;
		   h--;
		}while(g>5 || h>5);
		out.println(g + " - " + h);

   }
}