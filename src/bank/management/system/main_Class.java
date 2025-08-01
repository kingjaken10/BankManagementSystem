package bank.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class main_Class extends JFrame implements ActionListener{

    // components to be placed on window 
    JButton depositButton, fastCashButton, pinChangeButton, withdrawalButton, miniStmtButton, balanceButton, exitButton;   // buttons

    main_Class(){
        super("Transaction");   // call parent constructor 
        
        // set up window
        setLayout(null);
        setSize(1545, 1000);  // set window size
        setLocationRelativeTo(null);    // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation

        // set background image of window (ATM image)
        ImageIcon atm1 =  new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));   // load the image
        Image atm2 = atm1.getImage().getScaledInstance(1545, 830, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon atm3 = new ImageIcon(atm2);   // create a new ImageIcon to store the resized image
        JLabel atmImage = new JLabel(atm3); // add image to a label
        atmImage.setBounds(0, 0, 1545, 830);   // resize and position the label
        add(atmImage);  // add image to window

        // add labels and buttons to window
        // add transaction prompt label
        JLabel transactionLabel = new JLabel("PLEASE SELECT YOUR TRANSACTION");    // create transaction prompt label
        transactionLabel.setFont(new Font("System", Font.BOLD, 22)); // set font
        transactionLabel.setBounds(415, 180, 700, 35);   // set bounds
        transactionLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(transactionLabel);  // add transaction prompt label on ATM image

        // add deposit button
        depositButton = new JButton("DEPOSIT"); // create deposit button
        depositButton.setBounds(415, 270, 150, 34);    // set bounds
        depositButton.setForeground(Color.WHITE);  // set text color to white
        depositButton.setBackground(new Color(65, 125, 128));  // set background color
        depositButton.addActionListener(this);  // add ActionListener
        atmImage.add(depositButton);   // add deposit button on ATM image

        // add fast cash button
        fastCashButton = new JButton(" FAST CASH"); // create fast cash button
        fastCashButton.setBounds(415, 316, 150, 34);    // set bounds
        fastCashButton.setForeground(Color.WHITE);  // set text color to white
        fastCashButton.setBackground(new Color(65, 125, 128));  // set background color
        fastCashButton.addActionListener(this);  // add ActionListener
        atmImage.add(fastCashButton);   // add fast cash button on ATM image
        
        // add pin change button
        pinChangeButton = new JButton("PIN CHANGE"); // create pin change button
        pinChangeButton.setBounds(415, 363, 150, 34);    // set bounds
        pinChangeButton.setForeground(Color.WHITE);  // set text color to white
        pinChangeButton.setBackground(new Color(65, 125, 128));  // set background color
        pinChangeButton.addActionListener(this);  // add ActionListener
        atmImage.add(pinChangeButton);   // add pin change button on ATM image
        
        // add cash withdrawal button
        withdrawalButton = new JButton("CASH WITHDRAWAL"); // create cash withdrawal button
        withdrawalButton.setBounds(690, 271, 150, 34);    // set bounds
        withdrawalButton.setForeground(Color.WHITE);  // set text color to white
        withdrawalButton.setBackground(new Color(65, 125, 128));  // set background color
        withdrawalButton.addActionListener(this);  // add ActionListener
        atmImage.add(withdrawalButton);   // add cash withdrawal button on ATM image

        // add mini statement button
        miniStmtButton = new JButton("MINI STATEMENT"); // create mini statement button
        miniStmtButton.setBounds(690, 317, 150, 34);    // set bounds
        miniStmtButton.setForeground(Color.WHITE);  // set text color to white
        miniStmtButton.setBackground(new Color(65, 125, 128));  // set background color
        miniStmtButton.addActionListener(this);  // add ActionListener
        atmImage.add(miniStmtButton);   // add mini statement button on ATM image

        // add balance inquiry button
        balanceButton = new JButton("BALANCE INQUIRY"); // create balance inquiry button
        balanceButton.setBounds(690, 364, 150, 34);    // set bounds
        balanceButton.setForeground(Color.WHITE);  // set text color to white
        balanceButton.setBackground(new Color(65, 125, 128));  // set background color
        balanceButton.addActionListener(this);  // add ActionListener
        atmImage.add(balanceButton);   // add balance inquiry button on ATM image

        // add exit button
        exitButton = new JButton("EXIT"); // create exit button
        exitButton.setBounds(690, 410, 150, 34);    // set bounds
        exitButton.setForeground(Color.WHITE);  // set text color to white
        exitButton.setBackground(new Color(65, 125, 128));  // set background color
        exitButton.addActionListener(this);  // add ActionListener
        atmImage.add(exitButton);   // add exit button on ATM image

        setVisible(true);   // make window visible
    }

    @Override
    // clicked a button
    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {
        new main_Class();
    }
}
