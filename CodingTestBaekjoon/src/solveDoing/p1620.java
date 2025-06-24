package solveDoing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터
public class p1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Map<String, String> pokemon = new HashMap<>();
		
		//도감내용
		for(int i=1;i<=n;i++) {
			pokemon.put(i+"", bf.readLine().trim());
		}
		
		
		//문제내용
		String[] question = new String[m];
		for(int i=0;i<m;i++) {
			question[i] = bf.readLine();
			
		}
		for(int i=0;i<m;i++) {
			System.out.println(pokemon.get(question[i]));
		}
	}
}
