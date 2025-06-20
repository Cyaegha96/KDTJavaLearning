import java.io.File;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

class AutoServer {

	String ipString;
	int portNum;
	String idString;
	String passwordString;

	public AutoServer(String ipString, int portNum, String idString, String passwordString) {
		super();
		this.ipString = ipString;
		this.portNum = portNum;
		this.idString = idString;
		this.passwordString = passwordString;
	}


}

public class Quiz_ex {

	public static FTPClient serverAutoLogin(AutoServer autoServer) {


		System.out.println();

		FTPClient client = new FTPClient();
		connectingServer(autoServer.ipString, client);
		try {
			client.login(autoServer.idString, autoServer.passwordString);
			System.out.println("Login Success");


		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			System.out.println("로그인 실패! 아이디나 비밀번호를 확인해주세요!");

		}


		return client;
	}

	public static void connectingServer(String ipAddressString,FTPClient client) {
		while(true) {
			try {
				client.connect(ipAddressString);
				System.out.println("FTP Server is Connected!");
				return;
			} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
				System.out.println("서버 연결 실패!");
			}
		}
	}

	public static void loginToServer(FTPClient client) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("input id:");
			String idString = sc.nextLine();
			System.out.print("input password: ");
			String passwordString = sc.nextLine();

			try {
				client.login(idString, passwordString);
				System.out.println("Login Success");
				return;

			} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
				System.out.println("로그인 실패! 아이디나 비밀번호를 확인해주세요!");

			}
		}
	}



	public static void uploadFile(FTPClient client) {
		Scanner sc = new Scanner(System.in);

		System.out.println("업로드할 파일명을 입력하세요");
		System.out.print(">>>");
		String fileNameString = sc.nextLine();

		try {
			client.upload(new File(fileNameString));

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException
				| FTPDataTransferException | FTPAbortedException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 업로드에 실패했습니다.");
		}
	}

	public static void downloadFile(FTPClient client) {

		Scanner sc = new Scanner(System.in);

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

	public static boolean disconnectServer(FTPClient client,boolean serverLogin) {
		try {
			client.disconnect(true);
			System.out.println("===서버 연결이 종료되었습니다.===");
			serverLogin = false;

		} catch (IllegalStateException | IOException | FTPIllegalReplyException | FTPException e) {
			System.out.println("서버 연결을 끊는 도중에 오류가 발생했습니다.");

		}
		return serverLogin;
	}

	public static void deleteFile(FTPClient client) {

		Scanner sc = new Scanner(System.in);

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



	public static int select() {
		//번호 입력 로직
		String errorString = "제대로 된 번호를 입력해주세요.";
		Scanner sc = new Scanner(System.in);

		while(true) {
			try {
				return Integer.parseInt(sc.nextLine());

			} catch (Exception e) {
				System.out.println(errorString);
			}
		}
	}


	public static void main(String[] args) {
		//Brute Forcer
		//무차별 대입공격

		Scanner sc = new Scanner(System.in);
		String errorString = "제대로 된 번호를 입력해주세요.";
		boolean serverLogin = false;

		while(true) {
			System.out.println("===FTP Client Program===");
			System.out.println("1. Connect FTP server");
			System.out.println("2. Exit Program");
			System.out.println("3. AutoServerLogin");
			System.out.print(">>>");

			int select = select(); //메뉴 번호는 select에 저장
			if(select==1) {

				System.out.println("input url");
				System.out.print(">>>");
				String ipAddressString = sc.nextLine();

				System.out.println("input port");
				System.out.print(">>>");

				int port = select();

				if(port == 21) { //포트 번호가 21일 때만 허용
					System.out.println("Try to connect :"+ipAddressString+"(port : "+port+")");


					FTPClient client = new FTPClient();

					connectingServer(ipAddressString,client);


					loginToServer(client);
					serverLogin = true;

					while(serverLogin ) { //서버 로그인인 상태에만 
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
							serverLogin =disconnectServer(client,serverLogin);
						}else {
							System.out.println("제대로 된 번호를 선택해 주세요");
						}
					}


				}else {
					System.out.println("다른 포트 번호를 선택해주세요");
				}	

			}else if(select ==2) {
				System.out.println("===FTP Client Program을 종료합니다.===");
				System.exit(0);
			}else if(select ==3){
				AutoServer autoServer = new AutoServer("10.5.5.10", 21, "java", "52525");
				FTPClient client = serverAutoLogin(autoServer);
				serverLogin = true;
				while(serverLogin ) { //서버 로그인인 상태에만 
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
						serverLogin =disconnectServer(client,serverLogin);
					}else {
						System.out.println("제대로 된 번호를 선택해 주세요");
					}
				}
				
			}
			System.out.println(errorString);
		}
	}


}
