import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class CustomWidget extends JPanel{
	
	public final int SQUARE_SIZE = 15;
	
	public boolean onClick;
	public int clicX,clicY;
	public int x,y;
	
	public CustomWidget() {
		onClick = false;
		
		//Square position
		x = 0;
		y = 0;
		
		//Last clicked position
		clicX = 0;
		clicY = 0;
		
		setSize(100, 100);
		setPreferredSize(new Dimension(100,100));
		setBackground(Color.WHITE);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(onClick && contains(e.getX(), e.getY())){
					onClick = false;
					x = e.getX() - (clicX - x);
					y = e.getY() - (clicY - y);
				}
				repaint();
			}
			public void mousePressed(MouseEvent e) {
				if( x <= e.getX() && e.getX() <= (x+SQUARE_SIZE) &&
					y <= e.getY() && e.getY() <= (y+SQUARE_SIZE)){
					clicX = e.getX();
					clicY = e.getY();
					onClick = true;
				}
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {}
		});
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(onClick)	myPaint(e.getX(), e.getY());
			}
		});
	}
	
	public void myPaint(int x_, int y_){
		Graphics g = this.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.GRAY);
		g.fill3DRect(x_ - (clicX - x) ,y_ - (clicY - y), SQUARE_SIZE, SQUARE_SIZE, true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.setColor(Color.GRAY);
		g.fill3DRect(x, y, SQUARE_SIZE, SQUARE_SIZE, true);
	}
	
}
