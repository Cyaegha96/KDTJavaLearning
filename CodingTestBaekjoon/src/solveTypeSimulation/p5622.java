package solveTypeSimulation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class p5622 {
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = bfReader.readLine();
		int answer = 0;
		
		for(int i =0; i<inputString.length(); i++) {
			char c = inputString.charAt(i);
			if(c=='A' || c=='B'|| c=='C') {
				answer += 3;
			} else if(c=='D' || c=='E'|| c=='F') {
				answer += 4;
			}else if(c=='G' || c=='H'|| c=='I') {
				answer += 5;
			}else if(c=='J' || c=='K'|| c=='L') {
				answer += 6;
			}else if(c=='M' || c=='N'|| c=='O') {
				answer += 7;
			}else if(c=='P' || c=='Q'|| c=='R'|| c=='S') {
				answer += 8;
			}else if(c=='T' || c=='U'|| c=='V') {
				answer += 9;
			}
			else if(c=='W' || c=='X'|| c=='Y'|| c=='Z') {
				answer += 10;
			}else {
				answer +=2;
			}
		}
		System.out.println(answer);
		
	}
}
