package solveTypeHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


//µË∫∏¿‚
public class p1764 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String humanlist =bf.readLine();
		StringTokenizer st = new StringTokenizer(humanlist);
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String[] arr1 = new String[n];
		String[] arr2 = new String[m];
		
		for(int i=0;i<n;i++) {
			arr1[i] = bf.readLine();
		}
		
		for(int i=0;i<m;i++) {
			arr2[i] = bf.readLine();
		}

		Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<String> set2 = new HashSet<>(Arrays.asList(arr2));
       
        set1.retainAll(set2);
        
        List<String> list = new ArrayList<String>(set1);
        Collections.sort(list);
        System.out.println(list.size());
       	for (String string : list) {
			System.out.println(string);
		}
	}
}
