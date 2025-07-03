package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
	public static Scanner scanner = new Scanner(System.in);
	public static String userID = "";
	
	public static String menuBeforeLogin() {

		System.out.println("<< 인증시스템 >>");
		System.out.println(" 1. 로그인 ");
		System.out.println(" 2. 회원가입 ");
		System.out.println(" 0. 종료");
		
		System.out.print(">>");
		return scanner.nextLine();

	}
	
	public static String menuAfterLogin() {
		
		System.out.println("<< 온라인 방명록 >>");
		System.out.println(" 1. 방명록 남기기 ");
		System.out.println(" 2. 방명록 보기 ");
		System.out.println(" 3. 방명록 검색 (작성자로 검색)");
		System.out.println(" 4. 방명록 삭제 (글번호로 삭제)");
		
		System.out.print(">>");
		return scanner.nextLine();

	}
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("10.5.5.5", 7028);

		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);


		OutputStream os= socket.getOutputStream(); 
		DataOutputStream dos = new DataOutputStream(os);
		
		
		while (true) {
			
			dos.writeUTF(userID);
			dos.flush();
			
			if(userID.equals("")) {
				
				//로그인 되지 않았을 경우
				String menuSelect= menuBeforeLogin();
				
				dos.writeUTF(menuSelect);
				dos.flush();
				
				if(menuSelect.equals("1")) {
					//로그인
					System.out.print("ID:");
					userID = scanner.nextLine();
					dos.writeUTF(userID);
					dos.flush();
	
					System.out.print("Password:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
					
			
					if(dis.readBoolean() && dis.readBoolean()) {
						String userName = dis.readUTF();
			
						System.out.println("로그인 성공!");
						System.out.println(userName+"님 환영합니다!");
			
						
					}else {
						System.out.println("로그인 실패!");
						userID = "";
					}
				}else if(menuSelect.equals("2")) {
					// 회원가입
					System.out.println("<<회원가입을 진행합니다>>");
					
					System.out.print("ID:");
					dos.writeUTF(scanner.nextLine());
					dos.flush();
					
					// 중복되는 아이디가 없다면
					if(!dis.readBoolean()) {
						System.out.print("Password:");
						dos.writeUTF(scanner.nextLine());
						dos.flush();
						
						
						System.out.println("회원가입 완료");
					}else {
						System.out.println("이미 일치하는 아이디가 있습니다");
					}
				}else if(menuSelect.equals("0")) {
					//시스템 종료

					System.out.println("<< 온라인 방명록 >>을 종료합니다.");
					System.exit(0);
				}else {
					//이상한 입력시 (예외처리)
					System.out.println("정확한 메뉴 번호를 입력해주세요");
				}
			
			
			}else {
				//로그인 상태라면
				String menuSelect=menuAfterLogin();
				
				dos.writeUTF(menuSelect);
				dos.flush();
				
				if(menuSelect.equals("1")) {
					// 1. 방명록 남기기
					System.out.printf("[ %s ]님 방명록에 남기실 글을 작성해주세요", userID);
					System.out.print(">>");
					String postText = scanner.nextLine();
					dos.writeUTF(postText);
					dos.flush();
					
					
				}else if(menuSelect.equals("2")) {
					//2. 방명록 보기
					int postsCount = dis.readInt();
					
					if(postsCount>0) {
						System.out.println("글번호\t글내용\t작성자\t작성시간\t");
						for(int i=0; i<postsCount;i++) {
							String post = dis.readUTF();
							System.out.println(post);
						}
					}else {
						System.out.println("현재 서버에 남아있는 방명록이 없습니다.");
					}
					
				}else if(menuSelect.equals("3")) {
					//3. 방명록 검색 (작성자로 검색)
					
					int postsCount = dis.readInt();
					
					if(postsCount>0) {
						System.out.println("글번호\t글내용\t작성자\t작성시간\t");
						for(int i=0; i<postsCount;i++) {
							String post = dis.readUTF();
							System.out.println(post);
						}
					}else {
						System.out.println("현재 서버에 남아있는 방명록이 없습니다.");
					}
					
					System.out.print("검색할 작성자ID:");
					String searchID = scanner.nextLine();
					
					dos.writeUTF(searchID);
					dos.flush();
					
					postsCount = dis.readInt();
					
					if(postsCount>0) {
						System.out.println("글번호\t글내용\t작성자\t작성시간\t");
						for(int i=0; i<postsCount;i++) {
							String post = dis.readUTF();
							System.out.println(post);
						}
					}else {
						System.out.println("현재 서버에 남아있는"+searchID+"의 방명록이 없습니다.");
					}
					
					
					
				}else if(menuSelect.equals("4")) {
					//4. 방명록 삭제 (글번호로 삭제)
					int postsCount = dis.readInt();
					
					if(postsCount>0) {
						System.out.println("글번호\t글내용\t작성자\t작성시간\t");
						for(int i=0; i<postsCount;i++) {
							String post = dis.readUTF();
							System.out.println(post);
						}
					}else {
						System.out.println("현재 서버에 남아있는 방명록이 없습니다.");
					}
					int deleteId = 0;
					while(true) {
						System.out.print("삭제하고 싶은 글ID:");
						
						try {
							deleteId=Integer.parseInt(scanner.nextLine());
							break;
						} catch (Exception e) {
							System.out.println("숫자로 된 ID를 입력해주세요");
						}

					}
					dos.writeInt(deleteId);
					
					if(dis.readBoolean()) {
						System.out.println("삭제 성공!");
					}else {
						System.out.println("해당하는 id의 글이 없습니다.");
					}
					
					
				}else if(menuSelect.equals("5")) {
					//5. 로그아웃 (id 정보 말소)
					userID = "";
					System.out.println("로그아웃!");
					
				}
				
			}
			
		}
		
	}

}
