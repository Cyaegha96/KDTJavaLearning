package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//요세푸스 문제 0


public class p11866 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n  = Integer.parseInt(st.nextToken());
		
		StringBuilder builder = new StringBuilder();
		builder.append("<");
		List<Integer> list = new ArrayList<>();
		for(int i = 1;i<=k;i++) {
			list.add(i);
		}
		int count = 0;
	
		
		while(!list.isEmpty()) {
			count +=n-1;
			count%=list.size() ;
			builder.append(list.get(count));
			list.remove(count);
			if(!list.isEmpty()) {
				builder.append(", ");
			}
			
		}
		
		builder.append(">");
		
		System.out.println(builder);
	}
}
