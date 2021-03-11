import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Polygon extends BasePrimitives {
	
	// color
	private Color curColor;

	// create array to hold multiple points
	private int[] xPolygon, yPolygon;
	
	// point counter
	private int nPoints;

	// toggle with fill
	private boolean fill;
	
	private boolean selection;
	
	// constructor
	public Polygon()
	{
		
	}
	
	// get fill
	public boolean getFill()
	{
		return fill;
	}
		
	// set fill
	public void setFill(boolean f)
	{
		this.fill = f;
	}
		
	// set color
	public void setColor(Color curColor)
	{
		this.curColor = curColor;
	}	
	
	// get select
	public boolean getSelection()
	{
		return selection;
	}
		
	// set select
	public void setSelectItem(boolean select)
	{
		this.selection = select;
	}
	
	/*
	public boolean boxTest(int x, int y)
	{
		
		if(x > Math.min(xPolygon, yPolygon) && x < Math.max(xPolygon, yPolygon) && 
		   y > Math.min(xPolygon, yPolygon) && y < Math.max(xPolygon, yPolygon))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	*/
	
	public void draw(Graphics g)
	{			
		g.drawPolygon(xPolygon, yPolygon, nPoints);
		
		// assign fill to get fill
		fill = getFill();
		
		// assign curColor to get color
		curColor = getColorCut();
		
		// changing color [current color]
        g.setColor(curColor);
		
		if(selection == true)
		{
			g.drawPolygon(xPolygon, yPolygon, nPoints);
		}
		else if(fill == true)
		{
			g.fillPolygon(xPolygon, yPolygon, nPoints);
		}
		else if(fill == false)
		{
			g.drawPolygon(xPolygon, yPolygon, nPoints);
		}
	}
	
	// set lines
	public void setPolygon(ArrayList<Integer> points)
	{
		/*
		for(int i = 1; i < points.size() - 1; i += 2)
		{
		   xPolygon[i - 1] = points.get(i - 1);
		   yPolygon[i] = points.get(i);
		}
		*/
	}
}
