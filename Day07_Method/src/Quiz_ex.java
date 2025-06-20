public class Quiz_ex {
   public static int countWord(String str, String target) //jjava
   {
      int count =0;
      String newString = str;
      while(true) {
    	  	  
    	 int n= str.indexOf(target);
    	 
    	 if(n==-1) {
    		 break;
    	 }else if(newString.equals(target)){
    		 
    		 count++;
    		 System.out.println(count+"번째: "+newString);
    		 break;
    	 }else {    		 
    		 count++;
    		 System.out.println(count+"번째: "+newString.substring(n));;
    		 newString = newString.substring(n+32);	 
    	 } 
      }

      return count;
   }   //split 방법

   public static void main(String[] args) {
      //단톡방에 문자열 하나 올려주심

      String str ="AlkejflsdjJavafaweJJavaoifjdaslfiohwefqiJJaavvaaeffaJJavaaaaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAlkejflsdjfaweoifjdaslfiohwefqieffaewifjdalfaEILFJDLJlwfjLDJfqlfijSLDIfjleIFJDSLJflEIJowfjiSDLfkJlwfjidlSIEjfdiSLIDjflEIfjldskjlEJFLQlfjdLASDFJEILAJava";

      int result = countWord(str,"Java"); 
      System.out.println("정답은");
      System.out.println(result);


   }
}
