import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p25206 {
	//너의 평점은
	public static void main(String[] args) throws IOException {
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer;
		System.out.println();
		float[] scoreList = new float[20];
		String[] gradeList = new String[20]; 
		float sumClass = 0; //학점 x 과목 평점
		float sumMax = 0; //학점의 총합
		
		for (int i = 0; i < 20; i++) {
			stringTokenizer = new StringTokenizer(bfReader.readLine());
			
			stringTokenizer.nextToken();
			scoreList[i] = Float.parseFloat(stringTokenizer.nextToken());
			gradeList[i] = stringTokenizer.nextToken();
			
			if(gradeList[i].equals("A+") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 4.5);
				
			}else if(gradeList[i].equals("A0") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 4.0);
			
			}else if(gradeList[i].equals("B+") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 3.5);
			
			}else if(gradeList[i].equals("B0") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 3.0);
				
			}else if(gradeList[i].equals("C+") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 2.5);
			
			}else if(gradeList[i].equals("C0") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 2.0);
	
			}else if(gradeList[i].equals("D+") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 1.5);
				
			}else if(gradeList[i].equals("D0") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 1.0);
				
			}else if(gradeList[i].equals("F") ) {
				sumClass = (float) (sumClass + ((float)scoreList[i]) * 0.0);
				
			}
			
			if(!(gradeList[i].equals("P"))) {
				sumMax += scoreList[i];
			}
			
		}
		System.out.printf("%.6f",sumClass / sumMax);

		


	}

}
