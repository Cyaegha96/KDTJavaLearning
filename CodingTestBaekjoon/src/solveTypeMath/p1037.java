package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//¾à¼ö
public class p1037 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(bf.readLine());
		
		String line = bf.readLine();
		
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(line);
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		System.out.println(arr[0] * arr[n-1]);
		
		
	}
}
