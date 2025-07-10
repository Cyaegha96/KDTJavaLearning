package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//SciComLove
public class p31746 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String resultString = "SciComLove";
		
		
		if(n%2 == 0) {
			System.out.println(resultString);
		}else {
			System.out.println(new StringBuilder(resultString).reverse());
		}
		
	}
}
