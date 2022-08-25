import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class MessageModel implements ChatView{
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public ArrayList<String> startChat(UsersModel u1, UsersModel u2) throws FileNotFoundException {
        File csvFile = new File("ChatInfo.csv");
        PrintWriter out = new PrintWriter(csvFile);
        ArrayList<String> listmsg = new ArrayList<>();
        System.out.println(formatter.format(date));
        int turn = 1;
        int count = 8;
           while (true && count > 0) {
                if(turn == 1 && count > 0) {
                    String msg1;
                    try {
                        msg1 = chatMemebers(u1, count);
                        listmsg.add(u1.getUsername() + ":" + msg1);
                        count--;
                        turn = 2;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if (turn == 2 && count > 0) {
                    String msg2;
                    try {
                        msg2 = chatMemebers(u2, count);
                        listmsg.add(u2.getUsername() + ":" + msg2 + ";");
                        count--;
                        turn = 1;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
           }
           outputChatInfo(listmsg, out);
           return listmsg; 
    }

    private String chatMemebers(UsersModel user, int count) throws IOException {
            System.out.println(count + " messages left");
            System.out.println(" ");
            System.out.println(user.getUsername() + ":");
            String msg = br.readLine();
            System.out.println(" ");
            return msg;       
    }
    private void outputChatInfo(ArrayList<String> listmsg, PrintWriter out) {
        for (String str : listmsg) {
            out.println(str);
           }
           out.close();
    }
    
   
}
