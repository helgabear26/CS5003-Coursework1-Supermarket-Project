package supermarket.ui;

import supermarket.inventory.Product;
import supermarket.management.SupermarketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Main_Page extends JPanel implements ActionListener {

    private GUI_Frame frame;
    private SupermarketManager manager;
    private JTextField nameTextfield;
    private JTextField QuantityTextfield;
    private JTextField IDTextField;
    private JTextField ActionTextField;

    public GUI_Main_Page(GUI_Frame frame, SupermarketManager manager){
        this.frame = frame;
        this.manager = manager;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        // ===== Title (North panel) =====
        JLabel titleLabel = new JLabel("Supermarket Manager System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);



        // ===== Buttons =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton addProductBtn = new JButton("Add Product");
        JButton viewProductsBtn = new JButton("View Products");
        JButton deleteProductBtn = new JButton("Delete Product");
        JButton updateStockBtn = new JButton("Update Stock");
        JButton recentActivityBtn = new JButton("Recent Activities");
        JButton exitBtn = new JButton("Exit");
        JButton clearBtn = new JButton("Clear");


        buttonPanel.add(addProductBtn);
        buttonPanel.add(viewProductsBtn);
        buttonPanel.add(deleteProductBtn);
        buttonPanel.add(updateStockBtn);
        buttonPanel.add(recentActivityBtn);

        buttonPanel.add(exitBtn);
        buttonPanel.add(clearBtn);

        clearBtn.addActionListener(this);
        addProductBtn.addActionListener(this);

        exitBtn.addActionListener(e -> System.exit(0));

        add(buttonPanel, BorderLayout.CENTER);

        // ===== Form (Text fields) =====
        JPanel formPanel =  new JPanel();
        formPanel.setLayout(new GridLayout(4,2,10,10));

        JLabel name = new JLabel("Product Name:");
        nameTextfield = new JTextField();

        JLabel ID = new JLabel("Product ID:");
        IDTextField  =  new JTextField();

        JLabel quantity =  new JLabel("Quantity:");
        QuantityTextfield =  new JTextField();

        JLabel action = new JLabel("Action:");
        ActionTextField = new JTextField();

        formPanel.add(name);
        formPanel.add(nameTextfield);
        formPanel.add(ID);
        formPanel.add(IDTextField);
        formPanel.add(quantity);
        formPanel.add(QuantityTextfield);
        formPanel.add(action);
        formPanel.add(ActionTextField);

        add(formPanel, BorderLayout.CENTER);


        // ===== Main area (Center Panel) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 200, 30, 200));

        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalStrut(60)); // space under title
        centerPanel.add(formPanel);                   // text fields under title
        centerPanel.add(Box.createVerticalStrut(60)); // space between form and buttons
        centerPanel.add(buttonPanel);                 // buttons under text fields
        centerPanel.add(Box.createVerticalGlue());    // push content nicely in center

        add(centerPanel, BorderLayout.CENTER);


    }
    public void  actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();

        if (command.equalsIgnoreCase("clear"))
        {
            Clear();
        }
        if (command.equalsIgnoreCase("add product"))
        {
            addProduct();
        }
    }
    public  void  Clear()
    {
        nameTextfield.setText(" ");
        IDTextField.setText(" ");
        QuantityTextfield.setText(" ");
        ActionTextField.setText(" ");
    }
    public  void addProduct() {
        try {


            String ID = IDTextField.getText().trim();
            String name = nameTextfield.getText().trim();
            int Quantity = Integer.parseInt(QuantityTextfield.getText().trim());
            if(nameTextfield.getText().isBlank() &&
                    IDTextField.getText().isBlank()&&
                    QuantityTextfield.getText().isBlank())
            {
                JOptionPane.showMessageDialog(frame,
                        "the text Field is Empty!",
                        "Product",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            manager.addProduct(new Product(Quantity, name, ID));
            JOptionPane.showMessageDialog(frame,
                    "add product\n"+ "was successfully added",
                    "Product",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "please check your details for any error\n"+
                            " some field requried numerical Values",
                    "Product",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }



}
