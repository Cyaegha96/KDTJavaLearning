package solveTypeRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//칸토어 집합 // 문제 접근은 좋았지만 시간초과
public class p4779array {
	
	//여기서는 문제를 나눕니다. divde를 하는 과정이죠.
	public static void divideCantor(boolean[] arr,int start, int end ) {
		if(start <end) {
			int mid1 = (end-start)/3+start;
			int mid2 = (end-start) *2 /3+start;
			if(mid1==start) {
				mid1 = mid2 = (start+end)/2;
			}
			//System.out.printf("start값: %d mid1값: %d mid2값: %d end값: %d\n",start, mid1, mid2, end);
			if(mid1+1 <mid2 && mid2+1 < end) {
				divideCantor(arr, start, mid1);
				divideCantor(arr, mid1+1, mid2);
				divideCantor(arr, mid2+1, end);
				
			}
			mergeCantor(arr, start, mid1, mid2, end);
			
		}
	}
	
	public static void mergeCantor(boolean[] arr,int start,int mid1, int mid2, int end) {
		
		if(mid1 == mid2) {
			arr[mid1] = false;
			
		}else {
			for(int i=mid1+1; i<=mid2;i++) {
				arr[i] = false;
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st;
		while((st = br.readLine()) != null && !st.isEmpty()) {
			
			int n = Integer.parseInt(st);
			int target = (int) Math.pow(3, n);
			boolean[] arr = new boolean[target];
			Arrays.fill(arr, true);
			divideCantor(arr, 0, target-1);
			for(int i=0;i<target;i++) {
				if(arr[i]) {
					System.out.print("-");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
