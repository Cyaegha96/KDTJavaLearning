package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

//µ¦2
public class p28279 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			String lineString = br.readLine();
			StringTokenizer tokenizer = new StringTokenizer(lineString);
			int command = Integer.parseInt(tokenizer.nextToken());
			switch (command) {
			case 1:
				int x = Integer.parseInt(tokenizer.nextToken());
				deque.addFirst(x);
				
				break;
			case 2:
				int y = Integer.parseInt(tokenizer.nextToken());
				deque.addLast(y);
				break;
		
			case 3:
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.pollFirst()+"\n");
				}
				break;
			case 4:
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.pollLast()+"\n");
				}
				break;
			case 5:
				sb.append(deque.size()+"\n");
				break;
			case 6:
				if(deque.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
				break;
			case 7:
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.peekFirst()+"\n");
				}
				break;
			case 8:
				if(deque.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(deque.peekLast()+"\n");
				}
				break;
			
			}
			
			
		}
		System.out.println(sb);
	}
}
