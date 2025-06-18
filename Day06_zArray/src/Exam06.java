
public class Exam06 {
	public static void main(String[] args) {
			
		int[] arr1 = new int[] {1,2,3};
		int[] arr2 = new int[] {1,3,4};
		
		int answer = 0; //일치하는 숫자 개수
		
		for(int i = 0; i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i] == arr2[j]) {
					answer++;
					break;
				}
			}
		}
		System.out.println(answer+"개 일치함!");
		
	}
}
