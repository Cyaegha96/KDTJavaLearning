package exam;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class WriteThread extends Thread{
	private Socket socket;
	private DataOutputStream dos;
	
	public WriteThread (Socket socket, DataOutputStream dos){
		this.socket = socket;
		this.dos = dos;
	}
	
	public void run() {
	
			
			while(true) {
				String message	= JOptionPane.showInputDialog("클라이언트에게 보낼 메시지 입력");


				try {
					dos.writeUTF(message);
					System.out.println("내가 쓴 내용: "+message);
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
			
		
	}

}

