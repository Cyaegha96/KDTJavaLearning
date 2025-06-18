import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// 버블소트 -좌측에 있는 숫자가 우측에 있는 숫자보다 크다면, swap
		// 한번의 스왑이 끝나면 가장 큰 숫자가 맨 뒤에 위치함
		
		int[] arr = new int[] {15, 24, 35, 99, 86, 34, 13, 27, 46, 66};
		
		System.out.println("정렬 전" + Arrays.toString(arr));
		
		for(int i=0; i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				if(arr[j] > arr[j+1] ) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println("정렬 후" + Arrays.toString(arr));

	}

}
