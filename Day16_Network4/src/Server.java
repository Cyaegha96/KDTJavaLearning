
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import dao.MembersDAO;
import dto.MemberDTO;

public class Server {

	static MembersDAO dao = new MembersDAO();

	public static String encrypt(String text) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
			byte[] digest = md.digest(bytes);

			StringBuilder builder = new StringBuilder();
			for (byte b : digest) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("SHA-256 암호화 실패", e);
		}
	}

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = new ServerSocket(19329);
		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket.getInetAddress() + "에서 접속했습니다.");

		OutputStream os = clientSocket.getOutputStream(); // 기본 스트림 개설
		DataOutputStream dos = new DataOutputStream(os);

		InputStream iStream = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);

		String idBuffer = "";
		String nameBuffer = "";
		String passwordBuffer = "";

		while (true) {
			String menu = dis.readUTF();
			switch (menu) {
			case "1":
				// 로그인
				idBuffer = dis.readUTF();
				passwordBuffer = encrypt(dis.readUTF());

				// 로그
				System.out.println("==로그인 로그==");
				System.out.println(idBuffer);
				System.out.println(passwordBuffer);

				MemberDTO member = dao.searchById(idBuffer);
				if (member != null) {
					//id check
					dos.writeBoolean(true);
					dos.flush();
					
					if(dao.correctPassword(member, passwordBuffer)){
					// 비밀번호도 맞고, 멤버도 있는 경우에만

					System.out.println("==로그인 성공==");
					dos.writeBoolean(true);
					dos.flush();

					dos.writeUTF(member.getName());
					dos.flush();
					
					System.out.println("===로그인 이후 로직====");
					
					while(true) {
						String loginMenu = dis.readUTF();
						if(loginMenu.equals("1")) {
							
							String pathString ="C:/25_06_09_KDT/home/";
							
							File home = new File(pathString);
							File[] files = home.listFiles();
							
							//파일 갯수 보내주기
							dos.writeInt(files.length);
							dos.flush();
							
							for(File file: files) {
								dos.writeUTF(file.getName());
							}
							dos.flush();
							
							String targetName = dis.readUTF();
							System.out.println(clientSocket.getLocalAddress()+"로 부터 요청:"+targetName);
							//하드 디스크에 있는 파일을 꺼내서 램으로 가져오는 작업
						
							FileInputStream fis = new FileInputStream(pathString+targetName);
							DataInputStream fileDataInputStream = new DataInputStream(fis);
	
							
							byte[] fileContents = fileDataInputStream.readAllBytes();
							
							//로그
							System.out.println("요청한 파일 크기: "+ fileContents.length);
							dos.writeInt(fileContents.length);
							dos.write(fileContents);
							dos.flush();
							
						}else if(loginMenu.equals("2")) {
							
							//클라이언트 파일 생성 -> 서버 쪽 다운로드
							
							//파일명 받기
							String filename = dis.readUTF();
							

							int length = dis.readInt();
							System.out.println("받은 파일의 길이 " + length);

							byte[] fileContent = new byte[length];
							dis.read(fileContent);

							// 다운 받을 파일 경로 지정
							String filePath = "C:/download/" + filename;
							System.out.println(filePath);
							FileOutputStream fos = new FileOutputStream(filePath);
							DataOutputStream fileDos = new DataOutputStream(fos);
							fileDos.write(fileContent);
							fileDos.flush();
							
							System.out.println("클라이언트로부터 파일이 전송되었습니다. ");
							
						
						}
						else if(loginMenu.equals("3")) {
							//로그
							System.out.println("로그아웃");
							break;
						}
					}
					

					}else {
						dos.writeBoolean(false);
						dos.flush();
					}
				}else { // 로그: 그외의 경우(인증 실패)
					System.out.println("==로그인 실패==");
					dos.writeBoolean(false);
					dos.flush();
				}

				break;
			case "2":
				// 회원가입
				idBuffer = dis.readUTF();
				boolean idCheck;
				if(dao.searchById(idBuffer) == null) {
					idCheck= false;
				}
				else{
					idCheck =true;
				}
				dos.writeBoolean(idCheck);
				dos.flush();
				
				if(!idCheck) {
					passwordBuffer = encrypt(dis.readUTF());
					nameBuffer = dis.readUTF();

					dao.addMembers(idBuffer, passwordBuffer, nameBuffer);
				}

				
				//로그
				System.out.printf("%s %s %s\n", idBuffer, passwordBuffer, nameBuffer);
				System.out.println("==회원 가입 성공==");

			default:

			}

		}

	}
}
