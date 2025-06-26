package models;

import classes.StudentDTO;

public class StudentsDAO {

	private StudentDTO[] students  = new StudentDTO[3];
	private int index=0;
	
	public int getStudentsMany() {
		return students.length;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public void addStudent(StudentDTO studentDTO) {
		this.students[this.index] = studentDTO;
		this.index++;
	}
	
	public StudentDTO getStudentDTO(int index) {
		return this.students[index];
	}
	
	public int getSum(StudentDTO studentsDTO) {
		int sum = studentsDTO.getKorean() + studentsDTO.getEnglish()+studentsDTO.getMath();
		return sum;
	}
	
}
