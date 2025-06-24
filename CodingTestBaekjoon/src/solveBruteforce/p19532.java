package solveBruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수학은 비대면 강의입니다.
public class p19532 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(stringTokenizer.nextToken());
		int b = Integer.parseInt(stringTokenizer.nextToken());
		int c = Integer.parseInt(stringTokenizer.nextToken());
		int d = Integer.parseInt(stringTokenizer.nextToken());
		int e = Integer.parseInt(stringTokenizer.nextToken());
		int f = Integer.parseInt(stringTokenizer.nextToken());
		
		
		for(int n = -999;n <=999;n++) {
			for(int m= -999;m<=999;m++) {
				if(a*n + b*m == c && d*n + e*m ==f) {
					System.out.println(n+" "+m);
					System.exit(0);
				}
			}
		}
		
	}

}
