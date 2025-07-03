package exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {

	Socket socket = new Socket("10.5.5.9", 10000);
//		Socket socket = new Socket("10.5.5.8", 50000);
//	Socket socket = new Socket("10.5.5.5", 7028);
		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);

		OutputStream os = socket.getOutputStream(); // 기본 스트림 개설
		DataOutputStream dos = new DataOutputStream(os);
		
		new ReadThread(socket, dis).start();
		new WriteThread(socket, dos).start();

	}

}
