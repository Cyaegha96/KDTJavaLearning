package solveTypeString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//»ó¼ö
public class p2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sf = new StringTokenizer(bf.readLine());
		int s1 = Integer.parseInt(new StringBuffer(sf.nextToken()).reverse().toString());
		int s2 = Integer.parseInt(new StringBuffer(sf.nextToken()).reverse().toString());
		System.out.println(Math.max(s1, s2));
	
	}
}
