import javax.swing.*;
import java.awt.*;


public class Rainbow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Rainbow Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new RainbowPanel());
        frame.setVisible(true);
    }
}


class RainbowPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Graphics gg = (Graphics) g;
        Color[] rainbowColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(75, 0, 130), new Color(143, 0, 255)};
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int arcWidth = panelWidth;
        int arcHeight = panelHeight;
        int arcStep = 20;
        for (int i = 0; i < rainbowColors.length; i++) {
            g.setColor(rainbowColors[i]);
            g.fillArc((panelWidth - arcWidth) / 2, (panelHeight - arcHeight) / 2, arcWidth, arcHeight, 0, 180);
            arcWidth -= arcStep;
            arcHeight -= arcStep;
        }
        g.setColor(getBackground());
        g.fillArc((panelWidth - arcWidth) / 2, (panelHeight - arcHeight) / 2, arcWidth, arcHeight, 0, 180);
    }
}
