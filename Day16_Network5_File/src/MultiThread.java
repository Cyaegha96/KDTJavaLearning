import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MultiThread implements Runnable {

	private Socket clientSocket;

	public MultiThread(Socket socket) {
		this.clientSocket = socket;
	}

	@Override
	public void run() {
		try (OutputStream os = clientSocket.getOutputStream(); // 기본 스트림 개설
				DataOutputStream dos = new DataOutputStream(os);

				InputStream iStream = clientSocket.getInputStream();
				DataInputStream dis = new DataInputStream(iStream);) {

			String clientsocketString = clientSocket.getLocalAddress() + "";

			String pathString = "C:/25_06_09_KDT/home/";

			File home = new File(pathString);
			File[] files = home.listFiles();

			// 파일 갯수 보내주기
			dos.writeInt(files.length);
			dos.flush();

			for (File file : files) {
				dos.writeUTF(file.getName());
			}
			dos.flush();

			String targetName = dis.readUTF();
			System.out.println(clientSocket.getLocalAddress() + "로 부터 요청:" + targetName);
			// 하드 디스크에 있는 파일을 꺼내서 램으로 가져오는 작업

			FileInputStream fis = new FileInputStream(pathString + targetName);

			// 클라이언트가 다운로드 하고 싶은 파일명을 보내면(targetName)
			// 파일의 경로와 파일 이름을 결합하여
			// 다운로드 받을 파일을 특정하여, FileInputStream을 생성.

			DataInputStream fileDataInputStream = new DataInputStream(fis);
			// FileInputStrema을 업그레이드 하기 위해
			// DataInputStream을 wrap

			byte[] fileContents = fileDataInputStream.readAllBytes();
			// 파일에 개방된 DataStream으로 부터 모든 내용을 byte[] 형태로 로딩

			System.out.println(clientsocketString + "의 요청한 파일 크기: " + fileContents.length);
			dos.writeInt(fileContents.length);
			dos.write(fileContents);
			dos.flush();

		} catch (IOException e) {
			System.out.println("연결오류 발생");
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
