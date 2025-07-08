package solveTypeTimeComplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알고리즘 수업 - 점근적 표기 1
public class p24313 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		
		int c = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		boolean result=true;
		while(n <=100)
		{
			result = a1 * n + a2 <= c * n;
			if(!result) {
				break;
			}
			n++;
		}
		if(result) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
}
