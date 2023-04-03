package lab_work_five;
import java.awt.Graphics;
public class RecurStar_five {

	private int depth;
	private int size;
	
	public RecurStar_five() {
		this.depth = 1;
		this.size = 150;
	}
	
	public RecurStar_five(int size,int depth) {
		this.depth = depth;
		this.size = size;
	}	
	void setStarDepth(int depth)
	{
		this.depth = depth;
	}

	private void drawStar(Graphics g,int x,int y,int size)
	{
		int nPoints = 11;
		int midX = x;
		int midY = y;	
		int[] X = new int[nPoints];
		int[] Y = new int[nPoints];
		int R = size;
		int R1 = 2*R / 3;
		int a = 18;	
		for(int i = 0; i < nPoints; i++)
		{
			if(i % 2 != 0)
			{
				X[i] = midX + (int)(R1/2*Math.cos(a*Math.PI/180));
				Y[i] = midY - (int)(R1/2*Math.sin(a*Math.PI/180)); 
			}
			else 
			{
				X[i] = midX + (int)(R*Math.cos(a*Math.PI/180));
				Y[i] = midY - (int)(R*Math.sin(a*Math.PI/180));
			}
			a+=36;
		}
		g.drawPolygon(X, Y, nPoints);
	}
	
	private void RecurStar(Graphics g,int x,int y,int size,int depth)
	{
		if(depth <= 0)
			return;
		drawStar(g, x, y, size);
		RecurStar(g, x+(int)(size*Math.cos(18*Math.PI/180)), y-(int)(size*Math.sin(18*Math.PI/180)), size/2, depth-1);
		RecurStar(g, x-(int)(size*Math.cos(18*Math.PI/180)), y-(int)(size*Math.sin(18*Math.PI/180)), size/2, depth-1);
		RecurStar(g, x, y - (int)(3*size*Math.sin(18*Math.PI/180)), size/2, depth-1);
		RecurStar(g, x - (int)(size*Math.sin(36*Math.PI/180)), y + (int)(size*Math.sin(54*Math.PI/180)), size/2, depth-1);
		RecurStar(g, x + (int)(size*Math.sin(36*Math.PI/180)), y + (int)(size*Math.sin(54*Math.PI/180)), size/2, depth-1);
	}
	
	public void draw(Graphics g,int x,int y) 
	{
		RecurStar(g, x, y, size, depth);
	}
	
}
