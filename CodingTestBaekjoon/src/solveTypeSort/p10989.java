package solveTypeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//�� �����ϱ� 3 (ī���� ���� ����ϱ�)
public class p10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[n];

		int max= 0;
		
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			if(max < arr[i]) max = arr[i];
		}
		
		//ī��Ʈ �迭
		int[] count = new int[max + 1];
		
		//ī��Ʈ �迭 ä���
		for(int num:arr) {
			count[num]++;
		}
		
		//ī��Ʈ �迭 ������ ����ϱ�
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		//�������� �����鼭 �����պ��� ���� ��° ������ �ֱ�
		int[] result= new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			int num = arr[i];
			result[--count[num]] = num;
		}
		//���
		for(int num:result) {
			bw.write(num+"\n");
		}
		bw.flush();
		
	}
}
