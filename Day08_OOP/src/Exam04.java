import java.io.FileWriter;
import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

public class Exam04 {
	
	public static void main(String[] args) throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException {
		//FTP (File Transfer Protocol)
		
		FTPClient client = new FTPClient();
		client.connect("10.5.5.10");
		client.login("Java", "1234");
		
		String input = "이 행운의 편지는 KDT 505호 강의실에서 시작되어..이 편지를 받은 사람은 자바의 저주를 받게됍<-됩니다..\r\n"
				+ "저주를 풀고싶으면 이 편지를 다른사람에게 10번 보내세요..";
		 String filePath = "lucky.txt";
		try( FileWriter writer = new FileWriter(filePath)) {
			 writer.write(input);
			 System.out.println("파일 저장 완료: "+filePath);
		}catch (Exception e) {
			System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
		}
//		
		client.upload(new java.io.File("/C:/upload/thunder.gif"));
//		client.download("night.mp3",new java.io.File("c:/download/night.mp3"));
		client.disconnect(true);
		
	}
	
}
