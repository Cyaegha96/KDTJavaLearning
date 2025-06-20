
public class Exam05 {
	
	public static String func() {
		return "Hello";
	}
	
	public record User(String name, int age) {}
	
	public static void main(String[] args) {
		User user = new User("강성연", 30);
		System.out.println(user.name()+","+ user.age);
		
		func();
		
	}
}
