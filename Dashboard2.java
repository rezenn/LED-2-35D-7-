import javax.swing.*;
import java.awt.*;

public class Dashboard2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            // Create a JFrame (window)
            JFrame frame = new JFrame("Dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            frame.getContentPane().setBackground(Color.decode("#FFF4EC"));

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
            JButton dashboardButton = createButton("Dashboard", "Dashbord.png");
            JButton scheduleButton = createButton("Schedule", "schedule.png");
            JButton staffButton = createButton("Staffs", "Staff.png");
            JButton operationButton = createButton("Operations", "Operation.png");
            JButton inventoryButton = createButton("Inventory", "inventory.png");
            JButton reportButton = createButton("Reports", "Reports.png");

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

            // Right Panel with form fields
            RoundedPanel rightPanel = new RoundedPanel(new GridBagLayout(), 70, Color.decode("#FFE8D6"));
            rightPanel.setBackground(Color.decode("#FFE8D6"));
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5); // Reduced insets
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Add form fields to right panel
            addFormField(rightPanel, gbc, 0, "Incident ID:", createTextField());
            addFormField(rightPanel, gbc, 1, "Name Of Caller:", createTextField());
            addFormField(rightPanel, gbc, 2, "Type Of Incident:", createTextField());
            addFormField(rightPanel, gbc, 3, "Cause:", createTextField());
            addFormField(rightPanel, gbc, 4, "Place Of Incident:", createTextField());
            addFormField(rightPanel, gbc, 5, "Time Of Incident:", createTextField());
            addFormField(rightPanel, gbc, 6, "Date Of Incident:", createTextField());
            addFormField(rightPanel, gbc, 7, "Casualties:", createTextField());
            addFormField(rightPanel, gbc, 8, "Damage Of Infrastructure:", createTextField());
            addFormField(rightPanel, gbc, 9, "Injured:", createTextField());

            // Save Report button at the bottom
            JButton saveButton = new JButton("Save Report");
            styleButton(saveButton);
            saveButton.setPreferredSize(new Dimension(298, 76));

            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            rightPanel.add(saveButton, gbc);

            // Create a panel to add margins around the right panel
            JPanel rightPanelWithMargin = new JPanel(new BorderLayout());
            rightPanelWithMargin.setBackground(Color.decode("#FFF4EC"));
            rightPanelWithMargin.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
            rightPanelWithMargin.add(rightPanel, BorderLayout.CENTER);

            // Add panels to the frame
            frame.add(imagePanel, BorderLayout.WEST);
            frame.add(rightPanelWithMargin, BorderLayout.CENTER);

            // Set frame size and make it visible
            frame.setSize(1377, 832);
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }

    private static JButton createButton(String text, String iconPath) {
        ImageIcon icon = new ImageIcon(new ImageIcon(iconPath).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        JButton button = new JButton(text, icon);
        styleButton(button);
        return button;
    }

    private static void styleButton(JButton button) {
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setIconTextGap(20);
        button.setPreferredSize(new Dimension(200, 50));
        button.setFocusPainted(false);
        button.setBackground(Color.decode("#FFDEC8"));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    private static JLabel createFormLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    private static JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        return textField;
    }

    private static void addFormField(JPanel panel, GridBagConstraints gbc, int yPos, String labelText, JTextField textField) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        panel.add(createFormLabel(labelText), gbc);

        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    // Custom JPanel with rounded corners
    static class RoundedPanel extends JPanel {
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
}
