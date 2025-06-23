import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

class Server{
	//서버 접속을 위한 정보를 담는 클래스 Server
	
	String ipAddressString;
	int portNum;
	String idString;
	String passwordString;
	FTPClient client;
	boolean serverConnect =false;
	boolean serverLogin = false;
	
	
	public void setIpAddress(String ipAddressString) {
		this.ipAddressString = ipAddressString;
	}
	
	public void setPortNum(int portNum) {
		this.portNum = portNum;
	}
	
	public void setIdString(String id) {
		this.idString = id;
	}
	
	public void setPasswordString(String password) {
		this.passwordString = password;
	}
	
	Server(FTPClient client) {
		this.client = client;
	}
	
	public Server(String ipAddressString, int portNum, String idString, String passwordString) {
		super();
		this.ipAddressString = ipAddressString;
		this.portNum = portNum;
		this.idString = idString;
		this.passwordString = passwordString;
	}
	
	
	public void connectingServer(String ipAddressString, int portNum,FTPClient client) {
		
			try {
				client.connect(ipAddressString,portNum);
				client.setPassive(true);
				System.out.println("FTP Server is Connected!");
				this.serverConnect = true;
			} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
				// TODO Auto-generated catch block
				this.serverConnect = false;
				e.printStackTrace();			
			}
			
			return;
		
	}
	
	public void loginToServer(String idString, String passwordString, FTPClient client) {
		

			if(this.serverConnect == false) {
				return;
			}

			try {
				client.login(idString, passwordString);
				System.out.println("Login Success");
				this.serverLogin = true;
				return;

			} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
				System.out.println("로그인 실패!");
				e.printStackTrace();	
			}
		
	}

	void autoConnect(FTPClient client) {

		connectingServer(this.ipAddressString,this.portNum, client);
		loginToServer(this.idString,this.passwordString,client);
	}
}

public class Quiz02 {

	//static으로 선언
	public static Scanner sc = new Scanner(System.in);
	public static FTPClient client = new FTPClient();
	
	public static void uploadFile(FTPClient client) {
		Scanner sc = new Scanner(System.in);
		String folderPath = "C:/upload";

		File folder = new File(folderPath);

		if (folder.exists() && folder.isDirectory()) {
			File[] files = folder.listFiles();
			if (files != null) {
				for (int i=0;i<files.length;i++) {
					System.out.println(files[i].getName());
				}
			} else {
				System.out.println("폴더가 비어있거나 접근할 수 없습니다.");
			}
		}

		System.out.println("업로드할 파일명을 입력하세요");
		System.out.print(">>>");
		String fileNameString = sc.nextLine();


		try {
			client.upload(new File(folderPath+"/"+fileNameString));
			System.out.println("파일업로드 성공!");

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 업로드에 실패했습니다.");
		}
	}

	public static void downloadFile(FTPClient client) {

		try {
			System.out.println("Current Directory : /");
			FTPFile[] list = client.list();
			for(int i=0;i<list.length;i++) {
				System.out.println(list[i].getName()+"\t"+list[i].getSize()+"Byte");
			}

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException | FTPListParseException e) {
			System.out.println("공유 폴더의 파일을 리스트로 불러오는 와중에 에러 발생");
		}

		//파일 다운로드에 필요한 파일 명과 , 파일을 다운받을 경로, 새로운 파일 명을 입력
		System.out.println("다운받을 파일을 입력하세요.");
		System.out.print(">>>");
		String downloadFileName = sc.nextLine();
		System.out.println("다운받을 경로와 새로운 파일명을 입력하세요.");
		System.out.print(">>>");
		String downloadFilePathWithFileName = sc.nextLine();


		try {
			client.download(downloadFileName, new File(downloadFilePathWithFileName));
			System.out.println("Download Complete!");
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException e) {
			System.out.println("파일을 다운 받는 데 실패 했습니다.");
		}
	}

