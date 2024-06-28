import javax.swing.*;
import java.awt.*;

public class dashboard {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame (window)
            JFrame frame = new JFrame("dashboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
   
   
            //load and resize the image 
            String imagePath = "C:/Users/Acer/Desktop/project.java/Screenshot 2024-05-28 115233.png";
            ImageIcon originalIcon = new ImageIcon(imagePath); // Create an ImageIcon from the image path

            // Resize the image
            Image originalImage = originalIcon.getImage();
            int newWidth = 200; // Set the desired width
            int newHeight = 167; // Set the desired height
            Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
 
            // Create a new ImageIcon with the resized image
            ImageIcon resizedIcon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(resizedIcon);

            // Create a panel for the image and align to top-left
            JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            imagePanel.add(imageLabel);
            
            // add the imge to the frame
            frame.add(imagePanel, BorderLayout.WEST);


   
            // Set frame size and make it visible
   
            frame.pack();
   
            frame.setSize(1377, 832);
   
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setVisible(true);
        });
    }

    
}
