package solveTypeMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�߾� �̵� �˰���
public class p2903 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// 0�϶� 2�� ����, 1�϶� 3�� ����... 2�϶� 5�� ����... 3�϶�    5�϶� 33

		int n = Integer.parseInt(bf.readLine());

		System.out.println( ((int)Math.pow(2, n) +1) *(int)(Math.pow(2, n) +1));
		
	}
}
