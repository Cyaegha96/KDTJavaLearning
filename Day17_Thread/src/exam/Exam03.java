package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

class Countdown extends Thread {
	Map<String, String> wordsMap;
	String keyWord;
	String msg;
	
	public Countdown(Map<String, String> wordsMap) {
		
		this.wordsMap= wordsMap;
	}
	
	@Override
	public void run() {
		while(true) {
			int rand = (int) (Math.random()*wordsMap.size());
			List<String> keyStrings = new ArrayList<String>(wordsMap.keySet());
			
			this.keyWord = keyStrings.get(rand);
			this.msg= keyWord+"를 입력하세요\n 뜻:" + wordsMap.get(keyWord);
			
			String pane = JOptionPane.showInputDialog(msg);
			if(pane.equals(keyWord)) {
				System.out.println("성공 : time + 5");
				Exam03.countTime+=5;
			}else {
				System.out.println("실패 : time - 3");
				Exam03.countTime-=3;
			}
		}
		
	}
}


public class Exam03 {
	
	//초기 시작 시간
	public static int countTime=15;

	//카운트 다운 프로그램
	public static void main(String[] args) throws InterruptedException {


		Map<String, String> wordsMap = new HashMap<String, String>();
		

		wordsMap.put("psneumonoultramicroscopicsilicovolcanoconiosis", "화산재처럼 아주 미세한 실리카 먼지를 흡입해 생기는 폐 질환");
		wordsMap.put("supercalifragilisticexpialidociou", "아주 기가 막히게 멋진");
		wordsMap.put("hippopotomonstrosesquipedaliophobia", "긴 단어에 대한 공포증");
		wordsMap.put("floccinaucinihilipilification", "어떤 것을 가치 없다고 여기는 행위. ..아마 이 게임처럼?");
		wordsMap.put("antidisestablishmentarianism", "영국 국교회 분리 반대 운동 (19세기 정치·종교 용어)");
		wordsMap.put("incomprehensibilities", "이해할 수 없음, 이해 불가능한 것들. ..마치 이 게임처럼?");
		wordsMap.put("electroencephalographically", "뇌파 기록 방식으로 ✅ EEG(뇌파 검사)와 관련된 의학 기술 용어.");
		wordsMap.put("thyroparathyroidectomized", "갑상선과 부갑상선을 제거한 상태");
		wordsMap.put("Learning to code improves problem solving skills.", "코딩을 배우는 것은 문제 해결 능력을 향상시킨다.") ;
		
		
		
		
		new Countdown(wordsMap ).start();
		System.out.println("<<<우리가 이걸 알 필요가 있을까요>>>");
		for(;countTime>0;countTime--) {
			System.out.println(countTime);
			Thread.sleep(1000);
		}
		System.out.println("실패");
		System.exit(0);
	}
}
