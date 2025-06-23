package Quiz;

import classes.Movie;
import classes.Music;

public class Quiz01 {

	//제목, 장르
	//Movie 인스턴을 생성 후,
	
	public static void main(String[] args) {
		Movie movie = new Movie();
		Movie movie2 = new Movie("오징어게임3","스릴러");
		movie.setTitle("Straw");
		movie.setGenre("Thriller");
		System.out.println("영화 제목:"+movie.getTitle()+", 영화 장르:"+movie.getGenre());
		System.out.println("영화 제목:"+movie2.getTitle()+", 영화 장르:"+movie2.getGenre());
		
	
	//제목과 가수 이름을 멤버 필드로 가지는
	//Music 클래스를 설계하되, 정보 은닉을 적용하여 만들어주세요.
	//Music 인스턴스 생성 후, 제목에는 "밤"
	//가수 "손승진"을 저장하고, 잘 저장되었는지 확인해주세요.
		
		Music music = new Music();
		music.setTitle("밤");
		music.setArtist("손승진");
		System.out.println("노래 제목: "+music.getTitle()+", 노래가수: "+music.getArtist());
	}
	
}
