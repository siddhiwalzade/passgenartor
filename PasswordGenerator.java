package pass;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.datatransfer.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PasswordGenerator extends JFrame implements ActionListener {
	Scanner sc=new Scanner(System.in);
    private JLabel passwordLabel;
    private JTextField passwordTextField;
    private JButton generateButton, copyButton;
    private JButton button = new JButton("Get Input");
    
    private JCheckBox upperCaseCheckBox, lowerCaseCheckBox, numberCheckBox, symbolCheckBox;
   private Clipboard clipboard;
    private Random random;

    public PasswordGenerator() {
        setTitle("Password Generator");
        setSize(500, 500);
    

        JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(20, 5));

        passwordLabel = new JLabel("Random  Password:");
        panel.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setEditable(false);
        panel.add(passwordTextField);

        upperCaseCheckBox = new JCheckBox("Include Uppercase Letters");
        panel.add(upperCaseCheckBox);

        lowerCaseCheckBox = new JCheckBox("Include Lowercase Letters");
        panel.add(lowerCaseCheckBox);

        numberCheckBox = new JCheckBox("Include Numbers");
        panel.add(numberCheckBox);

        symbolCheckBox = new JCheckBox("Include Symbols");
        panel.add(symbolCheckBox);

        
   
        
        generateButton = new JButton("Generate Password");
        generateButton.addActionListener(this);
        panel.add(generateButton);

        copyButton = new JButton("Copy to Clipboard");
        copyButton.addActionListener(this);
      panel.add(copyButton);

        add(panel);
        setVisible(true);

       // clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        random = new Random();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            String characters = "";
            if (upperCaseCheckBox.isSelected()) {
                characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            }
            if (lowerCaseCheckBox.isSelected()) {
                characters += "abcdefghijklmnopqrstuvwxyz";
            }
            if (numberCheckBox.isSelected()) {
                characters += "0123456789";
            }
            if (symbolCheckBox.isSelected()) {
                characters += "!@#$%^&*()_+-=[]{}|;:,.<>/?";
            }

            if (characters.length() == 0) {
            	 JOptionPane.showMessageDialog(this, "Please select at least one character type.");
            } else {
             
                StringBuilder password = new StringBuilder();
              

                for (int i = 0; i < 8; i++) {
                    int pass = random.nextInt(characters.length());
                    password.append(characters.charAt(pass));
                }

                passwordTextField.setText(password.toString());
            }
        } else if (e.getSource() == copyButton) {

        	StringSelection selection = new StringSelection(passwordTextField.getText());
           clipboard.setContents(selection, null);
        }
    }

    public static void main(String[] args) {
        new PasswordGenerator();
    }
}
