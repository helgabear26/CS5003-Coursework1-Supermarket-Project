package supermarket.ui;

import supermarket.management.SupermarketManager;

import javax.swing.*;
import java.awt.*;

public class GUI_Main_Page extends JPanel {

    private GUI_Frame frame;
    private SupermarketManager manager;

    public GUI_Main_Page(GUI_Frame frame, SupermarketManager manager){
        this.frame = frame;
        this.manager = manager;

        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel welcomePage = new JLabel("Hello! ");

        add(welcomePage);



    }


}
