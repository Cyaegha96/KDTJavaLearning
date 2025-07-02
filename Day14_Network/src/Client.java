
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("10.5.5.5", 7028);

		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		
		
		OutputStream os= socket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);
		while(true) {
			String msg = dis.readUTF();
			System.out.println("서버가 보낸 메시지:" +msg );
			
			String message	= JOptionPane.showInputDialog("클라이언트에게 보낼 메시지 입력");


			dos.writeUTF(message);
			dos.flush();
			
		}
		
	}
}
