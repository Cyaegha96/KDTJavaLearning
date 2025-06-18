import java.util.Arrays;

public class Quiz01 {

	public static void main(String[] args) {
		//int 형 변수 100개를 묶은 배열 arr을 생성하고
		//0에서 부터 99까지 저장해봅시다.
		
		//검사방법
		//sysout(arr[0]); //0
		//sysout(arr[99]); //99
		
		int[] arr = new int[100];
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = 100-i;
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
