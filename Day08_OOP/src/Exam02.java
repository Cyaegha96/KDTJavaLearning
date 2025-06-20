import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.sql.Time;

public class Exam02 {
	public static void main(String[] args) throws AWTException {

		
		Robot robot = new Robot();
//		for(int i=0;i<500;i=i+2) {
//			robot.mouseMove(200+i, 200+i);
//			robot.delay(100);
//		}
		
		robot.mouseMove(1800, 20);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
