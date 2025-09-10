import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Funsies {

    static int miles_traveled = 0;
    static int thirst = 0;
    static int dog_tired = 0;
    static int drinks_in_canteen = 10;
    static int roman_distance = -20;
    static int wood_for_fire = 0;

    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("F:\\CS2K\\GUI\\1.GUI_intro\\labs\\Labs\\images-removebg-preview.png");
        JLabel label = new JLabel(icon);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.add(label);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(panel, BorderLayout.EAST);

        //JOptionPane.showMessageDialog(null, panel2, "Course", JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(null, "Brutus,\nYou have just aided in the murder of Julius Caesar\nThe Roman Legionaries are chasing you down to drink your blood\nSurvive the run for 300 miles and make sure to farm resources to start your fires\nAbove all, keep the dog alive and kicking(We are all dog lovers here"+Character.toString(0x1F60D) + ")!\n", "Game Start", JOptionPane.PLAIN_MESSAGE, icon);
        Random r = new Random();
        while (true){
            int add_roman_distance = r.nextInt(7, 13);
            int add_miles_traveled_min = r.nextInt(5, 12);
            int add_miles_traveled_max = r.nextInt(10, 20);
            int distance_between_parties = Math.abs(miles_traveled - roman_distance);


            String choice = JOptionPane.showInputDialog("Your Options are:\nA. Drink from your canteen.\nB. Ahead half speed\nC. Ahead full speed\nD. Stop for the night\nE. Status check\nF. Get Resources\nQ. Quit\n\nEnter your choice below(A-F or Q)");

            while (choice.matches("[^a-f|qA-FQ]") || choice.length() != 1){
                choice = JOptionPane.showInputDialog(null, "Your Options are:\nA. Drink from your canteen.\nB. Ahead half speed\nC.Ahead full speed\nD. Stop for the night\nE. Status check\nF. Get Resources\nQ. Quit\n\nEnter your choice below(A-F or Q)");
            }


            choice = choice.toLowerCase();

            if (choice.equals("a")){
                if (drinks_in_canteen == 0) {
                    JOptionPane.showMessageDialog(null, "You don't have any drinks available, and you wasted time!");
                }
                else {
                    thirst = 0;
                    if (dog_tired > 0) {
                        dog_tired -= 1;
                    }
                    drinks_in_canteen -= 1;
                    JOptionPane.showMessageDialog(null, "You took a long, thirsty drink out of your canteen");
                }
                roman_distance += add_roman_distance;
            }

            if (choice.equals("b")){
                roman_distance += add_roman_distance;
                miles_traveled += add_miles_traveled_min;
                thirst += 1;
                dog_tired += 1;
                JOptionPane.showMessageDialog(null, String.format("Miles just traveled: %d", add_miles_traveled_min));
            }

            if (choice.equals("c")){
                roman_distance += add_roman_distance;
                miles_traveled += add_miles_traveled_max;
                dog_tired += r.nextInt(1, 3);
                thirst += 1;
                JOptionPane.showMessageDialog(null, String.format("Miles just traveled: %d", add_miles_traveled_max));
            }

            if (choice.equals("d")) {
                roman_distance += add_roman_distance;
                dog_tired = 0;
                JOptionPane.showMessageDialog(null, "Your dog is happy for now, but do you have enough wood?");
                int n = r.nextInt(2, 4);
                if (wood_for_fire >= 4) {
                    JOptionPane.showMessageDialog(null, String.format("You have used %d pieces of wood to start a fire", wood_for_fire));
                    wood_for_fire -= n;
                } else {
                    JOptionPane.showMessageDialog(null, "Not enough wood\nYour dog is dying because of the cold");
                    dog_tired += 2;
                }
            }

            if (choice.equals("e")) {
             JOptionPane.showMessageDialog(null, String.format("Miles traveled: %d\nDrinks in canteen: %d\nThe Romans are %d miles behind you\nYou have %d pieces of wood", miles_traveled, drinks_in_canteen, distance_between_parties, wood_for_fire));
             roman_distance+=add_roman_distance;
            }

            if (choice.equals("f")) {
                int n = r.nextInt(0, 6);
                JOptionPane.showMessageDialog(null, String.format("You have gathered %d pieces of wood", n));
                wood_for_fire+=n;
            }

            if (choice.equals("q")) {
                break;
            }

            if (miles_traveled >= 300){
                JOptionPane.showMessageDialog(null, "You have made it and get to live another day.");
                break;
            }

            if (r.nextInt(1, 20) == 10){
                JOptionPane.showMessageDialog(null, "You stumbled along an oasis");
                thirst = 0;
                drinks_in_canteen = 10;
            }

            if (dog_tired > 7){
                JOptionPane.showMessageDialog(null, "You died of grief because your dog just died.😟😟😟");
                break;
            } else if (dog_tired > 5) {
                JOptionPane.showMessageDialog(null, "Your dog is is dying!");
            }
            if (thirst > 6){
                JOptionPane.showMessageDialog(null, "You died of thirst");
                break;
            } else if (thirst > 4) {
                JOptionPane.showMessageDialog(null, "You are getting thirsty");
            }

            if (r.nextInt(1, 8) == 6){
                JOptionPane.showMessageDialog(null, "You have discovered a hole in your canteen. You don't have any water");
            }

            if (miles_traveled<=roman_distance){
                JOptionPane.showMessageDialog(null, "The Roman Legionaries have caught you and have drunk your blood. You died by getting turned inside out! Those legionaries were really thirsty");
                break;
            } else if (distance_between_parties<=20) {
                JOptionPane.showMessageDialog(null, "The Romans are getting close");

            }

        }
    }
}
