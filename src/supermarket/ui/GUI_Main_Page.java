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

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        // ===== Title (north) =====
        JLabel titleLabel = new JLabel("Supermarket Manager System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);

        // ===== Buttons (center) =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 150, 20, 150));

        JButton addProductBtn = new JButton("Add Product");
        JButton viewProductsBtn = new JButton("View Products");
        JButton deleteProductBtn = new JButton("Delete Product");
        JButton updateStockBtn = new JButton("Update Stock");
        JButton recentActivityBtn = new JButton("Recent Activities");
        JButton exitBtn = new JButton("Exit");

        buttonPanel.add(addProductBtn);
        buttonPanel.add(viewProductsBtn);
        buttonPanel.add(deleteProductBtn);
        buttonPanel.add(updateStockBtn);
        buttonPanel.add(recentActivityBtn);

        buttonPanel.add(exitBtn);
        exitBtn.addActionListener(e -> System.exit(0));

        add(buttonPanel, BorderLayout.CENTER);











    }


}
