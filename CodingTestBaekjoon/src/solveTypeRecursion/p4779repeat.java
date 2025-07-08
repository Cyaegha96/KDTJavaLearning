package solveTypeRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Ä­Åä¾î ÁýÇÕ
public class p4779repeat {
	
	public static String cantor(int n) {
		if(n==0) return "-";
		String prev = cantor(n-1);
		String space = " ".repeat(prev.length());
		return prev+space+prev;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		while((st = br.readLine()) != null && !st.isEmpty()) {
			
			int n = Integer.parseInt(st);
			System.out.println(cantor(n));
		
		}
	}
}
