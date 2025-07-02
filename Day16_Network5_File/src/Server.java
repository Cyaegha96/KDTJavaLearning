
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		
	
		
		ServerSocket serverSocket = new ServerSocket(19329);
		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		
		while(true) {
			Socket clientSocket = serverSocket.accept();

			System.out.println(clientSocket.getInetAddress() + "에서 접속했습니다.");
			
			MultiThread thread = new MultiThread(clientSocket);
			new Thread(thread).start();
			
		}
		
	

		
	}
}
