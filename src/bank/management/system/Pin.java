package bank.management.system;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Pin extends JFrame{
    
    // components to be placed on window
    JPasswordField pinPass, pinConfirmPass;   // new pin and pin confirmation password fields
    JButton changeButton, backButton;  // change and back buttons 

    String pin;    // stores pin number

    // create a LineBorder with a specific color and thickness
    Border whiteBorder =  new LineBorder(Color.WHITE, 2);

    Pin(String pin){
        super("Deposit");   // call parent constructor 

        this.pin = pin; // store pin

        // set up window
        setLayout(null);
        setSize(1545, 1000);  // set window size
        setLocationRelativeTo(null);    // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation

        // set background image of window (ATM image)
        ImageIcon atm1 =  new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));   // load the image
        Image atm2 = atm1.getImage().getScaledInstance(1545, 835, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon atm3 = new ImageIcon(atm2);   // create a new ImageIcon to store the resized image
        JLabel atmImage = new JLabel(atm3); // add image to a label
        atmImage.setBounds(0, 0, 1545, 835);   // resize and position the label
        add(atmImage);  // add image to window

        // add labels and respective components to window
        // add change pin label
        JLabel changePinLabel = new JLabel("CHANGE YOUR PIN");    // create change pin label
        changePinLabel.setFont(new Font("System", Font.BOLD, 16)); // set font
        changePinLabel.setBounds(445, 160, 400, 35);   // set bounds
        changePinLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(changePinLabel);  // add change pin label on ATM image

        // add new pin label
        JLabel pinLabel = new JLabel("New PIN:");    // create new pin label
        pinLabel.setFont(new Font("System", Font.BOLD, 16)); // set font
        pinLabel.setBounds(445, 200, 400, 35);   // set bounds
        pinLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(pinLabel);  // add new pin label on ATM image

        // add new pin password field
        pinPass = new JPasswordField();    // create new pin password field
        pinPass.setFont(new Font("System", Font.BOLD, 24)); // set font
        pinPass.setBounds(600, 200, 200, 30);   // set bounds
        pinPass.setForeground(Color.WHITE); // set text color to white
        pinPass.setBackground(new Color(65, 125, 128));  // set background color
        pinPass.setBorder(whiteBorder);    // set border color to white
        pinPass.setCaretColor(Color.WHITE); // make cursor white
        atmImage.add(pinPass);  // add new pin password field on ATM image

        // add pin confirmation label
        JLabel pinConfirmLabel = new JLabel("Confirm New PIN:");    // create pin confirmation label
        pinConfirmLabel.setFont(new Font("System", Font.BOLD, 16)); // set font
        pinConfirmLabel.setBounds(445, 240, 400, 35);   // set bounds
        pinConfirmLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(pinConfirmLabel);  // add pin confirmation label on ATM image
        
        // add pin confirmation password field
        pinConfirmPass = new JPasswordField();    // create pin confirmation password field
        pinConfirmPass.setFont(new Font("System", Font.BOLD, 24)); // set font
        pinConfirmPass.setBounds(600, 240, 200, 30);   // set bounds
        pinConfirmPass.setForeground(Color.WHITE); // set text color to white
        pinConfirmPass.setBackground(new Color(65, 125, 128));  // set background color
        pinConfirmPass.setBorder(whiteBorder);    // set border color to white
        pinConfirmPass.setCaretColor(Color.WHITE); // make cursor white
        atmImage.add(pinConfirmPass);  // add pin confirmation password field on ATM image

        // add change button
        changeButton = new JButton("CHANGE"); // create change button
        changeButton.setBounds(710, 366, 130, 34);    // set bounds
        changeButton.setForeground(Color.WHITE);  // set text color to white
        changeButton.setBackground(new Color(65, 125, 128));  // set background color
        atmImage.add(changeButton);   // add change button on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(710, 413, 130, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);  // make window visible
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
