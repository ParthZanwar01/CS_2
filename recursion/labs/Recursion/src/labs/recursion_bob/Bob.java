package labs.recursion_bob;

import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bob {

    static boolean found;

    public static void main(String[] args) throws FileNotFoundException {
    	
        Scanner file = new Scanner(new File("bob.dat"));
        int size = file.nextInt();
        for (int i = 0; i < size; i++) {
            int numBlocks = file.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numBlocks; j++) {
                list.add(file.nextInt());
            }
            int favorite = file.nextInt();
            found = favorite(list, favorite);
            match(list, favorite, 0, 0);
            out.println(found ? "Yes." : "Not Possible.");
            //out.println(favorite(list, favorite) ? "Yes." : "Not Possible.");
        }

    }

    public static void match(ArrayList<Integer> list, int fav, int sum, int index) {}

    // or for the more advanced recursive thinker try a one liner nested ternary
    public static boolean favorite(ArrayList<Integer> list, int fav) {
        if (fav == 0) return true;
        if (list.isEmpty() || fav < 0) return false;
        int i = list.getFirst();
        list.removeFirst();
        if (favorite(new ArrayList<>(list), fav - i)) return true;
        return favorite(new ArrayList<>(list), fav);
    }
}
