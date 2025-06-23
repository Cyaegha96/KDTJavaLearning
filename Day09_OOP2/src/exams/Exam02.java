package exams;

import classes.Movie;

public class Exam02 {

	public static void main(String[] args) {
		
		Movie[] movies = new Movie[3];
		
		movies[0]= new Movie("아이언맨","액션");
		movies[1] = new Movie("블랙팬서","로맨스");
		movies[2] = new Movie("어벤져스","느와르");
		
		for(int i=0;i<movies.length;i++) {
			System.out.println("영화:"+movies[i].getTitle()+", 장르:"+movies[i].getGenre());
		}
		
	}

}
