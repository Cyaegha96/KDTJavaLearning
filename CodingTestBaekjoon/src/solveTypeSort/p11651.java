package solveTypeSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Dot{
	
	public Dot(int xIndex, int yIndex) {
		this.xIndex = xIndex;
		this.yIndex = yIndex;
	}
	
	int xIndex;
	int yIndex;
}

class MyComparator2 implements Comparator<Dot>{

	@Override
	public int compare(Dot o1, Dot o2) {

		if(o1.yIndex == o2.yIndex) {
			return Integer.compare(o1.xIndex, o2.xIndex);
		}else {
			return Integer.compare(o1.yIndex, o2.yIndex);
		}
	}
	
}


//좌표 정렬하기 2
public class p11651 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		
		List<Dot> dots = new ArrayList<Dot>();
		
		for(int i=0;i<n;i++) {
			String line = bf.readLine();
			st = new StringTokenizer(line);
			
			int xIndex= Integer.parseInt(st.nextToken());
			int yIndex= Integer.parseInt(st.nextToken());
			
			dots.add(new Dot(xIndex, yIndex));
			
			}
		
		dots.sort(new MyComparator2());
		
		for(Dot dot: dots) {
			System.out.println(dot.xIndex+" "+dot.yIndex);
		}
		
	}
}
