package supermarket.ui;

import supermarket.inventory.Activity;
import supermarket.inventory.Product;
import supermarket.management.CustomLinkedList;
import supermarket.management.SupermarketManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// ===== Main GUI Class for Supermarket System =====
public class GUI_Main_Page extends JPanel implements ActionListener {

    // Text fields and Combo box for inputs
    private GUI_Frame frame;
    private SupermarketManager manager;
    private JTextField nameTextfield;
    private JTextField QuantityTextfield;
    private JTextField IDTextField;
    private JComboBox<String> ActivityCombobox;

    // ===== Constructor: Builds the entire GUI =====
    public GUI_Main_Page(GUI_Frame frame, SupermarketManager manager){
        this.frame = frame; // Stores reference to main frame
        this.manager = manager; // Store reference to supermarket manager

        // Use BorderLayout for high-level layout (NORTH, CENTER, SOUTH)
        setLayout(new BorderLayout());
        // Padding
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        // ===== Title (North panel) =====
        JLabel titleLabel = new JLabel("Supermarket Management System");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel, BorderLayout.NORTH);



        // ===== Buttons =====
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addProductBtn = new JButton("Add Product"); // Button to add a new product
        JButton viewProductsBtn = new JButton("View Products"); // Button to display all products
        JButton deleteProductBtn = new JButton("Delete Product"); // Button to delete a product
        JButton updateStockBtn = new JButton("Update Stock"); // Button to update product stock/activity
        JButton recentActivityBtn = new JButton("Recent Activities"); // Button to view recent activities (last 4)
        JButton clearBtn = new JButton("Clear"); // Button to clear all input fields
        JButton exitBtn = new JButton("Exit"); // Button to close the application


