import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2566 {
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int max = -1;
		int answerI = -1;
		int answerJ = -1;
		
		for(int i=0; i<9;i++) {
			String lineString = bf.readLine();
			StringTokenizer st = new StringTokenizer(lineString);
			for(int j=0;j<9;j++) {
				int n =  Integer.parseInt(st.nextToken());
				if(n>max) {
					max = n;
					answerI = i+1;
					answerJ = j+1;
					
				}
			}
		}
		System.out.println(max);
		System.out.println(answerI +" " + answerJ);
	}
}
