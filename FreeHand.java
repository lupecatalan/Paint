import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FreeHand extends BasePrimitives {

	// holds x and y values for free hand drawing
	private int x, y, nPoints;
	
	private boolean fill;
	private boolean selection;

	private Color color;
	
	// constructor 
	public FreeHand()
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
		
	// get color
	public Color getColor()
	{
		return curColor;
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
	
	@Override
	// method in free hand class to draw free hand
	public void draw(Graphics g)
	{
		//g.drawPolyline(x, y, nPoints);
	}
	
	// set lines
	public void setFreeHand(ArrayList<Integer> points)
	{
		x = points.get(0);
		y = points.get(1);
	}

}
