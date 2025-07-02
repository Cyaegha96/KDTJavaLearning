import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {

		
		Scanner scanner = new Scanner(System.in);
		
		Socket socket = new Socket("10.5.5.5", 7028);
		
		OutputStream os= socket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);
		
		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		System.out.println("서버 기다리는 중...");
		while(true) {
			System.out.println("<<이용할 서비스를 선택하세요. >>");
			System.out.println("1. 현재 날짜 및 시간");
			System.out.println("2. 오늘의 운세");
			System.out.println("3. 오늘의 로또 번호 추천");
			System.out.println("4. 사칙연산 계산");
			System.out.println();
			System.out.println(">> :");
			int menu = Integer.parseInt(scanner.nextLine());
			
			switch (menu) {
			case 1:
				
				dos.write(menu);
				dos.flush();
				
				String resultString =dis.readUTF();
				System.out.println(resultString);
				break;
			case 2:
//				int year = Integer.parseInt(scanner.nextLine());
//				dos.write(year);
//				dos.flush();
//				
//				dos.write(menu);
//				dos.flush();
//				            String age = dis.readUTF();
	            
				// 서버한테 메세지 보내기
		         dos.write(menu);
		         dos.flush();

		         // 서버메세지 받을 준비
		         String serverMsg = dis.readUTF();

		         if(serverMsg.equals("1")) {
		            System.out.print("서버 왈 : " + serverMsg);
		            System.out.println("=====================");
		         }else if(serverMsg.equals("2")) {
		            String ageAsk = JOptionPane.showInputDialog("몇년생인가요? : ");
		            dos.writeUTF(ageAsk);
		            dos.flush();

		            String age = dis.readUTF();
		            System.out.println(age);

		            String zodiacSignAsk = JOptionPane.showInputDialog("무슨 띠 인가요? : ");
		            dos.writeUTF(zodiacSignAsk);
		            dos.flush();

		            String zodiacSign = dis.readUTF();
		            System.out.println(zodiacSign);

		            String msg = dis.readUTF();
		            System.out.println(msg);
		           
		         }
		            break;
			case 3:
				dos.write(menu);
		        dos.flush();
		        
		        String msg = dis.readUTF();
	            System.out.println(msg);
	           
	            
				break;
			case 4:
				dos.write(menu);
		        dos.flush();
		        
		        //연산자: 
		        String serverString = dis.readUTF();
		        System.out.print(serverString);
		        dos.writeUTF(scanner.nextLine());
		        dos.flush();
		        //숫자1:
		        serverString = dis.readUTF();
		        System.out.print(serverString);
		        dos.write(Integer.parseInt(scanner.nextLine()));
		        dos.flush();
		        //숫자2:
		        serverString = dis.readUTF();
		        System.out.print(serverString);
		        dos.write(Integer.parseInt(scanner.nextLine()));
		        dos.flush();
		        //결과:
		        serverString = dis.readUTF();
		        System.out.print(serverString);
				
				
			default:
				break;
			}
			
		}
		
		
	
	}
}
