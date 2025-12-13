package supermarket;

/* import supermarket.ui.ConsoleUI; */ // This was originally for the console

import supermarket.ui.GUI_Frame;

import javax.swing.*;

public class Main {
    public static void main (String[] args){

        SwingUtilities.invokeLater(() -> {
            new GUI_Frame();
        });



/* Console
        AdminInventory app = new AdminInventory();

        app.run();



 */

    }
}
