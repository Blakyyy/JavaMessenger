import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        UsersModel ad = new UsersModel("admin", "admin");
        UsersModel me = new UsersModel("dam", "ok");
        MessageModel mm = new MessageModel();
        try {
            mm.startChat(ad, me);
            ad.BanAccount(ad);
            me.tryToEnter(me);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
      
    }
}

