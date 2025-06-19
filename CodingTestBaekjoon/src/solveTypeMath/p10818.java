package solveTypeMath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10818 {
	//최소 최대 구현
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		int num = Integer.parseInt(bf.readLine());
		int min =1000001;
		int max =-1000001 ;
		StringTokenizer stringTokenizer = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<num;i++) {
			int temp =  Integer.parseInt(stringTokenizer.nextToken());
			if(temp < min) {
				min = temp;
			}
			if(temp > max) {
				max = temp;
			}
		}
		System.out.println(min + " " + max);
		
	}
}
