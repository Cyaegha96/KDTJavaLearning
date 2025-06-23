import java.awt.AWTException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;

public class AutoTajaPractice {
	
	public static void resizeImageByFactor(File inputFile, File outputFile, double scale) throws Exception {
        // 원본 이미지 읽기
        BufferedImage inputImage = ImageIO.read(inputFile);

        // 원래 크기
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        // 새로운 크기 계산
        int newWidth = (int)(width * scale);
        int newHeight = (int)(height * scale);

        // 리사이즈된 이미지 만들기
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, inputImage.getType());
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(inputImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();

        // 파일 포맷 추출 (확장자 기반)
        String formatName = getFileExtension(outputFile);

        // 저장
        ImageIO.write(resizedImage, formatName, outputFile);
    }

    // 파일 확장자 추출 함수 (예: "jpg", "png")
    private static String getFileExtension(File file) {
        String name = file.getName();
        int dotIndex = name.lastIndexOf('.');
        return (dotIndex == -1) ? "jpg" : name.substring(dotIndex + 1).toLowerCase();
    }
	
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
        	
        }
        else {
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
		 * @throws IOException 
		 */
	
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		
		Rectangle captureArea = new Rectangle(640, 260, 830, 45);
		
		instanceTesseract.setLanguage("eng");
		instanceTesseract.setPageSegMode(7);  
		instanceTesseract.setTessVariable("preserve_interword_spaces", "1");
		

		// Robot 인스턴스 생성
		Robot robot = new Robot();
		Thread.sleep(3000);
		for(int line=0;line<10;line++) {
			try {
				
				
				BufferedImage screenFullImage = robot.createScreenCapture(captureArea);
				
				ImageIO.write(screenFullImage, "png", new File("screenshotOrigin.png"));
				File input = new File("screenshotOrigin.png");
	            File output = new File("screenshot.png");
	            
				resizeImageByFactor(input, output, 2.0);
				
	            System.out.println("스크린샷 저장 완료!");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        String typeString = process("screenshot.png");
	        typeString.replace('‘', '\'');
	        
	   
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
	        robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            
	        Thread.sleep(1000);
		}
		
	}
}
