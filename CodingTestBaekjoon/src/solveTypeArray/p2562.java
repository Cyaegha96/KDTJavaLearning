package solveTypeArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ÃÖ´ñ°ª
public class p2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int[10];
		int max= 0;
		int result = 0;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<9;i++) {
			arr[i]= Integer.parseInt(bf.readLine());
			if(max <arr[i]) {
				 max=arr[i];
				 result = i+1;
			}
		}
		System.out.println(max);
		System.out.println(result);
	}
}
