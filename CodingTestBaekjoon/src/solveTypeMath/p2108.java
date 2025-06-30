package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//2108번 통계학
public class p2108 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(bf.readLine());
		
		double sum = 0;
		int middle=  0;
		int mostValue = 0;
		int range = 0;
		
		List<Integer> list  = new ArrayList<>();
		Map<Integer, Integer> hashIntegers = new HashMap<Integer, Integer>();
		
		
		for(int i=0; i<n;i++) {
			int num = Integer.parseInt(bf.readLine());
			list.add(num);
			hashIntegers.put(num, hashIntegers.getOrDefault(num, 0)+1);
			sum += num;
		}
		Collections.sort(list);
		
		double avg = sum / n;
		middle = list.get(n/2);
		mostValue = Collections.max(hashIntegers.values());
		
		List<Integer> modes=  new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: hashIntegers.entrySet()) {
			if(entry.getValue() == mostValue) {
				modes.add(entry.getKey());
			}
		}
		
		if(modes.size() >=2) {
			 Collections.sort(modes);
			mostValue =modes.get(1);
		}else {
			mostValue= modes.get(0);
		}
		
		range = list.get(n-1)-list.get(0);
		 double rounded = Math.round(avg * 10) / 10.0;
		
		 // 결과가 -0.0인 경우, 0.0으로 처리 
        if (rounded == -0.0) {
            rounded = 0.0;
        }

        // 절댓값이 0.5보다 작으면 0으로 처리
        if (Math.abs(rounded) < 0.5) {
            rounded = 0.0;
        }
		
		System.out.printf("%.0f\n",rounded);
		System.out.printf("%d\n", middle);
		//셋째 줄에는 최빈값을 출력한다. 
		//여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
		System.out.printf("%d\n", mostValue);
		System.out.printf("%d\n", range);
		
		
	}
	
	
	
	
	
	
}
