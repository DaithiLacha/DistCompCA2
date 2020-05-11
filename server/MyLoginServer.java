import com.distinct.rpc.*; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyLoginServer extends LOGINPROGServer {
    static ArrayList<String> loggedInUsers = new ArrayList<>();

    public static void main(String[] args) {
        try {
            new MyLoginServer(); 
        } catch (RPCError e) {
            System.out.println(e.getMessage());
        }
    }

    public MyLoginServer() throws RPCError {
        super(7777, true, false, true);
    }

    public String login_1(String username, String password) {
        if(!isUserAlreadyLoggedIn(username)) {
            try (BufferedReader br = new BufferedReader(new FileReader("../Users.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (username.equals(line.substring(0, line.indexOf(':'))) && password.equals(line.substring(line.indexOf(':') + 2))) {
                        loggedInUsers.add(username);
                        return "Login Successful";
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "Login Details Invalid";
        }else {
            return "User already logged in";
        }
    }

    private boolean isUserAlreadyLoggedIn(String username) {
        if(loggedInUsers.contains(username)) {
            return true;
        }
        return false;
    }
}
