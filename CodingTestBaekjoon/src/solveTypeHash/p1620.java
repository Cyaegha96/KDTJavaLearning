package solveTypeHash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터
public class p1620 {
	
	 public static boolean isNumeric(String str) {
	        if (str == null || str.isEmpty()) return false;
	        try {
	            Integer.parseInt(str); // 정수 판별
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		 HashMap<String, String> pokemons = new HashMap<String, String>();
		 HashMap<String, String> pokemonsNum = new HashMap<String, String>();
		
		//도감내용
		for(int i=1;i<=n;i++) {
			String pokemonString = bf.readLine();
			pokemons.put(pokemonString,i+"");
			pokemonsNum.put(i+"", pokemonString);
			
		}
		
		
		//문제내용
		String[] question = new String[m];
		for(int i=0;i<m;i++) {
			question[i] = bf.readLine();
			
		}
		for(int i=0;i<m;i++) {
			if(isNumeric(question[i])) {
				//숫자로 들어오면
				System.out.println(pokemonsNum.get(question[i]));
				
			}else {
				//문자로 들어오면
				System.out.println(pokemons.get(question[i]));;
			}
			
		}
	}
}
