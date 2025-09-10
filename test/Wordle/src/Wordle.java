/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */


import edu.willamette.cs1.wordle.WordleGWindow;
import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleEventListener;

import java.awt.*;
import java.util.Arrays;

public class Wordle {
    private String rw;

    public void run() {
        gw = new WordleGWindow();
        //rw = WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random()*5772)].toUpperCase();
        rw = "GLASS";
        gw.addEnterListener((s) -> enterAction(s));
        /*
        String rw = WordleDictionary.FIVE_LETTER_WORDS[(int) (Math.random()*5772)].toUpperCase();
        for (int i = 0; i < 5; i++) {
            gw.setSquareLetter(0, i, String.valueOf(rw.charAt(i)));
            gw.setSquareLetter(0, i, String.valueOf(rw.charAt(i)));
            gw.setSquareLetter(0, i, String.valueOf(rw.charAt(i)));
            gw.setSquareLetter(0, i, String.valueOf(rw.charAt(i)));
            gw.setSquareLetter(0, i, String.valueOf(rw.charAt(i)));
        }
        */
    }

    /*
     * Called when the user hits the RETURN key or clicks the ENTER button,
     * passing in the string of characters on the current row.
     */

    public void enterAction(String s) {
        int rowNum = gw.getCurrentRow();
        if (!(Arrays.stream(WordleDictionary.FIVE_LETTER_WORDS).toList().contains(s.toLowerCase()))) {
            gw.showMessage("Not a real word");
            return;
        }
        if (s.equals(rw)) gw.showMessage("You actually won!");
        if (rowNum > 5) {
            gw.showMessage("You lost");
        }
        for (int i = 0; i < 5; i++) {
            if (rw.charAt(i) == s.charAt(i)) {
                gw.setSquareColor(rowNum, i, WordleGWindow.CORRECT_COLOR);
                gw.setKeyColor("" + s.charAt(i), WordleGWindow.CORRECT_COLOR);
            }
        }

        for (int i = 0; i < 5; i++) {
            if (rw.charAt(i) != s.charAt(i)) {
                for (int j = 0; j < 5; j++) {
                    if (i != j && s.charAt(i) == rw.charAt(j)) {
                        gw.setSquareColor(rowNum, i, WordleGWindow.PRESENT_COLOR);
                        if (gw.getKeyColor("" + s.charAt(i)) != WordleGWindow.CORRECT_COLOR)
                            gw.setKeyColor("" + s.charAt(i), WordleGWindow.PRESENT_COLOR);
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < 5; i++) {
            if (gw.getSquareColor(rowNum, i) != WordleGWindow.CORRECT_COLOR && gw.getSquareColor(rowNum, i) != WordleGWindow.PRESENT_COLOR) {
                gw.setSquareColor(rowNum, i, WordleGWindow.MISSING_COLOR);
                gw.setKeyColor("" + s.charAt(i), WordleGWindow.MISSING_COLOR);
            }
        }


        gw.setCurrentRow(rowNum + 1);

    }

    /* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
    }

    /* Private instance variables */

    private WordleGWindow gw;

}
