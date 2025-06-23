import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.channels.FileChannel.MapMode;
import java.util.EmptyStackException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;

public class AutoTajaPractice {
	
	
static Tesseract instanceTesseract = Tesseract.getInstance();

private static void typeCharacter(Robot robot, char c) {
    try {
        // 대문자 처리
        boolean upperCase = Character.isUpperCase(c);
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);

       

        if (upperCase) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }
      
        	
        if (c == '!') {
        	robot.keyPress(KeyEvent.VK_SHIFT);
        	robot.keyPress(1);
        	robot.keyRelease(1);
        	robot.keyRelease(KeyEvent.VK_SHIFT);
        	
        }else {
        	robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
        	

        if (upperCase) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    } catch (IllegalArgumentException e) {
        System.out.println("Unsupported character: " + c);
    }
}
	
	public static String process(String fileName) {
		
		
		//저장한 파일의 OCR울 가져옴
		File inputFile = new File(fileName);
		String resultString = "";
		try {
			resultString = instanceTesseract.doOCR(inputFile);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return resultString;
	}
	
		/**
		 * 자동 타자 입력기
		 * 이 프로그램의 작동 방식은 다음과 같습니다.
		 * 특정 부분의 스크린샷을 뜬다.
		 * 그 부분의 문자를 인식한다.
		 * 그 부분의 타자를 타자로 친다!
		 * PROFIT! 
		 * 
		 * @param args
		 * @throws AWTException 
		 * @throws InterruptedException 
		 */
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		
		Rectangle captureArea = new Rectangle(650, 270, 850, 65);
		
		instanceTesseract.setLanguage("eng");
		instanceTesseract.setPageSegMode(7);  
		
		// Robot 인스턴스 생성
		Robot robot = new Robot();
		Thread.sleep(3000);
		while(true) {
			try {
				
				
				BufferedImage screenFullImage = robot.createScreenCapture(captureArea);
				
				ImageIO.write(screenFullImage, "png", new File("screenshot.png"));

	            System.out.println("스크린샷 저장 완료!");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        String typeString = process("screenshot.png");
	  
	   
	        if (!typeString.trim().endsWith(".")) {
	            // 마지막 영문자 위치 찾기 (a~z 또는 A~Z)
	            int lastLetterIndex = -1;
	            for (int i = typeString.length() - 1; i >= 0; i--) {
	                char c = typeString.charAt(i);
	                if (Character.isLetter(c) && c < 128) { // 영문자 조건
	                    lastLetterIndex = i;
	                    break;
	                }
	            }

	            // 영문자가 있을 경우에만 처리
	            if (lastLetterIndex != -1) {
	                // 마지막 영문자까지 자르고 나머지는 버림 (공백은 유지됨)
	                typeString = typeString.substring(0, lastLetterIndex + 1) + ".";
	            }
	        }


	        System.out.println(typeString);
	        for (char c : typeString.toCharArray()) {
	        	
	            typeCharacter(robot, c);
	            Thread.sleep(20); 
	        }
	        Thread.sleep(1000);
		}
		
	}
}