        // Add all buttons to the button panel in order (from top to bottom)
        buttonPanel.add(addProductBtn);
        buttonPanel.add(viewProductsBtn);
        buttonPanel.add(deleteProductBtn);
        buttonPanel.add(updateStockBtn);
        buttonPanel.add(recentActivityBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(exitBtn);


        // Attach action listeners so button clicks are handled by actionPerformed(...)
        clearBtn.addActionListener(this);
        addProductBtn.addActionListener(this);
        viewProductsBtn.addActionListener(this);
        deleteProductBtn.addActionListener(this);
        updateStockBtn.addActionListener(this);
        recentActivityBtn.addActionListener(this);
        exitBtn.addActionListener(e -> System.exit(0));

        add(buttonPanel, BorderLayout.CENTER);


        // ===== Form (Text fields + Combo box) =====
        JPanel formPanel =  new JPanel(); // Panel to hold the input form
        formPanel.setLayout(new GridLayout(4,2,10,10)); // 4 rows, 2 columns (label + field)

        JLabel name = new JLabel("Product Name:"); // Label for product name
        nameTextfield = new JTextField(); // Input for product name

        JLabel ID = new JLabel("Product ID:"); // Label for product ID
        IDTextField  =  new JTextField(); // Input for product ID

        JLabel quantity =  new JLabel("Quantity:"); // Label for quantity
        QuantityTextfield =  new JTextField(); // Input for product quantity

        JLabel Activity = new JLabel("Activity:"); // Label for Activity
        String [] activityOptions = {"Add to stock", "Remove from stock"}; // Combo box actions
        ActivityCombobox = new JComboBox<>(activityOptions); // Combo box choosing for add/remove


        // Add all labels and corresponding inputs to the form panel
        formPanel.add(name);
        formPanel.add(nameTextfield);
        formPanel.add(ID);
        formPanel.add(IDTextField);
        formPanel.add(quantity);
        formPanel.add(QuantityTextfield);
        formPanel.add(Activity);
        formPanel.add(ActivityCombobox);

        add(formPanel, BorderLayout.CENTER);


        // ===== Main area (Center Panel) =====

        // Panel that actually holds form + buttons
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.add(formPanel, BorderLayout.CENTER);
        contentPanel.add(buttonPanel, BorderLayout.EAST);



        // ===== Centering Content Panel with BoxLayout =====
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

        // Subtitle label
        JLabel subtitle = new JLabel("User Manual:");
        subtitle.setFont(new Font("Arial", Font.BOLD, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0)); // << shift subtitle up

        // Bullet list (centered)
        JLabel manualText = new JLabel(
                "<html><div style='text-align: center;'>"
                        + "• Add Product – Register a new product (Enter Product Name, ID, and Quantity fields)<br>"
                        + "• View Products – Display all items<br>"
                        + "• Delete Product – Remove a product (Enter Product ID field)<br>"
                        + "• Update Stock – Change quantity (Enter Product ID, Quantity, and select an option from the Activity menu)<br>"
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

    // ===== Event Handling: Respond to Button Clicks =====
    public void  actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand(); // Get button that triggered the event

        if (command.equalsIgnoreCase("clear")) // If "Clear" button pressed
        {
            Clear(); // Call Clear method
        }
        if (command.equalsIgnoreCase("add product")) // If "Add Product" button pressed
        {
            addProduct(); // Call addProduct method
        }
        if (command.equalsIgnoreCase("View Products")) // If "View Products" button pressed
        {
            display_product(); // Call display_product method

        }
        if (command.equalsIgnoreCase("delete product")) // If "Delete Product" button pressed
        {
            delete_product(); // Call delete_product method

        }
        if (command.equalsIgnoreCase("Update stock")) // If "Update Stock" button pressed
        {
            update_stock(); // Call update_stock method
        }
        if (command.equalsIgnoreCase("Recent Activities")) // If "Recent Activities" button pressed
        {
            Recent_Activities(); // Call Recent_Activities method

        }
    }
    public  void  Clear()
    {
        nameTextfield.setText(" "); // Clear product name field
        IDTextField.setText(" "); // Clear product ID field
        QuantityTextfield.setText(" "); // Clear product ID field
        ActivityCombobox.setSelectedIndex(-1); // Reset combo box selection (no option selected)
    }

    // Add product procedure
    public  void addProduct() {
        try {


            String ID = IDTextField.getText().trim();
            String name = nameTextfield.getText().trim();

            if(nameTextfield.getText().isEmpty() ||
                    IDTextField.getText().isEmpty() ||
                    QuantityTextfield.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(frame,
                        "The required text fields are empty!\nRefer to User Manual.",
                        "Add Product",
                        JOptionPane.INFORMATION_MESSAGE);
                return;

            }

            int Quantity = Integer.parseInt(QuantityTextfield.getText().trim());


            // Quantity must be > 0
            if (Quantity <= 0) {
                JOptionPane.showMessageDialog(frame,
                        "Quantity must be greater than 0.",
                        "Add Product Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }



            manager.addProduct(new Product(Quantity, name, ID));

            JOptionPane.showMessageDialog(frame,
                    "Product has been successfully added.",
                    "Add Product",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "Some fields require numerical values.",
                    "Add Product",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    // View product procedure
    public void display_product()
    {
        ArrayList<Product> products = manager.listproducts();
        if (products == null || products.isEmpty())
        {
            JOptionPane.showMessageDialog(frame,
                    "No Product(s) found." ,
                    "Display Product(s)",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        JTextArea textArea = new JTextArea(20,40);
        textArea.setEditable(false);
        StringBuilder message = new StringBuilder();

        for (Product value : products) {
            message.append(value.toString()).append("\n");

        }
        textArea.setText(message.toString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame productFrame = new JFrame("Product List");
        productFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        productFrame.add(scrollPane);
        productFrame.pack();
        productFrame.setLocationRelativeTo(frame);
        productFrame.setVisible(true);

    }

    // Delete product procedure
    public void delete_product()
    {

        String ID = IDTextField.getText().trim();
        Product deletedID = manager.deleteproducts(ID);
        if (deletedID  == null) {
            JOptionPane.showMessageDialog(frame,
                    "Invalid Product ID.",
                    "Delete Product Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(frame,
                    "Product has been removed.",
                    "Delete Product",
                    JOptionPane.INFORMATION_MESSAGE);
        }



    }

    // Update stock procedure (changing stock quantity)
    public void update_stock() {
        try {
            String ID = IDTextField.getText().trim();
            String selected = (String) ActivityCombobox.getSelectedItem();

            // Required fields check
            if (ID.isEmpty() ||
                    QuantityTextfield.getText().trim().isEmpty() ||
                    selected == null) {

                JOptionPane.showMessageDialog(frame,
                        "The required text fields are empty!\nRefer to User Manual.",
                        "Update Stock",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int Quantity = Integer.parseInt(QuantityTextfield.getText().trim());

            // Prevent zero or negative quantity
            if (Quantity <= 0) {
                JOptionPane.showMessageDialog(frame,
                        "Quantity must be greater than 0.",
                        "Update Stock Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert combo box choice → simple keyword ("add" / "remove")
            boolean isRemoving = selected.equalsIgnoreCase("Remove from stock");
            String action = isRemoving ? "remove" : "add";

            // If removing, validate stock
            if (isRemoving) {
                Product target = null;

                for (Product p : manager.listproducts()) {
                    if (p.getId().equalsIgnoreCase(ID)) {
                        target = p;
                        break;
                    }
                }

                if (target == null) {
                    JOptionPane.showMessageDialog(frame,
                            "Invalid Product ID.",
                            "Update Stock Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int stock = target.getQuantity();

                if (stock == 0) {
                    JOptionPane.showMessageDialog(frame,
                            "This product already has 0 stock.\nYou cannot remove any more.",
                            "Update Stock Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (Quantity > stock) {
                    JOptionPane.showMessageDialog(frame,
                            "Cannot remove more than available stock.\n" +
                                    "Available: " + stock + ", Requested: " + Quantity,
                            "Update Stock Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Add activity normally
            manager.addactivitytoproduct(ID, Quantity, action);

            JOptionPane.showMessageDialog(frame,
                    "Activity has been added to Product ID: " + ID,
                    "Update Stock",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame,
                    "Some fields require numerical values.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    // View last 4 recent activities procedure
    public void Recent_Activities()
    {
        String ID =IDTextField.getText().trim();

        CustomLinkedList<Activity> activityList = manager.lastFourSortedBYQuantity(ID);

        if (activityList == null || activityList.size() == 0)
        {
            JOptionPane.showMessageDialog(frame,
                    "No Activities found for that Product ID.",
                    "Recent Activities",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        StringBuilder message  = new StringBuilder();
        message.append("Recent Activities for Product ID: ").append(ID).append("\n");

        for (int i = 0; i < activityList.size(); i++) {
            message.append(activityList.get(i).toString()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(message.toString());
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame activityFrame = new JFrame("Activity List");
        activityFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        activityFrame.add(scrollPane);
        activityFrame.pack();
        activityFrame.setLocationRelativeTo(frame);
        activityFrame.setVisible(true);
    }




}

