package lab_work_five;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	
	private RecurStar_five star_five = new RecurStar_five();
	
	public void setFigureDepth(int depth)
	{
		if(depth > 4)
			return;
		star_five.setStarDepth(depth);
		repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		star_five.draw(g, this.getWidth()/2, this.getHeight()/2);
	}
}
