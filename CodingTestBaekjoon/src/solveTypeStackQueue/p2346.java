package solveTypeStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//«≥º± ≈Õ∆Æ∏Æ±‚
class Ballon{
	int index;
	int next;
	
	public Ballon(int index, int next) {
		this.index = index;
		this.next= next;
	}
	
}


public class p2346 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder builder = new StringBuilder();
		List<Ballon> list = new ArrayList<Ballon>();
		
		for(int i=1;i<=n;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			list.add(new Ballon(i, tmp));
		}
		
		int index =0;
		while(!list.isEmpty()) {
			
			//ª´¥Ÿ¿Ω ∫Ù¥ıø° √ﬂ∞°
			Ballon ballon = list.get(index);
			builder.append(ballon.index+" ");
			
			
			
			int move = ballon.next;
			
			list.remove(index);
			
			if(list.isEmpty()) break;

			if(ballon.next > 0) {
				index = (index + ballon.next -1) % list.size();
			}
			else{
				index  = (index + ballon.next) % list.size();
				if(index < 0) index += list.size();
			}
			
		
		}
		
		System.out.println(builder);

		
	}
}
