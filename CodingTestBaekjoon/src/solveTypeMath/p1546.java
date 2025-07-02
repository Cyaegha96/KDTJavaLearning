package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//ЦђБе
public class p1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(	bf.readLine());
		
		StringTokenizer sf = new StringTokenizer(bf.readLine());
		int[] arr = new int[n];
		double[] arr2 = new double[n];
		int max= 0;
		for(int i=0;i<n;i++) {
			arr[i]= Integer.parseInt(sf.nextToken());
			max = Math.max(max, arr[i]);
		}
		double sum =0;
		for(int i=0;i<n;i++) {
			arr2[i] = (double)arr[i]/(double)max * 100.0;
			sum += arr2[i];
		}
		System.out.println(sum/n);
	}
}
