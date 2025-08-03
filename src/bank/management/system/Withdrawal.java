package bank.management.system;

import java.util.Date;
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener{

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
        withdrawButton.addActionListener(this);  // add ActionListener
        atmImage.add(withdrawButton);   // add withdraw button on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(710, 413, 130, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        backButton.addActionListener(this);  // add ActionListener
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);  // make window visible
    }

    @Override
    // clicked withdraw or back buttons 
    public void actionPerformed(ActionEvent e){
        try{
            String amount = withdrawalAmtText.getText();   // get withdrawal amount

            // withdraw button clicked
            if(e.getSource() == withdrawButton){
                
                // no withdrawal amount inputted
                if(amount.equals("")) JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");   // display message to enter withdrawal amount
                // withdrawal amount inputted
                else{
                    // check if withdrawal amount is a numerical value
                    if(isNumerical(amount)){

                        // check if withdrawal amount exceeds maximum withdrawal amount
                        if(Double.parseDouble(amount) > 10000){
                            JOptionPane.showMessageDialog(null, "Entered withdrawal amount exceeds limit of $10,000");   // display message that withdrawal amount exceeds limit
                            return;
                        }

                        Date date = new Date();   // get current timestamp (date and time)

                        Connect con1 = new Connect();   // create a Connect object
                        Connection conn = con1.getConnection(); // get the connection from the Connect class
                    
                        double balance = getBalance(conn);  // get user's balance

                        // if withdrawal amount is greater than balance, display error message
                        if(balance < Double.parseDouble(amount)){
                            JOptionPane.showMessageDialog(null, "Insufficient Balance \nCurrent Balance: $" + String.format("%.2f", balance), "Error", JOptionPane.ERROR_MESSAGE); // display error message
                            return;
                        }

                        // update database with withdrawal details
                        String query = "INSERT INTO Bank (Pin, Date, Type, Amount) " 
                                        + "VALUES (?, '"+date+"', ?, ?)"; // query with placeholders
                        
                        PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

                        // set the parameter for the query
                        preparedStatement.setString(1, pin);    // set pin at position 1
                        preparedStatement.setString(2, "Withdrawal");    // set type of action (withdrawal) at position 2
                        preparedStatement.setString(3, amount);    // set withdrawal amount at position 3
                        
                        preparedStatement.executeUpdate();  // execute the prepared query and update database

                        // database updated successfully
                        String formattedValue = String.format("%.2f", Double.parseDouble(amount));  // format withdrawal amount to 2 decimal places
                        Double updatedBalance = balance - Double.parseDouble(amount);   // balance after withdrawal
                        JOptionPane.showMessageDialog(null, "$" + formattedValue + " Withdrawn Successfully \nCurrent Balance: $" + String.format("%.2f", updatedBalance));   // display message that withdrawal was successful
                        new main_Class(pin);    // open transaction window
                        setVisible(false);  // make this window invisible
                    }
                    else return;    // withdrawal amount was not a numerical value
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
        boolean isNumerical = false;    // stores whether withdrawal amount is a numerical value or not

        // check if withdrawal amount is a numerical value
        try{
            Double.parseDouble(amount);   // throws an exception if amount is not a numerical value
            isNumerical = true; // withdrawal amount is a numerical value
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null, "Please enter a numerical value for the withdrawal amount");   // display message to enter a numerical withdrawal amount
        }

        return isNumerical; // return whether withdrawal amount is a numerical value or not
    }

    public double getBalance(Connection conn){
        double balance = 0.0;   // stores user's balance

        try{
            // determine user's balance based on pin
            String query = "SELECT * FROM Bank WHERE Pin = ?"; // query with placeholder
            
            PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

            // set the parameter for the query
            preparedStatement.setString(1, pin);    // set pin at position 1

            ResultSet resultSet = preparedStatement.executeQuery(); // execute the prepared query

            while(resultSet.next()){
                // has info in database
                if(resultSet.getString("Type").equals("Deposit")) balance += Double.parseDouble(resultSet.getString("Amount")); // add to balance if entry is a deposit
                else balance -= Double.parseDouble(resultSet.getString("Amount"));  // subtract from balance if entry is not a deposit
            }
        }
        catch(Exception E){
            E.printStackTrace();    // if exception is thrown, print stack trace
        }

        return balance; // return user's balance
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
