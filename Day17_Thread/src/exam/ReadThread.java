package exam;

import java.io.DataInputStream;
import java.net.Socket;

public class ReadThread extends Thread {

	private Socket socket;
	private DataInputStream dis;

	public ReadThread(Socket socket, DataInputStream dis) {
		this.socket = socket;
		this.dis = dis;
	}

	public void run() {

		while (true) {
			try {
				String msgString = dis.readUTF();
				System.out.println(socket.getInetAddress()+"에서 보낸 메시지 :" + msgString);

			} catch (Exception e) {
				System.out.println("접속 해제");
				System.exit(0);
			}

		}
	}
}
