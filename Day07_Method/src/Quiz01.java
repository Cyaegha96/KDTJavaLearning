/**
 * 난수 생성 관련 기능을 제공하는 클래스입니다.
 */
public class Quiz01 {
	
	public static int getSum(int[] arr) {
		int sum =0;
//		for(int i=0;i<arr.length;i++) {
//			sum += arr[i];
//		}
		for(int num : arr) {
			sum += num;
		}
		return sum;
	}

    /**
     * 1부터 6 사이의 난수를 반환합니다.
     *
     * @return 1 이상 6 이하의 정수 난수
     */
    public static int getRandomDice() {
        return getRandomFrom(1, 6);    
    }

    /**
     * 지정한 범위(min ~ max)의 난수를 생성합니다.
     *
     * @param min 생성할 최소 정수 값
     * @param max 생성할 최대 정수 값
     * @return min 이상 max 이하의 정수 난수
     */
    public static int getRandomFrom(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);        
    }

    /**
     * 프로그램 실행 진입점. 난수 생성 메서드를 호출하여 결과를 출력합니다.
     *
     * @param args 커맨드라인 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
    	
    	//1.	1~6사이의 랜덤 값을 반환하는
    	//getRandomDice 함수를 제작하고 사용해보세요
    	//getRandomDice() // 1~6사이의 난수 반환

    	//2. 최소값과 최대값을 인자로 전달하면
    	//두 수 사이에 있는 랜덤값을 반환하는 getRandomFrom 함수를 제작하고 사용해보세요
    	//ex) getRandomFrom(3,10) // 3~10 사이의 난수 반환

    	// (((중요))) 2번째꺼 만들면 자동으로 첫번재 함수도 만들어짐
    	
    	//3. int형 배열을 인자값으로 전달하면, 배열 내 모든 숫자를 더한 결과를 반환하는 getSum() 제작
    	
        System.out.println(getRandomDice()); //1.
        System.out.println(getRandomFrom(3, 10)); //2. 
        
        int[] arr = new int[] {5,19,23,17};
        int total = getSum(arr);
        System.out.println("배열 값들의 합은: " +total); 
    }
}