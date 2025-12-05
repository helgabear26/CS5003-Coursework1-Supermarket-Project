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

        add(new JLabel("Username: "));
        add(usernameField);
        add(new JLabel("Password: "));
        add(passwordField);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (adminInventory.validate(username, password)) {
                frame.showGUI_Main_Page();
            } else {
                JOptionPane.showMessageDialog(frame, "Non-valid input. Try again! ");
            }
        });

    }


}
