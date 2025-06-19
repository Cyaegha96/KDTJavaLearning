
public class Exam04 {
	public static void main(String[] args) {
		//변수 - 데이터 저장 공간
		//상수 - 고정된 하나의 수
		//난수 - 임의의 수 (Random number)
		
		double rand = Math.random(); //0~1 사이의 예측할 수 없는 double 형 난수 생성
		
		//가정1. 1~10 사이의 난수
		System.out.println((int)(rand*8)+37);
		//random() * (최대값-최소값+1)+ 최소값
		
	}
}
