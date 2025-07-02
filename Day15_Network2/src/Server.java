import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(19329);
		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket.getInetAddress()+"에서 접속했습니다.");

		OutputStream os= clientSocket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);
		
		InputStream iStream = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);
		
		
		while(true) {
			
			int menu = dis.read();
			
			long date = System.currentTimeMillis(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss 맞나...?");
			String resultString = sdf.format(date);
			
			try {
				switch (menu) {
				case 1:
					
					String message	= resultString;

					dos.writeUTF(message);
					dos.flush();
					break;
				case 2: //오늘의 운세
					
					message	= "99년생 토끼띠 오늘의 운세는 전반적으로 좋은 흐름을 예상할 수 있습니다. \n"
								+ "특히, 직업/학업 분야에서 긍정적인 변화와 성과를 기대할 수 있습니다. \n"
								+ "다만, 타인과의 관계에서 신중하고 배려하는 자세가 필요하며, \n"
								+ "섣부른 결정보다는 신중하게 상황을 판단하는 것이 중요합니다. \n";


					dos.writeUTF(message);
					dos.flush();
					
					break;
				case 3: //오늘의 로또 번호 추천!
					int[] lottery = new int[45];
			
					for(int i=0;i<45;i++) {
						lottery[i] = i+1;
					}
					for(int i=0;i<456;i++) {
						int a = (int)(Math.random()*45);
						int b = (int)(Math.random()*45);

						int temp = lottery[a];
						lottery[a] = lottery[b];
						lottery[b] = temp;
					}
					
					sdf = new SimpleDateFormat("MM월 dd일");
					resultString = sdf.format(date);
					String lotto = resultString + "의 추천로또 번호는 \n";
					
					for(int i=0;i<6;i++) {
						lotto = lotto+ "("+lottery[i] + ") ";
					}
					lotto += "|| 보너스 번호는 " + lottery[6] + " || \n";
					dos.writeUTF(lotto);
					dos.flush();
					break;
				case 4: //사칙 연산 계산
					
					dos.writeUTF("연산자: ");
					dos.flush();
					char inputOperator =  dis.readUTF().charAt(0);
					
					dos.writeUTF("숫자1: ");
					dos.flush();
					int inputNum1 = dis.read();
					
					dos.writeUTF("숫자2: ");
					dos.flush();
					int inputNum2 = dis.read();
					int result=0;
					switch (inputOperator) {
					case '+':
						result = inputNum1+inputNum2;
						break;
					case '-':
						result = inputNum1-inputNum2;
						break;
					case '*':
						result = inputNum1 * inputNum2;
						break;
					case '/':
						result= inputNum1 / inputNum2;
						break;
					}
					dos.writeUTF(inputNum1+" "+ inputOperator+" "+ inputNum2 + "의 정답은: "+result);
					dos.flush();
					
					
					
					dos.write(inputNum2);
					
					
				default:
					message ="머야 메뉴값으로 멀보낸거야;;";
					dos.writeUTF(message);
					dos.flush();
					break;
				}
			} catch (Exception e) {
				System.out.println("클라이언트가 보낸 메시지가 적합한 메뉴 값이 아닙니다.");
				String message ="머야 메뉴값으로 멀보낸거야";
				dos.writeUTF(message);
				dos.flush();
			}
			
		}
	}
}
