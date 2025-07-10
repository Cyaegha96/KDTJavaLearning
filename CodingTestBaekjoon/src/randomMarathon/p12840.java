package randomMarathon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;

//창용이의 시계
public class p12840 {
	public static void main(String[] args) throws IOException, ParseException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String hms  = br.readLine();
		StringTokenizer st = new StringTokenizer(hms);
		SimpleDateFormat sdf = new SimpleDateFormat("H m s");
		
		long time = sdf.parse(hms).getTime();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			switch (st.nextToken()) {
			case "1":
				time += Long.parseLong(st.nextToken()) * 1000;
				break;
			case "2":
				time -= Long.parseLong(st.nextToken()) * 1000;
				
				break;
			case "3":
				System.out.println(sdf.format(new Date(time)));
				
				break;
			
			}
			
		}
	
	}
}
