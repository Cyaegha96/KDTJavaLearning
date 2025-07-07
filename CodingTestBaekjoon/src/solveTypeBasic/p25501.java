package solveTypeBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p25501 {
	
	static int count =0;
	public static int recursion(String s, int l, int r) {
		count++;
		if (l >= r)
			return 1;
		else if (s.charAt(l) != s.charAt(r))
			return 0;
		else
			return recursion(s, l + 1, r - 1);
	}

	public static int isPalindrome(String s) {
		return recursion(s, 0, s.length() - 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.out.println("ABBA: " + isPalindrome("ABBA"));
//		System.out.println("ABC: " + isPalindrome("ABC"));
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(bf.readLine());
	
	for(int i=0;i<N;i++) {
		
		String lineString = bf.readLine();
		count =0;
		System.out.println(isPalindrome(lineString) + " " + count);
		
	}
	
	
	}
}