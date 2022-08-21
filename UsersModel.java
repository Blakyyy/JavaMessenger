import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class UsersModel implements EntenerAccountView  {
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

    @Override
    public void tryToEnter(UsersModel us) throws FileNotFoundException {
        writetoCsv(us);
        Scanner scanner = new Scanner(System.in);
        int enter = 0;
            while (enter == 0) {
                System.out.println("Please enter username: ");
                String user = scanner.nextLine();
                if (user.equals(this.username))  {
                    String pass = "pass";
                    while(!pass.equals(this.password)) {
                        System.out.println("Please enter password");
                        pass = scanner.nextLine();
                        if(!pass.equals(this.password)) {
                            System.out.println("Password is incorrect, please try again");
                        }
                    }
                    if(pass.equals(this.password)) {
                        System.out.println("You entered. Hello " + this.username);
                        scanner.close();
                        break;
                    }
                }
                else {
                    System.out.println("Usern not found, please try again");
                }
                
        }
        
        }
    }

