package solveTypeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p1269 {
public static void main(String[] args) throws IOException {
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st; 
	st= new StringTokenizer(bf.readLine());
	
	
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	
	
	Set<Integer> arr1 = new HashSet<>();
	Set<Integer> arr2= new HashSet<>();
	
	st= new StringTokenizer(bf.readLine());
	
	for(int i=0;i<n;i++) {
		arr1.add(Integer.parseInt(st.nextToken()));
	}
	
	st= new StringTokenizer(bf.readLine());
	for(int i=0;i<m;i++) {
		arr2.add(Integer.parseInt(st.nextToken()));
	}
	
	//A-B
	Set<Integer> diff1 = new HashSet<>(arr1);
	diff1.removeAll(arr2);
	
	//B-A
	Set<Integer> diff2 = new HashSet<>(arr2);
	diff2.removeAll(arr1);
	
	
	System.out.println(diff1.size() + diff2.size());
}
}
