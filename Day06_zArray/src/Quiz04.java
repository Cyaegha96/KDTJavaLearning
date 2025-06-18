import java.util.Arrays;

public class Quiz04 {

	public static void main(String[] args) {
		//1~45 사이의 난수 7개를 중복되지 않게 선택하여 출력
		int[] arr = new int[45];
		for(int i=0;i<45;i++) {
			arr[i] = i+1;
		}
		
		for(int i=0;i<100;i++){
			int x = (int) (Math.random()*45);
			int y = (int) (Math.random()*45);
			int z = (int) (Math.random()*45);
			int tmp  = arr[x];
			arr[x] = arr[y];
			arr[y] = arr[z];
			arr[z] = tmp;
		}
		
		System.out.print("오늘의 추천번호!: ");
		for(int i =0;i<6;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("보너스번호:"+arr[6]);
	}

}
