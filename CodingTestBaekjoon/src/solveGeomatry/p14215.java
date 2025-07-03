package solveGeomatry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14215 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		String lineString = bf.readLine();
		StringTokenizer st = new StringTokenizer(lineString);
		for(int i=0;i<3;i++) {
			arr[i]= Integer.parseInt(st.nextToken());

		}
		int result = 0;
		
		for(int a=1;a<=arr[0];a++) {
			for(int b=1;b<=arr[1];b++) {
				for(int c=1;c<=arr[2];c++) {
					if(a+b>c && b+c >a && a+c>b) {
						result = Math.max(result, a+b+c);
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
