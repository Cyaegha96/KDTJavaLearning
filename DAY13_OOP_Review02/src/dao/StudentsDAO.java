package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dto.StudentsDTO;

public class StudentsDAO {
	
	
	static final int START_INDEX=1001;
	
	List<StudentsDTO> students = new ArrayList<>();
	
	public boolean isStudentID(int id) {
		for(StudentsDTO student:students) {
			if(student.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteStudent(int bufferId) {
		int index = bufferId - START_INDEX;
		
		students.remove(index);
		for(int i=index;i<students.size();i++) {
			students.get(i).setId(students.get(i).getId()-1);
		}
		
		
	}
	
	public void updateStudent(int id,String bufferName, int bufferKorean, int bufferEnglish, int bufferMath, Date bufferDate) {
		int index = id - START_INDEX;
		StudentsDTO student = students.get(index);
		student.setName(bufferName);
		student.setKoreanScore(index);
		student.setEnglishScore(index);
		student.setMathScore(index);
		student.setEvaluationDate(bufferDate);
	}
	
	
	public List<StudentsDTO> searchByName(String name){
		
		List<StudentsDTO> result = new ArrayList<StudentsDTO>();
		for(StudentsDTO student:students) {
			if(student.getName().contains(name)) {
				result.add(student);
			}
		}
		
		return result;
	}
	
	
	public List<StudentsDTO> getStudents(){
		return students;
	}
	
	public int getSum(StudentsDTO dto){
		return dto.getKoreanScore() + dto.getEnglishScore()+dto.getMathScore();
	}
	
	public double getAvg(StudentsDTO dto){
		return getSum(dto)/3.0;
	}
	
	public int howManyStudents() {
		return students.size();
	}
	
	public void addStudent(String name, int koreanScore, int englishScore, int mathScore, Date evaluationDate) {
		students.add(new StudentsDTO(START_INDEX+howManyStudents(), name, koreanScore, englishScore, mathScore, evaluationDate));
	}

}
