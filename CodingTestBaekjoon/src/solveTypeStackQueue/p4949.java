package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//4949¹ø ±ÕÇüÀâÈù ¼¼»ó
public class p4949 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();
			if (line.equals(".")) {
				break;
			}
			int size = line.length();
			char[] arr = line.toCharArray();

			Stack<Character> stack = new Stack<Character>();
			boolean isStack = true;
			for (int i = 0; i < size; i++) {
				if (arr[i] == '(' || arr[i] == '[') {
					stack.push(arr[i]);
				} else if (arr[i] == ')') {
					if (stack.empty()) {
						isStack = false;
					}else if(stack.pop() != '(') {
						isStack = false;
					}
				}else if (arr[i] == ']') {
					if (stack.empty()) {
						isStack = false;
					}else if(stack.pop() != '[') {
						isStack = false;
					}
				}
			

			}
			if (!isStack) {
				sb.append("no\n");
			} else if (stack.isEmpty()) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
			
		}
		System.out.println(sb);
	}
}
