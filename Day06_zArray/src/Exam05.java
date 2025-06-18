import java.util.Arrays;

public class Exam05 {

	public static void main(String[] args) {
//		for(int i=0;i<3;i++) {
//			int num = (int) (Math.random()*5+1);
//			System.out.println(num);
//			
//		}
		
		int[] arr = new int[] {1,2,3,4,5};
		
		for(int i=0;i<100;i++){
			int x = (int) (Math.random()*5);
			int y = (int) (Math.random()*5);
			
			int tmp  = arr[x];
			arr[x] = arr[y];
			arr[y] = tmp;
		}
		
		System.out.println(Arrays.toString(arr));
		
	}

}
