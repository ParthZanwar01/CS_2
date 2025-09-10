// Write a class that describes a flower. A flower has a location, a constructor and a draw method.
// The flower should look like the picture below:
// http://imgur.com/uOPHb3E

// The constructor takes the (x, y) coordinate of the upper left-hand corner of the flower.
// The arrow points to the x,y coordinates of the flower.
 
// There are four pink petals and a yellow center. Each petal and the center is a circle with a diameter of 20.
// A circle is an ellipse in which the width and height are both equal to the diameter of the circle.
// The pink circles touch the yellow one.

// The stem is green and is on the center line of the flower. Its length is 3 times the diameter.

// When implementing the draw method, I recommend that you start with the top petal, 
// figure out its coordinates, instantiate a circle at that point with a diameter of 20, and call its draw method. 
//Then test. You can create a flower object and invoke its draw method. Pick another of the circles; 
//calculate its coordinates; instantiate a circle at that location; and. Call its draw method. Now test again. 
//I believe you will find it much less intimidating to draw one little thing, get it right, and go to the next.
//You may want to use pencil and paper to do this. I did.

//Note: When drawing an Ellipse, you specify the x, y coordinates and the width and height of the rectangle 
//that would surround the ellipse.

// Here is how you would draw a circle of diameter 20 when the surrounding rectangle has an x, y coordinates or 30, 50
//      Ellipse circle = new Ellipse(30, 50, 20,20);
//      circle.draw();

// For the draft, provide a constructor that takes the x, y coordinates of the upper left-hand corner of a rectangle 
// that would surround the flower 
// Then in the draw method, draw the top-most petal in pink. The y coordinate of the top-most petal is the
// y instance variable from the constructor, but you will need to adjust the x coordinate to draw the petal in the center
// of the flower


public class Flower
{
   private int x;
   private int y;
   
   public Flower(int theX, int theY)
   {
      x = theX;
      y = theY;

   }
   /**
   * This function draws the flower.
   */
   public void draw()
   {
      circle(x-5, y+5, 20, Color.PINK);

      circle(x-25, y+5, 20, Color.PINK);

      circle(x-25, y+25, 20, Color.PINK);

      circle(x-5, y+25, 20, Color.PINK);

      circle(x-15, y+15, 20, Color.YELLOW);

      Line line = new Line(x-5, y+35, x-5, y+95);
      line.setColor(Color.GREEN);
      line.draw();
   }

   public void circle(int x, int y, int diameter, Color c){
      Ellipse circle = new Ellipse(x, y, diameter, diameter);
      circle.setColor(c);
      circle.fill();
   }
}
