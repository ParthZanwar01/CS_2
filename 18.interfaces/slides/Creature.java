//© A+ Computer Science
// www.apluscompsci.com

//comparable example three

public class Creature implements Comparable
{
  private int size;

  public Creature(int girth) { 
    size=girth; 
  }

  public boolean equals(Object obj)
  {
     Creature other = (Creature)obj;
     return size==other.size;
        	
  }

  public int compareTo(Object obj) 
  {
     Creature other = (Creature)obj;
     if(size>other.size)
       return 1;
     else if(size<other.size) 
       return -1;
     return 0; 
  }

  public String toString() { 
    return "" + size; 
  }
}