//© A+ Computer Science  -  www.apluscompsci.com

//truth tables worksheet key    

import static java.lang.System.*;

public class TruthTablesWorkSheetKEY
{
	public static void main(String args[])
	{
		out.println("\n\nabc");
						
		boolean a = false;
		boolean b = true;
		boolean c = false;
		
		a = b && c;
		out.println(a);
		
		out.println("\n\ndef");
		
		boolean d = false;
		boolean e = true;
		boolean f = false;
		
		d = f || e;
		out.println(d);		

		out.println("\n\nghij");		
		
		boolean g = false;
		boolean h = true;
		boolean i = false;
		boolean j = true;
		
		
		g = h && i || j;
		out.println(g);		
		
		out.println("\n\nmnpq");		
		
		boolean m = false;
		boolean n = true;
		boolean p = true;
		boolean q = true;
				
		m = !n || p && q;
		out.println(m);
	}
}
