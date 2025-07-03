package exam;


class PatternMaker extends Thread{

	public PatternMaker(String str) {
		this.setName(str);
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println(this.getName());
		}

	}
}

public class Exam02 {
	public static void main(String[] args) {
		//#을 100개 출력하는 코드
		//$을 100개 출력하는 코드
		//*를 100개 출력하는 코드
		new PatternMaker("#").start();
		new PatternMaker("$").start();
		new PatternMaker("*").start();
		
	}

}