	public static boolean disconnectServer(FTPClient client) {
		try {
			client.disconnect(true);
			System.out.println("===서버 연결이 종료되었습니다.===");
			return false;

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			System.out.println("서버 연결을 끊는 도중에 오류가 발생했습니다.");
			return true;
		}
		
	}

	public static void deleteFile(FTPClient client) {



		try {
			System.out.println("Current Directory : /");
			FTPFile[] list = client.list();
			for(int i=0;i<list.length;i++) {
				System.out.println(list[i].getName()+"\t"+list[i].getSize()+"Byte");
			}

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException | FTPListParseException e) {
			System.out.println("공유 폴더의 파일을 리스트로 불러오는 와중에 에러 발생");
		}

		//파일 다운로드에 필요한 파일 명과 , 파일을 다운받을 경로, 새로운 파일 명을 입력
		System.out.println("삭제할 파일을 입력하세요.");
		System.out.print(">>>");
		String deleteFileName = sc.nextLine();

		try {
			client.deleteFile(deleteFileName);
			System.out.println("Delete Complete!");
		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			System.out.println("파일을 삭제하는데 실패 했습니다.");
		}
	}


	public static void serverLogic(Server server) {
		
		if(server.serverConnect==false) {
			System.out.println("===Connect Failed====");
		}
		if(server.serverLogin == false) {
			System.out.println("===Login Failed====");
			return;
		}
		
		
		while(server.serverLogin & server.serverConnect  ) { //서버 로그인인 상태에만 
			System.out.println("1. Upload File");
			System.out.println("2. Download File");
			System.out.println("3. Delete File");
			System.out.println("4. Disconnect FTP Server");

			int serverSelect = select();
			if(serverSelect == 1) {
				uploadFile(client);

			}else if(serverSelect==2) {

				downloadFile(client);


			}else if(serverSelect == 3) {
				deleteFile(client);

			}

			else if(serverSelect ==4) {
				server.serverLogin =disconnectServer(client);
			}else {
				System.out.println("제대로 된 번호를 선택해 주세요");
			}
		}
	}

	public static int select() {
		//번호 입력 로직
		String errorString = "제대로 된 번호를 입력해주세요.";


		while(true) {
			System.out.print(">>>");
			try {
				return Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorString);
			}
		}
	}
	
	public static String checkIP() {
		
		String str="";
		while(true) {
			System.out.print(">>>");
			str = sc.nextLine();
			if(Pattern.matches("((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])([.](?!$)|$)){4}", str)){ 
				return str;
			}else {
				System.out.println("ip 주소가 아닌 문자열이 들어왔습니다.");
			}
		}

	}

	public static void main(String[] args) {

		while(true) {
			
			System.out.println("===FTP Client Program===");
			System.out.println("1. Connect FTP server");
			System.out.println("2. Connect My FTP server");
			System.out.println("3. Exit Program");

			int select = select(); //메뉴 번호는 select에 저장
			if(select==1) {

				System.out.println("input url");
				String ipAddressString = checkIP();

				System.out.println("input port");

				int port = select();


				System.out.println("Try to connect :"+ipAddressString+"(port : "+port+")");

				Server server = new Server(client);

				server.connectingServer(ipAddressString, port, client);
				
				if(server.serverConnect==true) {
					while(server.serverLogin==false) {
						System.out.print("input id:");
						String idString = sc.nextLine();
						System.out.print("input password: ");
						String passwordString = sc.nextLine();
						server.loginToServer(idString, passwordString,client);
					}
					
				}


				serverLogic(server);


			}else if(select==2) {
			//지정 포트로 자동 접속.


				Server server = new Server("175.124.197.58", 9600, "java", "1234");
				server.autoConnect(client);
				System.out.println("Try to connect :"+server.ipAddressString+"(port : "+server.portNum+")");
				
				serverLogic(server);
				
				
			
		}else if(select ==3) {
			System.out.println("===FTP Client Program을 종료합니다.===");
			
			System.exit(0);
		}
			
	}
}


}