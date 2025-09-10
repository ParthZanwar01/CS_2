//© A+ Computer Science  -  www.apluscompsci.com
//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster2 implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster2(){
		myAge = 10;
		myHeight = 20;
		myWeight = 30;
	}


	//write an initialization constructor with an int parameter ht
	public Monster2(int ht){
		myHeight = ht;
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster2(int ht, int wt){
		myWeight = wt;
		myHeight = ht;
	}


	//write an initialization constructor with int parameters ht, wt, and age
	public Monster2(int ht, int wt, int age){
		myHeight = ht;
		myWeight= wt;
		myAge = age;
	}


	//modifiers - write set methods for height, weight, and age

	public void setMyAge(int myAge) {
		this.myAge = myAge;
	}

	public void setMyHeight(int myHeight) {
		this.myHeight = myHeight;
	}

	public void setMyWeight(int myWeight) {
		this.myWeight = myWeight;
	}

	//accessors - write get methods for height, weight, and age


	public int getMyAge() {
		return myAge;
	}

	public int getMyWeight() {
		return myWeight;
	}

	public int getMyHeight() {
		return myHeight;
	}

	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster2(myHeight, myWeight, myAge);
	}

	public boolean equals( Object obj )
	{
		return compareTo(obj) == 0;
	}

	public int compareTo( Object obj )
	{
		Monster2 rhs = (Monster2)obj;
		if (this.myHeight > rhs.myHeight) return 1;
		if (this.myHeight < rhs.myHeight) return -1;
		if (this.myWeight > rhs.myWeight) return 1;
		if (this.myWeight < rhs.myWeight) return -1;
		if (this.myAge > rhs.myAge) return 1;
		if (this.myAge < rhs.myAge) return -1;
		return 0;
	}

	//write a toString() method
	public String toString(){
		return myHeight + " " + myWeight + " " + myAge;
	}
	
}