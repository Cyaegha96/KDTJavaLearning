package exams;


class Animal {
	String nameString;
	int age;
	
	void bark() {
		System.out.println("야옹");
	}
}

class Cat extends Animal{
	
	
	
	void bark() {
		System.out.println("월월");
	}
}


class A{
void funcA() {
	System.out.println("func A입니다.");	
	}
}

class B extends A{
	void funcB() {
		System.out.println("func B입니다.");
	}
}


public class Exam01 {
	public static void main(String[] args) {
		
		// 다형성 (형상이 많은 성질)
		//1 클래스 간 상속 관계에서 부모 클래스의 참조 변수는 
		//자신을 상속받는 자식클래스 인스턴스의 
		//주소를 저장할 수 있다.
		
		//다형성을 가진 변수를 참조하면, 참조변수 자료형만큼만 접근되는 것이 기본 RULE
		
		//자식 인스턴스의 모든 기능이 필요하다면, 다운 캐스팅을 통해 사용가능.
		
		//overriding 된 메서드는 다운 캐스팅 없이 자식 인스턴스의 기능 사용가능.
		
		Animal animal = new Cat();
		
		animal.bark();
		
		A a= new B();
		a.funcA();
		((B)a).funcB();
		
		
	}
}
