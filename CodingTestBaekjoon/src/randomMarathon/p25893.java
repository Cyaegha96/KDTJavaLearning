package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//majestic 10
public class p25893 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			System.out.println(s);
			StringTokenizer st = new StringTokenizer(s);
			boolean stat1 = Integer.parseInt(st.nextToken())>=10;
			boolean  stat2 = Integer.parseInt(st.nextToken())>=10;
			boolean  stat3 = Integer.parseInt(st.nextToken())>=10;
			if(stat1  && stat2  && stat3 ) {
				System.out.println("triple-double\n" );
			}else if(!stat1  && !stat2 && !stat3) {
				System.out.println("zilch\n");
			}else if((stat1  && stat2) || (stat2 && stat3) || (stat1 && stat3)  ) {
				System.out.println("double-double\n");
			}else {
				System.out.println("double\n");
			}
			
		}
		
	}
}
