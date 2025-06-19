
public class Exam02 {

	public static double divide(int num1 ,int num2) {
		double result=0;
		result = (double) num1 / (double)num2;
		return result;
	}
	
	public static int bigger(int num1, int num2) {
		
		if(num1 > num2) {
			return num1;
		}else if(num1 < num2) {
			return num2;
		}else {
			return 0;
		}

	}
	
	//boolean은 반환하는 메서드 명은 보통 의문문으로 작성한다.
	public static boolean isEven(int num) {
		if(num%2 == 0) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		//1. 두 정수를 인자로 전달받아
		//나눗셈한 결과를 소수점까지 포함하여 반환하는 divide 함수를 만들고 사용해보세요
		
		int a=10;
		int b =5;
		
		System.out.println(divide(a,b));
		
		//2. 두 정수를 인자로 전달받아
		//둘 중 더 큰 수를 반환하는 bigger 함수를 만들고 사용해보세요.
		//두 수가 같을 시 0을 반환
		
		System.out.println(bigger(a, b));
		
		//3. 정수 한개를 인자로 전달받아
		//전달 받은 수가 짝수면 true를 홀수면 false를 반환하는 isEven함수를 만들고 사용해보세요.
		
		System.out.println(isEven(a));
	}

}
