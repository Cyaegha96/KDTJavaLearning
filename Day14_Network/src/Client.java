import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("10.5.5.5", 7028);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
		
		writer.println("안녕하세요!");
		String response = reader.readLine();

	}
}
