package exam;
import javax.swing.JOptionPane;


public class ExamEx {
   public static void main(String[] args) throws Exception{

      new Contdown().start();

      // 카운트다운
      for(int i = 10; i > 0; i --) {
         System.out.println(i);
         Thread.sleep(1000);
      }
      System.out.println("땡 ! 시간 초과 !!! 실패입니다.");
      System.exit(0);

   }
}
























class Contdown extends Thread {

   public void run() {
      while(true) {
         String msg = JOptionPane.showInputDialog("은경이의 생일은 ? (MM/dd)로 입력");

         if(msg.equals("0728") ||msg.equals("728")) {
            System.out.println("★★★★ 정답 ! ★★★★");
            System.exit(0);
         }else {
            System.out.println("실패 ㅡㅡ");
            continue;
         }
      }
   }
}