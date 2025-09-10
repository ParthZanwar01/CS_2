import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        // Create a red color
        Color c = new Color(255, 0, 0);
        out.println(c);
// change it to white
        c.setBlue(255);
        c.setGreen(255);
        out.println(c);

// Create an AlphaColor green that is opaque
        AlphaColor green = new AlphaColor(0, 255, 0, 255);
        out.println(green);
// test dissolve/precipitate
        green.precipitate();
        out.println(green);
        green.dissolve();
        out.println(green);
// Create an AlphaColor using the CMYK constructor
        AlphaColor magenta = new AlphaColor(0.0, 1.0, 0.0, 0.0, 0);
        out.println(magenta);
        // Create an AlphaColor using the CMYK constructor
        AlphaColor orange = new AlphaColor(0.0, 0.4392156862745098, 1.0, 0.0, 200);
        out.println(orange);

    }

}