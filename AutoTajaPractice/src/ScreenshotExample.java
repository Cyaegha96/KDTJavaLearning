import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ScreenshotExample {

	public static void main(String[] args) {
		Rectangle captureArea = new Rectangle(100, 100, 400, 300);
		// Robot 인스턴스 생성
        try {
			Robot robot = new Robot();
			
			BufferedImage screenFullImage = robot.createScreenCapture(captureArea);
			
			ImageIO.write(screenFullImage, "png", new File("screenshot.png"));

            System.out.println("스크린샷 저장 완료!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
