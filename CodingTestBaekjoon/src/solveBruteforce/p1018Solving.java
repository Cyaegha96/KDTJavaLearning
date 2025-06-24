package solveBruteforce;

import java.util.Scanner;
import java.util.StringTokenizer;

//p1018 ü���� �ٽ� ĥ�ϱ�
public class p1018Solving {
	
	
	public static int bruteForcePrint(char[][] arr, byte startx, byte starty, int n, int m) {
		int countWB = 0;
		int countBW = 0;
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				if(i>=startx && i<startx+8 && j >=starty && j<starty+8) {
					System.out.print ("[" +arr[i][j]+ "]");
					if((i+j)%2 == 0) {
						//¦���ڸ��� w������ b��� count�ø���
						if(arr[i][j] == 'B') {
							countWB++;
						}
					}else{
						//Ȧ�� �� �� b������ w��� count�ø���
						if(arr[i][j] == 'W') {
							countWB++;
						}
					}
					
					//BWBWBW...�� ����� ���� ���̽�
					if((i+j)%2 == 0) {
						//¦���� �� b������ w��� count �ø���
						if(arr[i][j] == 'W') {
							countBW++;
						}
					}else{
						//Ȧ�� �� �� w������ b��� count�ø���
						if(arr[i][j] == 'B') {
							countBW++;
						}
					}
					
				}else {
					System.out.print (" "+ arr[i][j] + " ");
				}
				
			}
			System.out.println();
			
		}
		System.out.println("�ּҰ�:"+Math.min(countBW,countWB));
		
		return Math.min(countBW,countWB);
	}
	
	public static int bruteForce(char[][] arr, byte startx, byte starty) {
		// �ٽ� ĥ�ؾ� �ϴ� ���簢�� ������ �ּڰ��� ����
		int countWB = 0;
		int countBW = 0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				//WBWBWB...�� ����� ���� ���̽�
				//
				
			}
		}
		return Math.min(countWB, countBW);
		
		
	}
	
	
	
	public static void main(String[] args) {
		char[][] arr = new char[50][50];
		char[][] resultArr = new char[8][8];
		
		int result = 50*50/2;
		Scanner scanner= new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(scanner.nextLine());
		int n= Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//����̵� ���� �Է�
		for(int i=0;i<n;i++) {
			String lineString = scanner.nextLine();
			
			for(int j=0;j<m;j++) {
				arr[i][j] = lineString.charAt(j);
			}
		}
		
		//���Ʈ����
		for(byte i=0;i<n-7;i++) {
			
			for(byte j=0;j<m-7;j++) {
				
		
				int count = bruteForcePrint(arr, i, j, n, m);
				if(count < result) {
					result = count;
					
				}
			}
		}
		
		System.out.println("����: "+result);
		
	}
}
