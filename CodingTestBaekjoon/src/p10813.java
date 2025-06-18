import java.util.Arrays;
import java.util.Scanner;

public class p10813 {
	//공 바꾸기
public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N, M;
		
		N = scanner.nextInt();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = i+1;
		}
		
		M = scanner.nextInt();
		for(int i=0; i<M; i++) {
			int firstIndex = scanner.nextInt()-1;
			int lastIndex = scanner.nextInt()-1;
			int temp = arr[lastIndex];
			arr[lastIndex] = arr[firstIndex];
			arr[firstIndex]= temp;
		}
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1) {
				System.out.print(arr[i]);
			}else {
				System.out.print(arr[i]+" ");
			}
		}
		
	}
}
