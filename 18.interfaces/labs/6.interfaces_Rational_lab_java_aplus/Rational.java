//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 10/ 7/ 24
//Class - Comp Sci 2 K
//Lab  - Rational

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int numerator;
	private int denominator;

	//write two constructors
	public Rational(){
		numerator = 1;
		denominator = 1;
	}

	public Rational(int top, int bottom){
		numerator = top;
		denominator = bottom;
	}

	//write a setRational method
	public void setRational(int top, int bottom){
		numerator = top;
		denominator = bottom;
	}

	//write  a set method for numerator and denominator


	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new numerator = (num1 * den2 + num2 * den1)
		//new denominator = (den1 * den2)
		numerator = getNumerator() * other.getDenominator() + other.getNumerator() * getDenominator();
		denominator = getDenominator() * other.getDenominator();
		reduce();
	}

	public void subtract(Rational other){
		numerator = getNumerator() * other.getDenominator() - other.getNumerator() * getDenominator();
		denominator = getDenominator() * other.getDenominator();
		reduce();
	}

	public void multiply(Rational other){
		numerator = getNumerator() * other.getNumerator();
		denominator = getDenominator() * other.getDenominator();
		reduce();
	}

	public void divide(Rational other){
		numerator = getNumerator() * other.getDenominator();
		denominator = getDenominator() * other.getNumerator();
		reduce();
	}

	private void reduce()
	{
		int gcd = gcd(numerator, denominator);
		numerator = numerator/ gcd;
		denominator = denominator / gcd;
	}

	private int gcd(int numOne, int numTwo)
	{
		return numTwo == 0 ? numOne : gcd(numTwo, numOne % numTwo) ;
	}

	public Object clone ()
	{

		return new Rational(numerator, denominator);
	}


	//ACCESSORS

	//write get methods for numerator and denominator


	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public boolean equals(Object obj)
	{

		Rational other = (Rational) obj;
		other.reduce();
		return getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator();
	}

	public int compareTo(Rational other)
	{
		int tempNum1 = getNumerator() * other.getDenominator();
		int tempNum2 = other.getNumerator() * getDenominator();
		return Integer.compare(tempNum1, tempNum2);
	}



	
	//write  toString() method
	public String toString(){
		return numerator + "/" + denominator;
	}
	
	
}