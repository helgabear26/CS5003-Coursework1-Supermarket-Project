package supermarket.ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


// This class is responsible for storing and managing admin login credentials
public class AdminInventory {

    // Declares a private HashMap called 'admin'
    // It stores a username and password as a string.
    private HashMap<String, String> admin = new HashMap<>();

    // This stores the file path where the admin's login credentials are saved
    private String logins;

    // Constructor for the AdminInventory class which runs when an AdminInventory object is created
    public AdminInventory(String logins) {

        // Assigns the value passed into the constructor to the instance variable which allows the class to remember which file to use
        this.logins = logins;

        // Calls the method that loads existing admin login details from the file
        loadLoginsFromFile();
    }

    // Method that checks whether a username or password combination is valid
    // Returns true if valid or false if it is not
    public boolean validate(String username, String password ) {

        // Retrieves the stored password from the given username from the HashMap
        // trim() removes extra spaces from the username
        String passwords = admin.get(username.trim());
        return passwords != null && passwords.equals(password.trim());
    }

    // Method that checks if a username already exists and returns true if the username already exists in the HashMap
    public boolean exists(String username) {

        // Checks if the HashMap contains the given username as a key
        return admin.containsKey(username.trim()); // trim() removes any spaces
    }

    // Method that saves a new username and password when signing up
    public void saveAdmin(String usernames, String passwords) {

        // Stores the username and password in the HashMap
        // trim() ensures there are no unwanted spaces
        admin.put(usernames.trim(), passwords.trim());

        // Writes the username and password to the file by opening FileWriter in append mode so data is added to the end of the file
        try(FileWriter adminLoginInstances = new FileWriter(logins, true)) {

            // Writes the username and password separated by a comma followed by a new line so all the admin credentials have their own line in the .txt file
            adminLoginInstances.write(usernames + "," + passwords + "\n");
        }

        // Catches any errors that occur whole writing the file
        catch (IOException e) {

            // Prints this error message if it fails to save
            System.err.println("User could not be saved: " + e.getMessage());
        }
    }

    // Loads admin login credentials from the file
    private void loadLoginsFromFile() {

        // Tries to open the file using BufferedReader.
        try (BufferedReader adminLogins = new BufferedReader(new FileReader(logins))) {

            // Declares the variable to store each line read from the file
            String line;

            // Reads each line from the file until there are no more lines
            while ((line = adminLogins.readLine()) != null) {

                // Splits the line into parts using a comma
                String [] parts = line.split(",");

                // Checks that the line has exactly two bits, a username and a password
                if(parts.length == 2) {

                    // Extracts and trims the username
                    String username = parts[0].trim();

                    // Same thing done to the password
                    String password = parts[1].trim();

                    // Stores the username and password in the HashMap
                    admin.put(username, password);
                }
            }

            // Prints the loaded admin accounts for debugging
            System.out.println("Loaded the admins logged in: " + admin);
        } catch (IOException e) {

            // Executes if the file does not exist or cannot be read preventing the program from crashing
            System.out.println("No existing admin file found. Try again! ");
        }
    }
}
