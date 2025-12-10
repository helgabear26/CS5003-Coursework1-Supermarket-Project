package supermarket.ui;

import supermarket.management.SupermarketManager;

import javax.swing.*;
import java.awt.*;

public class GUI_Login_Page extends JPanel {

    private GUI_Frame frame;
    private AdminInventory adminInventory;
    private SupermarketManager manager;

    public GUI_Login_Page(GUI_Frame frame, AdminInventory adminInventory, SupermarketManager manager) {
        this.frame = frame;
        this.adminInventory = adminInventory;
        this.manager = manager;

        setLayout(new FlowLayout());

        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        JButton resetButton = new JButton("Reset");
        JButton signUpButton = new JButton("Sign Up");



        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(loginButton);
        add(resetButton);
        add(signUpButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (adminInventory.validate(username, password)) {
                JOptionPane.showMessageDialog(frame,"Login Successful.");
                frame.showGUI_Main_Page();
            } else {
                JOptionPane.showMessageDialog(frame, "Non-valid input. Try again! ");
            }
        });

        resetButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
        });

        signUpButton.addActionListener(e -> {
            String newUsername = usernameField.getText();
            String newPassword = new String(passwordField.getPassword());

            if(newUsername.isBlank() || newPassword.isBlank()) {
                JOptionPane.showMessageDialog(frame, "Credentials already exist. Log in! ");
            } else {
                adminInventory.saveAdmin(newUsername, newPassword);
                JOptionPane.showMessageDialog(frame, "Account created successfully! ");
                usernameField.setText("");
                passwordField.setText("");

            }
        });

    }


}
