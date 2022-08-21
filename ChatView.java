import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface ChatView {
    public ArrayList<String> startChat(UsersModel u1, UsersModel u2) throws FileNotFoundException;
}
