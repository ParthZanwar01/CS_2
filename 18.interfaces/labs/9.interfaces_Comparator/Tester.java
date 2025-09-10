//Name -
//Date -
//Class -  
//Lab  -

import java.util.*;
import java.io.*;
public class Tester {
	private ArrayList<Rectangle>list;
    public Tester() {
    	
    	readData();
    	sortAndPrintData();
    }
    public void readData(){
    	try{
    		Scanner file = new Scanner(new File("D:\\CS2K\\18.interfaces\\labs\\9.interfaces_Comparator\\rect.dat"));
			int N = file.nextInt();
			list = new ArrayList<>();
			while (N-- > 0){
				list.add(new Rectangle(file.nextInt(), file.nextInt()));
			}
    	}catch(Exception e){
    	  // you don't have to add anything here
    	  e.printStackTrace();
    	}
    	
    }
    public void sortAndPrintData(){
 		// sort the data using Comparator and then print the data
		list.sort(Comparator.comparingInt(Rectangle:: getArea));
		list.forEach(System.out::println);
 		
 		
 		
 		
    }
    public static void main(String[] args) {
        new Tester();
    }
    private class Rectangle implements Comparable<Rectangle>{
    	int length, width;
    	public Rectangle(int length, int width){
    		this.length = length;
    		this.width = width;
    	}
    	public int getArea(){
    		return length*width;
    	}
    	// you are not allowed to modify this method
    	public int compareTo(Rectangle other){
    		return width - other.width;	// DO NOT TOUCH
    	}
    	public String toString(){
    		// format the data appropriately
    		return String.format("%2d %3d %4d", length, width, getArea());
    	}
    }
}
