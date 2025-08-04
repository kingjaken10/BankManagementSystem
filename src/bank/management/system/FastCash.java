package bank.management.system;

import java.util.Date;
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class FastCash extends JFrame implements ActionListener{
    
    // components to be placed on window 
    JButton hundoButton, fiveHundoButton, thousandButton, twoThousandButton, fiveThousandButton, tenThousandButton, backButton;   // buttons

    String pin; // stores pin number

    FastCash(String pin){
        super("Fast Cash");   // call parent constructor 
        
        this.pin = pin; // store pin

        // set up window
        setLayout(null);
        setSize(1545, 1000);  // set window size
        setLocationRelativeTo(null);    // center align window
        setUndecorated(true);   // hides window border
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation

        // set background image of window (ATM image)
        ImageIcon atm1 =  new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));   // load the image
        Image atm2 = atm1.getImage().getScaledInstance(1545, 870, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon atm3 = new ImageIcon(atm2);   // create a new ImageIcon to store the resized image
        JLabel atmImage = new JLabel(atm3); // add image to a label
        atmImage.setBounds(0, 0, 1545, 870);   // resize and position the label
        add(atmImage);  // add image to window

        // add withdrawl prompt label and buttons to window
        // add withdrawl prompt label
        JLabel transactionLabel = new JLabel("SELECT WITHDRAWAL AMOUNT");    // create withdrawl prompt label
        transactionLabel.setFont(new Font("System", Font.BOLD, 22)); // set font
        transactionLabel.setBounds(445, 180, 700, 35);   // set bounds
        transactionLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(transactionLabel);  // add withdrawl prompt label on ATM image

        // add $100 button
        hundoButton = new JButton("$100"); // create $100 button
        hundoButton.setBounds(415, 272, 150, 34);    // set bounds
        hundoButton.setForeground(Color.WHITE);  // set text color to white
        hundoButton.setBackground(new Color(65, 125, 128));  // set background color
        hundoButton.addActionListener(this);  // add ActionListener
        atmImage.add(hundoButton);   // add $100 button on ATM image

        // add $500 button
        fiveHundoButton = new JButton("$500"); // create $500 button
        fiveHundoButton.setBounds(415, 319, 150, 34);    // set bounds
        fiveHundoButton.setForeground(Color.WHITE);  // set text color to white
        fiveHundoButton.setBackground(new Color(65, 125, 128));  // set background color
        fiveHundoButton.addActionListener(this);  // add ActionListener
        atmImage.add(fiveHundoButton);   // add $500 button on ATM image
        
        // add $1,000 button
        thousandButton = new JButton("$1000"); // create $1,000 button
        thousandButton.setBounds(415, 366, 150, 34);    // set bounds
        thousandButton.setForeground(Color.WHITE);  // set text color to white
        thousandButton.setBackground(new Color(65, 125, 128));  // set background color
        thousandButton.addActionListener(this);  // add ActionListener
        atmImage.add(thousandButton);   // add $1,000 button on ATM image
        
        // add $2,000 button
        twoThousandButton = new JButton("$2000"); // create $2,000 button
        twoThousandButton.setBounds(690, 272, 150, 34);    // set bounds
        twoThousandButton.setForeground(Color.WHITE);  // set text color to white
        twoThousandButton.setBackground(new Color(65, 125, 128));  // set background color
        twoThousandButton.addActionListener(this);  // add ActionListener
        atmImage.add(twoThousandButton);   // add $2,000 button on ATM image

        // add $5,000 button
        fiveThousandButton = new JButton("$5000"); // create $5,000 button
        fiveThousandButton.setBounds(690, 319, 150, 34);    // set bounds
        fiveThousandButton.setForeground(Color.WHITE);  // set text color to white
        fiveThousandButton.setBackground(new Color(65, 125, 128));  // set background color
        fiveThousandButton.addActionListener(this);  // add ActionListener
        atmImage.add(fiveThousandButton);   // add $5,000 button on ATM image

        // add $10,000 button
        tenThousandButton = new JButton("$10000"); // create $10,000 button
        tenThousandButton.setBounds(690, 366, 150, 34);    // set bounds
        tenThousandButton.setForeground(Color.WHITE);  // set text color to white
        tenThousandButton.setBackground(new Color(65, 125, 128));  // set background color
        tenThousandButton.addActionListener(this);  // add ActionListener
        atmImage.add(tenThousandButton);   // add $10,000 button on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(690, 413, 150, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        backButton.addActionListener(this);  // add ActionListener
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);   // make window visible
    }

    @Override
    // clicked a button
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == backButton){
            new main_Class(pin);    // open transaction window
            setVisible(false);  // make this window invisible
        }
        else{
            String amount = ((JButton)e.getSource()).getText().substring(1);    // get withdrawal amount

            try{
                Date date = new Date();   // get current timestamp (date and time)

                Connect con1 = new Connect();   // create a Connect object
                Connection conn = con1.getConnection(); // get the connection from the Connect class
            
                double balance = getBalance(conn);  // get user's balance

                // if fast cash amount is greater than balance, display error message
                if(balance < Double.parseDouble(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance \nCurrent Balance: $" + String.format("%.2f", balance), "Error", JOptionPane.ERROR_MESSAGE); // display error message
                    return;
                }

                // update database with fast cash details
                String query = "INSERT INTO Bank (Pin, Date, Type, Amount) " 
                                + "VALUES (?, '"+date+"', ?, ?)"; // query with placeholders
                
                PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

                // set the parameter for the query
                preparedStatement.setString(1, pin);    // set pin at position 1
                preparedStatement.setString(2, "Withdrawal");    // set type of action (withdrawal) at position 2
                preparedStatement.setString(3, amount);    // set withdrawal amount at position 3
                
                preparedStatement.executeUpdate();  // execute the prepared query and update database

                // database updated successfully
                String formattedValue = String.format("%.2f", Double.parseDouble(amount));  // format fast cash amount to 2 decimal places
                Double updatedBalance = balance - Double.parseDouble(amount);   // balance after withdrawal
                JOptionPane.showMessageDialog(null, "$" + formattedValue + " Withdrawn Successfully \nCurrent Balance: $" + String.format("%.2f", updatedBalance));   // display message that withdrawal was successful
                new main_Class(pin);    // open transaction window
                setVisible(false);  // make this window invisible
            } 
            catch(Exception E){
                E.printStackTrace();    // if exception is thrown, print stack trace
            }
        }
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
        new FastCash("");
    }
}
