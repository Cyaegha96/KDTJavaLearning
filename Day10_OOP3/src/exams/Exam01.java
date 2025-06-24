package exams;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Exam01 {
	public static void main(String[] args) throws ParseException {
		
		//프로그래밍 언어에서 날짜를 다루는 방법
		long date = System.currentTimeMillis(); 
		long haru = 86400000L;
		//1970년 1월 1일 부터 현시점까지 흐른 시간을 밀리 초 값으로 환산한 결과를 반환
		//유닉스 타임 스템프, 에폭스 타임
		System.out.println(date);
		
		//Timestamp 값 -> String 형태로 변환
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss ");
		String resultString = sdf.format(date);
		String resultString2 = sdf.format(date+haru);
		System.out.println(resultString);
		System.out.println(resultString2);
		
		//String 형태의 값 - >  Timestamp로 변환
		
		String tmpString = "2023년11월14일";
	
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년MM월dd일");
		Date result2 = sdf2.parse(tmpString);
		
		System.out.println(result2.getTime());
		System.out.println(sdf.format(result2.getTime()));
	}
}
