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


        // ===== Title (north) =====
        JLabel titleLabel = new JLabel("Supermarket Manager System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);



        // ===== Buttons (center) =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton addProductBtn = new JButton("Add Product");
        JButton viewProductsBtn = new JButton("View Products");
        JButton deleteProductBtn = new JButton("Delete Product");
        JButton updateStockBtn = new JButton("Update Stock");
        JButton recentActivityBtn = new JButton("Recent Activities");
        JButton exitBtn = new JButton("Exit");
        JButton clearBtn = new JButton("clear");

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
        JPanel panel =  new JPanel();
        panel.setLayout(new GridLayout(4,2,10,10));

        JLabel name = new JLabel("name");
        nameTextfield = new JTextField();

        JLabel quantity =  new JLabel("quantity");
        QuantityTextfield =  new JTextField();

        JLabel ID = new JLabel("ID");
        IDTextField  =  new JTextField();

        JLabel action = new JLabel("Action");
        ActionTextField = new JTextField();

        panel.add(name);
        panel.add(nameTextfield);
        panel.add(quantity);
        panel.add(QuantityTextfield);
        panel.add(ID);
        panel.add(IDTextField);
        panel.add(action);
        panel.add(ActionTextField);

        add(panel, BorderLayout.NORTH);





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
