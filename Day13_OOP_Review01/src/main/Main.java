package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.MovieDAO;
import dto.MovieDTO;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static MovieDAO movieDao = new MovieDAO();
	
	
	static final String MENU_STRING="MENU";
	static final String INPUT_MOVIE_ID = "MOVIEID";
	static final String INPUT_MOVIE_TITLE = "MOVIENAME";
	static final String INPUT_MOVIE_GENRE= "MOVIEGENRE";
	static final String INPUT_MOVIE_DATE="MOVIEDATE";
	
	
	
	static String inputString(String selectString) {
		
		String inputString ="";
		
		while(true) {
			switch (selectString) {
			case INPUT_MOVIE_TITLE:
				System.out.print("영화 제목:");
				break;
			case INPUT_MOVIE_GENRE:
				System.out.print("영화 장르:");
				break;
			case INPUT_MOVIE_DATE:
				System.out.print("영화 출시일(yy/MM/dd):");
				break;
			default:
				break;
			}
			
			
			inputString = scanner.nextLine();
			if(selectString.equals(INPUT_MOVIE_DATE)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/MM/dd");
				try {
					simpleDateFormat.parse(inputString);
					break;
				} catch (ParseException e) {
					System.out.println("제대로 된 날짜를 입력해주세요");
				}
			
			
			}else {
				break;
			}
			
		}
		
		
		return inputString;
	}
	
	
	static int inputNumber(String selectString) {
		int num = 0;
		
		while(true) {
			switch (selectString) {
			case MENU_STRING:
				System.out.print(">>");
				break;
			case INPUT_MOVIE_ID:
				System.out.print("영화 id:");
				break;
			default:
				break;
			}
			
			try {
				num = Integer.parseInt(scanner.nextLine());
				if(selectString.equals(INPUT_MOVIE_ID) && !movieDao.isMoviesId(num)) {
					System.out.println("해당되는 영화 아이디가 없습니다.");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("제대로된 숫자를 입력해주세요");
			}
		}
		
		
		return num;
	}
	
	static void printMovies(List<MovieDTO> list) {
		System.out.println("ID\tTitle\tGenre\t(pub_date)");
		for(MovieDTO movie: list){
			SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월");
			String dateString = sdf.format(movie.getPublishDate());
			
			System.out.printf("%d\t%s\t%s\t%s\t\n",movie.getId(), movie.getTitle(), movie.getGenre(),dateString );
		}
		System.out.println();
	}
	
	static void testCase() throws ParseException {
		movieDao.addMovie("아바타", "판타지", new SimpleDateFormat("yy/MM/dd").parse("24/03/25"));
		movieDao.addMovie("아이언맨", "마블", new SimpleDateFormat("yy/MM/dd").parse("08/04/30"));
		movieDao.addMovie("헤어질결심", "로맨스?", new SimpleDateFormat("yy/MM/dd").parse("22/06/29"));
		
	}
	
	static void menuList() {
		System.out.println("<<Netflix 영화 관리 시스템>>");
		System.out.println("1> 신규 영화 등록");
		System.out.println("2> 영화 목록 출력");
		System.out.println("3> 영화 검색 (제목으로 검색)");
		System.out.println("4> 영화 삭제 (ID로 삭제)");
		System.out.println("5> 영화 정보 수정 (ID 로 전체 수정)");
		System.out.println("0> 시스템 종료");
	}
	
	static boolean moviesCheck() {
		if(movieDao.howManyMovies() <1) {
			System.out.println("충분한 영화가 존재하지 않습니다.");
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws ParseException {
		
		int bufferMovieId = 0;
		String bufferMovieTitle ="";
		String bufferMovieGenre = "";
		Date bufferMovieDate = null;
		testCase();
		
		
		while(true) {
			menuList();
			
			int menuNum = inputNumber(MENU_STRING);

			switch (menuNum) {
			
			case 1: 
				//신규 영화 등록
				bufferMovieTitle = inputString(INPUT_MOVIE_TITLE);
				bufferMovieGenre = inputString(INPUT_MOVIE_GENRE);
				bufferMovieDate = new SimpleDateFormat("yy/MM/dd").parse(inputString(INPUT_MOVIE_DATE));
				
				movieDao.addMovie(bufferMovieTitle, bufferMovieGenre, bufferMovieDate);
				
				
				break;
			case 2: 
				//영화 목록 출력
				if(moviesCheck()) continue;
				printMovies(movieDao.getMovies());
				break;
			case 3:
				//영화 검색
				if(moviesCheck()) continue;
				System.out.println("<<영화를 검색합니다>>");
				bufferMovieTitle = inputString(INPUT_MOVIE_TITLE);
				printMovies(movieDao.getContainTitleInMovies(bufferMovieTitle));
				break;
			case 4:
				//영화 삭제 (id로 삭제)
				if(moviesCheck()) continue;
				printMovies(movieDao.getMovies());
				System.out.println("<<삭제할 영화의 id값을 입력해주세요>>");
				
				bufferMovieId = inputNumber(INPUT_MOVIE_ID);
				movieDao.deleteMovie(bufferMovieId);
				
				System.out.println("<<삭제 완료>>");
				printMovies(movieDao.getMovies());
				break;
				
			case 5:
				//영화 정보 수정
				if(moviesCheck()) continue;
				printMovies(movieDao.getMovies());
				System.out.println("<<수정할 영화의 id값을 입력해주세요>>");
				
				bufferMovieId = inputNumber(INPUT_MOVIE_ID);
				
				bufferMovieTitle = inputString(INPUT_MOVIE_TITLE);
				bufferMovieGenre = inputString(INPUT_MOVIE_GENRE);
				bufferMovieDate = new SimpleDateFormat("yy/MM/dd").parse(inputString(INPUT_MOVIE_DATE));
				
				movieDao.updateMovie(bufferMovieId, bufferMovieTitle, bufferMovieGenre, bufferMovieDate);
				System.out.println("<<업데이트 완료>>");
				printMovies(movieDao.getMovies());
				
				break;
			case 0:
				System.out.println("<<Netflix 영화 관리 시스템을 종료합니다.>>");
				System.out.println("...");
				System.out.println("..bye");
				System.exit(0);
				
				break;
			default:
				System.out.println("제대로 된 메뉴 번호를 입력해주세요");
				break;
			}
		}
	}
}
