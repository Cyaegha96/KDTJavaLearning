package solveDoing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//풍선 터트리기


class IntPair{
	int index;
	int data;
	
	public IntPair(int first, int second) {
		index = first;
		data = second;
	}
	
}

public class p2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder builder = new StringBuilder();
		List<IntPair> list = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			list.add(new IntPair(i, tmp));
		}
		int index = 0;
		int checked = 0;
		
		while(!list.isEmpty()) {
			
			//해당 인덱스 추가
			builder.append(list.get(index).index);
			
			int buffer = list.get(index).data;
			
			if(!list.isEmpty()) {
				list.remove(index);
				builder.append(", ");
				index = index + buffer;
				if(index < 0) {
					index = (index + list.size())%list.size();
				}else {
					if(!list.isEmpty()) {
						index %= list.size();
					}
				}
			}
		
		}
		System.out.println(builder);
		
		
		
		
	}
}
