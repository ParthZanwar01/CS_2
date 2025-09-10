package labs.recursion_irina;

import java.io.*;
import java.util.*;
public class Irina {
	// set up your class however you want
	// a partial Bag class has been provided below

	public static List<Bag> grab(int index, int weight, List<Bag> bags, List<Bag> choice){
		if (index >= bags.size() || weight >= 45) return choice;
		if (weight+bags.get(index).weight>45) return grab(index+1, weight, bags, choice);

		List<Bag> willTake = new ArrayList<>(choice);
		willTake.add(bags.get(index));
		List<Bag> wontTake = new ArrayList<>(choice);

		List<Bag> one = grab(index+1, weight + bags.get(index).weight, bags, willTake);
		List<Bag> two = grab(index+1, weight, bags, wontTake);
		double value1 = value(one);
		double value2 = value(two);

		return (value1>=value2) ? one : two;
	}

	public static double value(List<Bag> bags){
		double sum = 0;
		for (Bag b : bags) sum += b.value;
		return sum;
	}
    
    public static void main(String[] args)throws IOException {
        Scanner file = new Scanner(new File("irina.dat"));
		int N = file.nextInt();
		while (N-- > 0){
			int bagCount = file.nextInt();
			ArrayList<Bag> bags = new ArrayList<>();
			while (bagCount-- > 0){
				int weight = file.nextInt();
				String type = file.next();
				bags.add(new Bag(weight, type));
			}
			List<Bag> grabBags = grab(0, 0, bags, new ArrayList<>());
			Collections.sort(bags);

            for (Bag bag : grabBags) {
				System.out.printf("GRAB THE %d KG OF %s%n", bag.weight, bag.type);
			}
			System.out.println();
		}
    }
}
class Bag implements Comparable<Bag>{
	
	String type;
	int weight;
	double value;
	int denomination;
	
	public Bag(int a,String s){
		type = s;
		weight =a;
		// switch or if/else/if to determine value and denomination
		//• Penny 2.5 • Nickel 5.0 • Dime 2.25 • Quarter 5.6 • Dollar coin 8.1
		switch (type){
			case "PENNIES":
				value=(weight*1000)/2.5;
				denomination=1;
				break;
			case "NICKELS":
				value=(weight*1000)/5.0 *5;
				denomination=5;
				break;
			case "DIMES":
				value=(weight*1000)/2.25 *10;
				denomination=10;
				break;
			case "QUARTERS":
				value=(weight*1000)/5.6*25;
				denomination=25;
				break;
			case "DOLLARS":
				value=(weight*1000)/8.1 *100;
				denomination=100;
		}
	}
	public String toString(){
		return weight + " KG of " + type;
	}

	public int compareTo(Bag other){
		return this.weight == other.weight ? Double.compare(other.denomination, this.denomination) : Integer.compare(other.weight, this.weight);
	}

}
