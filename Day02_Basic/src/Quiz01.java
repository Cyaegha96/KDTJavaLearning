

public class Quiz01 {

	public static void main(String[] args) {

//		byte b = 10;
//		short s = 20;
//		char c = 'A';
//		int i;
//		float f;
//		long l = 100L;
//		
//		s = b;
//		c = (char) b;
//		s = (short) c;
//		c = (char) s;
//		i = (int) 100L;
//		l = 500;
//		f = l;
//		f = (float) 5.11;
		
//		byte b = 10;
//		char ch = 'A';
//		int i = 100;
//		long l = 1000L;
//		
//		b = (byte)i;
//		ch = (char) b;
//		short s = (short) ch;
//		float f = l;
//		i = ch;

		int i1 = 10;
		int i2 = 20;
		float f1= 3.14f;
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println("결과 : " + i1 + i2);
		System.out.println("결과 : " + (i1 + i2));
		System.out.println("결과 : " + i1 + f1);
		System.out.println("결과 : " + (i1 + f1));
		System.out.println("결과 : " + f1 + c1);
		System.out.println("결과 : " + (f1 + c1));
		System.out.println("결과 : " + c1 + c2);
		System.out.println("결과 : " + (c1 + c2));
	
	}

}
