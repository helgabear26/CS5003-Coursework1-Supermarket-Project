package supermarket.ui;

import supermarket.management.SupermarketManager;

import javax.swing.*;
import java.awt.*;

// The GUI_Login_Page extends JPanel meaning that it was added to the JFrame
public class GUI_Login_Page extends JPanel {

    // Allows the panel to interact with the main frame
    private GUI_Frame frame;

    // Used to validate, save and manage admin login credentials
    private AdminInventory adminInventory;

    // Allows access to supermarket data
    private SupermarketManager manager;

    // Constructor for the GUI_Login_Page accepts to the main frame, admin inventory and supermarket manager
    public GUI_Login_Page(GUI_Frame frame, AdminInventory adminInventory, SupermarketManager manager) {

        // Stores the frame reference in this class
        this.frame = frame;

        // Stores the AdminInventory reference for validating and saving logins
        this.adminInventory = adminInventory;

        // Stores the SupermarketManger REFERENCE
        this.manager = manager;

        // Sets the layout of this panel to FlowLayout
        // Components will be added left-to-right and top to bottom
        setLayout(new FlowLayout());

        // Creates a text field for the username input with a width of 20 characters
        JTextField usernameField = new JTextField(20);

        // Creates a text field for the password input with a width of 20 characters
        JPasswordField passwordField = new JPasswordField(20);

        // Creates a Login button that will trigger login validation
        JButton loginButton = new JButton("Login");

        // Creates a Reset button to clear inputs
        JButton resetButton = new JButton("Reset");

        // Creates a Sign-Up button that accepts new credentials
        JButton signUpButton = new JButton("Sign Up");

        // Adds a label to the panel
        add(new JLabel("Username: "));

        // Adds a username text field to the panel
        add(usernameField);

        // Adds a label to the panel
        add(new JLabel("Password: "));

        // Adds a password button to the panel
        add(passwordField);

        // Adds the login button to the panel
        add(loginButton);

        // Adds the reset button to the panel
        add(resetButton);

        // Adds the sign-up button to the panel
        add(signUpButton);

        // Adds an action listener to the login button
        // This code runs when the login button is clicked
        loginButton.addActionListener(e -> {

            // Retrieves the text entered in the username field
            String username = usernameField.getText();

            // Retrieves the text entered in the password field
            String password = new String(passwordField.getPassword());

            // Checks if the entered username and password are valid
            if (adminInventory.validate(username, password)) {

                // Shows a pop-up message to confirm login was successful
                JOptionPane.showMessageDialog(frame,"Login Successful.");

                // Switches the main frame to the main GUI page
                frame.showGUI_Main_Page();

            } else {

                // Shows a pop-up message if the credentials are invalid
                JOptionPane.showMessageDialog(frame, "Non-valid input. Try again! ");
            }
        });

        // Adds an action listner to the reset button which will run when the button is clicked
        resetButton.addActionListener(e -> {

           //  Clears the username and password fields
            usernameField.setText("");
            passwordField.setText("");
        });

        // Adds action listener to the sign-up button which runs when the button is clicked
        signUpButton.addActionListener(e -> {

            // Retrieves the text entered in the username and password field
            String newUsername = usernameField.getText();
            String newPassword = new String(passwordField.getPassword());

            // Checks if either the username or the password field are empty
            if(newUsername.isBlank() || newPassword.isBlank()) {

                // Shows a message dialog prompting the user to log in if the fields are blank
                JOptionPane.showMessageDialog(frame, "Credentials already exist. Log in! ");
            } else {

                // Saves the new admin account using AdminInventory
                adminInventory.saveAdmin(newUsername, newPassword);

                // Shows a new message confirming account creation
                JOptionPane.showMessageDialog(frame, "Account created successfully! ");

                // Clears the input fields after account creation
                usernameField.setText("");
                passwordField.setText("");

            }
        });

    }


}
