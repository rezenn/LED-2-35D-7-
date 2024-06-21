import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
            String imagePath = "SytemLogo.png"; // Path to your image file
            ImageIcon originalIcon = new ImageIcon(imagePath); // Create an ImageIcon from the image path

            JLabel imagLabel =  new JLabel(originalIcon);
           
            // Create a JPanel for the left side to hold the image
            JPanel imagePanel = new JPanel();
            imagePanel.add(imagLabel);
            imagePanel.setBackground(bgColor); // Set the background color of the image panel

            // Center panel to hold the right panel
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.setBackground(bgColor); // Set background color to match the frame's background

            // Right panel for registration
            JPanel rightPanel = new JPanel();
            rightPanel.setLayout(new BorderLayout());
            rightPanel.setPreferredSize(new Dimension(600, 820));
            rightPanel.setBackground(bgColor); // Set the background color to match the frame's background
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 70)); // Add padding around the right panel

            // Form panel
            JPanel formPanel = new JPanel(new GridBagLayout());
            formPanel.setOpaque(true); // Make the panel transparent
            formPanel.setBackground(Color.decode("#EFB481"));
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

            // Adding components to form panel with default styles
            JTextField fullNameField = createTextField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
            formPanel.add(new JLabel("Full Name"), gbc);
            gbc.gridy = 2;
            formPanel.add(fullNameField, gbc);

            JTextField emailField = createTextField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 3;
            formPanel.add(new JLabel("Email"), gbc);
            gbc.gridy = 4;
            formPanel.add(emailField, gbc);

            JPasswordField passwordField = createPasswordField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 5;
            formPanel.add(new JLabel("Password"), gbc);
            gbc.gridy = 6;
            formPanel.add(passwordField, gbc);

            JPasswordField confirmPasswordField = createPasswordField(350, 50);
            gbc.gridx = 0;
            gbc.gridy = 7;
            formPanel.add(new JLabel("Confirm Password"), gbc);
            gbc.gridy = 8;
            formPanel.add(confirmPasswordField, gbc);

            JButton registerButton = createButton("Register", 350, 50);
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String fullName = fullNameField.getText();
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());
                    String confirmPassword = new String(confirmPasswordField.getPassword());

                    if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else if (!password.equals(confirmPassword)) {
                        JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration successful!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            });
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.CENTER;
            formPanel.add(registerButton, gbc);

            rightPanel.add(formPanel, BorderLayout.CENTER);

            // Add right panel to center panel with positioning
            GridBagConstraints centerGbc = new GridBagConstraints();
            centerGbc.gridx = 0;
            centerGbc.gridy = 0;
            centerPanel.add(rightPanel, centerGbc);

            // Add panels to frame
            frame.add(imagePanel, BorderLayout.WEST); // Add the image panel to the left side
            frame.add(centerPanel, BorderLayout.CENTER); // Add the registration form to the right side

            // Maximize the frame to full screen and make it visible
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
        });
    }

    // Helper method to create text field
    private static JTextField createTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjusted font size
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")), // Simple line border with color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
        textField.setOpaque(true); // Ensure the text field is opaque
        textField.setForeground(Color.BLACK); // Set text color
        textField.setCaretColor(Color.BLACK); // Set caret color
        textField.setBackground(Color.decode("#EFB481")); // Ensure the background is set to white
        return textField;
    }

    // Helper method to create password field
    private static JPasswordField createPasswordField(int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(width, height));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjusted font size
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")), // Simple line border with color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
        passwordField.setOpaque(true); // Ensure the password field is opaque
        passwordField.setForeground(Color.BLACK); // Set text color
        passwordField.setCaretColor(Color.BLACK); // Set caret color
        passwordField.setBackground(Color.decode("#EFB481")); // Ensure the background is set to white
        return passwordField;
    }

    // Helper method to create button
    private static JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Arial", Font.BOLD, 20)); // Adjusted font size
        button.setBackground(Color.decode("#134700")); // Set button background color to #134700
        button.setForeground(Color.WHITE); // Set text color to white
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")), // Simple line border with color #282828
                BorderFactory.createEmptyBorder(13, 26, 13, 26) // Inner padding
        ));
        button.setFocusPainted(false); // Remove focus border
        return button;
    }
}
