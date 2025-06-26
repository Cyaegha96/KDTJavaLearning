package models;

import classes.MovieDTO;

//DAO;
//Data Access Object

//  데이터 입력 /  출력  /   수정    / 삭제 등을 수행하는 기능만 분리한 객체
//  Create  / Read  /  Update / Delete 

public class MovieDAO {

	private MovieDTO[] movies = new MovieDTO[5];
	private int index = 0;
	
	public void addMovie(MovieDTO movie) {
		this.movies[this.index]  = movie;
		this.index++;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public MovieDTO[] getMovies() {
		return this.movies;
	}
	
	public MovieDTO getMovie(int index) {
		return this.movies[index];
	}

	public boolean isIdExist(int id) {
		
		for(int i=0;i< this.index;i++) {
			if(id == movies[i].getId()) {
				return true;
			}
		}
		return false;
	}
	
}
