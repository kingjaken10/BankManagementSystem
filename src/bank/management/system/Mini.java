package bank.management.system;

import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Mini extends JFrame implements ActionListener{

    String pin; // stores pin number

    Mini(String pin){
        super("Mini Statement");   // call parent constructor 
        
        // component to be placed on window 
        JButton exitButton; // exit button

        this.pin = pin; // store pin

        // set up window
        setLayout(null);
        getContentPane().setBackground(new Color(192, 134, 240));   // set window background color
        setSize(400, 540);  // set window size
        setLocationRelativeTo(null);    // center align window
        setUndecorated(true);   // hides window border
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        
        // add labels and exit button to window
        // add title label
        JLabel titleLabel = new JLabel("--------MINI STATEMENT--------");   // create title label
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 16)); // set font
        titleLabel.setBounds(-10, 5, 400, 20);   // set bounds
        titleLabel.setHorizontalAlignment(JTextField.CENTER);   // center align text
        add(titleLabel);  // add title label to window

        // card number label
        JLabel cardNoLabel = new JLabel();   // create card number label
        cardNoLabel.setFont(new Font("Monospaced", Font.BOLD, 16));    // set font
        cardNoLabel.setBounds(20, 40, 300, 20);   // set bounds
        add(cardNoLabel);  // add card number label to window

        // add balance label
        JLabel balanceLabel = new JLabel();   // create balance label
        balanceLabel.setFont(new Font("Monospaced", Font.BOLD, 16));    // set font
        balanceLabel.setBounds(20, 400, 300, 20);   // set bounds
        add(balanceLabel);  // add balance label to window

        // set up statement label
        JLabel statementLabel = new JLabel();   // create statement label
        statementLabel.setFont(new Font("Monospaced", Font.BOLD, 11));  // set font
        statementLabel.setVerticalAlignment(SwingConstants.TOP);    // make text always appear at top of label

        // add exit button
        exitButton = new JButton("EXIT");   // create exit button
        exitButton.setFont(new Font("Monospaced", Font.BOLD, 14));  // set font
        exitButton.setBounds(20, 450, 75, 25); // set bounds
        exitButton.setForeground(Color.WHITE);  // set text color to white
        exitButton.setBackground(Color.BLACK);  // set button color to black
        exitButton.addActionListener(this); // add ActionListener
        add(exitButton);    // add exit button to window

        // set text of card number label
        try{
            // get card number to set text of card number label
            Connect con1 = new Connect();   // create a Connect object
            Connection conn = con1.getConnection(); // get the connection from the Connect class

            String query = "SELECT * FROM Login WHERE Pin = ?"; // query with placeholder
            
            PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

            // set the parameter for the query
            preparedStatement.setString(1, pin);    // set pin at position 1

            ResultSet resultSet = preparedStatement.executeQuery(); // execute the prepared query

            while(resultSet.next()){
                cardNoLabel.setText("CARD NUMBER: " + resultSet.getString("Card_No").substring(0,4) + "XXXXXXXX" + resultSet.getString("Card_No").substring(12));   // set text of card number label
            }
        }
        catch(Exception e){
            e.printStackTrace();    // if exception is thrown, print stack trace
        }

        // get user balance and statement to set text of balance label and statement label
        try{
            double balance = 0.0;   // store user's 

            Connect con1 = new Connect();   // create a Connect object
            Connection conn = con1.getConnection(); // get the connection from the Connect class
            
            // determine user's balance based on pin
            String query = "SELECT * FROM Bank WHERE Pin = ?"; // query with placeholder
            
            PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

            // set the parameter for the query
            preparedStatement.setString(1, pin);    // set pin at position 1

            ResultSet resultSet = preparedStatement.executeQuery(); // execute the prepared query

            while(resultSet.next()){
                // update statement label
                if(resultSet.getString("Type").equals("Deposit")){
                    statementLabel.setText("<html>" + statementLabel.getText().replace("<html>", "").replace("</html>","") 
                                       + resultSet.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("Type") 
                                       + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;$" + resultSet.getString("Amount") + "<br><br><html>"); // set text of statement label
                }
                else{
                    statementLabel.setText("<html>" + statementLabel.getText().replace("<html>", "").replace("</html>","") 
                                       + resultSet.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("Type") 
                                       + "&nbsp;&nbsp;&nbsp;&nbsp;$" + resultSet.getString("Amount") + "<br><br><html>"); // set text of statement label
                }

                // calculate balance
                if(resultSet.getString("Type").equals("Deposit")) balance += Double.parseDouble(resultSet.getString("Amount")); // add to balance if entry is a deposit
                else balance -= Double.parseDouble(resultSet.getString("Amount"));  // subtract from balance if entry is not a deposit
            }

            // add statement scroll pane
            JScrollPane scrollPane = new JScrollPane(statementLabel);   // create statement scroll pane
            scrollPane.setBounds(20, 80, 350, 300); // set bounds
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);    // vertical scroll bar appears if needed
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);    // horizontal scroll bar appears if needed
            scrollPane.setOpaque(false);    // make scroll pane not opaque
            scrollPane.getViewport().setBackground(new Color(192, 134, 240));   // set background color to be same as window's
            scrollPane.setBorder(new LineBorder(new Color(192, 134, 240))); // set border color to be same as window's
            add(scrollPane);    // add statement scroll pane to window

            balanceLabel.setText("CURRENT BALANCE: $" + String.format("%.2f", balance));    // set text of balance label
        }
        catch(Exception e){
            e.printStackTrace();    // if exception is thrown, print stack trace
        }

        setVisible(true);   // make this window visible
    }

    @Override
    // clicked exit button
    public void actionPerformed(ActionEvent e){
        setVisible(false);  // make this window invisible
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
