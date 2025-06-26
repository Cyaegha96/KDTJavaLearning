package solveDoing;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class p11478 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String problem = scanner.nextLine();
		
		Set<String> subStringSet  = new HashSet<>();
		
		for(int i = 0;i<=problem.length();i++) {
			for(int j=i;j<=problem.length();j++) {
				if(!problem.substring(i,j).isEmpty())
				subStringSet.add(problem.substring(i,j));
			}
		}
		
		List<String> resultList = new ArrayList<String>(subStringSet);
		
		System.out.println(resultList.size());
		
	}
}
