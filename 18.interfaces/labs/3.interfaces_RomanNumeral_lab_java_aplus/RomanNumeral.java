//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*; 

public class RomanNumeral implements Comparable<RomanNumeral>
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		roman = str;
		toNumber(roman);
	}

	public RomanNumeral(Integer orig)
	{
		number = orig;
		toRoman(number);
	}

	//write a set number method

	public void setNumber(Integer number) {
		this.number = number;
		toRoman(number);
	}


	//write a set roman method

	public void setRoman(String roman) {
		this.roman = roman;
		toNumber(roman);
	}


	//write get methods for number and roman
	public String getRoman() {
		return roman;
	}

	public Integer getNumber() {
		return number;
	}

	public int compareTo(RomanNumeral r)
	{
		return number-r.getNumber();
	}

	private void toRoman(int number) {
		StringBuilder result = new StringBuilder();

		for(int i = 0; i < NUMBERS.length; ++i) {
			while(number >= NUMBERS[i]) {
				result.append(LETTERS[i]);
				number -= NUMBERS[i];
			}
		}
		roman =  result.toString();
	}

	private void toNumber(String roman) {
		int result = 0;

		for(int i = 0; i < LETTERS.length; ++i) {
			while(roman.startsWith(LETTERS[i])) {
				result += NUMBERS[i];
				roman = roman.substring(LETTERS[i].length());
			}
		}
		number = result;
	}
	//write  toString() method

	public String toString(){
		return roman + "\n";
	}
	
	
	
}