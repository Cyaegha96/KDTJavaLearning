package solveTypeString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2941 {
	//ũ�ξ�Ƽ�� ���ĺ�
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] ca = {"c=", "c-", "dz=","d-", "lj", "nj","s=", "z="};
		int answer = 0;
		String inputString = bf.readLine();
		for(int i=0;i<inputString.length();i++) {
			boolean find = false;
			//inputString�� �ڸ��� ��ȸ

			for(int j=0;j<8;j++) {
				//���� ã���� 1�� ����
				if((i+ca[j].length()-1 <inputString.length())) {
						
					if(ca[j].equals(inputString.substring(i,i+ca[j].length()))) {
						answer++;
						i+=ca[j].length()-1;
						find = true;
//						System.out.println("ã�� ���ĺ�: ["+ca[j]+"]");
						break;
					}
				}

			}
			//��ã���� answer�׳� ����
			if(!find) {
//				System.out.println("ã�� ���ĺ�: ["+inputString.charAt(i)+"]");
				answer++;
			}

		}
		System.out.println(answer);

	}
}
