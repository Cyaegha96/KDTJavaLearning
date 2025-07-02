import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	static Scanner scanner =  new Scanner(System.in);

	public static int printContact(DataInputStream dis ) throws IOException {
		int size = dis.read();
		if(size == 0) {
			System.out.println("해당하는 연락처가 존재하지 않습니다");
		}else {

			System.out.println("id\t이름\t연락처\t");
			for(int i=0;i<size;i++) {
				String resultString = dis.readUTF();
				System.out.println(resultString);
			}
		}
		return size;
	}

	public static void menu() {
		System.out.println("<<연락처 관리 시스템>>");
		System.out.println("1. 연락처 등록");
		System.out.println("2. 연락처 목록");
		System.out.println("3. 연락처 검색");
		System.out.println("4. 연락처 수정");
		System.out.println("5. 연락처 삭제");
	}

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("10.5.5.5", 7028);

		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);


		OutputStream os= socket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);


		while(true) {
			menu();

			//메뉴 입력 받기
			System.out.print(">>");
			String menu = scanner.nextLine();

			dos.writeUTF(menu);
			dos.flush();

			if(menu.equals("1")) {
				//연락처 등록

				System.out.print("이름:");
				dos.writeUTF(scanner.nextLine());
				dos.flush();

				System.out.print("연락처:");
				dos.writeUTF(scanner.nextLine());
				dos.flush();
			}else if(menu.equals("2")) {
				//연락처 목록

				//목록 출력
				printContact(dis);

			}else if(menu.equals("3")) {

				int size = printContact(dis);
				
				if(size != 0) {

					//연락처 검색
					System.out.print("이름:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();

					size = printContact(dis);

				}


			}else if(menu.equals("4")) {
				//연락처 목록 수정
				int size = printContact(dis);
				
				if(size != 0) {
					
					System.out.print("수정할 id:");
					dos.writeInt(Integer.parseInt(scanner.nextLine()));
					dos.flush();
					
					if(dis.readBoolean()) {
						
						System.out.print("이름:");
						dos.writeUTF(scanner.nextLine());
						dos.flush();

						System.out.print("연락처:");
						dos.writeUTF(scanner.nextLine());
						dos.flush();
						
						System.out.println("수정 성공!");
					}
					
					
				}

			}else if(menu.equals("5")){
				//연락처 목록 삭제
				int size = printContact(dis);
				
				if(size != 0) {
					
					System.out.print("삭제할 id:");
					dos.writeInt(Integer.parseInt(scanner.nextLine()));
					dos.flush();
					
					if(dis.readBoolean()) {
						System.out.println("삭제 성공!");
					}
				}

			}else {

				System.out.println("메뉴 번호를 제대로 입력해주세요");
			}


		}
	}
}
