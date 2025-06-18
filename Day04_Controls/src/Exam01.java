
public class Exam01 {

	public static void main(String[] args) {
		
//		1/5 = 0
//	    1%5 = 1
//	    2%5 = 2
//	    3%5 = 3
//	    4%5 = 4
//	    5%5 = 0
//      6/5 = 1
//      6%5 = 1

		int i=0;
		while(i<25) {
			i++;
			System.out.print(i+" ");
			if(i%5==0) {
				System.out.println();
			}
		}

	}

}
