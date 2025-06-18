
public class Exam04 {
	public static void main(String[] args) {
//		int a= 30;
//		int b = 50;
//		System.out.println(a + ":" + b);
//		int tmp =a;
//		a = b;
//		b= tmp;
//		System.out.println(a+ ":" + b);
		
		char[] c = {'A' , 'B'};
		char temp;
		
		System.out.println(c[0] + ":" + c[1]);
		temp = c[0];
		c[0] =  c[1];
		c[1] = temp;
		System.out.println(c[0] + ":" + c[1]);
		
	}
}
