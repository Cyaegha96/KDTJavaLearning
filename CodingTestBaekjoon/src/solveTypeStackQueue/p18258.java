package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//18258 ť2
public class p18258 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		//List<Integer>  queue = new ArrayList<>();
		//Queue<Integer> queue = new PriorityQueue<Integer>();
		Deque<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0;i<N;i++) {
			String line = bf.readLine();
			StringTokenizer st = new StringTokenizer(line);
			
			while(st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "push":
					queue.add(Integer.parseInt(st.nextToken()));
					break;
					
				case "pop":
					if(queue.isEmpty()) {
						sb.append("-1\n");
						
					}else {
						sb.append(queue.pop()+"\n");
						
					}
					break;
					
				case "size":
					sb.append(queue.size()+"\n");
					break;
					
				case "empty":
					if(queue.isEmpty()) {
						sb.append("1\n");
					}else {
						sb.append("0\n");
					}
					break;
					
				case "front":
					if(queue.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(queue.getFirst()+"\n");
					}
					break;
					
				case "back":
					if(queue.isEmpty()) {
						sb.append("-1\n");
					}else {
						sb.append(queue.getLast()+"\n");
					}
					break;

				}
			
			}
			
			
		}
		System.out.println(sb);
	}
}
