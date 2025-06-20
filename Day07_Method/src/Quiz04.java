
public class Quiz04 {

	public static int countChar(String str, char target) {
		
//		int count = 0;
//		for(int i=0;i<str.length();i++) {
//			if(str.charAt(i) == c) {
//				count++;
//			}
//		}
//		return count;
		int count = str.length();
		String token = target+"";
		String[] arr = str.split(token);
		for(int i=0; i<arr.length; i++) {
			count -= arr[i].length();
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "AlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEIL";
	
		int result = countChar(str, 'a');// 알파벳 A의 개수를 세서 반환하는 함수
		System.out.println(result); 
		
		str = "AbefdAfAAAA";
		
		result = countChar(str, 'A');// 알파벳 A의 개수를 세서 반환하는 함수
		System.out.println(result); 
		
		str = "AAAAAAAAA";
		
		result = countChar(str, 'A');// 알파벳 A의 개수를 세서 반환하는 함수
		System.out.println(result); 
	
	}

}
