import javax.swing.*;

public class Lab1 {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog(null, "This is a input box! Enter the gayest person in the room right now");
        while (s.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").toLowerCase().contains("parth") || s.toLowerCase().contains("p@rth")){
            JOptionPane.showMessageDialog(null, "Wrong guy! Try again", "Error Message Example", JOptionPane.ERROR_MESSAGE);
            s = JOptionPane.showInputDialog(null, "This is a input box! Enter the gayest person in the room right now");
        }
        if (s.equalsIgnoreCase("Sree") || s.equalsIgnoreCase("Sreeshan")){
            JOptionPane.showMessageDialog(null, String.format("Nice job identifying %s as the gayest person in the room", s));
            JOptionPane.showMessageDialog(null, String.format("Hi %s, you have some wonderful friends who helped you come out of the closet. I wish you a good journey ahead", s));
        } else {


        int i = JOptionPane.showConfirmDialog(null, String.format("Just to confirm, you think that %s is the gayest person in the room?", s), "Confirmation Example", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null, "Good job sticking to you decision! I'm so proud of you");
        } else if (i == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Stick with your original answer. Don't second guess yourself");
        }
        JOptionPane.showMessageDialog(null, String.format("Hi %s, you have some wonderful friends who helped you come out of the closet. I wish you a good journey ahead", s));
    }}
}
