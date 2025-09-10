import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please think of an integer between 0 and 100!");
        System.out.println("I will guess it in 7 choices or less.");
        System.out.println("Enter 'h' to indicate the guess is too high");
        System.out.println("Enter 'l' to indicate the guess is too low");
        System.out.println("Enter 'c' to indicate I guessed correctly");
        System.out.println();
        System.out.println();
        int number = 50;
        int guesses = 0;
        int left = 0;
        int right = 100;
        for (; guesses < 7; guesses++){
            System.out.printf("Is your secret number %d\n", number);
            System.out.print("Enter h, l, or c: ");
            String choice = in.next().toLowerCase();
            if (choice.equals("c")){
                System.out.printf("Game over. Your secret number was %d\n", number);
                guesses = 0;
                break;
            }
            if (choice.equals("h")) {
                right = number - 1;
            }
            else {
                left = number+1;
            }
            number = left + (right-left)/2;
        }
        if (guesses > 6) System.out.println("You cheated!");
    }
}
