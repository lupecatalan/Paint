import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Oval extends BasePrimitives {
	
	// hold user clicks
	private int ovalX, ovalY, ovalXTwo, ovalYTwo;
	
	// hold width and height
	private int ovalWidth, ovalHeight, ovalWidthTwo, ovalHeightTwo;
	
	// hold fill, boolean to determine if its true to fill, otherwise do no fill
	private boolean fill; 
	
	// hold selection, boolean to determine if its true to change color of shape being clicked
	private boolean selection;
	
	// holds color 
	private Color curColor;
	
	// constructors
	public Oval()
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
	public Color getColor()
	{
		return curColor;
	}
	
	// set color
	public void setColorCut(Color curColor)
	{
		this.curColor = curColor;
	}
	
	// get selectItem
	public boolean getSelection()
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
		if(x > Math.min(ovalX, ovalXTwo) && x < Math.max(ovalX, ovalXTwo) && 
		   y > Math.min(ovalY, ovalYTwo) && y < Math.max(ovalY, ovalYTwo))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	// method in Oval class to draw oval
	public void draw(Graphics g)
	{
		// width and height from top to bottom
		ovalWidth = ovalXTwo - ovalX;
		ovalHeight = ovalYTwo - ovalY;
		
		// width and height from bottom to top, to avoid negative width
		ovalWidthTwo = ovalX - ovalXTwo;
		ovalHeightTwo = ovalY - ovalYTwo;
		
		// assign curColor to get color
		curColor = getColorCut();
				
		// changing color [current color]
		g.setColor(curColor);
		        
		// assign fill to get fill
		fill = getFill();
		     	
		// assign selection to get select
		selection = getSelectItem();
		
		// top left to bottom right
		if(ovalX < ovalXTwo && ovalY < ovalYTwo)
		{
			g.drawOval(ovalX, ovalY, ovalWidth, ovalHeight);

			if(selection == true)
			{
				g.drawOval(ovalX, ovalY, ovalWidth, ovalHeight);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);

			}
			else if(fill == false)
			{
				g.fillOval(ovalX, ovalY, ovalWidth, ovalHeight);

			}
		}
		
		// bottom right to top left
		else if(ovalX > ovalXTwo && ovalY > ovalYTwo)
		{
			g.drawOval(ovalXTwo, ovalYTwo, ovalWidthTwo, ovalHeightTwo);

			if(selection == true)
			{
				g.drawOval(ovalXTwo, ovalYTwo, ovalWidthTwo, ovalHeightTwo);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillOval(ovalXTwo, ovalYTwo, ovalWidthTwo, ovalHeightTwo);
			}
			else if(fill == false)
			{
				g.fillOval(ovalXTwo, ovalYTwo, ovalWidthTwo, ovalHeightTwo);
			}		
		}
		
		// bottom left to top right
		else if(ovalX < ovalXTwo && ovalY > ovalYTwo)
		{
			g.drawOval(ovalX, ovalYTwo, ovalWidth, ovalHeightTwo);
		
			if(selection == true)
			{
				g.drawOval(ovalX, ovalYTwo, ovalWidth, ovalHeightTwo);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillOval(ovalX, ovalYTwo, ovalWidth, ovalHeightTwo);
			}
			else if(fill == false)
			{
				g.fillOval(ovalX, ovalYTwo, ovalWidth, ovalHeightTwo);
			}
		}
		
		// top right to bottom left
		else if(ovalX > ovalXTwo && ovalY < ovalYTwo)
		{
			g.drawOval(ovalXTwo, ovalY, ovalWidthTwo, ovalHeight);

			if(selection == true)
			{
				g.drawOval(ovalXTwo, ovalY, ovalWidthTwo, ovalHeight);
			}
			
			// toggle fill
			else if(fill == true)
			{
				g.fillOval(ovalXTwo, ovalY, ovalWidthTwo, ovalHeight);
			}

			else if(fill == false)
			{
				g.fillOval(ovalXTwo, ovalY, ovalWidthTwo, ovalHeight);
			}
		}
	}

	public void setOval(ArrayList<Integer> points)
	{
		ovalX = points.get(0);
		ovalY = points.get(1);
		ovalXTwo = points.get(2);
		ovalYTwo = points.get(3);
	}
}
