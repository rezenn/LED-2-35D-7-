import java.awt.*;
import javax.swing.*;

public class ViewInventoryPage {
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