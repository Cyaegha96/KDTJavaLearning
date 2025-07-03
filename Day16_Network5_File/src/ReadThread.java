import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread{
	
	private Socket socket;
	private DataInputStream dis;
	
	public ReadThread(Socket socket, DataInputStream dis){
		this.socket = socket;
		this.dis = dis;
	}
	
	public void run() {
		while(true) {
			String clientMsgString = ""+socket.getInetAddress();
			try {
				clientMsgString = dis.readUTF();
			} catch (IOException e) {
				System.out.println("dis오류");
				System.exit(0);
			}
			System.out.println("클라이언트 메시지: "+clientMsgString);
		}
	}

}
