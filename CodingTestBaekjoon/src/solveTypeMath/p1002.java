package solveTypeMath;

import java.util.Scanner;
import java.util.StringTokenizer;

//1002�� �ͷ�
public class p1002 {
	// x1, y1, r1, x2, y2, r2�� �־��� ����
	// x3, y3�� ��ġ�� �� � ���� �� �ִ��� ���Ͻÿ�

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());

		int[] answers = new int[n];

		for (int i = 0; i < n; i++) {
			String problemLine = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(problemLine);

			int x1, y1, r1, x2, y2, r2;
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());

			// �߽� �� �Ÿ� d = ��[(x2 - x1)�� + (y2 - y1)��]

			double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

			if (d == 0 && r1 == r2) {
			    answers[i] = -1; // ���Ѵ��� ��� -1�� ����ϴ� ������� ���⼭ ó��
			}else if (d > r1 + r2) {
				answers[i] = 0;
			} else if (d == r1 + r2) {
				//������ ���� (�� ������ ����)
				answers[i] = 1;
			} else {
				// 
				if (Math.abs(r2 - r1) < d && d < r1 + r2) {
					// �ο��� ��ĥ���
					answers[i] = 2;
				} else if (Math.abs(r2 - r1) == d) {
					// ����
					answers[i] = 1;
				} else if (d < Math.abs(r2 - r1)) {
					answers[i] = 0;
				}
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.println(answers[i]);
		}
	}

}
