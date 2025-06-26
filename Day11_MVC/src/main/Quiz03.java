package main;

import java.util.Scanner;

import classes.StudentDTO;
import models.StudentsDAO;

public class Quiz03 {
	public static void main(String[] args) {
		//1. 이름, 국어, 영어, 수학 항목을 멤버필드로 가지는
		//Student 클래스를 설계하되, setter/getter/constructor 를 구현할 것.
		
		//2. 제작한 Student 클래스를 활용하여, 3명의 학생 정보를 스캐너로 입력 받아 보관할 것.
	
		//3. 입력이 전부 끝나면 학생 정보들을 취합하여
		//이름, 국어, 영어, 수학, 합계, 평균을 화면에 출력할 것.
		
		Scanner scanner = new Scanner(System.in);

		StudentsDAO dao = new StudentsDAO();
		
		for (int i = 0; i <dao.getStudentsMany(); i++) {
			String name;
			int korean;
			int math;
			int english;
			
			System.out.print((i+1)+" 번째 학생 이름: ");
			name= scanner.nextLine();
			System.out.print(name+" 학생 국어: ");
			korean = Integer.parseInt(scanner.nextLine());
			System.out.print(name+" 학생 영어: ");
			english = Integer.parseInt(scanner.nextLine());
			System.out.print(name+" 학생 수학: ");
			math = Integer.parseInt(scanner.nextLine());
			
			
			StudentDTO studentDTO = new StudentDTO(name, korean, english, math);
			dao.addStudent(studentDTO);
		}
		System.out.println("이름\t국어\t수학\t영어\t합계\t평균\t");
		for (int i = 0; i <dao.getIndex(); i++) {
			int sum = dao.getSum(dao.getStudentDTO(i));
			float avg = sum / 3.0f;
			System.out.println(dao.getStudentDTO(i).getName()+"\t"+
					dao.getStudentDTO(i).getKorean()+"\t"+
					dao.getStudentDTO(i).getMath()+"\t"+
					dao.getStudentDTO(i).getEnglish()+"\t"+
								sum+"\t"+
								avg+"\t");
		}
		
		
	}
}
