//© A+ Computer Science  -  www.apluscompsci.com

//truth tables worksheet 2 key     

import static java.lang.System.*;

public class TruthTablesWorkSheet2KEY
{
	public static void main(String args[])
	{
		out.println("\n\nabc");
						
		boolean a = false;
		boolean b = true;
		boolean c = false;
		
		a = !(b && c);
		out.println(a);
		
		out.println("\n\ndef");
		
		boolean d = false;
		boolean e = true;
		boolean f = false;
		
		d = !(f || e);
		out.println(d);		

		out.println("\n\nghij");		
		
		boolean g = false;
		boolean h = true;
		boolean i = false;
		boolean j = true;
		
		
		g = h && i||(i || j);
		out.println(g);		
		
		out.println("\n\nmnpq");		
		
		boolean m = false;
		boolean n = true;
		boolean p = true;
		boolean q = true;
				
		m = !(n && p)|| p &&(n || q);
		out.println(m);
	}
}
