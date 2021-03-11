import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JColorChooser;

public class PaintMain extends Frame
{
	private static final long serialVersionUID = 1L;
	
	// a menu: handle exit, changing the fill state
	private MenuBar menuBar;
	private Menu ChoiceMenu;
	private Menu EditMenu;
	private MenuItem exitItem, fillItem;
	private CheckboxMenuItem lineItem, ovalItem, rectangleItem, polygonItem, freehandItem, selectItem;

	private  MenuItem colorItem; 
	
	// create arrayList for points
	private ArrayList<Integer> points;
	
	// create arrayList for primitives
	private ArrayList<BasePrimitives> primitives;
	
	// primitives selected
	BasePrimitives selected;
	
	// hold x and y
	private int x, y;
	
	// mouse drag
	private int currentX, currentY;
	
	// initial color
	private Color curColor;
	
	// Constructor
	PaintMain()
	{
		// instantiate array lists
		points = new ArrayList<>();
		primitives = new ArrayList<>();
		
		// Enables the closing of the window.
		addWindowListener(new MyFinishWindow());
		
		// create menu
		createMenu();
		
		// we need mouse input, so need to handle the events associated with it
		addMouseListener(
			new MouseAdapter()
			{
				public void mousePressed(MouseEvent evt)
				{
					Graphics2D g = (Graphics2D)getGraphics();
					
					// register control points 
					x = evt.getX();
					points.add(x);
					y = evt.getY();
					points.add(y);
					
					// if select item is chosen
					if(selectItem.getState() == true)
					{
						// go through the base primitives and color
						for(BasePrimitives p : primitives)
						{
							if(p.boxTest(x,y) == true)
							{
								selected = p;
								selected.setSelectItem(true);
								break;
 							}
						}
					}
					
					// draws line
					else if (points.size() == 4 && lineItem.getState() == true)
					{
						Line l = new Line();
						l.setLine(points);
						l.setColorCut(curColor);
						primitives.add(l);
						points.clear();
					}
							
					// draws oval
					else if(points.size() == 4 && ovalItem.getState() == true)
					{
						Oval o = new Oval();
						o.setOval(points);
						o.setColorCut(curColor);
						primitives.add(o);
						points.clear();
					}
						
					// draws rectangle
					else if(points.size() == 4 && rectangleItem.getState() == true)
					{
						Rectangle r = new Rectangle();
						r.setRectangle(points);
						r.setColorCut(curColor);
						primitives.add(r);
						points.clear();
					}
					
					// draws polygon
					else if(polygonItem.getState() == true)
					{
						Polygon p = new Polygon();
						p.setPolygon(points);
						p.setColorCut(curColor);
						primitives.add(p);
						points.clear();
					}
					
					// draw free hand
					else if(freehandItem.getState() == true)
					{
						FreeHand fh = new FreeHand();
						fh.setFreeHand(points);
						fh.setColorCut(curColor);
						primitives.add(fh);
						points.clear();	
					}	
					repaint();	
				}
				
				public void mouseDragged(MouseEvent evt)
				{
					currentX = evt.getX();
					points.add(currentX);
					currentY = evt.getY();
					points.add(currentY);
					
					repaint();
				}
						
				public void mouseReleased(MouseEvent evt)
				{
					Graphics2D g = (Graphics2D)getGraphics();		
				}		
			}
		);
	}
	
	private void createMenu()
	{
		// build a menu
		menuBar = new MenuBar();
		
		// main menu bar
		setMenuBar(menuBar);
		
		// a menu
		ChoiceMenu = new Menu("Choices");
		menuBar.add(ChoiceMenu);
		
		// a menu
		EditMenu = new Menu("Edit");
		menuBar.add(EditMenu);
		
		// draw line
		lineItem = new CheckboxMenuItem("Line");
		ChoiceMenu.add(lineItem);
		// line dialog handler
		lineItem.addItemListener(
		         new ItemListener()
				 {
					public void itemStateChanged(ItemEvent evt)
					{
						repaint();
					}
   				 }
		         );
		
		// draw oval
		ovalItem = new CheckboxMenuItem("Oval");
		ChoiceMenu.add(ovalItem);
		// oval dialog handler
		ovalItem.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent evt)
					{
						repaint();
					}
		   		}
				);
		
		// draw rectangle
		rectangleItem = new CheckboxMenuItem("Rectangle");
		ChoiceMenu.add(rectangleItem);
		// rectangle dialog handler
		rectangleItem.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent evt)
					{
						repaint();
					}
		   		}
				);
		
		// draw polygon
		polygonItem = new CheckboxMenuItem("Polygon");
		ChoiceMenu.add(polygonItem);
		// polygon dialog handler
		polygonItem.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent evt)
					{
						repaint();
					}
		   		}
				);
		
		// draw free hand
		freehandItem = new CheckboxMenuItem("Free Hand");
		ChoiceMenu.add(freehandItem);
		// free hand dialog handler
		freehandItem.addItemListener(
		new ItemListener()
			{
				public void itemStateChanged(ItemEvent evt)
				{
					repaint();
				}
			}
			);
		
		// toggle between filling shape
		fillItem = new MenuItem("Fill shape");
		EditMenu.add(fillItem);
		fillItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						repaint();	
					}
				}
				);
		
		// select item, used to select within shape to fill / outline 
		selectItem = new CheckboxMenuItem("Select");
		EditMenu.add(selectItem);
		selectItem.addItemListener(
				new ItemListener()
				{
					public void itemStateChanged(ItemEvent evt)
					{
						repaint();
					}
				}
				);
		
		// a menu item through which we allow changing the color
		colorItem =  new MenuItem("Color");
		EditMenu.add(colorItem);
		// color dialog handler
		colorItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						// bring up a color dialog with the current color selected
						Color c = JColorChooser.showDialog(null, "Select drawing color", curColor);
						
						curColor = c;	
						
					    if(selectItem.getState() == true)
						{
							selected.setColorCut(curColor);
						}
					    
						// we changed the color and want to see the effect
						repaint();
					}
				}
				);
			
		// exit
		exitItem = new MenuItem("Exit");
		ChoiceMenu.add(exitItem);
		// exit handler
		exitItem.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						// the parameter of exit() can indicate an error code
						// zero means the program exited without error
						System.exit(0);
					}
				}
				);
	}
	
	public void paint(Graphics g)
	{			
		// to draw control points
		for(int i = 0; i < points.size(); i++)
		{
			g.fillOval(x, y, 10, 10);
		}
		
		// go through the base primitives and draw 
		for(BasePrimitives p : primitives)
		{
			p.draw(g); 
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Generate the window.
		
		PaintMain f = new PaintMain();
				
		//Define a title for the window.
		f.setTitle("Java 2D Paint");
		//Definition of the window size in pixels
		f.setSize(800, 600);
		// background to black
		f.setBackground(Color.white);
		//Show the window on the screen.
		f.setVisible(true);
	}

}
