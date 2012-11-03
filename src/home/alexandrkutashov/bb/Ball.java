package home.alexandrkutashov.bb;

import java.awt.geom.*;
import java.util.Random;

/**
 * A ball that moves and bounces off the edges of a 
 * rectangle
 * @version 1.33 2007-05-17
 * @author Cay Horstman
 * @author Alexandr Kutashov
*/
public class Ball
{
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	/**
      Moves the ball to the next position, reversing direction
      if it hits one of the edges
	*/
	public void move(Rectangle2D bounds)
	{
      x += dx;
      y += dy;
      if (x < bounds.getMinX())
      {
         x = 2*bounds.getMinX() - x;
         dx = -dx;
      }
      if (x + XSIZE >= bounds.getMaxX())
      {
         x = 2*(bounds.getMaxX() - XSIZE) - x;
         dx = -dx;
      }
      if (y < bounds.getMinY())
      {
         y = 2*bounds.getMinY() - y;
         dy = -dy;
      }
      if (y + YSIZE >= bounds.getMaxY())
      {
         y = 2*(bounds.getMaxY() - YSIZE) - y;
         dy = -dy;
      }
	}
	
	Ball (int defaultWidth, int defaultHeight) {
		Random random = new Random();
		int border = random.nextInt(4);
		switch (border) {
		case 0:	x = 0;
				y = random.nextInt(defaultHeight);
				break;
		case 1: y = 0;
				x = random.nextInt(defaultWidth);
				break;
		case 2:	x = defaultWidth;
				y = random.nextInt(defaultHeight);
				break;
		case 3: y = defaultHeight;
				x = random.nextInt(defaultWidth);
				break;
		default: System.out.println("Error: random border was not found");
		}
		
	}

	/**
      	Gets the shape of the ball at its current position.
	 */
	public Ellipse2D getShape()
	{
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}

	
}
