package solveTypeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//좌표 압축
public class p18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[n];

		Map<Integer, Integer> setMap = new HashMap<Integer, Integer>();

		//입력
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] sorted = arr.clone();
        Arrays.sort(sorted);

		
		int idx = 0;
        for (int num : sorted) {
            if (!setMap.containsKey(num)) {
            	setMap.put(num, idx++);
            }
        }
		for(int i=0;i<n;i++) {
			bw.write(setMap.get(arr[i])+" ");
		
		}
		bw.flush();
	}
}
