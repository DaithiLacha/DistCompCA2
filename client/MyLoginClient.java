// MyLoginClient.java
import java.net.*; 

public class MyLoginClient {
    public static void main(String[] argv) {
        LOGINPROG client; 
        if (argv.length != 3) {
            System.out.println("Incorrect number of args passed. 3 required");
            System.exit(0);
        }
        try {
            client = new LOGINPROG(InetAddress.getByName(argv[0]), 7777, true);
            // client->cl_auth = authsys_create_default();
            String loginStatus = client.login_1(argv[1], argv[2]);
            System.out.println("\n" + loginStatus);
        } catch (Exception e) {
            System.out.println("\nThe Exception is " + e.getMessage());
        }
        System.exit(0);
    }
}