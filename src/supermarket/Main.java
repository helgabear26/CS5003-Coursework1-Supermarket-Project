package supermarket;

/* import supermarket.ui.ConsoleUI; */
import supermarket.ui.AdminInventory;
import supermarket.ui.GUI_Frame;

import javax.swing.*;

public class Main {
    public static void main (String[] args){

        SwingUtilities.invokeLater(() -> {
            new GUI_Frame();
        });



/*
        AdminInventory app = new AdminInventory();

        app.run();



 */

    }
}
