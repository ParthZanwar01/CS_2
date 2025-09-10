
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class PlayingCards {

	public static final String[] RANKS = {" A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    public static final String[] SUITSYMBOLS = {"\u2665", "\u2666", "\u2660", "\u2663"};
    private static final int[] VALUES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public static final int CARDWIDTH = 30;
    public static final int CARDHEIGHT = 50;

    public static void main(String[] args) {
        int number = 1;
        BufferedImage image = new BufferedImage(CARDWIDTH, CARDHEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(new Color(0, 0, 0, 0));
        g.fillRect(0, 0, CARDWIDTH, CARDHEIGHT);
        Font font = new Font(Font.DIALOG, Font.BOLD, 24);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics(font);
        for(int i=0; i<52;i++){
          	g.setColor(Color.WHITE);
            g.fillRoundRect(0, 0, CARDWIDTH-1, CARDHEIGHT-1, 8, 8);
            g.setColor(Color.BLACK);
            g.drawRoundRect(0, 0, CARDWIDTH-1, CARDHEIGHT-1, 8, 8);
            if(i<26){
            	g.setColor(Color.RED);
            }
            String rank = RANKS[i%13];
            int rankWidth = fm.stringWidth(rank);
            int fromLeft = CARDWIDTH/ 2 - rankWidth/ 2;
            int fromTop = 20;
            g.drawString(rank, fromLeft, fromTop);
            String suit = SUITSYMBOLS[i/13];
            int suitWidth = fm.stringWidth(suit);
            fromLeft = CARDWIDTH/ 2 - suitWidth/ 2;
            fromTop = 45;
            g.drawString(suit, fromLeft, fromTop);
            String fileName = "cards" + number++ + ".png";
		    File file = new File(fileName);
		    try{
		    	ImageIO.write(image,"png", file);
		    }
		    catch (IOException e){
		       	String message = "Could not save " + fileName;
		       	JOptionPane.showMessageDialog(null, message);
		    }
        }

    }
}