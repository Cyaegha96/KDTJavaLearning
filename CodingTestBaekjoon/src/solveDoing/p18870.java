package solveDoing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

//좌표 압축
public class p18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int[] arr = new int[n];

		Set<Integer> select =new HashSet<Integer>();
		Map<Integer, Integer> setMap = new HashMap<Integer, Integer>();

		//입력
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			setMap.put(arr[i],0);
		}
		
		for(int i=0;i<n;i++) {
			
			if(setMap.get(arr[i]) == 0) {
				select.clear();
				for(int j=0;j<n;j++) {
					if(arr[i] != arr[j] && arr[i] > arr[j] && !select.contains(arr[j])) {
						setMap.put(arr[i], setMap.get(arr[i])+1);
						select.add(arr[j]);
					}
				}
				
			}

		}
		for(int i=0;i<n;i++) {
			System.out.print(setMap.get(arr[i])+" ");
		}
		
	}
}
