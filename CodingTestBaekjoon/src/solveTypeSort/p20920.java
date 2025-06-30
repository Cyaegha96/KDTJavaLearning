package solveTypeSort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.StringTokenizer;


//p20920 영단어 암기는 괴로워

public class p20920 {
	
	
	public static class WordComparator implements Comparator<String> {

		Map<String, Integer> hashMap;
		public WordComparator(Map<String, Integer> hashMap) {
			this.hashMap = hashMap;
		}
		
		
		@Override
		public int compare(String o1, String o2) {
			
			int freq1 = hashMap.getOrDefault(o1, 0);
			int freq2 = hashMap.getOrDefault(o2, 0);
			
			//자주 나오는 단어일수록 앞에 배치한다.
			if(freq1 != freq2) {
				return Integer.compare(freq2, freq1);
			}else if(o1.length() != o2.length()){
			//해당 단어의 길이가 길 수록 앞에 배치한다.
				return Integer.compare( o2.length(),o1.length());
			
			}
			return o1.compareTo(o2);
		}
		
	}
		
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer((bf.readLine()));
		int n=0, m=0;
		
		List<String> wordList = new ArrayList<>();
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		
		while(st.hasMoreTokens()) {
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			String word = bf.readLine();
			if(word.length() >= m) {
				hashMap.put(word, hashMap.getOrDefault(word, 0) +1);
				if(hashMap.get(word) == 1) {
					wordList.add(word);
				}
			}			
		}
		
		Collections.sort(wordList, new WordComparator(hashMap));
		
		for(String result: wordList) {
			bw.write(result+"\n");
		}
		bw.flush();
		
	}
}
