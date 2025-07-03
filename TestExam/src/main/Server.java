package Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;

import DAO.GuestBookDAO;
import DAO.MemberDAO;
import DTO.GuestBookDTO;
import DTO.MemberDTO;

class ClientThread extends Thread {
   Socket client;

   public ClientThread(Socket client)
   {
      this.client = client;   
   }

   public void run()
   {
      try
      {
         while(true)
         {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            
            dos.writeUTF("severConnect");
            dos.flush();
            
            String menu = dis.readUTF();   //메뉴 받기
            
            if(menu.equals("1")) 
            {
               dos.writeUTF("loginTry");
               dos.flush();
               String id = dis.readUTF();   // id 받기
               dos.writeUTF("idtrans");
               String password = encrypt(dis.readUTF());   // password 받기

               System.out.println("로그인 시도" + id + " " + password);
               String checkLogin = Server.memberDAO.loginCheck(id,password);
               //login 성공은 true 실패는 false
               if(checkLogin != null)   
               {
                  
                  while(true)
                  {
                     dos.writeUTF("loginSuccess");
                     dos.flush();
                     
                     
                     dos.writeUTF(checkLogin);   //이름 보내주기
                     dos.flush();
                     
                     String guestBookMenu = dis.readUTF();   //방명록 메뉴 받기
                     
                     if(guestBookMenu.equals("1"))
                     {   
                        dos.writeUTF("Menu1");
                        dos.flush();
                        
                        dos.writeUTF(checkLogin);
                        dos.flush();
                        String post = dis.readUTF();   // 글 내용 받기
                        
                        long currentUnixTime = System.currentTimeMillis();
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        String time = sdf.format(currentUnixTime);  //입력받은 시간
                        System.out.println("메뉴1번 저장까지 왔다.");
                        Server.guestBookDAO.addGuestBookDTO(new GuestBookDTO("",post,checkLogin,time));
                        //방명록 남기기 완료
                     }
                     else if(guestBookMenu.equals("2"))
                     {
                        List<GuestBookDTO> guestBookDTOs = Server.guestBookDAO.getGuestBookDTOs();
                        
                        System.out.println("여기까지 온다");
                        dos.writeUTF("Menu2");
                        dos.flush();
                        
                        String str = "";
                        System.out.println("방명록 사이즈는" + guestBookDTOs.size());
                        dos.writeUTF(""+guestBookDTOs.size());   //이름 보내주기
                        dos.flush();
                        for(GuestBookDTO dto : guestBookDTOs)
                        {
                           dos.writeUTF(dto.getNum());
                           dos.writeUTF(dto.getPost());
                           dos.writeUTF(dto.getName());
                           dos.writeUTF(dto.getWriteTime());
                        }
                        dos.flush();
                        
                     }
                     else if(guestBookMenu.equals("3"))
                     {
                        dos.writeUTF("Menu3");
                        dos.flush();
                        
                        String name = dis.readUTF(); //작성자 받기
                        
                        List<GuestBookDTO> searchList = Server.guestBookDAO.searchGuestBook(name);
                        
                        String str = "";
                        dos.writeUTF(""+searchList.size());   // 사이즈 보내주기
                        
                        dos.flush();
                        
                        for(GuestBookDTO dto : searchList)
                        {
                           dos.writeUTF(dto.getNum());
                           dos.writeUTF(dto.getPost());
                           dos.writeUTF(dto.getName());
                           dos.writeUTF(dto.getWriteTime());
                        }
                        dos.flush();
                     }
                     else if(guestBookMenu.equals("4"))
                     {
                        dos.writeUTF("Menu4");
                        dos.flush();
                        
                        String num = dis.readUTF(); //글번호 받기
                        
                        String checkStr = Server.guestBookDAO.deletePost(num);
                        
                        dos.writeUTF(checkStr);
                        dos.flush();
                     }
                  }
                  
               }
               else
               {
                  dos.writeUTF("아이디 또는 비밀번호가 잘못되었습니다.");
                  dos.flush();
               }
            }
            else if(menu.equals("2"))
            {
               dos.writeUTF("JoinTry");
               dos.flush();
               
               String id = dis.readUTF();   // id 받기
               dos.writeUTF("idTry");
               dos.flush();
               
               String password = encrypt(dis.readUTF());   // password 받기
               dos.writeUTF("passTry");
               dos.flush();
               String name = dis.readUTF();
               
               System.out.println(id + " " + password + " " + name);
               MemberDTO memberDTO = new MemberDTO(name,id,password);
               Server.memberDAO.addMemberDTO(memberDTO);
            }

         }
      }
      catch(Exception e){

      }
   }
   
   // =================암호화
   public static String encrypt(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            byte[] digest = md.digest(bytes);
            
            StringBuilder builder = new StringBuilder();
            for (byte b : digest) {
                builder.append(String.format("%02x", b));
            }
            return builder.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 암호화 실패", e);
        }
    }
   
//   public static void main(String[] args) {
//      String result = encrypt("비밀텍스드");
//      System.out.println(result);   
//      //동일한 텍스트를 넣어서 찾는 방법 말고는 찾을 방법이 없다.
//      //단방향 암호화
//      //해싱 알고리즘 취약점. md5 hashing
//      //서로 다른 단어가 동일한 암호가 나올수 있다. 근데 극히 희박하다.
//      //
//   }
}

public class Server {
   public static MemberDAO memberDAO = new MemberDAO();

   public static GuestBookDAO guestBookDAO = new GuestBookDAO(); // 방명록 DAO 받기
   
   
   public static void main(String[] args) throws Exception{
      ServerSocket server = new ServerSocket(30000);

      while(true) {
         try {
            Socket client = server.accept();
            System.out.println(client.getInetAddress() + " 로 부터 접속");

            new ClientThread(client).start();

         }
         catch(Exception e)
         {
            System.out.println("접속 해제");
         }
      }
   }
}

