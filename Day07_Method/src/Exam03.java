
public class Exam03 {
	public static void main(String[] args) {
		
		String str = "Hello!";
		
		System.out.println("문자열의 길이:"+str.length()); //문자열의 길이.
		char a = str.charAt(0);
		System.out.println("특정한 번째의 글자 출력: "+a);
		
		
		
		System.out.println("e의 위치" + str.indexOf("ㅋ"));
		
		if(str.startsWith("Hello")) {
			System.out.println("해당 문자열로 시작합니다.");
		}else {
			System.out.println("해당문자열로 시작하지 않습니다");
		}
		
		if(str.endsWith("o!")){
			System.out.println("해당 문자열로 끝납니다.");
		}else {
			System.out.println("해당문자열로 끝나지 않습니다");
		}
		
		if(str.contains("el")){

			System.out.println("해당 문자열을 포함합니다.");
		}else {
			System.out.println("해당문자열을 포함하지 않습니다");
		}
		
		System.out.println(str.toCharArray());
		
		String[] splitStrings = str.split("e");
		System.out.println(splitStrings[0]  +":"+ splitStrings[1]);
		
	}
}
