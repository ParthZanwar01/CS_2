import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
public class CreateAnImage {

    public static void main(String[] args) {
    	int width = 100, height = 100;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.yellow);
        g.fillRect(0,0,width,height);
		Font font = new Font(Font.DIALOG,Font.BOLD,90);
		g.setFont(font);
		g.setColor(new Color(0,0,0,255));
		String skull = "\u2620";
		FontMetrics fm = g.getFontMetrics(font);
		int skullWidth = fm.stringWidth(skull);
		int skullHeight = fm.getAscent()-fm.getLeading()-fm.getDescent();
		int marginW = (width - skullWidth)/2;
		int marginH = (height - skullHeight)/2;
		g.drawString(skull, marginW, height - marginH);

        try{
        	ImageIO.write(image,"png", new File("skull.png"));
        }
        catch (IOException e){
            String message = "Could not save skull.png";
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
