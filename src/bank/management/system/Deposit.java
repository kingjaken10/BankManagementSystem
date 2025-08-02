package bank.management.system;

import java.util.Date;
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
    
    // components to be placed on window
    JTextField depositAmtText;   // deposit amount text field
    JButton depositButton, backButton;  // deposit and back buttons 

    String  pin;    // stores pin number

    Deposit(String pin){
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
        Image atm2 = atm1.getImage().getScaledInstance(1545, 830, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon atm3 = new ImageIcon(atm2);   // create a new ImageIcon to store the resized image
        JLabel atmImage = new JLabel(atm3); // add image to a label
        atmImage.setBounds(0, 0, 1545, 830);   // resize and position the label
        add(atmImage);  // add image to window

        // add labels and respective components to window
        // add deposit amount label
        JLabel depositAmtLabel = new JLabel("ENTER DEPOSIT AMOUNT");    // create deposit amount label
        depositAmtLabel.setFont(new Font("System", Font.BOLD, 16)); // set font
        depositAmtLabel.setBounds(520, 170, 400, 35);   // set bounds
        depositAmtLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(depositAmtLabel);  // add deposit amount label on ATM image

        // add deposit amount text field
        depositAmtText = new JTextField();   // create deposit amount text field
        depositAmtText.setFont(new Font("System", Font.BOLD, 22)); // set font
        depositAmtText.setBounds(465, 210, 320, 30);    // set bounds
        depositAmtText.setForeground(Color.WHITE);  // set text color to white
        depositAmtText.setBackground(new Color(65, 125, 128));  // set background color
        depositAmtText.setHorizontalAlignment(JTextField.CENTER);   // center align text
        depositAmtText.setCaretColor(Color.WHITE); // make cursor white
        atmImage.add(depositAmtText);   // add deposit amount text field on ATM image

        // add deposit button
        depositButton = new JButton("DEPOSIT"); // create deposit button
        depositButton.setBounds(710, 364, 130, 34);    // set bounds
        depositButton.setForeground(Color.WHITE);  // set text color to white
        depositButton.setBackground(new Color(65, 125, 128));  // set background color
        depositButton.addActionListener(this);  // add ActionListener
        atmImage.add(depositButton);   // add deposit button on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(710, 410, 130, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        backButton.addActionListener(this);  // add ActionListener
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);  // make window visible
    }

    @Override
    // clicked deposit or back buttons 
    public void actionPerformed(ActionEvent e){
        try{
            String amount = depositAmtText.getText();   // get deposit amount

            // deposit button clicked
            if(e.getSource() == depositButton){
                
                // no deposit amount inputted
                if(amount.equals("")) JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");   // display message to enter deposit amount
                // deposit amount inputted
                else{
                    // check if deposit amount is a numerical value
                    if(isNumerical(amount)){
                        Date date = new Date();   // get current timestamp (date and time)

                        Connect con1 = new Connect();   // create a Connect object
                        Connection conn = con1.getConnection(); // get the connection from the Connect class

                        String query = "INSERT INTO Bank (Pin, Date, Type, Amount) " 
                                       + "VALUES (?, '"+date+"', ?, ?)"; // query with placeholders

                        PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

                        // set the parameters for the query
                        preparedStatement.setString(1, pin);    // set pin at position 1
                        preparedStatement.setString(2, "Deposit");  // set type of action (Deposit) at position 2
                        preparedStatement.setString(3, amount); // set deposit amount at position 3 

                        preparedStatement.executeUpdate();  // execute the prepared query and update database

                        // database updated successfully
                        JOptionPane.showMessageDialog(null, "$" + amount + " Deposited Successfully");   // display message that deposit was successful
                        new main_Class(pin);    // open transaction window
                        setVisible(false);  // make this window invisible
                    }
                    else return;    // deposit amount was not a numerical value
                }
            }
            // back button clicked
            else if(e.getSource() == backButton){
                new main_Class(pin);    // open transaction window
                setVisible(false);  // make this window invisible
            }
        }
        catch(Exception E){
            E.printStackTrace();    // if exception is thrown, print stack trace
        }
    }

    public boolean isNumerical(String amount){
        boolean isNumerical = false;    // stores whether deposit amount is a numerical value or not

        // check if deposit amount is a numerical value
        try{
            Integer.parseInt(amount);   // throws an exception if amount is not a numerical value
            isNumerical = true; // deposit amount is a numerical value
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null, "Please enter a numerical value for the deposit amount");   // display message to enter a numerical deposit amount
        }

        return isNumerical; // return whether deposit amount is a numerical value or not
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
