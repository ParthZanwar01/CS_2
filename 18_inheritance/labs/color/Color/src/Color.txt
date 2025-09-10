public class Color {
    private int red;
    private int blue;
    private int green;

    public Color() {
        red = 0;
        blue = 0;
        green = 0;
    }

    public Color(int red, int green, int blue) {
        this.red = inBounds(red);
        this.blue = inBounds(blue);
        this.green = inBounds(green);
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public int getRed() {
        return red;
    }

    public void setBlue(int blue) {
        this.blue = inBounds(blue);
    }

    public void setGreen(int green) {
        this.green = inBounds(green);
    }

    public void setRed(int red) {
        this.red = inBounds(red);
    }

    public int inBounds(int i) {
        return i < 0 ? 0 : Math.min(i, 255);
    }

    public String toString() {
        return String.format("#(%d,%d,%d)", red, green, blue);
    }
}

class AlphaColor extends Color {
    private int alpha;

    public int getAlpha() {
        return alpha;
    }

    public void dissolve() {
        if (alpha < 255) alpha += 1;
        setBlue(getBlue() + 1);
        setGreen(getGreen() + 1);
        setRed(getRed() + 1);
    }

    public void precipitate() {
        if (alpha > 0) alpha -= 1;
        setBlue(getBlue() - 1);
        setGreen(getGreen() - 1);
        setRed(getRed() - 1);
    }

    public String toString() {
        return super.toString() + String.format("(%s:%d)", alphaName(alpha), alpha);
    }

    private String alphaName(int alpha) {
        return (alpha >= 0 && alpha <= 100 ? "transparent" : alpha >= 101 && alpha <= 200 ? "translucent" : "opaque");
    }

    public AlphaColor(int red, int green, int blue, int alpha) {
        super(red, green, blue);
        this.alpha = inBounds(alpha);
    }

    public AlphaColor(double cyan, double magenta, double yellow, double black, int alpha) {
        double white = (1 - black);
        int red = Integer.parseInt(String.format("%.0f", 255 * white * (1 - cyan)));
        int green = Integer.parseInt(String.format("%.0f", (255 * white * (1 - magenta))));
        int blue = Integer.parseInt(String.format("%.0f", (255 * white * (1 - yellow))));
        setRed(red);
        setBlue(blue);
        setGreen(green);
        this.alpha = inBounds(alpha);
    }
}