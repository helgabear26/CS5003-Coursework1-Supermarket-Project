package supermarket;

/* import supermarket.ui.ConsoleUI; */ // This was originally for the console

import supermarket.ui.GUI_Frame;

import javax.swing.*;

public class Main {
    public static void main (String[] args){

        // Ensures that the GUI is created and updated on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {

            // Creates a new instance of GUI_Frame which opens the main GUI window
            new GUI_Frame();
        });



/* Console
        AdminInventory app = new AdminInventory();

        app.run();
 */

    }
}
