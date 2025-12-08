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
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        // ===== Title (North panel) =====
        JLabel titleLabel = new JLabel("Supermarket Manager System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);



        // ===== Buttons =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addProductBtn = new JButton("Add Product");
        JButton viewProductsBtn = new JButton("View Products");
        JButton deleteProductBtn = new JButton("Delete Product");
        JButton updateStockBtn = new JButton("Update Stock");
        JButton recentActivityBtn = new JButton("Recent Activities");
        JButton clearBtn = new JButton("Clear");
        JButton exitBtn = new JButton("Exit");



        buttonPanel.add(addProductBtn);
        buttonPanel.add(viewProductsBtn);
        buttonPanel.add(deleteProductBtn);
        buttonPanel.add(updateStockBtn);
        buttonPanel.add(recentActivityBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(exitBtn);



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

        // Panel that actually holds form + buttons
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // inner padding
        contentPanel.add(formPanel, BorderLayout.CENTER); // form in the middle
        contentPanel.add(buttonPanel, BorderLayout.EAST); // buttons on the right



// Outer panel uses BoxLayout to center the content panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(60, 200, 30, 200));

// Horizontal glue on both sides keeps the contentPanel centered like a “box”
        centerPanel.add(Box.createHorizontalGlue());
        centerPanel.add(contentPanel);
        centerPanel.add(Box.createHorizontalGlue());

// Add to the main BorderLayout center
        add(centerPanel, BorderLayout.CENTER);


        // ===== Separator + Manual Section (South Panel) =====
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

// Separator line between buttons and manual
        JSeparator separator = new JSeparator();
        separator.setForeground(Color.GRAY);
        bottomPanel.add(separator, BorderLayout.NORTH);

// Manual Panel (centers all content)
        JPanel manualPanel = new JPanel(new GridBagLayout());
// Moves the manual section downwards a little
        manualPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));

// Panel for stacking subtitle + bullet list vertically
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

// Subtitle label — moved slightly up
        JLabel subtitle = new JLabel("System Manual:");
        subtitle.setFont(new Font("Arial", Font.BOLD, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // << shift subtitle up

// Bullet list (centered)
        JLabel manualText = new JLabel(
                "<html><div style='text-align: center;'>"
                        + "• Add Product – Register a new product (Enter Product Name, ID, and Quantity fields)<br>"
                        + "• View Products – Display all items<br>"
                        + "• Delete Product – Remove a product (Enter Product ID field)<br>"
                        + "• Update Stock – Change quantity (Enter Product ID, and Action field)<br>"
                        + "• Recent Activities – View latest updates (Enter Product ID)<br>"
                        + "• Exit – Close the system"
                        + "</div></html>"
        );
        manualText.setFont(new Font("Arial", Font.PLAIN, 14));
        manualText.setAlignmentX(Component.CENTER_ALIGNMENT);

// Add components to text panel
        textPanel.add(subtitle);
        textPanel.add(Box.createVerticalStrut(5)); // spacing below subtitle
        textPanel.add(manualText);

// Add to manual panel and bottom container
        manualPanel.add(textPanel);
        bottomPanel.add(manualPanel, BorderLayout.CENTER);

// Add full bottom panel to SOUTH region
        add(bottomPanel, BorderLayout.SOUTH);







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
