import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import dao.ContactDAO;
import dto.ContactDTO;

public class Server {
	
	public static void printServerSide(DataOutputStream dos,ContactDAO dao) throws IOException {
		dos.write(dao.Size());
		dos.flush();
		
		for(ContactDTO dto: dao.getContactLists()) {
			dos.writeUTF(dto.getId()+"\t"+dto.getName()+"\t"+dto.getPhone());
			
		}
		dos.flush();
	}
	
	public static void main(String[] args) throws IOException {
		
		
	
		
		
		
		ContactDAO dao = new ContactDAO();

		ServerSocket serverSocket = new ServerSocket(19329);
		System.out.println("클라이언트 연결을 기다리는 중입니다..");
		Socket clientSocket = serverSocket.accept();

		System.out.println(clientSocket.getInetAddress() + "에서 접속했습니다.");

		OutputStream os = clientSocket.getOutputStream(); // 기본 스트림 개설
		DataOutputStream dos = new DataOutputStream(os);

		InputStream iStream = clientSocket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);

		String nameBuffer = "";
		String phoneNumberBuffer = "";

		while (true) {

			String menu = dis.readUTF();
			if (menu.equals("1")) {
				// 연락처 등록

				nameBuffer = dis.readUTF();
				phoneNumberBuffer = dis.readUTF();
				
				dao.addContact(nameBuffer, phoneNumberBuffer);
			
				//로그
				ContactDTO dto =dao.getContactLists().get(dao.Size()-1);
				System.out.printf("입력 받은 데이터 %d %s %s \n",dto.getId(),dto.getName(),dto.getPhone());
					

			} else if (menu.equals("2")) {
				// 연락처 목록
				
				dos.write(dao.Size());
				dos.flush();
				
				for(ContactDTO dto: dao.getContactLists()) {
					dos.writeUTF(dto.getId()+"\t"+dto.getName()+"\t"+dto.getPhone());
					
				}
				dos.flush();
				

			} else if(menu.equals("3")) {
				//검색목록 출력
				
				printServerSide(dos,dao);
				
				String targetName = dis.readUTF();
				
				List<ContactDTO> resultDto= dao.searchByName(targetName);
				dos.write(resultDto.size());
				dos.flush();
				
				for(ContactDTO dto: resultDto) {
					dos.writeUTF(dto.getId()+"\t"+dto.getName()+"\t"+dto.getPhone());
					
				}
				dos.flush();
				
			}else if(menu.equals("4")) {
				//연락처 수정
				printServerSide(dos,dao);
				
				int targetId = dis.readInt();
				System.out.println("입력받은 targetId:"+targetId);
				//targetId가 있다면
				System.out.println("targetId 유무:"+dao.hasId(targetId));
				
				if(dao.hasId(targetId)) {
					
					
					//클라이언트 쪽에서 boolean 값 받아서 검사
					dos.writeBoolean(true);
					dos.flush();
					
					nameBuffer = dis.readUTF();
					phoneNumberBuffer = dis.readUTF();
					
					dao.updateContact(targetId, nameBuffer, phoneNumberBuffer);
					
				}else if(!dao.hasId(targetId)){
					dos.writeBoolean(false);
					dos.flush();
				}
				
				
				
			}else if(menu.equals("5")) {
				//연락처 삭제
				printServerSide(dos,dao);
				
				int targetId = dis.readInt();
				
				
				//targetId가 있다면
				if(dao.hasId(targetId)) {
					//클라이언트 쪽으로 boolean 값 받아서 검사
					dos.writeBoolean(true);
					dos.flush();
					
					dao.removeContact(targetId);
				}else {
					dos.writeBoolean(false);
					dos.flush();
				}

			}

		}

	}
}
