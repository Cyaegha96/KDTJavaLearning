
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

		Socket socket = new Socket("10.5.5.8", 5000);
//		Socket socket = new Socket("10.5.5.5", 7028);
		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		
		
		OutputStream os= socket.getOutputStream(); //기본 스트림 개설
		DataOutputStream dos = new DataOutputStream(os);
		
			new Thread(()->{
				while(true) {
					String msg="";
					try {
						msg = dis.readUTF();
					} catch (IOException e) {
						System.out.println("dis오류");
						System.exit(0);
					}
					System.out.println("서버가 보낸 메시지:" +msg );
				}
				
				
			}).start();
			
			new Thread(()->{
				while(true) {
					String message	= JOptionPane.showInputDialog("클라이언트에게 보낼 메시지 입력");
					System.out.println("서버에게:"+message);

					try {
						dos.writeUTF(message);
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
			
		}
		
	
}
