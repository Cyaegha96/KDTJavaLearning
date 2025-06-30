package solveTypeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//³ª¸ÓÁö
public class p3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<10;i++) {
			set.add(Integer.parseInt(bf.readLine())%42);
		}
		
		System.out.println(set.size());
	}
}
