import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.player.Player;

	

public class Exam03 {
	public static void main(String[] args) {
		 try {
	            FileInputStream fis = new FileInputStream("밤.mp3");
	            Player player = new Player(fis);
	            System.out.println("Playing song...");
	            player.play();
	            System.out.println("Song finished.");
	        } catch (FileNotFoundException e) {
	            System.err.println("File not found: " + e.getMessage());
	        } catch (Exception e) { // Catch general exceptions from JLayer
	            System.err.println("Error playing MP3: " + e.getMessage());
	        }
		
		
	}
}
