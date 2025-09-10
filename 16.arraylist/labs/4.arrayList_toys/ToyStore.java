//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.*;

import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<>();
	}

	public void loadToys( String toys ) {
		String[] list = toys.split(" ");
		for (int i = 0; i < list.length; i++){
			Toy t = getThatToy(list[i]);
			if (t == null){
				toyList.add(new Toy(list[i]));
			} else {
				t.setCount(t.getCount()+1);
			}

		}
	}

	public Toy getThatToy( String nm )
	{
		for (Toy t : toyList){
			if (t.getName().equals(nm)){
				return t;
			}
		}
		return null;
	}

	public String getMostFrequentToy()
	{
		String name = toyList.getFirst().getName();
		int count = toyList.getFirst().getCount();
		for (Toy t : toyList){
			if (t.getCount() > count){
				name = t.getName();
				count = t.getCount();
			}
		}
		return "max == " + name;
	}

	public void sortToysByCount(){
		Collections.sort(toyList);
	}

	public String toString()
	{
		StringBuilder ret = new StringBuilder("[");
		for (int i = 0; i < toyList.size()-1; i++){
			ret.append(toyList.get(i).getName()).append(" ").append(toyList.get(i).getCount()).append(", ");
		}
		ret.append(toyList.getLast().getName()).append(" ").append(toyList.getLast().getCount()).append("]");
		return ret.toString();
	}
}