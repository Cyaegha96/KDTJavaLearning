package main;

import java.util.Scanner;

import classes.MovieDTO;
import models.MovieDAO;


//View
public class Quiz01 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void printMovieInfo(MovieDTO movie) {
		System.out.println(movie.getId()+"\t"+movie.getTitle()+"\t"+movie.getGenre());
	}
	
	public static int selectID(MovieDAO dao) {
		
		while(true) {
	
			System.out.print("신규 영화 ID:");
			try {
				int num = Integer.parseInt(sc.nextLine());
				boolean isIdExist = dao.isIdExist(num);
				
				if(isIdExist) {
					System.out.println("중복된 id입니다. 다시 입력해주세요.");
				}else {
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
		
		
		MovieDAO dao = new MovieDAO();
		
		
		while(true) {
			System.out.println("<<Netflix 영화 관리 시스템>>");
			System.out.println("1> 신규 영화 등록");
			System.out.println("2> 영화 목록 출력");
			System.out.println("0> 시스템 종료");
			
			int menuNum = selectNum();
			if(menuNum == 1) {
				//신규 영화 등록
				if(dao.getIndex() >=5) {
					System.out.println("더 이상 영화를 등록 할 수 없습니다.");
				}else {
					
					int movieId = selectID(dao);
					System.out.print("신규 영화 제목:");
					String movieTitle = sc.nextLine();
					System.out.print("신규 영화 장르:");
					String movieGenre = sc.nextLine();
					
					//무비 인스턴스 생성
					MovieDTO movie = new MovieDTO(movieId, movieTitle,movieGenre); 
					dao.addMovie(movie);
				
					
				}

				
			}else if(menuNum == 2) {
				//영화 목록 출력
				
				if(dao.getIndex() ==0) {
					System.out.println("출력할 영화 목록이 없습니다.");
				}else {
					
					System.out.println("ID\t제목\t장르\t");
					for(int i=0;i<dao.getIndex();i++) {
						printMovieInfo(dao.getMovie(i));
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
