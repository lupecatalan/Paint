import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class BasePrimitives {
	
	// color
	Color curColor;
	
	private boolean fill; 
	
	private boolean selection;

	// constructor 
	public BasePrimitives()
	{

	}

	// handle points 
	public void points()
	{

	}
	
	// box methods
	public boolean boxTest(int x, int y)
	{
		return true;
	}
	
	// draw method
	public void draw(Graphics g)
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
	public Color getColorCut()
	{
		return curColor;
	}

	// set color
	public void setColorCut(Color curColor)
	{
		this.curColor = curColor;
	}
	
	// get select
	public boolean getSelectItem()
	{
		return selection;
	}
	
	// set select
	public void setSelectItem(boolean select)
	{
		this.selection = select;
	}
	
	// remove
	public void remove()
	{
		
	}
}
