package supermarket.ui;

import supermarket.management.SupermarketManager;

import javax.swing.*;

public class GUI_Frame extends JFrame {
    private AdminInventory adminInventory;
    private SupermarketManager manager;

    public GUI_Frame() {
        super(" Supermarket System ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 600);

        adminInventory = new AdminInventory("logins.txt");
        manager = new SupermarketManager();

        setContentPane(new GUI_Login_Page(this, adminInventory, manager));
        setVisible(true);
    }

    public void showGUI_Main_Page() {
        setContentPane(new GUI_Main_Page(this, manager));
        revalidate();
    }

    public void showGUI_Login_Page() {
        setContentPane(new GUI_Login_Page(this, adminInventory, manager));
        revalidate();
    }




}
