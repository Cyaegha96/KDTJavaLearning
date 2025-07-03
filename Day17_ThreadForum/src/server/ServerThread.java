package server;

import util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;


import dao.MemberDAO;
import dao.PostDAO;
import dto.MemberDTO;
import dto.PostDTO;

public class ServerThread extends Thread {
	
	MemberDAO memberDAO = ServerMain.memberDAO;
	PostDAO postDAO = ServerMain.postDAO;
	
	
	Socket socket;
	
	public ServerThread(Socket clientSocket) {
		this.socket = clientSocket;
	}
	
	
	@Override
	public void run() {
		
		
		//접속한 클라이언트 마다 해당 내용이 실행됨
		try {
			InputStream iStream = socket.getInputStream();
			DataInputStream dis = new DataInputStream(iStream);

			OutputStream os = socket.getOutputStream(); // 기본 스트림 개설
			DataOutputStream dos = new DataOutputStream(os);
			
			String idBuffer = "";

			String passwordBuffer = "";
			
			
			String loginedClient = "";
			
			while(true) {
				
				loginedClient = dis.readUTF();
				String menuSelect = dis.readUTF();
				System.out.println(loginedClient + "가 "+menuSelect+"번 메뉴를 누름");
				
				if(loginedClient.equals("")) {
					System.out.println("로그인 클라이언트가 빈문자열임" );
					
					switch (menuSelect) {
					case "1":
						// 로그인
						idBuffer = dis.readUTF();
						passwordBuffer = Util.encrypt(dis.readUTF());

						// 로그
						System.out.println("==로그인 로그==");
						System.out.println(idBuffer);
						System.out.println(passwordBuffer);
						
						MemberDTO member = memberDAO.searchById(idBuffer);
						if (member != null) {
							//id check
							dos.writeBoolean(true);
							dos.flush();
							
							if(memberDAO.correctPassword(member, passwordBuffer)){
							// 비밀번호도 맞고, 멤버도 있는 경우에만

								System.out.println("==로그인 성공==");
								dos.writeBoolean(true);
								dos.flush();
	
								dos.writeUTF(member.getId());
								dos.flush();
								
								loginedClient=idBuffer;
								System.out.println("서버에 남은 로그인 된 아이디:"+loginedClient);
								
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
						boolean idCheck=false;
						do {
							idBuffer = dis.readUTF();
							
							if(memberDAO.searchById(idBuffer) == null) {
								idCheck= false;
							}
							else{
								idCheck =true;
								
							}
							dos.writeBoolean(idCheck);
							dos.flush();
						
							
							if(!idCheck) {
								passwordBuffer = Util.encrypt(dis.readUTF());
					

								memberDAO.addMembers(idBuffer, passwordBuffer);
								break;
							}
						} while(idCheck);

						
						//로그
						System.out.printf("%s %s\n", idBuffer, passwordBuffer);
						System.out.println("==회원 가입 성공==");
					break;
					case "0":
						System.out.println(socket.getInetAddress()+"님이 종료하셨습니다.");
						return;
					}
					
					
				}else {
					//클라이언트가 로그인 한 상태라면
					System.out.println("로그인 클라이언트가 빈문자열이 아님" );
					
					switch (menuSelect) {
					case "1": 
						//방명록 남기기.
						String postText = dis.readUTF();
						
						postDAO.addPost(postText,loginedClient, System.currentTimeMillis());
						break;
						
						
					case "2":
						//방명록 보기
						
						//서버로그
						System.out.println(loginedClient+"가 방명록 봄");
						
						dos.writeInt(postDAO.getPostsCount());
						dos.flush();
						
						List<PostDTO> posts = postDAO.getPosts();

						if(postDAO.getPostsCount() >0) {
						
							
							
							for(int i=0;i<posts.size();i++) {
								
								PostDTO post = posts.get(i);
								
								String postBuffer = post.getPostId()+"\t"
													+post.getPost()+"\t"
													+post.getAuthorId()+"\t"
													+Util.timeStampFormatString(post.getTimestamp());
													
								
								dos.writeUTF(postBuffer);
							}
							dos.flush();
						}
						
						break;
					case "3":
						//방명록 검색
						
						dos.writeInt(postDAO.getPostsCount());
						dos.flush();
						
						posts = postDAO.getPosts();

						if(postDAO.getPostsCount() >0) {
						
							
							
							for(int i=0;i<posts.size();i++) {
								
								PostDTO post = posts.get(i);
								
								String postBuffer = post.getPostId()+"\t"
													+post.getPost()+"\t"
													+post.getAuthorId()+"\t"
													+Util.timeStampFormatString(post.getTimestamp());
													
								
								dos.writeUTF(postBuffer);
							}
							dos.flush();
						}
						
						String searchId =  dis.readUTF();
						//서버로그
						System.out.println(loginedClient+"가 방명록 검색함");
						
						
						System.out.println(searchId+"문자열 가진 Id 검색중...");
						List<PostDTO> searchPosts = postDAO.searchByAuthorID(searchId);
						
						System.out.println("검색완료");
						
						dos.writeInt(searchPosts.size());
						dos.flush();

						if(searchPosts.size()>0) {

							for(int i=0;i<searchPosts.size();i++) {
								
								PostDTO post = searchPosts.get(i);
								
								String postBuffer = post.getPostId()+"\t"
										+post.getPost()+"\t"
										+post.getAuthorId()+"\t"
										+Util.timeStampFormatString(post.getTimestamp());
										
								dos.writeUTF(postBuffer);
							}
							dos.flush();
						}
						
						
						break;
					case "4":
						//방명록 삭제
						System.out.println(loginedClient+"가 방명록 삭제할라캄");
						
						dos.writeInt(postDAO.getPostsCount());
						dos.flush();
						
						posts = postDAO.getPosts();

						if(postDAO.getPostsCount() >0) {
				
							
							for(int i=0;i<posts.size();i++) {
								
								PostDTO post = posts.get(i);
								
								String postBuffer = post.getPostId()+"\t"
													+post.getPost()+"\t"
													+post.getAuthorId()+"\t"
													+Util.timeStampFormatString(post.getTimestamp());
													
								
								dos.writeUTF(postBuffer);
							}
							dos.flush();
						}
						
						int deleteID = dis.readInt();
						boolean hasID = postDAO.searchById(deleteID);
						dos.writeBoolean(hasID);
						
						if(hasID) {
							postDAO.deleteByPostID(deleteID);
						}

						break;

					}
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println("접속 오류");
			System.err.println(e.getMessage());

		}
	
	}
}
