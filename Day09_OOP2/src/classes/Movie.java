package classes;

public class Movie {
	private String title;
	private String genre;
	
	//Constructor: 생성자 메서드
	
	
	public Movie() {
		System.out.println("무비 인스턴스 생성");
	}
	
	//생성자
	public Movie(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
}

