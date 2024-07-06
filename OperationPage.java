import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
 
public class OperationPage         {
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
            panel.setBounds(250, 70, 1150, 710);
            frame.add(panel);

            JLabel inventory = new JLabel("Operationgit ");
            panel.setLayout(null); 
            inventory.setBounds(80,30,250,30);
            inventory.setBackground(Color.decode("#FFDEC8"));
            inventory.setFont(new Font("Arial", Font.BOLD, 26)); 
            panel.add(inventory);
            
            
            JLabel Incident = new JLabel("Incident ID:");
            panel.setLayout(null); 
            Incident.setBounds(50,110,150,30);
            Incident.setBackground(Color.decode("#FFDEC8"));
            Incident.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(Incident);
            JTextField IncidentField = new JTextField();
            IncidentField.setLayout(null); 
            IncidentField.setBackground(Color.decode("#FFDEC8"));
            IncidentField.setBounds(250,110,250,35);
            IncidentField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            IncidentField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(IncidentField);

            JLabel caller = new JLabel("Name Of Caller:");
            panel.setLayout(null); 
            caller.setBounds(50,170,150,30);
            caller.setBackground(Color.decode("#FFDEC8"));
            caller.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(caller);
            JTextField callerField = new JTextField();
            callerField.setLayout(null); 
            callerField.setBackground(Color.decode("#FFDEC8"));
            callerField.setBounds(250,170,250,35);
            callerField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            callerField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(callerField);

            JLabel typeOfIncident = new JLabel("Type Of Incident:");
            panel.setLayout(null); 
            typeOfIncident.setBounds(50,230,150,30);
            typeOfIncident.setBackground(Color.decode("#FFDEC8"));
            typeOfIncident.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(typeOfIncident);
            JTextField typeOfIncidentField = new JTextField();
            typeOfIncidentField.setLayout(null); 
            typeOfIncidentField.setBackground(Color.decode("#FFDEC8"));
            typeOfIncidentField.setBounds(250,230,250,35);
            typeOfIncidentField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            typeOfIncidentField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(typeOfIncidentField);

            JLabel Cause = new JLabel("Cause:");
            panel.setLayout(null); 
            Cause.setBounds(50,290,150,30);
            Cause.setBackground(Color.decode("#FFDEC8"));
            Cause.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(Cause);
            JTextField CauseField = new JTextField();
            CauseField.setLayout(null); 
            CauseField.setBackground(Color.decode("#FFDEC8"));
            CauseField.setBounds(250,290,250,35);
            CauseField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            CauseField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(CauseField);

            JLabel Injured = new JLabel("No Of Injured:");
            panel.setLayout(null); 
            Injured.setBounds(50,350,150,30);
            Injured.setBackground(Color.decode("#FFDEC8"));
            Injured.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(Injured);
            JTextField InjuredField = new JTextField();
            InjuredField.setLayout(null); 
            InjuredField.setBackground(Color.decode("#FFDEC8"));
            InjuredField.setBounds(250,350,250,35);
            InjuredField.setFont(new Font("Arial",Font.PLAIN, 18));
            InjuredField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(InjuredField);

