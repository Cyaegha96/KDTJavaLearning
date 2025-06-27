package models;

import java.util.ArrayList;

import classes.MovieDTO;

//DAO;
//Data Access Object

//  데이터 입력 /  출력  /   수정    / 삭제 등을 수행하는 기능만 분리한 객체
//  Create  / Read  /  Update / Delete 

public class MovieDAO {

	private ArrayList<MovieDTO> movies = new ArrayList<>();

	
	public void addMovie(MovieDTO movie) {
		movies.add(movie);
	}
	

	public ArrayList<MovieDTO> getMovies() {
		return this.movies;
	}
	
	public MovieDTO getMovie(int index) {
		return movies.get(index);
	}

	public boolean isIdExist(int id) {
		
		for(int i=0;i< movies.size();i++) {
			if(id == movies.get(i).getId()) {
				return true;
			}
		}
		return false;
	}
	
}
