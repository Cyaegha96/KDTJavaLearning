package solveTypeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());
		
		String[] firstSets = new String[n];
		String[] secondSets = new String[m];
		
		for(int i=0;i<n+m;i++) {
			if(i <n) {
				firstSets[i] = bf.readLine();
			}else {
				secondSets[i-n] = bf.readLine();
			}
		}
		
		
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(firstSets[i].equals(secondSets[j])) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
