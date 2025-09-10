//© A+ Computer Science  -  www.apluscompsci.com
//Name - Parth Zanwar
//Date - 8/22/2024
//Class - CSK 2
//Lab  - TriangleFive

import static java.lang.System.*;

public class TriangleFive {
    private char letter;
    private int amount;

    public TriangleFive() {
        letter = 'C';
        amount = 4;
    }

    public TriangleFive(char c, int amt) {
        this.letter = c;
        this.amount = amt;
    }

    public void setLetter(char c) {
        this.letter = c;
    }

    public void setAmount(int amt) {
        this.amount = amt;
    }

    public String toString() {
        String output = "";
        int big = amount;
        char mainLetter = letter;
        int incr = 0;
        for (int k = 0; k < big; k++) {
            for (int i = amount; i > incr; i--) {
                for (int j = 0; j < i; j++) {
                    output += letter;
                }
                letter += 1;
                if (letter > 'Z') letter = 'A';
                output += " ";
            }
            output = output.trim();
            output += "\n";
            letter = mainLetter;
            incr += 1;
        }
        return output;
    }
}