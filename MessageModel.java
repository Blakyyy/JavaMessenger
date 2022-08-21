import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class MessageModel implements ChatView{
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    Scanner scan = new Scanner(System.in);
    
    @Override
    public ArrayList<String> startChat(UsersModel u1, UsersModel u2) throws FileNotFoundException {
       File csvFile = new File("ChatInfo.csv");
       PrintWriter out = new PrintWriter(csvFile);
       ArrayList<String> listmsg = new ArrayList<>();
       System.out.println(formatter.format(date));
       int startchat = 1;
       int turn = 1;
       String continueChat = "yes";
       while (startchat == 1 && continueChat.equalsIgnoreCase("yes")) {
            if(turn == 1 && continueChat.equals("yes")) {
                System.out.println(u1.getUsername() + ":");
                String msg = scan.nextLine();
                System.out.println(" ");
                listmsg.add(u1.getUsername() + ":" + msg + ";");
                turn = 2;                
                System.out.println("Do you want to continue chatting?(yes/no): ");
                System.out.println(" ");
                continueChat  = scan.nextLine();
                System.out.println(" ");
            }
            else if (turn == 2 && continueChat.equalsIgnoreCase("yes")) {
                System.out.println(u2.getUsername() + ":");
                String msg2 = scan.nextLine();
                System.out.println(" ");
                listmsg.add(u2.getUsername() + ":" + msg2 + ";");
                turn = 1;
                System.out.println("Do you want to continue chatting?(yes/no): ");
                System.out.println(" ");
                continueChat = scan.nextLine();
                System.out.println(" ");
                
            }

       }
       for (String str : listmsg) {
        out.println(str);
       }
       out.close();
       return listmsg;
       
    }


}
