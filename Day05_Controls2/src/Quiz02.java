
public class Quiz02 {
	public static void main(String[] args) {
		
		double rand = Math.random(); 
		System.out.println("0~9까지의 랜덤 수 : "+((int) (rand*10)));
		System.out.println("1~10까지의 랜덤 수 : "+((int)(rand*10)+1));
		System.out.println("20~35까지의 랜덤 수 : "+((int)(rand*16) + 20));
		System.out.println("0 또는 1 : "+((int) (rand *2)));
	}
}
