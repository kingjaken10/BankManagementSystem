package bank.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener{

    // components to be placed on window 
    JLabel welcomeLabel, cardNoLabel, pinLabel;  // labels for welcome message, card number, and pin
    JTextField cardNoText;  // text field for card number
    JPasswordField pinField;  // password field for pin
    JButton signInButton, clearButton, signUpButton; // buttons for sign in, clear, and sign up

    // create a LineBorder with a specific color and thickness
    Border blackBorder = new LineBorder(Color.BLACK, 2);
    Border whiteBorder =  new LineBorder(Color.WHITE, 2);
    Border darkGrayBorder = new LineBorder(Color.DARK_GRAY, 2);

    Login(){
        super("Bank Management System");    // call parent constructor

        // set up window
        setLayout(null);
        setSize(850, 480);  // set window size
        setLocationRelativeTo(null); // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation

        // add icons to window
        // add bank icon to window
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));   // load the image
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // resize the image
        ImageIcon bank3 = new ImageIcon(bank2); // create a new ImageIcon to store the resized image
        JLabel bankImage = new JLabel(bank3);   // add image to a label
        bankImage.setBounds(370, 10, 100, 100); // resize and position the label
        add(bankImage); // add label to window

        // add card icon to window
        // ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));   // load the image
        // Image card2 = card1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    // resize the image
        // ImageIcon card3 = new ImageIcon(card2); // create a new ImageIcon to store the resized image
        // JLabel cardImage = new JLabel(card3);   // add image to a label
        // cardImage.setBounds(700, 345, 100, 100);    // resize and position the label
        // add(cardImage); // add label to window

        // add labels and respective text fields to window
        // add welcome label
        welcomeLabel = new JLabel("WELCOME TO ATM");  // create welcome label
        // welcomeLabel.setForeground(Color.WHITE);  // set text color to white
        welcomeLabel.setForeground(Color.BLACK);  // set text color to black
        welcomeLabel.setFont(new Font("Britannic Bold", Font.BOLD, 43));  // set font
        welcomeLabel.setBounds(240, 120, 450, 40);    // set bounds
        add(welcomeLabel);    // add welcome label to window

        // add card number label
        cardNoLabel = new JLabel("Card No:");    // create card number label
        // cardNoLabel.setForeground(Color.WHITE);  // set text color to white
        cardNoLabel.setForeground(Color.BLACK);  // set text color to black
        cardNoLabel.setFont(new Font("Britannic Bold", Font.BOLD, 28));  // set font
        cardNoLabel.setBounds(240, 190, 375, 30);    // set bounds
        add(cardNoLabel);    // add card number label to window

        // add text field for card number
        cardNoText = new JTextField(15);    // create card number text field
        cardNoText.setBounds(370, 190, 230, 30);    // set bounds
        cardNoText.setFont(new Font("Arial", Font.BOLD, 14));   // set font  
        // cardNoText.setBackground(Color.DARK_GRAY);  // set background color to dark gray
        // cardNoText.setForeground(Color.WHITE);  // set text color to white
        cardNoText.setBackground(Color.WHITE);  // set background color to white
        cardNoText.setForeground(Color.BLACK);  // set text color to black
        cardNoText.setBorder(whiteBorder);  // set border color to white
        // cardNoText.setCaretColor(Color.WHITE); // make cursor white
        cardNoText.setCaretColor(Color.BLACK); // make cursor black
        add(cardNoText);    // add card number text field to window

        // add pin label
        pinLabel = new JLabel("PIN:");    // create pin label
        // pinLabel.setForeground(Color.WHITE);  // set text color to white
        pinLabel.setForeground(Color.BLACK);  // set text color to black
        pinLabel.setFont(new Font("Britannic Bold", Font.BOLD, 28));  // set font
        pinLabel.setBounds(240, 230, 375, 30);    // set bounds
        add(pinLabel);    // add pin label to window

        // add password field for pin
        pinField = new JPasswordField(15);    // create pin password field
        pinField.setBounds(370, 230, 230, 30);    // set bounds
        pinField.setFont(new Font("Arial", Font.BOLD, 14));   // set font
        // pinField.setBackground(Color.DARK_GRAY);  // set background color to dark gray
        // pinField.setForeground(Color.WHITE);  // set text color to white
        pinField.setBackground(Color.WHITE);  // set background color to white
        pinField.setForeground(Color.BLACK);  // set text color to black
        pinField.setBorder(whiteBorder);  // set border color to white
        // pinField.setCaretColor(Color.WHITE);    // make cursor white
        pinField.setCaretColor(Color.BLACK);    // make cursor black
        add(pinField);    // add pin password field to window   

        // add buttons to window
        // add sign in button
        signInButton = new JButton("SIGN IN");  // create sign in button
        signInButton.setFont(new Font("Britannic Bold", Font.BOLD, 14));    // set font
        signInButton.setForeground(Color.WHITE);    // set text color to white
        signInButton.setBackground(Color.DARK_GRAY);    // set background color to dark gray
        // signInButton.setBorder(whiteBorder);    // set border color to white
        signInButton.setBorder(darkGrayBorder);    // set border color to dark gray
        signInButton.setBounds(310, 295, 100, 30);  // set bounds
        signInButton.addActionListener(this);   // add ActionListener
        add(signInButton);  // add sign in button to window

        // add clear button
        clearButton = new JButton("CLEAR"); // create clear button
        clearButton.setFont(new Font("Britannic Bold", Font.BOLD, 14)); // set font
        clearButton.setForeground(Color.WHITE); // set text color to white
        clearButton.setBackground(Color.DARK_GRAY); // set background color to dark gray
        // clearButton.setBorder(whiteBorder); // set border color to white
        clearButton.setBorder(darkGrayBorder);    // set border color to dark gray
        clearButton.setBounds(430, 295, 100, 30);   // set bounds
        clearButton.addActionListener(this);    // add ActionListener
        add(clearButton);   // add clear button to window

        // add sign up button
        signUpButton = new JButton("SIGN UP");  // create sign up button
        signUpButton.setFont(new Font("Britannic Bold", Font.BOLD, 14));    // set font
        signUpButton.setForeground(Color.WHITE);    // set text color to white
        signUpButton.setBackground(Color.DARK_GRAY);    // set background color to dark gray
        // signUpButton.setBorder(whiteBorder);    // set border color to white
        signUpButton.setBorder(darkGrayBorder);    // set border color to dark gray
        signUpButton.setBounds(310, 345, 220, 30);  // set bounds
        signUpButton.addActionListener(this);   // add ActionListener
        add(signUpButton);  // add sign up button to window

        // set background of window
        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg4.jpg"));   // load the image
        Image bg2 = bg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon bg3 = new ImageIcon(bg2); // create a new ImageIcon to store the resized image
        JLabel bgImage = new JLabel(bg3);   // add image to a label
        bgImage.setBounds(0, 0, 850, 480);  // resize and position the label
        add(bgImage);   // add label to window

        setVisible(true);   // make window visible
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            // sign in button clicked
            if(e.getSource() == signInButton){

            }
            // clear button clicked
            else if(e.getSource() == clearButton){
                cardNoText.setText(""); // clear text in card number text field
                pinField.setText("");   // clear text in pin password field
            }
            // sign up button clicked
            else if(e.getSource() ==  signUpButton){
                new SignUp();   // go to page 1 of sign up process
                setVisible(false);  // make this window invisible
            }
        } 
        catch(Exception E){
            E.printStackTrace();    // if exception is thrown, print stack trace
        }
    }

    public static void main(String[] args){
        new Login();
    }
}
