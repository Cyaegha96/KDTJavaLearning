
public class Exam05 {
	public int a; 			//인스턴스 멤버 변수 (필드) - 인스턴스를 생성해야 존재하는 멤버
	public static int b;	//클래스 멤버 변수 (필드) - 정적 변수
	
	public void funcA() {
		a=10;
		b=20;
	}
	
	public static void funcB() {
	//	a = 10; a는 static 생성 시점에 메모리에 적재되어 있지 않음.
		b= 20;
	}
	
	public static void main(String[] args) {
		Exam05 e1 = new Exam05();
		Exam05 e2 = new Exam05();
		
		e1.b = 10;
		e2.b = 20;
		
		System.out.println(e1.b);
	}
}
