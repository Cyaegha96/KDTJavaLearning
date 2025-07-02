import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		// Socket socket = new Socket("10.5.5.11", 19329);
		// Socket socket = new Socket("10.5.5.0", 40000);
		Socket socket = new Socket("10.5.5.5", 7028);
		InputStream iStream = socket.getInputStream();
		DataInputStream dis = new DataInputStream(iStream);

		OutputStream os = socket.getOutputStream(); // 기본 스트림 개설
		// 기본 스트림은 데이터 통신에 불편함이 많음.
		DataOutputStream dos = new DataOutputStream(os);

		System.out.println("==서버에 접속 완료==");
		int n = dis.readInt();

		System.out.printf("파일의 개수: %d개\n", n);
		System.out.println("===파일 목록===");
		String[] texts = new String[n];

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
		fileDos.close();
	}
}
