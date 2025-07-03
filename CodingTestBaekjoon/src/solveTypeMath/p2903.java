package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//중앙 이동 알고리즘ㄴ
public class p2903 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 0일때 2의 제곱, 1일때 3의 제곱... 2일때 5의 제곱... 3일때    5일때 33

		int n = Integer.parseInt(bf.readLine());

		System.out.println( ((int)Math.pow(2, n) +1) *(int)(Math.pow(2, n) +1));
		
	}
}
