import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClickPositionTracker implements MouseListener, MouseMotionListener{
    public static void main(String[] args) throws Exception {
    	while(true) {
    		
			Point point = MouseInfo.getPointerInfo().getLocation();
			int mx = (int) point.getLocation().getX();
			int my = (int) point.getLocation().getY();
			System.out.println("x좌표 : "+mx+" , y좌표:" +my);
    		
    	}

    }

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 System.out.println("Mouse clicked at: " + e.getX() + ", " + e.getY());
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}