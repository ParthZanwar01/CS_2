//© A+ Computer Science  -  www.apluscompsci.com

//sort seach worksheet key

import static java.lang.System.*;    
import java.util.Arrays;

public class SortSearchWorkSheetKEY
{
	public static void sort1( Comparable[] list )
	{
	  int i, j, min;
	  for( i=0; i<list.length-1; i++)
	  {
	     min = i;
	     for(j=i+1; j<list.length; j++)
	     {
		 if(list[min].compareTo(list[j]) > 0)
		     min = j;
	     }
	     if( min != i)
	     {
		  Comparable temp = list[min];
		  list[min] = list[i];
		  list[i] = temp;
	     }
	     System.out.println(Arrays.toString(list));
	   }
	}



	public static void sort2(Comparable[] list ) 
	{
	  for (int i=1; i< list.length; ++i) 
	  {
		int bot=0, top=i-1;
		while (bot<=top) 
		{
		   int mid=(bot+top)/2;
		   if (list[mid].compareTo(list[i])<0)
			bot=mid+1;
		   else top=mid-1;
		}
		Comparable temp=list[i];
		for (int j=i; j>bot; --j)
			list[j]=list[j-1];
		list[bot]=temp;
		     System.out.println(Arrays.toString(list));	
	  }
	}


	public static void sort3(Comparable[] list )
	{
	    sort3(list, 0, list.length);
	}
	
	private static void sort3( Comparable[] list, int front, int back)  	
      {
		int mid = (front+back)/2;
		if( mid==front) return;
		sort3(list, front, mid);
		sort3(list, mid, back);
		help(list, front, back);
	}
	
	private static void help(Comparable[] list, int front, int back)  
	{
	   Comparable[] temp = new Comparable[back-front];
	   int i = front, j = (front+back)/2, k =0;
	   int mid =j;
	   while( i<mid && j<back)
	   {
	      if(list[i].compareTo(list[j])<0)
	         temp[k++]=list[i++];
	      else
	         temp[k++]=list[j++];
	   }
	   
	   while(i<mid) 
	      temp[k++]=list[i++];
	   while(j<back) 
	      temp[k++]=list[j++];
	   for(i = 0; i<back-front; ++i)
	      list[front+i]=temp[i];
	      
	     System.out.println(Arrays.toString(list));	
	}

	public static void main(String[] args)
	{
		Integer[] list  = {3,15,61,11,7,9,2};
	
		sort3(list);
	}
}