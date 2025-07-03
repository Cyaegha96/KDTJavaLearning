package dao;

import java.util.ArrayList;
import java.util.List;

import dto.PostDTO;

public class PostDAO {
	
	List<PostDTO> posts = new ArrayList<>();
	
	public void addPost(String postText, String authorId, long currentTimestamp) {
		int postId = 1001+posts.size();
		posts.add(new PostDTO(postId, postText, authorId,currentTimestamp));
	}
	
	public List<PostDTO> getPosts(){
		return posts;
	}
	
	
	public int getPostsCount() {
		return posts.size();
	}
	
	public PostDTO getPost(int id) {
		return posts.get(id-1001);
	}
	
	public List<PostDTO> searchByAuthorID(String authorID) {
		
		List<PostDTO> result = new ArrayList<PostDTO>();
		for(PostDTO post: this.posts) {
			if(post.getAuthorId().contains(authorID)) {
				result.add(post);
			}
		}
		return result;
	}
	
	public boolean searchById(int id) {
		for(int i=0;i<getPostsCount();i++) {
			if(posts.get(i).getPostId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteByPostID(int id) {
	
		int deleteId= 0;
		for(int i=0;i<getPostsCount();i++) {
			if(posts.get(i).getPostId() == id) {
				deleteId =i;
			}
		}
		posts.remove(deleteId);
		
		
	}
	
	

}
