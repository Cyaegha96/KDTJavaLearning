package quizs;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		//사용자로부터 연월일을 입력 받고 (yyyy년MM월dd일) 
		//입력받은 날로부터 일주일 전 날짜를 
		//yyyy/MM/dd 형식으로 출력해보세요
		Date date = null;
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("년월일을 입력해주세용 (yyyy년MM월dd일) ");
			System.out.print(">>>");
			String inpuString = scanner.nextLine();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년MM월dd일");
			try {
				date= simpleDateFormat.parse(inpuString);
				if(date == null) {
					System.out.println("제대로 된 형식으로 입력해주세요.");
				}
				else {
					break;
				}
			} catch (ParseException e) {
				System.out.println("제대로 된 형식으로 입력해주세요.");
				
			}
			
		}
		long targetDay = date.getTime();
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
		
		System.out.println(simpleDateFormat2.format(targetDay-86400000L*7));
	}

}
