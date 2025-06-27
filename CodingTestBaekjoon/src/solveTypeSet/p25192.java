package solveTypeSet;

import java.util.HashSet;

import java.util.Scanner;
import java.util.Set;

//√—√—¿Ã
public class p25192 {
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int num = Integer.parseInt(scanner.nextLine());
		
		Set<String> greetSet = new HashSet<String>();
		int result = 0;
		
		for(int i=0;i<num;i++) {
			String lineString = scanner.nextLine();
			
			if(lineString.equals("ENTER")) {
				greetSet.clear();
			}else if(!greetSet.contains(lineString)){
				greetSet.add(lineString);
				result++;
			}
		}
		System.out.println(result);
	}
}
