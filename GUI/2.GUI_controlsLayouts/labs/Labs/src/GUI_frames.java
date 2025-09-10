import javax.swing.*;

public class GUI_frames extends JFrame{

    JFrame everythingClose = new JFrame("Click to close everything");
    JFrame closeThisOnly = new JFrame("Click to close just this");

    GUI_frames() {
        everythingClose.setDefaultCloseOperation(EXIT_ON_CLOSE);
        closeThisOnly.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        everythingClose.setVisible(true);
        everythingClose.setLocationRelativeTo(null);
        everythingClose.setSize(300, 400);
        closeThisOnly.setVisible(true);
        closeThisOnly.setLocationRelativeTo(null);
        closeThisOnly.setSize(300, 400);

    }

    public static void main(String[] args) {
        GUI_frames demo = new GUI_frames();
    }

}
