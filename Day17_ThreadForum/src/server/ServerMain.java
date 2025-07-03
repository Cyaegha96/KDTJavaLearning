package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dao.MemberDAO;
import dao.PostDAO;

public class ServerMain {
	
	static MemberDAO memberDAO = new MemberDAO();
	static PostDAO postDAO = new PostDAO();
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(19329);

		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		
		
		while (true) {
			Socket clientSocket = server.accept();
			System.out.println(clientSocket.getInetAddress() + "가 접속");
			new ServerThread(clientSocket).start();
		}
	}
}
