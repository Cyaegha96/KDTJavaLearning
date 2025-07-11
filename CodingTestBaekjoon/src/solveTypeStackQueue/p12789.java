package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

//��Ű��Ű ���ĵ帮�� 
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
			
//			System.out.println("������ : "+(count)+"��° �л��� ����");
//			System.out.println("�� ����:"+ list.toString());
//			System.out.println("���� ����: "+stack.toString());
			//���� ����Ʈ �Ǿտ� �ִ°� �´ٸ�
			if(list.getFirst() == count) {
				count++;
				list.removeFirst();
			}//���� ������ ������� �ʰ�
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
//				System.out.println("������ : "+count+"��° �л��� ����");
//				
//				System.out.println("���� ����: "+stack.toString());
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
