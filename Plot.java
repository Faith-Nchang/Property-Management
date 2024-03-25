/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: plots a property of the management company on a window
 * Due: 10/23/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Faith Fru Nchang
   
*/

public class Plot {
	// attributes
	private int x;
	private int y;
	private int width;
	private int depth;
	/*
	 * no - arg constructor with width and depth of 1
	 */
	public Plot()
	{
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * 
	 * @param x - x coordinate of a plot
	 * @param y - y coordinate of a plot
	 * @param width - width of a plot
	 * @param depth - height of a plot
	 */
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y =y;
		this.width = width;
		this.depth = depth;
	}
	

	/**
	 * 
	 * @param plotObject
	 */
	public Plot(Plot plotObject)
	{
		this(plotObject.x, plotObject.y, plotObject.width, plotObject.depth);
	}
	
	// getters
	/**
	 * 
	 * @return x - x coordinate of the plot
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * @return y - y coordinate of the plot
	 */
	public int getY()
	{
		return y;
	}
	/**
	 * 
	 * @return width - width of the plot
	 */
	public int getWidth()
	{
		return width;
	}
	/**
	 * @return depth - depth of the plot
	 */
	public int getDepth()
	{
		return depth;
	}
	
	//setters
	/**
	 * @param x - x coordinate of a plot
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * @param y - y coordinate of a plot
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * @param depth - depth of a plot
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	/**
	 * accessor for the width parameter
	 * @param w - width
	 */
	public void setWidth(int w)
	{
		this.width = w;
	}
	
	
	
	/**
	 * plot - a plot object
	 */
	 public boolean encompasses(Plot plot)
	 {
		 
		 // checks whether the plot object is  encompassed
		 if(this.x <= plot.x && this.y <= plot.y && this.width >= plot.width && this.depth >= plot.depth && this.width >= (plot.x+plot.width) && this.depth >= (plot.y+plot.depth) )
			 return true;
		 else
			 return false;
		 
	 }
	 
	 /**
	  * plot - a plot object
	  */
	 public boolean overlaps(Plot plot)
	 {
		 // checks whether a current plot object overlaps another
		 if(this.x < (plot.x + plot.width) && (this.x + this.width) > plot.x  && this.y <(plot.y + plot.depth) && (this.y + this.depth) > plot.y)
			 return true;
		 else
			 return false;
		 
	 }
	 
	 public String toString()
	 {
		 String str = this.x +","+ this.y + "," + this.width + "," + this.depth;
		 return str;
	 }
}
