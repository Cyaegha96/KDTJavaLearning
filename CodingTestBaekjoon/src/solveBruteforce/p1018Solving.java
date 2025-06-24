package solveBruteforce;

import java.util.Scanner;
import java.util.StringTokenizer;

//p1018 체스판 다시 칠하기
public class p1018Solving {
	
	
	public static int bruteForcePrint(char[][] arr, byte startx, byte starty, int n, int m) {
		int countWB = 0;
		int countBW = 0;
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<m;j++) {
				if(i>=startx && i<startx+8 && j >=starty && j<starty+8) {
					System.out.print ("[" +arr[i][j]+ "]");
					if((i+j)%2 == 0) {
						//짝수자리는 w여야함 b라면 count올리기
						if(arr[i][j] == 'B') {
							countWB++;
						}
					}else{
						//홀수 일 때 b여야함 w라면 count올리기
						if(arr[i][j] == 'W') {
							countWB++;
						}
					}
					
					//BWBWBW...로 만들기 위한 케이스
					if((i+j)%2 == 0) {
						//짝수일 때 b여야함 w라면 count 올리기
						if(arr[i][j] == 'W') {
							countBW++;
						}
					}else{
						//홀수 일 때 w여야함 b라면 count올리기
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
		System.out.println("최소값:"+Math.min(countBW,countWB));
		
		return Math.min(countBW,countWB);
	}
	
	public static int bruteForce(char[][] arr, byte startx, byte starty) {
		// 다시 칠해야 하는 정사각형 개수의 최솟값을 리턴
		int countWB = 0;
		int countBW = 0;
		
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				//WBWBWB...로 만들기 위한 케이스
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
		
		//대상이될 보드 입력
		for(int i=0;i<n;i++) {
			String lineString = scanner.nextLine();
			
			for(int j=0;j<m;j++) {
				arr[i][j] = lineString.charAt(j);
			}
		}
		
		//브루트포스
		for(byte i=0;i<n-7;i++) {
			
			for(byte j=0;j<m-7;j++) {
				
		
				int count = bruteForcePrint(arr, i, j, n, m);
				if(count < result) {
					result = count;
					
				}
			}
		}
		
		System.out.println("정답: "+result);
		
	}
}
