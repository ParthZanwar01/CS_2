
//package startthebeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class StartTheBeep extends JFrame {

    JButton beepButton = new JButton("Start the Beep!");
    JPanel centerPanel = new JPanel();
    Timer timer;

    public StartTheBeep(){

        initGUI();
        setTitle("Beep Beep");
    	//setSize(new Dimension(300,300));
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//centers the frame
        pack();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((int) (.5*(screensize.width-getWidth())), (int)(.5*(screensize.height-getHeight())), getWidth(), getHeight() );
    }
    private void initGUI(){
        centerPanel.setPreferredSize(new Dimension(160, 100));
        centerPanel.setBackground(Color.blue);
        getContentPane().add(centerPanel);
        beepButton.setPreferredSize(new Dimension(150, 50));
        centerPanel.add(beepButton,BorderLayout.CENTER);
        beepButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickButtonActionPerformed(e);
            }
        });
        timer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                beepTimerActionPerformed(e);
            }
        });
    }
    private void clickButtonActionPerformed(ActionEvent e){
        if(timer.isRunning()){
            beepButton.setText("Start the Beep!");
            timer.stop();
        }
        else{
            beepButton.setText("Stop the Beep!");
            timer.start();
        }
    }
    private void beepTimerActionPerformed(ActionEvent e){
        Toolkit.getDefaultToolkit().beep();
    }
    public static void main(String[] args) {
        new StartTheBeep();
    }

}
