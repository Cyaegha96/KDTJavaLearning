package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//Ω∫≈√2
public class p28278 {
	

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		List<Integer> stack = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String line = bf.readLine();
			StringTokenizer st = new StringTokenizer(line);
			
			while(st.hasMoreTokens()) {
				switch (st.nextToken()) {
				case "1":
					stack.add(Integer.parseInt(st.nextToken()));
					break;
				case "2":
					if(stack.size()==0) {
						System.out.println(-1);
					}else {
						System.out.println(stack.get(stack.size()-1));
						stack.remove(stack.size()-1);
					}
					break;
				case "3":
					System.out.println(stack.size());
					break;
				case "4":
					if(stack.size() == 0) {
						System.out.println(1);
					}else {
						System.out.println(0);
					}
					break;
				case "5":
					if(stack.size() == 0) {
						System.out.println(-1);
					}else {
						System.out.println(stack.get(stack.size()-1));
					}
					break;
				
				}
			}
				
		}

	}
}
