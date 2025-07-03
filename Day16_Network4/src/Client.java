import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	static Scanner scanner = new Scanner(System.in);
	static String userName = null;
	
	public static void menu() {

		System.out.println("<< 인증시스템 >>");

		System.out.println(" 1. 로그인 ");
		
		System.out.println(" 2. 회원가입 ");
		System.out.println(" 0. 종료");

	}
	


	public static void main(String[] args) throws UnknownHostException, IOException {

		// 로그인을 선택할 시
		// id와 password를 입력받아
		// 회원여부를 판단한다.

		// 회원가입을 선택할 시,
		// id, password, name 3개의 값을 입력받아 가입시킨다.

		// 회원가입 시점에 password는 sha256 알고리즘으로 암호화시킨다.
		
		
		Socket socket = new Socket("10.5.5.5", 7028);

		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);


		OutputStream os= socket.getOutputStream(); //기본 스트림 개설
		//기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);
		
		Boolean isLogined = false;

		while (true) {
		
			menu();
			
			System.out.print(">>");
			String menuSelect = scanner.nextLine();
			
			dos.writeUTF(menuSelect);
			dos.flush();
			
			switch (menuSelect) {
			
			case "1":
				//로그인
				if(userName == null) {
					System.out.print("ID:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
	
					System.out.print("Password:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
					
			
					if(dis.readBoolean() && dis.readBoolean()) {
						String userName = dis.readUTF();
						System.out.println("로그인 성공!");
						System.out.println(userName+"님 환영합니다!");
						isLogined = true;
						
					}else {
						System.out.println("로그인 실패!");
					}
				}
				
				//다운 받았을 때만
				if(isLogined) {
					
					
					while(true) {
						System.out.println("1. 파일 다운 받기");
						System.out.println("2. 파일 업로드");
						System.out.println("3. 로그아웃");
						
						System.out.print(">>");
						String fileMenuSelect = scanner.nextLine();
						
						dos.writeUTF(fileMenuSelect);
						dos.flush();
						if(fileMenuSelect.equals("1")) {
							//파일 다운로드 로직
							System.out.println("<<파일 목록>>");
							int n = dis.readInt();
							String texts[] = new String[n];
							
							for (int i = 0; i < n; i++) {
								texts[i] = dis.readUTF();
								System.out.println("(" + (i + 1) + ") " + texts[i]);
							}
							Scanner sc = new Scanner(System.in);
							System.out.print("다운 받고 싶은 파일 번호 >> ");

							String filename = texts[Integer.parseInt(sc.nextLine()) - 1];

							// 서버에 다운받고 싶은 파일 이름 보내주기

							dos.writeUTF(filename);
							dos.flush();

							int length = dis.readInt();
							System.out.println("받은 파일의 길이 " + length);

							byte[] fileContent = new byte[length];
							dis.readFully(fileContent);

							// 다운 받을 파일 경로 지정
							String filePath = "C:/download/" + filename;

							FileOutputStream fos = new FileOutputStream(filePath);
							DataOutputStream fileDos = new DataOutputStream(fos);
							fileDos.write(fileContent);
							fileDos.flush();
						
							
							System.out.println("파일 다운로드 완료");
							
						}else if(fileMenuSelect.equals("2")) {
							
							//클라이언트 파일 생성 - >서버 다운로드
							
							String pathString="C:/25_06_09_KDT/home/";
							
							System.out.print("서버에게 보낼 txt파일에 적을 말:");
							String textInput = scanner.nextLine();
							System.out.print("파일명 *뒤에 .txt는 자동으로 붙음: ");
							String fileName = scanner.nextLine()+".txt";
						    FileWriter writer = new FileWriter(pathString +fileName  );
						    writer.write(textInput );
						    writer.flush();
						    
						    
						    dos.writeUTF(fileName);
							
							FileInputStream fis = new FileInputStream(pathString +fileName );
							DataInputStream fileDataInputStream = new DataInputStream(fis);
	
							
							byte[] fileContents = fileDataInputStream.readAllBytes();
							
							//로그
							System.out.println("요청한 파일 크기: "+ fileContents.length);
							dos.writeInt(fileContents.length);
							dos.write(fileContents);
							dos.flush();
							
							
						}else if(fileMenuSelect.equals("3")) {
						
							System.out.println("메인메뉴로 돌아갑니다.");
							isLogined =false;
							break;
							
						}
						
					}

				}
				
				
				break;
			
			case "2":
				//회원가입
				
				System.out.println("<<회원가입을 진행합니다>>");
				
				System.out.print("ID:");
				dos.writeUTF(scanner.nextLine());
				dos.flush();
				
				// 중복되는 아이디가 없다면
				if(!dis.readBoolean()) {
					System.out.print("Password:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
					
					System.out.println("Name:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
					
					System.out.println("회원가입 완료");
				}else {
					System.out.println("이미 일치하는 아이디가 있습니다");
				}


				break;
			case "0":
				System.out.println("인증을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("정확한 메뉴 번호를 입력해주세요");
				break;
			}
			

		}

	}
}
