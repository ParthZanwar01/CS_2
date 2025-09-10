import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bubble {


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter list to sort: ");
        String filename = in.nextLine();
        Scanner file = new Scanner(new File(filename));
        ArrayList<President> listOfNames = new ArrayList<>();
        while (file.hasNextLine()){
            String[] line = file.nextLine().split(" ");
            if (line.length == 2){
                listOfNames.add(new President(line[0], line[1], ""));
            } else {
                listOfNames.add(new President(line[0], line[2], line[1]));
            }
        }
        bubbleSort(listOfNames);
        for (President p : listOfNames){
            System.out.print(p);
        }
    }

    public static <T extends Comparable<? super T>> void bubbleSort(ArrayList<T> list){
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.size() - 1 - i; j++){
                if (list.get(j).compareTo((list.get(j+1))) > 0){
                    T temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }
}

class President implements Comparable{
    String firstName;
    String lastName;
    String middleName;

    public President(String fn, String ln, String mN){
        firstName = fn;
        lastName = ln;
        middleName = mN;
    }
public String toString(){
        return String.format("%s, %s %s\n", lastName, firstName, middleName);
    }

    @Override
    public int compareTo(Object o) {
        President other = (President) o;
        return lastName.compareTo(other.lastName) != 0 ? lastName.compareTo(other.lastName) : firstName.compareTo(other.firstName) != 0 ? firstName.compareTo(other.firstName) : middleName.compareTo(other.middleName);
    }
}
