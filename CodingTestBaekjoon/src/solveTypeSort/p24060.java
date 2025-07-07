package solveTypeSort;


import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p24060 {
	
	static int count = 0;
	static int result = -1;
	static int k=0;
	//������ ���.
	//��������� p<r�� ��쿡�� ��� ����
	public static void merge_sort(int[] arr, int p, int r) {

		if(p< r) {

			int q = (p+r)/2;
		
			merge_sort(arr, p, q);
			merge_sort(arr, q+1, r);
			merge(arr, p, q, r);
		}
	}
	
	
	//������ ���, ������ �迭 a[p...q] a[q+1...r]�� �ϳ��� ���ĵ� �迭�� ��ħ
	public static void merge(int[] arr, int p, int q, int r) {

		int i= p;
		int j= q+1;
		int t=0;
		int[] tmp = new int[r-p+1];
		
		while(i <= q && j <=r) {
			if(arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
				
			}else {
				tmp[t++] = arr[j++];
			}
			
		}

		while(i<=q) {
		
			tmp[t++] = arr[i++];
		}
		while(j <= r) {
		
			tmp[t++] = arr[j++];
		}
		i = p;
		t = 0;
		while(i<=r) {
			arr[i++] = tmp[t++];
			
			count++;
			if(count==k) {
				result = arr[i-1];
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(scanner.nextLine());
		for(int i=0;i<n;i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(arr, 0, n-1);
		System.out.println(result);
	}
}
