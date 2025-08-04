package bank.management.system;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class BalanceInquiry extends JFrame implements ActionListener{

    // components to be placed on window
    JLabel balanceLabel;   // balance label
    JButton backButton;  // back button

    String pin;    // stores pin number

    BalanceInquiry(String pin){
        super("Balance Inquiry");   // call parent constructor 

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

        // add labels and back button to window
        // add balance description label
        JLabel balanceDescripLabel = new JLabel("CURRENT BALANCE");    // create balance description label
        balanceDescripLabel.setFont(new Font("System", Font.BOLD, 28)); // set font
        balanceDescripLabel.setBounds(485, 170, 320, 35);   // set bounds
        balanceDescripLabel.setForeground(Color.WHITE); // set text color to white
        atmImage.add(balanceDescripLabel);  // add balance description label on ATM image

        // add balance label
        balanceLabel = new JLabel("$" + String.format("%.2f", getBalance()));    // create balance label
        balanceLabel.setFont(new Font("System", Font.BOLD, 30)); // set font
        balanceLabel.setBounds(465, 210, 320, 35);   // set bounds
        balanceLabel.setForeground(Color.WHITE); // set text color to white
        balanceLabel.setOpaque(true);   // make balance label opaque
        balanceLabel.setBackground(new Color(65, 125, 128));  // set background color
        balanceLabel.setHorizontalAlignment(JTextField.CENTER);   // center align text
        atmImage.add(balanceLabel);  // add balance label on ATM image

        // add back button
        backButton = new JButton("BACK"); // create back button
        backButton.setBounds(710, 430, 130, 34);    // set bounds
        backButton.setForeground(Color.WHITE);  // set text color to white
        backButton.setBackground(new Color(65, 125, 128));  // set background color
        backButton.addActionListener(this);  // add ActionListener
        atmImage.add(backButton);   // add back button on ATM image

        setVisible(true);  // make window visible
    }

    @Override
    // clicked back button
    public void actionPerformed(ActionEvent e){
        new main_Class(pin);    // open transaction window
        setVisible(false);  // make this window invisible
    }

    public double getBalance(){
        double balance = 0.0;   // stores user's balance

        try{
            // determine user's balance based on pin
            Connect con1 = new Connect();   // create a Connect object
            Connection conn = con1.getConnection(); // get the connection from the Connect class

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
        new BalanceInquiry("");
    }
}