            JLabel NoOfCasualties = new JLabel("No Of Casualties:");
            panel.setLayout(null); 
            NoOfCasualties.setBounds(50,410,170,30);
            NoOfCasualties.setBackground(Color.decode("#FFDEC8"));
            NoOfCasualties.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(NoOfCasualties);
            JTextField NoOfCasualtiesField = new JTextField();
            NoOfCasualtiesField.setLayout(null); 
            NoOfCasualtiesField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); 
            NoOfCasualtiesField.setBackground(Color.decode("#FFDEC8"));
            NoOfCasualtiesField.setBounds(250,410,250,35);
            NoOfCasualtiesField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            panel.add(NoOfCasualtiesField);

            JLabel TimeOfIncident = new JLabel("Time of Incident:");
            panel.setLayout(null); 
            TimeOfIncident.setBounds(550,110,150,30);
            TimeOfIncident.setBackground(Color.decode("#FFDEC8"));
            TimeOfIncident.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(TimeOfIncident);
            JTextField TimeOfIncidentField = new JTextField();
            TimeOfIncidentField.setLayout(null); 
            TimeOfIncidentField.setBackground(Color.decode("#FFDEC8"));
            TimeOfIncidentField.setBounds(750,110,250,35);
            TimeOfIncidentField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            TimeOfIncidentField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(TimeOfIncidentField);

            JLabel DateOfIncident = new JLabel("Date Of Incident:");
            panel.setLayout(null); 
            DateOfIncident.setBounds(550,170,150,30);
            DateOfIncident.setBackground(Color.decode("#FFDEC8"));
            DateOfIncident.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(DateOfIncident);
            JTextField DateOfIncidentField = new JTextField();
            DateOfIncidentField.setLayout(null); 
            DateOfIncidentField.setBackground(Color.decode("#FFDEC8"));
            DateOfIncidentField.setBounds(750,170,250,35);
            DateOfIncidentField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            DateOfIncidentField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(DateOfIncidentField);

            JLabel PlaceOfIncident = new JLabel("Place Of Incident:");
            panel.setLayout(null); 
            PlaceOfIncident.setBounds(550,230,180,30);
            PlaceOfIncident.setBackground(Color.decode("#FFDEC8"));
            PlaceOfIncident.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(PlaceOfIncident);
            JTextField PlaceOfIncidentField = new JTextField();
            PlaceOfIncidentField.setLayout(null); 
            PlaceOfIncidentField.setBackground(Color.decode("#FFDEC8"));
            PlaceOfIncidentField.setBounds(750,230,250,35);
            PlaceOfIncidentField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            PlaceOfIncidentField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(PlaceOfIncidentField);


            JLabel DamageOfProperty = new JLabel("Damage Of Property:");
            panel.setLayout(null); 
            DamageOfProperty.setBounds(550,290,250,30);
            DamageOfProperty.setBackground(Color.decode("#FFDEC8"));
            DamageOfProperty.setFont(new Font("Arial", Font.BOLD, 18)); 
            panel.add(DamageOfProperty);
            JTextField DamageOfPropertyField = new JTextField();
            DamageOfPropertyField.setLayout(null); 
            DamageOfPropertyField.setBackground(Color.decode("#FFDEC8"));
            DamageOfPropertyField.setBounds(750,290,250,35);
            DamageOfPropertyField.setFont(new Font("Arial",Font.PLAIN, 18)); 
            DamageOfPropertyField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));  
            panel.add(DamageOfPropertyField);

          

            JButton SaveReport = new JButton("Save Report");
            SaveReport.setLayout(null);
            SaveReport.setBackground(Color.decode("#01520E"));
            SaveReport.setForeground(Color.WHITE);
            SaveReport.setFocusPainted(false);
            SaveReport.setFont(new Font("Arial",Font.PLAIN, 24)); 
            SaveReport.setBounds(400, 640, 370, 60);
             SaveReport.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int incidentId = Integer.parseInt(IncidentField.getText());
                    String nameOfCaller = callerField.getText();
                    String typeOfIncident = typeOfIncidentField.getText();
                    String cause = CauseField.getText();
                    int noOfInjured = Integer.parseInt(InjuredField.getText());
                    int noOfCasualties = Integer.parseInt(NoOfCasualtiesField.getText());
                    String timeOfIncident = TimeOfIncidentField.getText();
                    String dateOfIncident = DateOfIncidentField.getText();
                    String placeOfIncident = PlaceOfIncidentField.getText();
                    String damageOfProperty = DamageOfPropertyField.getText();

                    // Database connection
                    String url = "jdbc:mysql://localhost:3306/fireGuard"; // Update with your DB name
                    String username = "root"; // Update with your DB username
                    String password = "root"; // Update with your DB password

                    String query = "INSERT INTO operation (incident_id, nameOfCaller, type_of_incident, cause, no_of_injured, no_of_casualties, time_of_incident, date_of_incident, place_of_incident, damage_of_property) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    try (Connection conn = DriverManager.getConnection(url, username, password);
                         PreparedStatement stmt = conn.prepareStatement(query)) {

                        stmt.setInt(1, incidentId);
                        stmt.setString(2, nameOfCaller);
                        stmt.setString(3, typeOfIncident);
                        stmt.setString(4, cause);
                        stmt.setInt(5, noOfInjured);
                        stmt.setInt(6, noOfCasualties);
                        stmt.setString(7, timeOfIncident);
                        stmt.setString(8, dateOfIncident);
                        stmt.setString(9, placeOfIncident);
                        stmt.setString(10, damageOfProperty);

                        int rowsInserted = stmt.executeUpdate();
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "Data added successfully!");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error adding data: " + ex.getMessage());
                    }
                }
            });
        panel.add(SaveReport);




 
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
