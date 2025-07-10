package solveTypeBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1330 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(line);
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());
		if(n>m) { System.out.println(">"); }
		else if(n < m) {System.out.println("<");}
		else {System.out.println("==");}
				
	}
}
