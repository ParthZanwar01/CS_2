import javax.swing.*;
public class GUI_input_output {
    public static void main(String args[]){

        JOptionPane.showMessageDialog(null,"This is the rise of our FBLA project","FBLA project first try", JOptionPane.ERROR_MESSAGE);


        String name = JOptionPane.showInputDialog("What's your name?");
        if (name.toLowerCase().startsWith("a")) {
            JOptionPane.showMessageDialog(null, String.format("Hi %s, we love A names here",name));

        } else{
            JOptionPane.showMessageDialog(null, String.format("You should have had a A name %s",name));
        }

        String age = JOptionPane.showInputDialog("What's you age (whole numbers only)?");
        while (age.matches(".*[^0-9].*") || age.isEmpty()){
            age = JOptionPane.showInputDialog("What's you age (whole numbers only)?");
        }
        if (Integer.parseInt(age) < 19 ){
            JOptionPane.showMessageDialog(null, String.format("Sorry %s, but you cannot legally drink, because you are only %s", name, age));
        } else {
            JOptionPane.showMessageDialog(null, String.format("Congratulations %s, you can legally drink with an age of %s", name, age));
        }

        int cont = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
        if (cont == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null,String.format("Goodbye %s", name));
        }

    }
    // repeat but ask for the persons age
}