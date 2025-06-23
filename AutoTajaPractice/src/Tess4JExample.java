import java.io.File;

import net.sourceforge.tess4j.Tesseract;

public class Tess4JExample {
	
	static Tesseract instanceTesseract = Tesseract.getInstance();
	
	public static String process(String fileName) {
		
		instanceTesseract.setLanguage("eng");
		
		//instanceTesseract.setOcrEngineMode(1); // LSTM only
		instanceTesseract.setPageSegMode(7);   // 자동 레이아웃 분석
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

	public static void main(String[] args) {
		System.out.println(process("test.png"));
	}

}
