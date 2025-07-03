package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ClientThread extends Thread {

	private Socket socket;

	public ClientThread(Socket clientSocket) {
		this.socket = clientSocket;
	}

	@Override
	public void run() {
		try {
			InputStream iStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(iStream);

			OutputStream os = socket.getOutputStream(); // 기본 스트림 개설
			DataOutputStream dos = new DataOutputStream(os);

			new ReadThread(socket, dis).start();
			new WriteThread(socket, dos).start();

		} catch (Exception e) {
			System.out.println();
		}
	}
}

public class MainServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(19329);

		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		while (true) {
			Socket clientSocket = server.accept();
			System.out.println(clientSocket.getInetAddress() + "가 접속");
			new ClientThread(clientSocket).start();
		}
	}

}
