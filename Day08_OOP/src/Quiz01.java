import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;



public class Quiz01 {
	public static void main(String[] args) throws IllegalStateException, IOException, FTPIllegalReplyException, FTPException, FTPDataTransferException, FTPAbortedException {
		FTPClient client = new FTPClient();
		client.connect("10.5.5.0");
		int correct = 0;
		client.login("Java", "2486");
		
		String input = "10.5.5.7 이랑 10.5.5.5 는 화이트리스트";
		
		String filePath = "secret.txt";
		try( FileWriter writer = new FileWriter(filePath)) {
			 writer.write(input);
			 System.out.println("파일 저장 완료: "+filePath);
		}catch (Exception e) {
			System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
		}
//		
		client.upload(new java.io.File("secret.txt"));
		client.download("secret.txt",new File("c:/download/secret.txt"));
		
//		for(int num1=0;num1<10;num1++) {
//
//			for(int num2=0; num2<10;num2++) {
//				for(int num3=0;num3<10;num3++) {
//					for(int num4=0;num4<10;num4++) {
//						
//							try {
//								String password = num1+""+num2+""+num3+""+num4;
//								client.login("java",password);
//								client.download("secret.txt",new File("c:/download/secret.txt"));
//								correct = Integer.parseInt(password);
//								System.out.println("비번:"+correct);
//								System.exit(0);
//								
//								client.disconnect(true);
//							} catch (Exception e) {
//								String password = num1+""+num2+""+num3+""+num4;
//								System.out.println(password+"는 비번이 아님.");
//								
//							}
//						
//					}
//				}
//			}
//		}
		
	}
}
