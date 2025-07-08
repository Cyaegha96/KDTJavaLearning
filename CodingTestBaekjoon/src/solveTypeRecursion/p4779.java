package solveTypeRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p4779 {

    public static void cantor(boolean[] arr, int start, int end) {
        if (end - start < 3) return;

        int third = (end - start) / 3;
        int midStart = start + third;
        int midEnd = start + 2 * third;

        // 가운데 부분 제거
        for (int i = midStart; i < midEnd; i++) {
            arr[i] = false;
        }

        // 좌측과 우측 재귀 분할
        cantor(arr, start, midStart);
        cantor(arr, midEnd, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        while ((st = br.readLine()) != null && !st.isEmpty()) {
            int n = Integer.parseInt(st);
            int len = (int) Math.pow(3, n);
            boolean[] arr = new boolean[len];
            Arrays.fill(arr, true);

            cantor(arr, 0, len);

            StringBuilder sb = new StringBuilder();
            for (boolean b : arr) {
                sb.append(b ? '-' : ' ');
            }
            System.out.println(sb);
        }
    }
}