package Quiz;

import java.util.Scanner;

import classes.Contact;

public class Quiz02 {
	public static void main(String[] args) {
		//이름과 연락처를 Scanner로 입력받아
		//Contact 인스턴스에 저장 후, 
		//잘 저장되었는지 출력하는 프로그램을 작성해보세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("이름>>");
		String nameString = sc.nextLine();
		System.out.print("연락처>>");
		String phoneString= sc.nextLine();
		
		Contact contact = new Contact(nameString, phoneString);
		System.out.println("이름:" +contact.getName() + ", 전번: "+contact.getPhoneNumber());
	}
}
