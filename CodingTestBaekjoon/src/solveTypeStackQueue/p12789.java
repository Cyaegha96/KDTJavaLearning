package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

//도키도키 간식드리미 
public class p12789 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> list = new ArrayDeque<Integer>();
		Stack<Integer> stack =  new Stack();
		
		String lineString = br.readLine();
		StringTokenizer tokenizer = new StringTokenizer(lineString);
		while(tokenizer.hasMoreTokens()) {
			list.add(Integer.parseInt(tokenizer.nextToken()));
		}
		int count = 1;

		while(!list.isEmpty()) {
			
//			System.out.println("지금은 : "+(count)+"번째 학생의 차례");
//			System.out.println("줄 상태:"+ list.toString());
//			System.out.println("스택 상태: "+stack.toString());
			//만약 리스트 맨앞에 있는게 맞다면
			if(list.getFirst() == count) {
				count++;
				list.removeFirst();
			}//만약 스택이 비어있지 않고
			else if(!stack.isEmpty() &&stack.peek() == count) {
				
					count++;
					stack.pop();
				
			}else {
				stack.add(list.getFirst());
				list.removeFirst();
			}
		}
		
		if(!stack.isEmpty()) {
			
			while(!stack.isEmpty()) {
//				System.out.println("지금은 : "+count+"번째 학생의 차례");
//				
//				System.out.println("스택 상태: "+stack.toString());
				if(stack.peek() == count) {
					count++;
					stack.pop();
				}else {
					break;
				}
			}
		}
		if(count == n+1) {
			System.out.println("Nice");
		}else {
			System.out.println("Sad");
		}
		
	}
}
