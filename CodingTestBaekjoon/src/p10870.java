import java.util.Scanner;

public class p10870 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		int n = Integer.parseInt(sc.nextLine());
		if(n<=1) {
			System.out.println(n);
			
		}
		else {
			int prev = 0; int curr = 1;
			
			
			for(int i=2;i<=n;i++) {
					int next = prev + curr;
					prev=curr;
					curr = next;
						
			}
			System.out.println(curr);
		}
		
	}
}
