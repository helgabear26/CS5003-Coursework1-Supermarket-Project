package supermarket.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminInventory {
    private HashMap<String, String> admin = new HashMap<>();
    private String logins;

    public AdminInventory(String logins) {
        this.logins = logins;
        loadLoginsFromFile();
    }

    public boolean validate(String username, String password ) {
        String passwords = admin.get(username.trim());
        return passwords != null && passwords.equals(password.trim());
    }

    public boolean exists(String username) {

        return admin.containsKey(username.trim());
    }

    public void saveAdmin(String usernames, String passwords) {
        admin.put(usernames.trim(), passwords.trim());
        try(FileWriter adminLoginInstances = new FileWriter(logins, true)) {
            adminLoginInstances.write(usernames + "," + passwords + "\n");
        }
        catch (IOException e) {
            System.err.println("User could not be saved: " + e.getMessage());
        }
    }

    private void loadLoginsFromFile() {
        try (BufferedReader adminLogins = new BufferedReader(new FileReader(logins))) {
            String line;
            while ((line = adminLogins.readLine()) != null) {
                String [] parts = line.split(",");
                if(parts.length == 2) {
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                    admin.put(username, password);
                }
            }
            System.out.println("Loaded the admins logged in: " + admin);
        } catch (IOException e) {
            System.out.println("No existing admin file found. Try again! ");
        }
    }
}
