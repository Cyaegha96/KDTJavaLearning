package solveTypeString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2941 {
	//크로아티아 알파벳
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] ca = {"c=", "c-", "dz=","d-", "lj", "nj","s=", "z="};
		int answer = 0;
		String inputString = bf.readLine();
		for(int i=0;i<inputString.length();i++) {
			boolean find = false;
			//inputString의 자리를 순회

			for(int j=0;j<8;j++) {
				//만약 찾으면 1번 증가
				if((i+ca[j].length()-1 <inputString.length())) {
						
					if(ca[j].equals(inputString.substring(i,i+ca[j].length()))) {
						answer++;
						i+=ca[j].length()-1;
						find = true;
//						System.out.println("찾은 알파벳: ["+ca[j]+"]");
						break;
					}
				}

			}
			//못찾으면 answer그냥 증가
			if(!find) {
//				System.out.println("찾은 알파벳: ["+inputString.charAt(i)+"]");
				answer++;
			}

		}
		System.out.println(answer);

	}
}
