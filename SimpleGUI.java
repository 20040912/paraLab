import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleGUI {
   public static void main(String[] args) {
      JFrame frame = new JFrame("Input GUI");
      frame.setSize(400, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      JPanel panel = new JPanel();
      frame.add(panel);
      placeComponents(panel);
      
      frame.setVisible(true);
   }
   
   private static void placeComponents(JPanel panel) {
      panel.setLayout(null);
      
      JLabel label = new JLabel("Enter text: ");
      label.setBounds(10, 20, 80, 25);
      panel.add(label);
      
      JTextField textField = new JTextField(20);
      textField.setBounds(100, 20, 250, 25);
      panel.add(textField);
      
      JButton button = new JButton("Submit");
      button.setBounds(150, 60, 100, 25);
      panel.add(button);
      
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String inputText = textField.getText();
            
            JOptionPane.showMessageDialog(null, "You entered: " + inputText);
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Notedpad.txt", true))) {
               writer.write(inputText);
               writer.newLine();
               JOptionPane.showMessageDialog(null, "Text save to Notepad.txt");
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }
      });
   }
}