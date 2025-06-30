package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dao.StudentsDAO;
import dto.StudentsDTO;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	static StudentsDAO studentsDAO = new StudentsDAO();
	
	static final String MENU_STRING="MENU";
	static final String INPUT_STUDENT_ID = "ID";
	static final String INPUT_STUDENT_KOREAN = "KOREAN";
	static final String INPUT_STUDENT_ENGLISH = "ENGLISH";
	static final String INPUT_STUDENT_MATH = "MATH";
	static final String INPUT_STUDENT_NAME = "NAME";
	static final String INPUT_MOVIE_DATE="MOVIEDATE";
	
	static boolean studentsCheck() {
		if(studentsDAO.howManyStudents() <1) {
			System.out.println("충분한 학생 정보가 존재하지 않습니다.");
			return true;
		}
		return false;
	}

	
	static String inputString(String selectString) {
		
		String inputString ="";
		
		while(true) {
			switch (selectString) {
			case INPUT_STUDENT_NAME:
				System.out.print("학생 이름:");
				break;
			case INPUT_MOVIE_DATE:
				System.out.print("평가 날짜(yyyy/MM/dd):");
				break;
			default:
				break;
			}
			
			
			inputString = scanner.nextLine();
			if(selectString.equals(INPUT_MOVIE_DATE)) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				try {
					simpleDateFormat.parse(inputString);
					break;
				} catch (ParseException e) {
					System.out.println("제대로 된 날짜를 입력해주세요");
				}
			
			
			}else {
				break;
			}
			
		}

		return inputString;
	}
	
	
	static int inputNumber(String selectString) {
		int num = 0;
		
		while(true) {
			switch (selectString) {
			case MENU_STRING:
				System.out.print(">>");
				break;
			case INPUT_STUDENT_KOREAN:
				System.out.print("국어점수:");
				break;
			case INPUT_STUDENT_ENGLISH:
				System.out.print("영어점수:");
				break;
			case INPUT_STUDENT_MATH:
				System.out.print("수학점수");
				break;
			case INPUT_STUDENT_ID:
				System.out.print("학번:");
				break;
			default:
				break;
			}
			
			try {
				num = Integer.parseInt(scanner.nextLine());
				if(selectString.equals(INPUT_STUDENT_ID) && !studentsDAO.isStudentID(num)) {
					System.out.println("해당되는 학번이 없습니다.");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("제대로된 숫자를 입력해주세요");
			}
		}
		
		
		return num;
	}
	
	static Date ParseStringToDate(String str) throws ParseException {
		return new SimpleDateFormat("yyyy/MM/dd").parse(str);
	}
	
	static void testCase() throws ParseException {
		studentsDAO.addStudent("Tom", 80, 90, 40, 
				ParseStringToDate("2024/08/12"));
		studentsDAO.addStudent("David", 70, 90, 80, 
				ParseStringToDate("2025/11/15"));
		studentsDAO.addStudent("Timy", 100, 90, 80, 
				ParseStringToDate("2025/03/03"));
	
	}
	
	
	static void printStudents(List<StudentsDTO> students) {
		System.out.println("학번\t이름\t국어\t영어\t수학\t합계\t평균\t평가일");
		for(StudentsDTO student: students) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM월 dd일 ss:mm");
			String dateString = sdf.format(student.getEvaluationDate());
			
			System.out.printf("%d\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s\n",
					student.getId(), 
					student.getName(), 
					student.getKoreanScore(), 
					student.getEnglishScore(), 
					student.getMathScore(), 
					studentsDAO.getSum(student),
					studentsDAO.getAvg(student),
					dateString );
		}
		
	}
	
	static void menuList() {
		System.out.println("<< 학생 관리 시스템>>");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 학생 목록 출력");
		System.out.println("3. 학생 정보 검색 (이름으로 검색)");
		System.out.println("4. 학생 정보 삭제 (ID로 삭제)");
		System.out.println("5. 학생 정보 수정(ID로 전체 항목 수정)");
		System.out.println("0> 시스템 종료");
	}
	
	public static void main(String[] args) throws ParseException {
		
		int bufferId = 0;
		String bufferName= "";
		int bufferKorean = 0;
		int bufferEnglish= 0;
		int bufferMath = 0;
		Date bufferDate  = null;
		
		
		testCase();
		
		while(true) {
			menuList();
			
			int menuNum = inputNumber(MENU_STRING);
			switch (menuNum) {
			
			case 1: 
				
				bufferName= inputString(INPUT_STUDENT_NAME);
				bufferKorean = inputNumber(INPUT_STUDENT_KOREAN);
				bufferEnglish = inputNumber(INPUT_STUDENT_ENGLISH);
				bufferMath = inputNumber(INPUT_STUDENT_MATH);
				bufferDate = new SimpleDateFormat("yyyy/MM/dd").parse(inputString(INPUT_MOVIE_DATE));
				
				studentsDAO.addStudent(bufferName,bufferKorean, bufferEnglish, bufferMath, bufferDate);
				
				break;
			case 2: 
				//영화 목록 출력
				if(studentsCheck()) continue;
				
				printStudents(studentsDAO.getStudents());
				break;
			case 3:
				//학생  검색
				if(studentsCheck()) continue;
				System.out.println("<<학생을 이름으로 검색합니다>>");
				bufferName = inputString(INPUT_STUDENT_NAME);
				printStudents(studentsDAO.searchByName(bufferName));
				break;
			case 4:
				//학생 정보 삭제 (id로 삭제)
				if(studentsCheck()) continue;
				printStudents(studentsDAO.getStudents());
				System.out.println("<<삭제할 학생의 id값을 입력해주세요>>");
				
				bufferId = inputNumber(INPUT_STUDENT_ID);
				studentsDAO.deleteStudent(bufferId);
				
				System.out.println("<<삭제 완료>>");
				printStudents(studentsDAO.getStudents());
				break;
				
			case 5:
				//학생 정보 수정
				if(studentsCheck()) continue;
				printStudents(studentsDAO.getStudents());
				System.out.println("<<수정할 학생의 id값을 입력해주세요>>");
				
				bufferId = inputNumber(INPUT_STUDENT_ID);
				
				bufferName= inputString(INPUT_STUDENT_NAME);
				bufferKorean = inputNumber(INPUT_STUDENT_KOREAN);
				bufferEnglish = inputNumber(INPUT_STUDENT_ENGLISH);
				bufferMath = inputNumber(INPUT_STUDENT_MATH);
				bufferDate = new SimpleDateFormat("yyyy/MM/dd").parse(inputString(INPUT_MOVIE_DATE));
				
				studentsDAO.updateStudent(bufferId, bufferName,bufferKorean, bufferEnglish, bufferMath, bufferDate);
				
				System.out.println("<<업데이트 완료>>");
				printStudents(studentsDAO.getStudents());
				
				break;
			case 0:
				System.out.println("<<학생 정보 관리 시스템을 종료합니다.>>");
				System.out.println("...");
				System.out.println("..bye");
				System.exit(0);
				
				break;
			default:
				System.out.println("제대로 된 메뉴 번호를 입력해주세요");
				break;
			}
		}
		
	}
}	
