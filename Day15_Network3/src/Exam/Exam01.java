package Exam;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Exam01 {
	
	//SHA-256/ SHA-512
	public static String encrypt(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            byte[] digest = md.digest(bytes);
            
            StringBuilder builder = new StringBuilder();
            for (byte b : digest) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 암호화 실패", e);
        }
    }
	
	
	public static void main(String[] args) {
		//암호화
		
		// MD5 Hashing -> SHA256, SHA512
		
		String resultString = encrypt("사실여기별내용은없습니다");
		System.out.println(resultString);
	}
}
