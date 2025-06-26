package solveTypeHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//숫자카드
//해시맵 사용
public class p10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Map<Integer, Integer> numberCards = new HashMap<>(); 
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String cardString =bf.readLine();
		StringTokenizer st = new StringTokenizer(cardString);
		for(int i=0;i<n;i++) {
			int token = Integer.parseInt(st.nextToken());
			numberCards.put(token, numberCards.getOrDefault(token, 0) +1);
		}
		
		int m = Integer.parseInt(bf.readLine());
		int[] arr = new int[m];
		
		String cardString2=bf.readLine();
		
		st = new StringTokenizer(cardString2);
		
		for(int i=0;i<m;i++) {
			int token = Integer.parseInt(st.nextToken());
			arr[i] = token;
		}

		//출력
		for(int i=0;i<m;i++) {
			System.out.print(numberCards.getOrDefault(arr[i], 0)+" ");
		}
		
	}
}
