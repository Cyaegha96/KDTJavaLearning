package solveTypeMath;
import java.util.Scanner;


public class p27433 {

	static int fibo(int a ) {
		if(a==1) {
			return 1;
		}else if(a==2) {
			return 1;
		}else {
			return fibo(a-1) + fibo(a-2);
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		
		System.out.println(fibo(n));
	}

}
