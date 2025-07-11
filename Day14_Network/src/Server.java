import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;



public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(19329);
		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket.getInetAddress()+"에서 접속했습니다.");

		OutputStream os= clientSocket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);
				InputStream iStream = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		
		
	
			
			new Thread(()->{
				while(true) {
					String message	= JOptionPane.showInputDialog("클라이언트에게 보낼 메시지 입력");


					try {
						dos.writeUTF(message);
						System.out.println("서버에게: "+message);
					} catch (IOException e) {
						System.out.println("dos오류");
						System.exit(0);
					}
					try {
						dos.flush();
					} catch (IOException e) {
						System.out.println("dos오류");
						System.exit(0);
					}
				}
			}).start();

			
			new Thread(()->{
				while(true) {
					String clientMsgString = ""+clientSocket.getInetAddress();
					try {
						clientMsgString = dis.readUTF();
					} catch (IOException e) {
						System.out.println("dis오류");
						System.exit(0);
					}
					System.out.println("클라이언트 메시지: "+clientMsgString);
				}
			}).start();
			
			
		

	}
}
