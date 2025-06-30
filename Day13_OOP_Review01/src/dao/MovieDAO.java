package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.MovieDTO;

public class MovieDAO {

	static final int ID_START =  1001;
	List<MovieDTO> movies = new ArrayList<MovieDTO>();
	
	//movies[i] = new MovieDTO(ADFDASF);
	public void addMovie(String title, String genre, Date publishDate) {
		movies.add(new MovieDTO(ID_START+movies.size(), title, genre, publishDate));
		
	}
	
	public void updateMovie(int id, String title, String genre, Date publishDate) {
		int index = id - ID_START;
		MovieDTO movie = movies.get(index);
		movie.setTitle(title);
		movie.setGenre(genre);
		movie.setPublishDate(publishDate);
	}
	
	public List<MovieDTO> getMovies(){
		return movies;
	}
	
	public int howManyMovies() {
		return movies.size();
	}
	
	public void deleteMovie(MovieDTO dto) {
		for(MovieDTO movie: movies) {
			movies.remove(dto);
		}
	}
	
	
	public void deleteMovie(int movieId) {
		
		int index = movieId - ID_START;
		movies.remove(index);
		
		//삭제된 movie의 id값이 비게 되므로 
		//뒤쪽 movie들의 Id값을 앞으로 땡겨주기
		for(int i=index;i<movies.size();i++) {
			movies.get(i).setId(movies.get(i).getId()-1);
		}
		
	}
	
	public boolean isMoviesId(int id) {
		for(MovieDTO movie: movies) {
			if(movie.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public List<MovieDTO> getContainTitleInMovies(String titleString){
		List<MovieDTO> bufferMovie = new ArrayList<MovieDTO>();
		
		for(MovieDTO movie: movies) {
			if(movie.getTitle().contains(titleString)) {
				bufferMovie.add(movie);
			}
		}
		
		return bufferMovie;
	}
	
}
