import java.util.Arrays;
import java.util.Scanner;

public class p10810 {
	//10810	���ֱ�	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		Arrays.fill(arr, 0); //�迭 0���� �ʱ�ȭ
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			for(int j=a;j<=b; j++) {
				arr[j-1] = c;
			}
		}
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
	}
}
