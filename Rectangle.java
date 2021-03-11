import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Rectangle extends BasePrimitives {
	
	// variables to hold points that create the rectangle
	// based upon user clicks
	// four variables needed to hold first click(x,y) and then the next click(x2,y2)
	private int rectX, rectY, rectXTwo, rectYTwo;
	
	// holds width and height of rectangle, no matter the order of the user clicks
	private int rectWidth, rectHeight, rectWidthTwo, rectHeightTwo;
	
	// hold fill, boolean to determine if its true to fill, otherwise do not fill object 
	private boolean fill; 
	
	// hold selection, boolean to determine if its true to change color of shape being clicked
	private boolean selection;
	
	// holds color 
	private Color curColor;
	
	// constructor
	public Rectangle()
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
	
	/* box test to test if point lies within the object
	 * if point does not lie within the object, return false
	 * and do not change color of object
	 */
	public boolean boxTest(int x, int y)
	{
		if(x > Math.min(rectX, rectXTwo) && x < Math.max(rectX, rectXTwo) && 
		   y > Math.min(rectY, rectYTwo) && y < Math.max(rectY, rectYTwo))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	// method in Rectangle class to draw rectangles
	public void draw(Graphics g)
	{	
    	// width and height from top to bottom
		rectWidth = rectXTwo - rectX;
		rectHeight = rectYTwo - rectY;

		// width and height from bottom to top, to avoid negative width
		rectWidthTwo = rectX - rectXTwo;
		rectHeightTwo = rectY - rectYTwo;
				
		// assign curColor to get color
		curColor = getColorCut();
		
		// changing color [current color]
        g.setColor(curColor);
        
        // assign fill to get fill
     	fill = getFill();
     	
     	// assign selection to get select
     	selection = getSelectItem();
     	
        // top left to bottom right
		if(rectX < rectXTwo && rectY < rectYTwo)
		{
			g.drawRect(rectX, rectY, rectWidth, rectHeight);	

			if(selection == true)
			{
				g.drawRect(rectX, rectY, rectWidth, rectHeight);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillRect(rectX, rectY, rectWidth, rectHeight);
			}
			else if(fill == false)
			{
				g.drawRect(rectX, rectY, rectWidth, rectHeight);
			}	
		}
		
		// bottom right to top left
		else if(rectX > rectXTwo && rectY > rectYTwo)
		{
			g.drawRect(rectXTwo, rectYTwo, rectWidthTwo, rectHeightTwo);

			if(selection == true)
			{
				g.drawRect(rectXTwo, rectYTwo, rectWidthTwo, rectHeightTwo);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillRect(rectXTwo, rectYTwo, rectWidthTwo, rectHeightTwo);
			}
			else if(fill == false)
			{
				g.drawRect(rectXTwo, rectYTwo, rectWidthTwo, rectHeightTwo);
			}
		}
	
		// bottom left to top right
		else if(rectX < rectXTwo && rectY > rectYTwo)
		{
			g.drawRect(rectX, rectYTwo, rectWidth, rectHeightTwo);

			if(selection == true)
			{
				g.drawRect(rectX, rectYTwo, rectWidth, rectHeightTwo);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillRect(rectX, rectYTwo, rectWidth, rectHeightTwo);
			}
			else if(fill == false)
			{
				g.drawRect(rectX, rectYTwo, rectWidth, rectHeightTwo);
			}		
		}
		
		// top right to bottom left
		else if(rectX > rectXTwo && rectY < rectYTwo)
		{
			g.drawRect(rectXTwo, rectY, rectWidthTwo, rectHeight);

			if(selection == true)
			{
				g.drawRect(rectXTwo, rectY, rectWidthTwo, rectHeight);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillRect(rectXTwo, rectY, rectWidthTwo, rectHeight);
			}
			else if(fill == false)
			{
				g.drawRect(rectXTwo, rectY, rectWidthTwo, rectHeight);
			}		
		}	
	}

	public void setRectangle(ArrayList<Integer> points)
	{
		rectX = points.get(0); 
		rectY = points.get(1);
		rectXTwo = points.get(2);
		rectYTwo = points.get(3);
	}
}
