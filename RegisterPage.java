import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class RegisterPage {
    private JFrame frame;

    public RegisterPage() {
        // Create a JFrame (window)
        frame = new JFrame("Register Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE_ON_CLOSE for non-main windows
        frame.setLayout(new BorderLayout());

        // Set background color for the content pane
        Color bgColor = Color.decode("#FFDEC8");
        frame.getContentPane().setBackground(bgColor);

        // Load and resize the image (Replace with your image path)
        String imagePath = "SytemLogo.png"; // Path to your image file
        ImageIcon originalIcon = new ImageIcon(imagePath);
        JLabel imagLabel = new JLabel(originalIcon);

        // Create a JPanel for the left side to hold the image
        JPanel imagePanel = new JPanel();
        imagePanel.add(imagLabel);
        imagePanel.setBackground(bgColor);

        // Center panel to hold the right panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(bgColor);

        // Right panel for registration
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setPreferredSize(new Dimension(600, 820));
        rightPanel.setBackground(bgColor);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 70));

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setOpaque(true);
        formPanel.setBackground(Color.decode("#EFB481"));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Creating headline
        JLabel headline = new JLabel("Register Your Account", SwingConstants.CENTER);
        headline.setFont(new Font("Serif", Font.BOLD, 34));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(headline, gbc);
        gbc.gridwidth = 1;

        // Adding components to form panel with default styles
        JTextField fullNameField = createTextField(350, 50);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Establishing database connection
                    String jdbcUrl = "jdbc:mysql://localhost:3306/fireGuard";
                    String dbUsername = "root";
                    String dbPassword = "root";

                    try {
                        Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

                        String sql = "INSERT INTO accounts (full_name, email, password) VALUES (?, ?, ?)";
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, fullName);
                        statement.setString(2, email);
                        statement.setString(3, password);

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }

                        statement.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Failed to register. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            
            private boolean isValidEmail(String email) {
                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z]+\\.[A-Za-z]+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(registerButton, gbc);

        JButton login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 16));
        login.setPreferredSize(new Dimension(100, 30));
        login.setBackground(Color.decode("#EFB481"));
        login.setForeground(Color.decode("#1D48DF"));
        login.setBorderPainted(false);
        login.setFocusPainted(false);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create an instance of LoginPage and make it visible
                LoginPage loginpage = new LoginPage();
                loginpage.setVisible(true);
                frame.dispose();
            }
        });
        gbc.gridy = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(login, gbc);

        rightPanel.add(formPanel, BorderLayout.CENTER);

        // Add right panel to center panel with positioning
        GridBagConstraints centerGbc = new GridBagConstraints();
        centerGbc.gridx = 0;
        centerGbc.gridy = 0;
        centerPanel.add(rightPanel, centerGbc);

        // Add panels to frame
        frame.add(imagePanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Maximize the frame and make it visible
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // Helper method to create text field
    private JTextField createTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")),
                BorderFactory.createEmptyBorder(13, 26, 13, 26)
        ));
        textField.setOpaque(true);
        textField.setForeground(Color.BLACK);
        textField.setCaretColor(Color.BLACK);
        textField.setBackground(Color.decode("#EFB481"));
        return textField;
    }

    // Helper method to create password field
    private JPasswordField createPasswordField(int width, int height) {
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(width, height));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")),
                BorderFactory.createEmptyBorder(13, 26, 13, 26)
        ));
        passwordField.setOpaque(true);
        passwordField.setForeground(Color.BLACK);
        passwordField.setCaretColor(Color.BLACK);
        passwordField.setBackground(Color.decode("#EFB481"));
        return passwordField;
    }

    // Helper method to create button
    private JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setFont(new Font("Arial", Font.BOLD, 20));
        button.setBackground(Color.decode("#134700"));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.decode("#282828")),
                BorderFactory.createEmptyBorder(13, 26, 13, 26)
        ));
        button.setFocusPainted(false);
        return button;
    }


    // Method to set the visibility of the frame
    public void setVisible(boolean isVisible) {
        frame.setVisible(isVisible);
    }
}