package quizs;

import java.util.Scanner;

import classes.Movie;

public class Quiz01 {
	
	static Scanner sc = new Scanner(System.in);
	
	
	public static int selectID(Movie[] moives,int count) {
		
		while(true) {
			boolean isdup = false;
			System.out.print("신규 영화 ID:");
			try {
				int num = Integer.parseInt(sc.nextLine());
				for(int i=0;i<count;i++) {
					if(num == moives[i].getId()) {
						System.out.println("이미 있는 영화 ID와 중복됩니다.");
						isdup = true;
					}
				}
				
				if(!isdup) {
					return num;
				}
				
			} catch (Exception e) {
				System.out.println("제대로 된 숫자를 입력해주세요");
			}
		}
	}
	
	public static int selectNum() {
		
		while(true) {
			System.out.print(">>");
			try {
				int num = Integer.parseInt(sc.nextLine());
				return num;
			} catch (Exception e) {
				System.out.println("제대로 된 숫자를 입력해주세요");
			}
		}
	}
	
	public static void main(String[] args) {
		
		Movie[] movies = new Movie[5];
		int movieCount = 0;
		while(true) {
			System.out.println("<<Netflix 영화 관리 시스템>>");
			System.out.println("1> 신규 영화 등록");
			System.out.println("2> 영화 목록 출력");
			System.out.println("0> 시스템 종료");
			
			int menuNum = selectNum();
			if(menuNum == 1) {
				//신규 영화 등록
				if(movieCount >=5) {
					System.out.println("더 이상 영화를 등록 할 수 없습니다.");
				}else {
					
					int movieId = selectID(movies, movieCount);
					System.out.print("신규 영화 제목:");
					String movieTitle = sc.nextLine();
					System.out.print("신규 영화 장르:");
					String movieGenre = sc.nextLine();
					
					//무비 인스턴스 생성
					movies[movieCount++] = new Movie(movieId, movieTitle,movieGenre); 
					
				}

				
			}else if(menuNum == 2) {
				//영화 목록 출력
				
				if(movieCount ==0) {
					System.out.println("출력할 영화 목록이 없습니다.");
				}else {
					
					System.out.println("ID\t제목\t장르\t");
					for(int i=0;i<movieCount;i++) {
						movies[i].printMovieInfo();
					}
				}
			
			}else if(menuNum == 0) {
				//시스템 종료
				System.out.println("Netflix 영화 관리 시스템을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("메뉴 안에서 선택해주세요");
			}
			
		}
		
		
	}
}
