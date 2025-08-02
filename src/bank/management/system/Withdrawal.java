package bank.management.system;

import java.awt.*;

import javax.swing.*;

public class Withdrawal extends JFrame{

    // components to be placed on window
    JTextField withdrawalAmtText;   // withdrawal amount text field
    JButton withdrawButton, backButton;  // withdraw and back buttons 

    String pin;    // stores pin number

    Withdrawal(String pin){
        super("Withdrawal");   // call parent constructor 

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
        // add withdrawal amount label
        JLabel withdrawalAmtLabel = new JLabel("ENTER WITHDRAWAL AMOUNT");    // create withdrawal amount label
        withdrawalAmtLabel.setFont(new Font("System", Font.BOLD, 16)); // set font
        withdrawalAmtLabel.setBounds(502, 170, 400, 35);   // set bounds
        withdrawalAmtLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(withdrawalAmtLabel);  // add withdrawal amount label on ATM image

        // add max withdrawal amount label
        JLabel maxWithdrawalAmtLabel = new JLabel("*MAXIMUM WITHDRAWAL AMOUNT IS $10,000*");    // create max withdrawal amount label
        maxWithdrawalAmtLabel.setFont(new Font("System", Font.BOLD, 8)); // set font
        maxWithdrawalAmtLabel.setBounds(530, 190, 400, 35);   // set bounds
        maxWithdrawalAmtLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(maxWithdrawalAmtLabel);  // add max withdrawal amount label on ATM image

        // add withdrawal amount text field
        withdrawalAmtText = new JTextField();   // create withdrawal amount text field
        withdrawalAmtText.setFont(new Font("System", Font.BOLD, 22)); // set font
        withdrawalAmtText.setBounds(465, 220, 320, 30);    // set bounds
        withdrawalAmtText.setForeground(Color.WHITE);  // set text color to white
        withdrawalAmtText.setBackground(new Color(65, 125, 128));  // set background color
        withdrawalAmtText.setHorizontalAlignment(JTextField.CENTER);   // center align text
        withdrawalAmtText.setCaretColor(Color.WHITE); // make cursor white
        atmImage.add(withdrawalAmtText);   // add withdrawal amount text field on ATM image

        // add withdraw button
        withdrawButton = new JButton("WITHDRAW"); // create withdraw button
        withdrawButton.setBounds(710, 366, 130, 34);    // set bounds
        withdrawButton.setForeground(Color.WHITE);  // set text color to white
        withdrawButton.setBackground(new Color(65, 125, 128));  // set background color
        atmImage.add(withdrawButton);   // add withdraw button on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(710, 413, 130, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);  // make window visible
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
