package solveTypeBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p10101 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[3];
		
		for(int i=0;i<3;i++) {
			arr[i]= Integer.parseInt(bf.readLine());
		}
		
		if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == 60) {
			System.out.println("Equilateral");
		}else if((arr[0]+arr[1]+arr[2])==180) {
		
			if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
				System.out.println("Scalene");
			}else {
				System.out.println("Isosceles");
			}
			
		}else{
			System.out.println("Error");
		}
		
	}
}
