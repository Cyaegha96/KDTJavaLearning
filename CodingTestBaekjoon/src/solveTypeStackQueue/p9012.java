package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<n;i++) {
			String lineString = bf.readLine();
			int size = lineString.length();
			
			char[] line = lineString.toCharArray();
			Stack<Character> stack = new Stack<Character>();
			boolean isStack =true;
			for(int j=0;j<size;j++) {
				if(line[j] == '(') {
					stack.add('(');
				}else if(line[j] == ')'){
					if(!stack.empty()) {
						stack.pop();
					}else {
						isStack = false;
					}
				}
			}
			if(!isStack) {
				System.out.println("NO");
			}
			else if(stack.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
			
			
		}
	}
}
