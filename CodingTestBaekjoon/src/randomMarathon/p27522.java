package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//카트라이더 드리프트
class Kart implements Comparable<Kart>{
	long time;
	String team;
	public Kart(long time, String team) {
		this.time = time;
		this.team = team;
	}
	@Override
	public int compareTo(Kart other) {
		return Long.compare(this.time, other.time);
	}
}

public class p27522 {
	
	
	public static void main(String[] args) throws IOException, ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("m:ss:SSS");
		List<Kart> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		
		for(int i=0;i<8;i++) {
			String lineString = br.readLine();
			st = new StringTokenizer(lineString);
			list.add(new Kart(sf.parse(st.nextToken()).getTime(), st.nextToken()));
		}
		Collections.sort(list);
		
		int redScore= 0;
		int blueScore = 0;
		int[] score = {10, 8, 6, 5, 4, 3, 2, 1};
		int i =0;
		for(Kart kart : list) {
			if(kart.team.equals("R")) {
				redScore += score[i++];
			}else if(kart.team.equals("B")){
				blueScore += score[i++];
			}
		}
		
		if(redScore > blueScore) {
			System.out.println("Red");
		}else if(blueScore > redScore) {
			System.out.println("Blue");
		}
		
	}
}
