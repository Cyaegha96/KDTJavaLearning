package solveGeomatry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9063 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		int[] arrX = new int[n];
		int[] arrY = new int[n];
		
		int maxX=-10000, maxY=-10000, minX=10000, minY=10000;
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			arrX[i] = Integer.parseInt(st.nextToken());
			arrY[i] = Integer.parseInt(st.nextToken());
			maxX = Math.max(maxX, arrX[i]);
			maxY = Math.max(maxY, arrY[i]);
			minX = Math.min(minX, arrX[i]);
			minY = Math.min(minY, arrY[i]);
		}

		System.out.println((maxX-minX)* (maxY-minY) );
		
		
	}
}
