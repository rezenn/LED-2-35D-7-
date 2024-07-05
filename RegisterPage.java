import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
            JFrame frame = new JFrame("Register Page");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout()); // Set layout manager

            // Set background color for the content pane
            Color bgColor = Color.decode("#FFDEC8"); // Convert hexadecimal color to RGB
            frame.getContentPane().setBackground(bgColor); // Set background color of the content pane

            // Load and resize the image (Replace with your image path)
            String imagePath = "fireguard.png"; // Path to your image file
            ImageIcon originalIcon = new ImageIcon(imagePath); // Create an ImageIcon from the image path

            // Resize the image
            int newWidth = 612; // Set the desired width
            int newHeight = 658; // Set the desired height
            Image resizedImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon); // Create a JLabel with the resized ImageIcon

            // Create a JPanel for the left side to hold the image
            JPanel imagePanel = new JPanel();
            imagePanel.setPreferredSize(new Dimension(newWidth, newHeight));
            imagePanel.add(imageLabel);
            imagePanel.setBackground(bgColor); // Set the background color of the image panel

            // Right panel for registration
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BorderLayout());
            rightPanel.setPreferredSize(new Dimension(559, 774));
            rightPanel.setBackground(bgColor); // Set the background color to match the frame's background
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 70)); // Add padding around the right panel

            // Form panel with rounded corners
            RoundedPanel formPanel = new RoundedPanel(20, new Color(236, 145, 67, 128)); // 20 is the arc width/height for rounded corners
            formPanel.setLayout(new GridBagLayout());
            formPanel.setOpaque(false); // Make the panel transparent
            formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding around the form panel

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.anchor = GridBagConstraints.WEST; // Align components to the left

            // Creating headline
            JLabel headline = new JLabel("Register Your Account", SwingConstants.CENTER);
            headline.setFont(new Font("Serif", Font.BOLD, 34)); // Increased font size to 34
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2; // Span across two columns
            formPanel.add(headline, gbc);
            gbc.gridwidth = 1; // Reset grid width

            // Adding components to form panel with custom styles
            JTextField fullNameField = createRoundedTextField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
            formPanel.add(new JLabel("Full Name"), gbc);
            gbc.gridy = 2;
            formPanel.add(fullNameField, gbc);

            JTextField emailField = createRoundedTextField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 3;
            formPanel.add(new JLabel("Email"), gbc);
            gbc.gridy = 4;
            formPanel.add(emailField, gbc);

            JPasswordField passwordField = createRoundedPasswordField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 5;
            formPanel.add(new JLabel("Password"), gbc);
            gbc.gridy = 6;
            formPanel.add(passwordField, gbc);

            JPasswordField confirmPasswordField = createRoundedPasswordField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 7;
            formPanel.add(new JLabel("Confirm Password"), gbc);
            gbc.gridy = 8;
            formPanel.add(confirmPasswordField, gbc);

            JButton registerButton = createRoundedButton("Register", 350, 50);
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fullName = fullNameField.getText();
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    String confirmPassword = new String(confirmPasswordField.getPassword());

                    if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!password.equals(confirmPassword)) {
                        JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            gbc.gridx = 0;
            gbc.gridy = 9;
            formPanel.add(registerButton, gbc);

            rightPanel.add(formPanel, BorderLayout.CENTER);

            // Add panels to frame
            frame.add(imagePanel, BorderLayout.WEST); // Add the image panel to the left side
            frame.add(rightPanel, BorderLayout.CENTER); // Add the registration form to the right side

            // Maximize the frame to full screen and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }

    // Helper method to create rounded text field
    private static JTextField createRoundedTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjusted font size
        textField.setOpaque(false); // Make text field transparent
        textField.setForeground(Color.BLACK); // Set text color
        textField.setCaretColor(Color.BLACK); // Set caret color

        // Create rounded border with padding
        textField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(50, Color.decode("#282828")), // Rounded border with radius 20 and color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));

        return textField;
    }

    // Helper method to create rounded password field
    private static JPasswordField createRoundedPasswordField(int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(width, height));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjusted font size
        passwordField.setOpaque(false); // Make password field transparent
        passwordField.setForeground(Color.BLACK); // Set text color
        passwordField.setCaretColor(Color.BLACK); // Set caret color

        // Create rounded border with padding
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                new RoundedBorder(50, Color.decode("#282828")), // Rounded border with radius 20 and color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));

        return passwordField;
    }

    // Helper method to create rounded button
    private static JButton createRoundedButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Arial", Font.BOLD, 20)); // Adjusted font size
        button.setBackground(Color.decode("#134700")); // Set button background color to #134700
        button.setForeground(Color.WHITE); // Set text color to white

        // Create rounded border with padding
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
            Graphics2D graphics = (Graphics2D) g.create();
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draws the rounded panel with background color
            graphics.setColor(backgroundColor);
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);

            graphics.dispose();
        }
    }

    static class RoundedBorder implements Border {
        private int radius;
        private Color borderColor;

        RoundedBorder(int radius, Color borderColor) {
            this.radius = radius;
            this.borderColor = borderColor;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(borderColor);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
}
