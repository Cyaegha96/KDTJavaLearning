
import java.io.DataOutputStream;
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
				try {
				String message	= JOptionPane.showInputDialog("클라이언트에게 보낼 메시지 입력");
				System.out.println("내가 입력한 메시지:"+message);
				
				dos.writeUTF(message);
				dos.flush();
				}catch (Exception e) {
					System.out.println("접속 해제");
					System.exit(0);
				}
			
			}
			
		
	}

}

