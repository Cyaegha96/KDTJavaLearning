package solveTypeMath;

import java.util.Scanner;
import java.util.StringTokenizer;

//1002번 터렛
public class p1002 {
	// x1, y1, r1, x2, y2, r2가 주어질 때에
	// x3, y3의 위치가 총 몇개 나올 수 있는지 구하시오

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

			// 중심 간 거리 d = √[(x2 - x1)² + (y2 - y1)²]

			double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

			if (d == 0 && r1 == r2) {
			    answers[i] = -1; // 무한대의 경우 -1로 출력하는 문제라면 여기서 처리
			}else if (d > r1 + r2) {
				answers[i] = 0;
			} else if (d == r1 + r2) {
				//두점이 내접 (한 점에서 만남)
				answers[i] = 1;
			} else {
				// 
				if (Math.abs(r2 - r1) < d && d < r1 + r2) {
					// 두원이 겹칠경우
					answers[i] = 2;
				} else if (Math.abs(r2 - r1) == d) {
					// 내접
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
