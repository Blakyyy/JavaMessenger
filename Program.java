import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        UsersModel ad = new UsersModel("admin", "admin");
        UsersModel me = new UsersModel("dam", "ok");
        MessageModel mm = new MessageModel();
        mm.startChat(ad, me);
    }
}

