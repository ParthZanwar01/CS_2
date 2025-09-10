
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUI_Buttons extends JFrame{

    JButton redButton = new JButton("click for red");
    JButton grnButton = new JButton("click for green");
    JButton blueButton = new JButton("click for blue");
    JButton grayButton = new JButton("click for gray");
    JButton randomButton = new JButton("click for random color");
    Random r =  new Random();

    GUI_Buttons()
    {
        setLayout(new FlowLayout());       // choose the layout manager
        redButton.addActionListener(ae -> getContentPane().setBackground(redButton.getBackground()));
        grnButton.addActionListener(ae -> getContentPane().setBackground(grnButton.getBackground()));
        blueButton.addActionListener(ae -> getContentPane().setBackground(blueButton.getBackground()));
        grayButton.addActionListener(ae -> getContentPane().setBackground(grayButton.getBackground()));
        randomButton.addActionListener(ae -> getContentPane().setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256))));

        redButton.setBackground(Color.red);
        grnButton.setBackground(Color.green);
        blueButton.setBackground(Color.blue);
        grayButton.setBackground(Color.gray);
        randomButton.setBackground(Color.white);

        add(redButton);
        add(grnButton);
        add(blueButton);
        add(grayButton);
        add(randomButton);

        setVisible(true);
        setTitle("Four Buttons plus Random!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setResizable(false);
        setLocationRelativeTo(null);
        pack();
    }

    public static void main(String[] args) {
        GUI_Buttons demo = new GUI_Buttons();
    }
}