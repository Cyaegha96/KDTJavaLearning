package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Mathematics
public class p26545 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0;i<n;i++) {
			result += Integer.parseInt(br.readLine());
		}
		System.out.println(result);
	}
}
