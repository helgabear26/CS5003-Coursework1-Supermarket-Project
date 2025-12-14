package supermarket.ui;

import supermarket.management.SupermarketManager;

import javax.swing.*;

// Declares the public class GUI_Frame which extends JFrame so it opens a new window in a Swing application
public class GUI_Frame extends JFrame {

    // Stores and manages admin login credentials
    private AdminInventory adminInventory;

    // Declares the SupermarketManager object which manages products, inventory and supermarket actions and activities
    private SupermarketManager manager;

    // Constructor for this class which runs when a GUI_Frame object is created
    public GUI_Frame() {

        // Calls the constructor from the parent JFrame class and sets the window title
        super(" Supermarket System ");

        // Allows the application to exit completely when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Sets the width and height of the window
        setSize(400, 600);

        // Creates an AdminInventory object that loads login data from the logins.txt file
        adminInventory = new AdminInventory("logins.txt");

        // Creates a new SupermarketManger object to control the supermarket logic
        manager = new SupermarketManager();

        // Sets the initial window as the login page
        setContentPane(new GUI_Login_Page(this, adminInventory, manager));

        // Removes any menu bar while the login page is being displayed
        setJMenuBar(null);

        // Makes the window visible on the screen
        setVisible(true);
    }

    // Method that switches the GUI from the login page to the main page after a successful login
    public void showGUI_Main_Page() {

        // Changes the content of the window to the main page
        setContentPane(new GUI_Main_Page(this, manager));

        // Adds the menu bar to the main page
        setJMenuBar(menuBar());

        // Updates the UI
        revalidate();

        // Repaints so the new content is visible
        repaint();
    }

    // Method to create and return the menu bar and only shows it on the main page
    private JMenuBar menuBar() {

        // Creates a JMenuBar
        JMenuBar menuBar = new JMenuBar();

        // Creates a File menu
        JMenu fileMenu = new JMenu("File");

        // Creates a Save menu item
        JMenuItem saveActions = new JMenuItem("Save");

        // Adds the Save menu item to the File menu
        fileMenu.add(saveActions);

        // Adds file menu to the menu bar
        menuBar.add(fileMenu);

        // Creates a new object to control the Save functionality
        SaveMenuBarFunction save = new SaveMenuBarFunction();

        // Adds an action listener to the Save menu item which runs when the user clicks Save
        saveActions.addActionListener(e -> {

            // Calls the save method to store supermarket activities in a file
            save.saveActivities(manager,"SaveActivities.txt");

            // Dispays a pop-up message confirming the save was successful
            JOptionPane.showMessageDialog(this, "Products have been successfully saved! ", "Save action confirmed", JOptionPane.INFORMATION_MESSAGE);
        });

        // Returns the completed menu bar
        return menuBar;
    }




}
