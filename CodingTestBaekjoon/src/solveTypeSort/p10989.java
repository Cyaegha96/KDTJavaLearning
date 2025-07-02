package solveTypeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//수 정렬하기 3 (카운팅 정렬 사용하기)
public class p10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];

		int max= 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			if(max < arr[i]) max = arr[i];
		}
		
		//카운트 배열
		int[] count = new int[max + 1];
		
		//카운트 배열 채우기
		for(int num:arr) {
			count[num]++;
		}
		
		//카운트 배열 누적합 계산하기
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		//역순으로 훑으면서 누적합보다 적은 번째 순서에 넣기
		int[] result= new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			int num = arr[i];
			result[--count[num]] = num;
		}
		//출력
		for(int num:result) {
			bw.write(num+"\n");
		}
		bw.flush();
		
	}
}
