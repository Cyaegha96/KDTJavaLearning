package exam;

class Worker extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("Worker"+this.getName()+": " + i);
		}
	}
}

public class Exam01 {
	public static void main(String[] args) {
		//Thread란?
		//일을 처리하는 단위
		
		//멀티 쓰레드 구현을 위한 Steps
		//1. Thread 클래스를 상속받는 사용자 정의 클래스 구현
		
		//2. Thread 클래스로부터 상속받은 public void run() 메서드를 오버라이드한다.
		
		
		Thread thread1 = new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("Thread1: " + i);
			}
			
		});
		thread1.start();
		
		Thread thread2 = new Thread(()->{
			for(int i=0;i<100;i++) {
				System.out.println("Thread2: " + i);
			}
			
		});
		thread2.start();
		
		Worker w1 = new Worker();
		w1.start();
		
		
		Worker w2 = new Worker();
		w2.start();
		
	}
}
