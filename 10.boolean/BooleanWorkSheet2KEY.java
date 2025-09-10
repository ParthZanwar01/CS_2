//© A+ Computer Science  -  www.apluscompsci.com

//boolean worksheet 2 key

import static java.lang.System.*;   

class BooleanWorkSheet2KEY
{
   public static void main( String args[] )
   {
		//boolean worksheet 2 key

		out.println("\n\nx");

		int x=5;
		out.println(x++);
		x=10;
		out.println(++x);
		x=3;
		out.println(--x);
		x=9;
		out.println(x--);

		
		out.println("\n\naflipper");		
		
		
		int a=5;
		boolean flipper = false;
		if(flipper || a>4)
		{
		   out.println("short");
		}
		out.println("fun");

		
		
		out.println("\n\nbc");		
		
		
		int b=9, c=7;
		if(b<4 || ++c<8)   
		{
		   out.println("fly");
		}
		out.println(c);

		
		
		out.println("\n\n");		
		
		
		int d=9, e=13;
		if(d>4 && ++e>15)   
		{
		   out.println("go");
		}
		out.println(e);

		
		
		out.println("\n\n");	
		
		
		int f=9, g=13;
		if(f>4 ||++g>15 && f>0)   
		{
		   out.println("run");
		}
		out.println(g);



		out.println("\n\n");	
		
		
		int h=9, i=13;
		if(h<4 ||++i>13 && h>8)   
		{
		   out.println("run");
		}
		out.println(i);


   }
}