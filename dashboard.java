import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
 
public class Dashboard {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
 
            // Create a JFrame (window)
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
 
            // Image Panel on the left
            String imagePath = "D:/Frontend For Project/fireguard.png";
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image originalImage = originalIcon.getImage();
            int newWidth = 200;
            int newHeight = 167;
 
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);
 
            // Dashboard button with text and image
            String dashboardIconPath = "Dashbord.png";
            ImageIcon dashboardIcon = new ImageIcon(new ImageIcon(dashboardIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton dashboardButton = new JButton("Dashboard", dashboardIcon);
 
            // Dashboard button styling
            dashboardButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            dashboardButton.setVerticalTextPosition(SwingConstants.CENTER);
            dashboardButton.setIconTextGap(20);
            dashboardButton.setPreferredSize(new Dimension(200, 50));
            dashboardButton.setFocusPainted(false);
            dashboardButton.setBackground(Color.decode("#FFDEC8"));
            dashboardButton.setForeground(Color.BLACK);
            dashboardButton.setFont(new Font("Arial", Font.BOLD, 18));
            dashboardButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            dashboardButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Dashboard button clicked!"));
 
            // Schedule button with text and a different image
            String scheduleIconPath = "schedule.png";
            ImageIcon scheduleIcon = new ImageIcon(new ImageIcon(scheduleIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton scheduleButton = new JButton("Schedule", scheduleIcon);
 
            // Schedule button styling
            scheduleButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            scheduleButton.setVerticalTextPosition(SwingConstants.CENTER);
            scheduleButton.setIconTextGap(20);
            scheduleButton.setPreferredSize(new Dimension(200, 50));
            scheduleButton.setFocusPainted(false);
            scheduleButton.setBackground(Color.decode("#FFDEC8"));
            scheduleButton.setForeground(Color.BLACK);
            scheduleButton.setFont(new Font("Arial", Font.BOLD, 18));
            scheduleButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            scheduleButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Schedule button clicked!"));
 
            // Image for staff button
            String staffIconPath = "Staff.png";
            ImageIcon staffIcon = new ImageIcon(new ImageIcon(staffIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton staffButton = new JButton("Staff", staffIcon);
 
            // Staff button styling
            staffButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            staffButton.setVerticalTextPosition(SwingConstants.CENTER);
            staffButton.setIconTextGap(20);
            staffButton.setPreferredSize(new Dimension(200, 50));
            staffButton.setFocusPainted(false);
            staffButton.setBackground(Color.decode("#FFDEC8"));
            staffButton.setForeground(Color.BLACK);
            staffButton.setFont(new Font("Arial", Font.BOLD, 18));
            staffButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            staffButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Staff button clicked!"));
 
            // Image for operation button
            String operationIconPath = "Operation.png";
            ImageIcon operationIcon = new ImageIcon(new ImageIcon(operationIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton operationButton = new JButton("Operation", operationIcon);
 
            // Operation button styling
            operationButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            operationButton.setVerticalTextPosition(SwingConstants.CENTER);
            operationButton.setIconTextGap(20);
            operationButton.setPreferredSize(new Dimension(200, 50));
            operationButton.setFocusPainted(false);
            operationButton.setBackground(Color.decode("#FFDEC8"));
            operationButton.setForeground(Color.BLACK);
            operationButton.setFont(new Font("Arial", Font.BOLD, 18));
            operationButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            operationButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Operation button clicked!"));
 
            // Image for inventory
            String inventoryIconPath = "inventory.png";
            ImageIcon inventoryIcon = new ImageIcon(new ImageIcon(inventoryIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton inventoryButton = new JButton("Inventory", inventoryIcon);
 
            // Inventory button styling
            inventoryButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            inventoryButton.setVerticalTextPosition(SwingConstants.CENTER);
            inventoryButton.setIconTextGap(20);
            inventoryButton.setPreferredSize(new Dimension(200, 50));
            inventoryButton.setFocusPainted(false);
            inventoryButton.setBackground(Color.decode("#FFDEC8"));
            inventoryButton.setForeground(Color.BLACK);
            inventoryButton.setFont(new Font("Arial", Font.BOLD, 18));
            inventoryButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            inventoryButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Inventory button clicked!"));
 
            // Image for report
            String reportIconPath = "Reports.png";
            ImageIcon reportIcon = new ImageIcon(new ImageIcon(reportIconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            JButton reportButton = new JButton("Reports", reportIcon);
 
            // Report button styling
            reportButton.setHorizontalTextPosition(SwingConstants.RIGHT);
            reportButton.setVerticalTextPosition(SwingConstants.CENTER);
            reportButton.setIconTextGap(20);
            reportButton.setPreferredSize(new Dimension(200, 50));
            reportButton.setFocusPainted(false);
            reportButton.setBackground(Color.decode("#FFDEC8"));
            reportButton.setForeground(Color.BLACK);
            reportButton.setFont(new Font("Arial", Font.BOLD, 18));
            reportButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
 
            // Add action listener for the button
            reportButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Report button clicked!"));
 
            // Create a panel with BoxLayout to stack image and buttons vertically
            JPanel stackPanel = new JPanel();
            stackPanel.setLayout(new BoxLayout(stackPanel, BoxLayout.Y_AXIS));
            stackPanel.setBackground(Color.decode("#FFDEC8"));
            stackPanel.add(imageLabel);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            stackPanel.add(dashboardButton);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            stackPanel.add(scheduleButton);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            stackPanel.add(staffButton);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            stackPanel.add(operationButton);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            stackPanel.add(inventoryButton);
            stackPanel.add(Box.createRigidArea(new Dimension(0, 20)));
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
            contentPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#FFDEC8"), 1));
 
            // Custom JPanel with rounded corners
            class RoundedPanel extends JPanel {
                private Color backgroundColor;
                private int cornerRadius;
 
                public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
                    super(layout);
                    cornerRadius = radius;
                    backgroundColor = bgColor;
                    setOpaque(false); // Make sure the panel is transparent
                }
 
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Dimension arcs = new Dimension(cornerRadius, cornerRadius);
                    int width = getWidth();
                    int height = getHeight();
                    Graphics2D graphics = (Graphics2D) g;
                    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
                    // Draws the rounded panel with borders.
                    if (backgroundColor != null) {
                        graphics.setColor(backgroundColor);
                    } else {
                        graphics.setColor(getBackground());
                    }
                    graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
                    graphics.setColor(getForeground());
                }
            }
 
            // Right Panel with form fields
            RoundedPanel rightPanel = new RoundedPanel(new GridLayout(6, 2, 10, 10), 70, Color.decode("#FFE8D6"));
            rightPanel.setBackground(Color.decode("#FFE8D6"));
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
 
            // Add form fields to right panel
            rightPanel.add(new JLabel("Name Of Caller:"));
            rightPanel.add(new JTextField());
            rightPanel.add(new JLabel("Place Of Incident:"));
            rightPanel.add(new JTextField());
            rightPanel.add(new JLabel("Type Of Incident:"));
            rightPanel.add(new JTextField());
            rightPanel.add(new JLabel("Time:"));
            rightPanel.add(new JTextField());
            rightPanel.add(new JLabel("Date:"));
            rightPanel.add(new JTextField());
            rightPanel.add(new JLabel("Contact:"));
            rightPanel.add(new JTextField());
 
            // Create a panel to add margins around the right panel
            JPanel rightPanelWithMargin = new JPanel(new BorderLayout());
            rightPanelWithMargin.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
            rightPanelWithMargin.add(rightPanel, BorderLayout.CENTER);
 
            // Add right panel with margins to the content panel
            contentPanel.add(rightPanelWithMargin, BorderLayout.CENTER);
 
            // Add panels to the frame
            frame.add(imagePanel, BorderLayout.WEST);
            frame.add(controlPanel, BorderLayout.NORTH);
            frame.add(contentPanel, BorderLayout.CENTER);
 
            // Set frame size and make it visible
            frame.setSize(1377, 832);
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }
}