package exam;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class ExamEx2 {
   public static void main(String[] args) throws Exception{

      new Contdown2().start();

      List<String> words = new ArrayList<>();
      words.add("은경이의 생일은 몇 월? (MM)으로 입력");
      words.add("은경이의 생일은 몇 일? (dd)으로 입력");
      words.add("은경이의 띠는? (힌트 : 99년생)");
      words.add("은경이의 별자리는?");
      words.add("은경이의 키는? (숫자로만 입력)");

      int level = 1;
      int j = 0;
      
      
      while(true) {
         String msg = JOptionPane.showInputDialog(words.get(j));
         
         if(words.get(j) == words.get(0)) {
            // 1번 문제
            if(msg.equals("07") ||msg.equals("7")) {
               System.out.println("★★★★ 정답 ! ★★★★");
               System.out.println("Time + 8초");
               System.out.println((level + 1) + "단계로 넘어갑니다.");
               Contdown2.i += 8;
               level++;
               j ++;
            }else if(Contdown2.i > 0) {
               System.out.println("실패 ㅡㅡ");
               System.out.println("3초 감소 ~~~");
               Contdown2.i -= 3;
            }else {
               System.out.println("실패 ㅡㅡ");
               System.out.println("분발하세요 !");
               System.exit(0);
            }

         }else if(words.get(j) == words.get(1)) {
            // 2번 문제
            if(msg.equals("28")) {
               System.out.println("★★★★ 정답 ! ★★★★");
               System.out.println("Time + 8초");
               System.out.println((level + 1) + "단계로 넘어갑니다.");
               Contdown2.i += 8;
               level++;
               j ++;
            }else if(Contdown2.i > 0) {
               System.out.println("실패 ㅡㅡ");
               System.out.println("3초 감소 ~~~");
               Contdown2.i -= 3;
            }else {
               System.out.println("실패 ㅡㅡ");
               System.out.println("분발하세요 !");
               System.exit(0);
            }
         }else if(words.get(j) == words.get(2)) {
            // 3번 문제
            if(msg.equals("토끼") || msg.equals("토끼띠")) {
               System.out.println("★★★★ 정답 ! ★★★★");
               System.out.println("Time + 8초");
               System.out.println((level + 1) + "단계로 넘어갑니다.");
               Contdown2.i += 8;
               j ++;
               level++;
            }else if(Contdown2.i > 0) {
               System.out.println("실패 ㅡㅡ");
               System.out.println("3초 감소 ~~~");
               Contdown2.i -= 3;
            }else {
               System.out.println("실패 ㅡㅡ");
               System.out.println("분발하세요 !");
               System.exit(0);
            }
         }else if(words.get(j) == words.get(3)) {
            // 4번 문제
            if(msg.equals("사자") || msg.equals("사자자리")) {
               System.out.println("★★★★ 정답 ! ★★★★");
               System.out.println("Time + 8초");
               System.out.println((level + 1) + "단계로 넘어갑니다.");
               Contdown2.i += 8;
               j ++;
               level++;
            }else if(Contdown2.i > 0) {
               System.out.println("실패 ㅡㅡ");
               System.out.println("3초 감소 ~~~");
               Contdown2.i -= 3;
            }else {
               System.out.println("실패 ㅡㅡ");
               System.out.println("분발하세요 !");
               System.exit(0);
            }
         }else if(words.get(j) == words.get(4)) {
            // 5번 문제
            if(msg.equals("161")) {
               System.out.println("★★★★ 정답 ! ★★★★");
               System.out.println("★★★★★★★★★★★★★★★★");
               System.out.println("★★★★ 축 하 축 하 ★★★★");
               System.out.println("★★★★★★★★★★★★★★★★");
               System.exit(0);
            }else if(Contdown2.i > 0) {
               System.out.println("실패 ㅡㅡ");
               System.out.println("3초 감소 ~~~");
               Contdown2.i -= 3;
            }else {
               System.out.println("실패 ㅡㅡ");
               System.out.println("분발하세요 !");
               System.exit(0);
            }
         }


      }
   }

}
























class Contdown2 extends Thread {

   public static int i = 0;

   public void run() {      
      // 카운트다운

      for(i = 10; i > 0; i --) {
         System.out.println(i);
         try {
            Thread.sleep(1000);
         }catch(Exception e) {

         }
      }

      System.out.println("땡 ! 시간 초과 !!! 실패입니다.");
      System.exit(0);


   }
}
