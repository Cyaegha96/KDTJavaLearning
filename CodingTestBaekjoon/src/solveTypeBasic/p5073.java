package solveTypeBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5073 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		while(true) {
			String lineString = bf.readLine();
			StringTokenizer st = new StringTokenizer(lineString);
			int sum = 0;
			for(int i=0;i<3;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			if(sum == 0) {
				break;
			}
			if(arr[0] == arr[1] && arr[1] == arr[2] && arr[0] ==arr[2]) {
				System.out.println("Equilateral");
			}else if((arr[0] == arr[1])&&(arr[1] != arr[2]) || (arr[1] == arr[2])&& (arr[2] != arr[0]) || (arr[0] ==arr[2])&&(arr[0] != arr[1])) {
				System.out.println("Isosceles");
			}else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] !=arr[2]) {
				System.out.println("Scalene");
			}else {
				System.out.println("Invalid");
			}
			
			
		}
		
	}
}
