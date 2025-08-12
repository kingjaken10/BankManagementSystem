package bank.management.system;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Pin extends JFrame implements ActionListener{
    
    // components to be placed on window
    JPasswordField pinPass, pinConfirmPass;   // new pin and pin confirmation password fields
    JButton changeButton, backButton;  // change and back buttons 

    String pin;    // stores pin number

    Pin(String pin){
        super("Pin Change");   // call parent constructor 

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
        pinConfirmPass.setCaretColor(Color.WHITE); // make cursor white
        atmImage.add(pinConfirmPass);  // add pin confirmation password field on ATM image

        // add change button
        changeButton = new JButton("CHANGE"); // create change button
        changeButton.setBounds(710, 382, 130, 34);    // set bounds
        changeButton.setForeground(Color.WHITE);  // set text color to white
        changeButton.setBackground(new Color(65, 125, 128));  // set background color
        changeButton.addActionListener(this);  // add ActionListener
        getRootPane().setDefaultButton(changeButton);   // make enter key function as change button
        atmImage.add(changeButton);   // add change button on ATM image

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
    // clicked change or back buttons
    public void actionPerformed(ActionEvent e){

        try{
            // get new pin and pin confirmation
            char[] pinChar = pinPass.getPassword(); // get new pin as a char array
            char[] pinConfirmChar = pinConfirmPass.getPassword();   // get pin confirmation as a char array
            String newPin = new String(pinChar);    //  convert new pin to String
            String pinConfirm = new String(pinConfirmChar); // convert pin confirmation to String

            // change button clicked
            if(e.getSource() == changeButton){

                // check if new pin inputted
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");   // display error message
                    return;
                }

                // check if pin confirmation inputted
                if(pinConfirm.equals("")){
                    JOptionPane.showMessageDialog(null, "Confirm New PIN");   // display error message
                    return;
                }

                // check if new pin and pin confirmation match
                if(!newPin.equals(pinConfirm)){
                    JOptionPane.showMessageDialog(null, "Entered PIN entries do not match", "Error", JOptionPane.ERROR_MESSAGE);   // display error message
                    return;
                }

                // update tables in database with new pin
                updatePin("Bank", newPin);  // update Bank table
                updatePin("Login", newPin); // update Login table
                updatePin("SignUpThree", newPin);   // update SignUpThree table

                // database updated successfully
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");    // display message that pin was changed
                new main_Class(newPin); //open transaction window
                setVisible(false);    // make this window invisible

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

    public void updatePin(String tableName, String newPin){
        
        try{
        // update table in database with new pin
        Connect con1 = new Connect();   // create a Connect object
        Connection conn = con1.getConnection(); // get the connection from the Connect class 

        String query = "UPDATE " + tableName + " SET Pin = ? WHERE Pin = ?"; // query with placeholders

        PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

        // set the parameters for the query
        preparedStatement.setString(1, newPin);    // set new pin at position 1
        preparedStatement.setString(2, pin);  // set current pin at position 2

        preparedStatement.executeUpdate();  // execute the prepared query and update database
        }
        catch(Exception e){
            e.printStackTrace();    // if exception is thrown, print stack trace
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
