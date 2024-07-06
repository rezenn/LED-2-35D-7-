import java.awt.*;
import javax.swing.*;
 
public class InventoryPage {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // Image Panel on the left
            String imagePath = "SytemLogo.png";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            int newWidth = 203;
            int newHeight = 185;
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);

            // Dashboard button with text and image
            String dashboardIconPath = "download (5).png";
            ImageIcon dashboardIcon = new ImageIcon(new ImageIcon(dashboardIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton dashboardButton = new JButton("Dashboard", dashboardIcon);
            configureButton(dashboardButton);

            // Schedule button with text and a different image
            String scheduleIconPath = "download (1).png";
            ImageIcon scheduleIcon = new ImageIcon(new ImageIcon(scheduleIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton scheduleButton = new JButton("Schedule", scheduleIcon);
            configureButton(scheduleButton);

            // Staff button with text and image
            String staffIconPath = "download.png";
            ImageIcon staffIcon = new ImageIcon(new ImageIcon(staffIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton staffButton = new JButton("Staff", staffIcon);
            configureButton(staffButton);

            // Operation button with text and image
            String operationIconPath = "download (6).png";
            ImageIcon operationIcon = new ImageIcon(new ImageIcon(operationIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton operationButton = new JButton("Operation", operationIcon);
            configureButton(operationButton);

            // Inventory button with text and image
            String inventoryIconPath = "download (2).png";
            ImageIcon inventoryIcon = new ImageIcon(new ImageIcon(inventoryIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton inventoryButton = new JButton("Inventory", inventoryIcon);
            configureButton(inventoryButton);

            // Report button with text and image
            String reportIconPath = "download (7).png";
            ImageIcon reportIcon = new ImageIcon(new ImageIcon(reportIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton reportButton = new JButton("Reports", reportIcon);
            configureButton(reportButton);
             // Create a panel with BoxLayout to stack image and buttons vertically
             JPanel stackPanel = new JPanel();
             stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
             stackPanel.setBackground(Color.decode("#FFDEC8"));
             stackPanel.add(imageLabel);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(dashboardButton);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(scheduleButton);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(staffButton);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(operationButton);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(inventoryButton);
             stackPanel.add(createVerticalSpacing(20));
             stackPanel.add(reportButton);
            // Image panel with BorderLayout
            JPanel imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBackground(Color.decode("#FFDEC8"));
            imagePanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 1));
            imagePanel.add(stackPanel, BorderLayout.NORTH);
 
            // Control Panel at the top
            JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            controlPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
 
            // Content Panel in the center
            JPanel contentPanel = new JPanel(new BorderLayout());
            contentPanel.setBackground(Color.WHITE);
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
 
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#FFDEC8"));
            panel.setBounds(300, 70, 1150, 710);
            frame.add(panel);

            JLabel inventory = new JLabel("Add To Inventory");
            panel.setLayout(null); 
            inventory.setBounds(80,30,250,30);
            inventory.setBackground(Color.decode("#FFDEC8"));
            inventory.setFont(new Font("Arial", Font.BOLD, 26)); 
            panel.add(inventory);
            
            
            JLabel name = new JLabel("Name:");
            panel.setLayout(null); 
            name.setBounds(100,110,150,30);
            name.setBackground(Color.decode("#FFDEC8"));
            name.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(name);
            JTextField nameField = new JTextField();
            nameField.setLayout(null); 
            nameField.setBackground(Color.decode("#FFDEC8"));
            nameField.setBounds(300,110,300,35);
            nameField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            nameField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(nameField);

            JLabel category = new JLabel("Category:");
            panel.setLayout(null); 
            category.setBounds(100,170,150,30);
            category.setBackground(Color.decode("#FFDEC8"));
            category.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(category);
            JTextField categoryField = new JTextField();
            categoryField.setLayout(null); 
            categoryField.setBackground(Color.decode("#FFDEC8"));
            categoryField.setBounds(300,170,300,35);
            categoryField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            categoryField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(categoryField);

            JLabel code = new JLabel("Serial Code:");
            panel.setLayout(null); 
            code.setBounds(100,230,150,30);
            code.setBackground(Color.decode("#FFDEC8"));
            code.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(code);
            JTextField codeField = new JTextField();
            codeField.setLayout(null); 
            codeField.setBackground(Color.decode("#FFDEC8"));
            codeField.setBounds(300,230,300,35);
            codeField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            codeField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(codeField);

            JLabel quanity = new JLabel("Quanity:");
            panel.setLayout(null); 
            quanity.setBounds(100,290,150,30);
            quanity.setBackground(Color.decode("#FFDEC8"));
            quanity.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(quanity);
            JTextField quanityField = new JTextField();
            quanityField.setLayout(null); 
            quanityField.setBackground(Color.decode("#FFDEC8"));
            quanityField.setBounds(300,290,300,35);
            quanityField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            quanityField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(quanityField);

            JLabel manufacture = new JLabel("Manufacture Date:");
            panel.setLayout(null); 
            manufacture.setBounds(100,350,180,30);
            manufacture.setBackground(Color.decode("#FFDEC8"));
            manufacture.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(manufacture);
            JTextField manufactureField = new JTextField();
            manufactureField.setLayout(null); 
            manufactureField.setBackground(Color.decode("#FFDEC8"));
            manufactureField.setBounds(300,350,300,35);
            manufactureField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            manufactureField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(manufactureField);

            JLabel expiry = new JLabel("Expiry Date:");
            panel.setLayout(null); 
            expiry.setBounds(100,410,150,30);
            expiry.setBackground(Color.decode("#FFDEC8"));
            expiry.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(expiry);
            JTextField expiryField = new JTextField();
            expiryField.setLayout(null); 
            expiryField.setBackground(Color.decode("#FFDEC8"));
            expiryField.setBounds(300,410,300,35);
            expiryField.setFont(new Font("Arial",Font.PLAIN, 18));
            expiryField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(expiryField);

            JLabel description = new JLabel("Description:");
            panel.setLayout(null); 
            description.setBounds(100,470,150,30);
            description.setBackground(Color.decode("#FFDEC8"));
            description.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(description);
            JTextArea descriptionArea = new JTextArea();
            descriptionArea.setLayout(null); 
            descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
            descriptionArea.setBackground(Color.decode("#FFDEC8"));
            descriptionArea.setBounds(300,470,300,130);
            descriptionArea.setFont(new Font("Arial",Font.PLAIN, 18)); 
            panel.add(descriptionArea);

            JButton AddInventory = new JButton("Save In Inventory");
            AddInventory.setLayout(null);
            AddInventory.setBackground(Color.decode("#01520E"));
            AddInventory.setForeground(Color.WHITE);
            AddInventory.setFocusPainted(false);
            AddInventory.setFont(new Font("Arial",Font.PLAIN, 24)); 
            AddInventory.setBounds(250, 640, 370, 60);
            panel.add(AddInventory);


 
            // Create a panel to add margins around the right panel
            JPanel rightPanelWithMargin = new JPanel(new BorderLayout());
            rightPanelWithMargin.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
 
            // Add right panel with margins to the content panel
            contentPanel.add(rightPanelWithMargin, BorderLayout.CENTER);
 
            // Add panels to the frame
            frame.add(imagePanel, BorderLayout.WEST);
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER);
 
            // Set frame size and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
    
    // Method to configure button styling
    private static void configureButton(JButton button) {
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setIconTextGap(20);
        button.setSize(new Dimension(180, 60));
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#FFDEC8"));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private static Component createVerticalSpacing(int height) {
        return Box.createRigidArea(new Dimension(0, height));
    }

}
