import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class LoginPage {
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
            JFrame frame = new JFrame("Login Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout()); // Set layout manager
 
            // Set background color for the content pane
            Color bgColor = Color.decode("#FFDEC8"); // Convert hexadecimal color to RGB
            frame.getContentPane().setBackground(bgColor); // Set background color of the content pane
 
            // Load and resize the image (Replace with your image path)
            String imagePath = "fireguard.png"; // Path to your image file
            ImageIcon originalIcon = new ImageIcon(imagePath); // Create an ImageIcon from the image path
 
            // Resize the image
            Image originalImage = originalIcon.getImage();
            int newWidth = 612; // Set the desired width
            int newHeight = 658; // Set the desired height
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
 
            // Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon); // Create a JLabel with the resized ImageIcon
 
            // Create a JPanel for the left side to hold the image
            JPanel imagePanel = new JPanel();
            imagePanel.setPreferredSize(new Dimension(newWidth, newHeight));
            imagePanel.add(imageLabel);
            imagePanel.setBackground(bgColor); // Set the background color of the image panel
 
            // Right panel for login
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BorderLayout());
            rightPanel.setPreferredSize(new Dimension(559, 774));
            rightPanel.setBackground(bgColor); // Set the background color to match the frame's background
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 70)); // Add padding around the right panel
 
            // Form panel with rounded corners
            RoundedPanel formPanel = new RoundedPanel(50, bgColor); // 50 is the arc width/height for rounded corners
            formPanel.setLayout(new GridBagLayout());
            formPanel.setOpaque(false);
            Color formPanelColor = new Color(236, 145, 67, 128); // ARGB color with 50% transparency
            formPanel.setBackground(formPanelColor); // Set the background color of the form panel
            formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the form panel
 
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST; // Align components to the left
 
            // Creating headline
            JLabel headline = new JLabel("Welcome Back", SwingConstants.CENTER);
            headline.setFont(new Font("Serif", Font.BOLD, 34)); // Increased font size to 34
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2; // Span across two columns
            formPanel.add(headline, gbc);
            gbc.gridwidth = 1; // Reset grid width
 
            // Adding components to form panel with custom styles
            JTextField emailField = createRoundedTextField(350, 50);
            emailField.setFont(new Font("Arial", Font.PLAIN, 25)); // Increased font size to 25
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
            formPanel.add(new JLabel("Email"), gbc);
            gbc.gridy = 2;
            formPanel.add(emailField, gbc);
 
            JPasswordField passwordField = createRoundedPasswordField(350, 50);
            passwordField.setFont(new Font("Arial", Font.PLAIN, 25)); // Increased font size to 25
            gbc.gridx = 0;
            gbc.gridy = 3;
            formPanel.add(new JLabel("Password"), gbc);
            gbc.gridy = 4;
            formPanel.add(passwordField, gbc);
 
            JButton loginButton = createRoundedButton("Login", 350, 50);
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
 
                    if (email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            loginButton.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size to 20
            gbc.gridx = 0;
            gbc.gridy = 5;
            formPanel.add(loginButton, gbc);
 
            // Sign-up prompt
            JLabel signUpPrompt = new JLabel("If you didn’t have account sign-up");
            signUpPrompt.setFont(new Font("Arial", Font.PLAIN, 16)); // Set font size for the prompt
            gbc.gridx = 0;
            gbc.gridy = 6;
            formPanel.add(signUpPrompt, gbc);
 
            rightPanel.add(formPanel, BorderLayout.CENTER);
 
            // Add panels to frame
            frame.add(imagePanel, BorderLayout.WEST); // Add the image panel to the left side
            frame.add(rightPanel, BorderLayout.CENTER); // Add the login form to the right side
 
            // Maximize the frame to full screen and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }
 
    // Helper method to create rounded text field
    private static JTextField createRoundedTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(50, Color.decode("#282828")), // Rounded border with radius 20 and color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
        textField.setOpaque(false); // Make text field transparent
        textField.setForeground(Color.BLACK); // Set text color
        textField.setCaretColor(Color.BLACK); // Set caret color
        return textField;
    }
 
    // Helper method to create rounded password field
    private static JPasswordField createRoundedPasswordField(int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(width, height));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(50, Color.decode("#282828")), // Rounded border with radius 20 and color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
        passwordField.setOpaque(false); // Make password field transparent
        passwordField.setForeground(Color.BLACK); // Set text color
        passwordField.setCaretColor(Color.BLACK); // Set caret color
        return passwordField;
    }
 
    // Helper method to create rounded button
    private static JButton createRoundedButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size to 20
        button.setBackground(Color.decode("#134700")); // Set button background color to #134700
        button.setForeground(Color.WHITE); // Set text color to white
 
        // Apply rounded border with 20px radius (similar to text fields)
        button.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(20, Color.decode("#282828")), // Rounded border with radius 20 and color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
 
        button.setFocusPainted(false); // Remove focus border
        return button;
    }
 
    static class RoundedPanel extends JPanel {
        private int cornerRadius;
        private Color backgroundColor;
 
        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }
 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
            // Draws the rounded panel with background color
            graphics.setColor(backgroundColor);
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);
 
            // Draws the rounded panel with border color (if needed)
            graphics.setColor(getBackground());
            graphics.fillRoundRect(1, 1, width - 2, height - 2, arcs.width, arcs.height);
        }
    }
 
    static class RoundedBorder implements Border {
        private int radius;
        private Color color;
 
        public RoundedBorder(int radius, Color color) {
            this.radius = radius;
            this.color = color;
        }
 
        @Override
        public Insets getBorderInsets(Component c) {
            int borderWidth = radius + 1;
            return new Insets(borderWidth, borderWidth, borderWidth + 1, borderWidth);
        }
 
        @Override
        public boolean isBorderOpaque() {
            return true;
        }
 
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(color);
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}