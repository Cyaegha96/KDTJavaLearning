
public class Quiz07 {

	public static int[] mply(int[] arr, int num) {
		
		for(int i=0;i<arr.length;i++) {
			arr[i]*=num;
		}
		
		return arr;
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3};
		
		int[] result = mply(arr,2); //모든 배열요소 2배
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]+" ");
		}

	}

}
