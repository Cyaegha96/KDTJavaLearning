package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//queuestack

public class p24511 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		boolean queuestack[] = new boolean[n];
		Deque<Long> deque = new ArrayDeque<Long>();
 	
		String lineString = br.readLine();
		StringTokenizer st = new StringTokenizer(lineString);
		for(int i=0;i<n;i++) {
			int type = Integer.parseInt(st.nextToken());
			switch (type) {
			case 0:
				//큐일경우
				queuestack[i] = true;
				break;

			case 1:
				//스택일경우
				//이 안에 있는 데이터는 초기값에서 바뀌지 않음.
				queuestack[i]=false;
				break;
			}
		}
		lineString = br.readLine();
		st = new StringTokenizer(lineString);
		for(int i=0;i<n;i++) {
			long token = Long.parseLong(st.nextToken());
			if(queuestack[i]) {
				deque.addFirst(token);
			}			
		}

		int m = Integer.parseInt(br.readLine());
		lineString = br.readLine();
		st = new StringTokenizer(lineString);
		
		for(int i=0;i<m;i++) {
			
			deque.addLast(Long.parseLong(st.nextToken()));
			builder.append(deque.pollFirst()+" ");
		}
		System.out.println(builder);
	}	
}
	

