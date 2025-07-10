package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//1271 엄청난 부자
//랜덤마라톤 58
public class p1271 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		BigInteger n =  new BigInteger(st.nextToken());
		BigInteger m = new BigInteger(st.nextToken());
		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
		
	}
}
