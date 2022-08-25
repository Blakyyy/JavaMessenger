import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UsersModel {
    private String username;
    private String password;
    
    protected UsersModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    private ArrayList<UsersModel> adToArray(UsersModel us) {
        ArrayList<UsersModel> list = new ArrayList<>();
        list.add(us);
        return list;
    }

    private void writetoCsv(UsersModel us) throws FileNotFoundException {
        List<UsersModel> list = adToArray(us);
        File csvFile = new File("Usersinfo.csv");
        PrintWriter out = new PrintWriter(csvFile);
        for (UsersModel user : list ) {
            out.print(user.getUsername() + ";");
            out.print(user.getPassword() + ";");
        }
        out.close();
    }

    public String tryToEnter(UsersModel us) throws IOException  {
        writetoCsv(us);
        List<String> anyAccBan = anyAccountBanned();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Please enter username: ");
                String user = br.readLine();
                if (user.equals(this.username))  {
                    String pass = "pass";
                    while(!pass.equals(this.password)) {
                        System.out.println("Please enter password");
                        pass = br.readLine();
                        if(!pass.equals(this.password)) {
                            System.out.println("Password is incorrect, please try again");
                        }
                    }
                        if (pass.equals(this.password) && !anyAccBan.contains(this.username)) {
                            System.out.println("You entered your account!");
                            break;           
                    }    
                        if(pass.equals(this.password) && anyAccBan.contains(this.username)) {
                            System.out.println("You account has been banned!");
                            break;
                        }
                        else {
                            System.out.println("User not found, please try again");
                            } 
                }
        } return this.username + this.password;
    }
    
    public List<String> BanAccount(UsersModel us) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File bannedFile = new File("BannedAccounts.csv");
        PrintWriter out = new PrintWriter(bannedFile);
        List<String> bannedAcs = new ArrayList<>();
        String enter = tryToEnter(us);
        if(enter.equals("adminadmin")) {
            banningProcces(br, out, bannedAcs);
        }
        return bannedAcs;
    }

    private void banningProcces(BufferedReader br, PrintWriter out, List<String> bannedAcs) throws IOException {
        System.out.println("Hello admin, which person do you want to ban?");
        String personBan = br.readLine();
        bannedAcs.add(personBan);
        System.out.println("What is the reason for ban? ");
        String reason = br.readLine();
        System.out.println(personBan + " has been banned");
        out.println(personBan);
        out.println(reason + ";"); 
        out.close();
    }

    private List<String> anyAccountBanned() {
        List<String> bannedAcsList = new ArrayList<>();
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/danii/OneDrive/Рабочий стол/HomeworkSem5OOP/BannedAccounts.csv"))) {
            while ((line = br.readLine()) != null) {
                bannedAcsList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bannedAcsList;
    }
}

