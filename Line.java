import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Line extends BasePrimitives {
	
	// hold x and y-variable's for the line 
	private int xOne, yOne, xTwo, yTwo;
	
	// hold fill, boolean to determine if its true to fill, otherwise do not fill object 
	private boolean fill; 
	
	// hold selection, boolean to determine if its true to change color of shape being clicked
	private boolean selection;
	
	// holds color 
	private Color curColor;
	
	// constructor
	public Line()
	{

	}
	
	// get fill
	public boolean getFill()
	{
		return fill; 
	}	
	
	// set fill
	// boolean to determine if it needs to filled or not
	public void setFill(boolean f)
	{
		this.fill = f;
	}
		
	// get color
	public Color getColorCut()
	{
		return curColor;
	}
		
	// set color
	public void setColorCut(Color curColor)
	{
		this.curColor = curColor;
	}
		
	// get selectItem
	public boolean getSelectItem()
	{
		return selection;
	}
		
	// set selectItem 
	public void setSelectItem(boolean select)
	{
		this.selection = select;
	}
	
	@Override
	/* box test to test if point lies within the object
	 * if point does not lie within the object, return false
	 * and do not change color of object
	 */
	// box test
	public boolean boxTest(int x, int y)
	{
		if(x > Math.min(xOne, xTwo) && x < Math.max(xOne, xTwo) && 
	       y > Math.min(xOne, xTwo) && y < Math.max(xOne, xTwo))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	// method in Line class to draw lines
	public void draw(Graphics g)
	{
		// assign curColor to get color
		curColor = getColorCut();
		
		// changing color [current color]
	    g.setColor(curColor);
	    
	    // assign fill to get fill
	 	fill = getFill();
	 	
	 	// assign selection to get select
	 	selection = getSelectItem();
	 	
	 	// draw line initially
		g.drawLine(xOne, yOne, xTwo, yTwo);
	 	
		if(selection == true)
		{
			g.drawLine(xOne, yOne, xTwo, yTwo);
		}
		
		// toggle fill
		else if(fill == true)
		{
			g.drawLine(xOne, yOne, xTwo, yTwo);
		}
		else if(fill == false)
		{
			g.drawLine(xOne, yOne, xTwo, yTwo);
		}	
	}
	
	// set lines
	public void setLine(ArrayList<Integer> points)
	{
		xOne = points.get(0);
		yOne = points.get(1);
		xTwo = points.get(2);
		yTwo = points.get(3);
	}
}
