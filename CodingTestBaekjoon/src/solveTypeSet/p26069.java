package solveTypeSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//p26069 ���Ӽ� ���� ������
public class p26069 {
	
	
	private static final String CHONGCHON_STRING="ChongChong";
	
	public static void main(String[] args) {
		
		//ChongChong�̶� ���� �� �ִ� �ֵ��� Set�� �����ϰ� 
		//�׷� ģ����� �������� �ִٸ� �� Set�� ����.
		//���������� Set�ȿ��� ��� �� ���
		Scanner scanner = new Scanner(System.in);
		
		int num = Integer.parseInt(scanner.nextLine());
		
		Set<String> greetSet = new HashSet<String>();
		
		for(int i=0;i<num;i++) {
			String lineString = scanner.nextLine();
			String[] meetings = lineString.split(" ");
		
			if(meetings[0].equals(CHONGCHON_STRING) || meetings[1].equals(CHONGCHON_STRING)) {
				greetSet.add(meetings[0]);
				greetSet.add(meetings[1]);
			}else {
				if(greetSet.contains(meetings[0]) || greetSet.contains(meetings[1])) {
					greetSet.add(meetings[0]);
					greetSet.add(meetings[1]);
				}
			}
			
			
		}
		System.out.println(greetSet.size());	
	}
}
