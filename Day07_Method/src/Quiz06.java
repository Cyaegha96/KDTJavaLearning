
public class Quiz06 {

	public static String[] getShortNames(String[] names, int findNum ) {

		String buffer= "";
		for(int i=0;i<names.length;i++) {
			if(names[i].length() <= findNum) {
				buffer+=names[i]+" ";
			}
		}

		return buffer.split(" ");
	}

	public static void main(String[] args) {
		String[] nameStrings = new String[] {"Susan", "Mike", "Tom", "Jane" , "Luke", "Mia"};
		String[] shortNameStrings = getShortNames(nameStrings,4); //해당 숫자보다 적은 길이의 이름만 반환
		
		for(int i=0;i<shortNameStrings.length;i++) {
			System.out.println(shortNameStrings[i]);
		}
	}

}
