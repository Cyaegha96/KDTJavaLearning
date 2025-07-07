package solveTypeMath;

import java.util.Arrays;
import java.util.Scanner;

//°¡·Î¼ö
public class p2485 {
	
	public static long gcb(long a, long b) {
		if(b == 0) {
			return a;
		}
		return gcb(b, a%b);
	}
	
	
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		
		long[] arr = new long[n];
		long[] arr2 = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(scanner.nextLine());
			if(i>0) {
				arr2[i] = arr[i] - arr[i-1];
			}
		}

		
		long result = arr2[1];
		
		for(int i=2;i<n;i++) {
			result = gcb( arr2[i],result);
		}
	
		long result2 = 0l;
		for(int i=1;i<n;i++) {
			result2 += (arr2[i]/result-1);
		}
		System.out.println(result2);
		

	}
}
