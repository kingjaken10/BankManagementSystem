package bank.management.system;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame{

    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField2;

    Login(){
        super("Bank Management System");    // call parent constructor

        // set up window
        setLayout(null);
        setSize(850, 480);  // set window size
        setLocationRelativeTo(null); // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        
        // add bank icon to window
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));   // load the image
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // resize the image
        ImageIcon bank3 = new ImageIcon(bank2); // create a new ImageIcon to store the resized image
        JLabel bankImage = new JLabel(bank3);   // add image to a label
        bankImage.setBounds(370, 10, 100, 100); // resize and position the label
        add(bankImage); // add label to window

        // add card icon to window
        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));   // load the image
        Image card2 = card1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon card3 = new ImageIcon(card2); // create a new ImageIcon to store the resized image
        JLabel cardImage = new JLabel(card3);   // add image to a label
        cardImage.setBounds(700, 345, 100, 100);    // resize and position the label
        add(cardImage); // add label to window

        // add welcome label
        label1 = new JLabel("WELCOME TO ATM");  // create label
        label1.setForeground(Color.WHITE);  // set text to white
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));  // set up font
        label1.setBounds(240, 120, 450, 40);    // set bounds
        add(label1);    // add label to window

        // add card number label
        label2 = new JLabel("Card No:");    // create label
        label2.setForeground(Color.WHITE);  // set text to white
        label2.setFont(new Font("Dialog", Font.BOLD, 28));  // set up font
        label2.setBounds(240, 190, 375, 30);    // set bounds
        add(label2);    // add label to window

        // add text field for card number
        textField2 = new JTextField(15);    // create text field
        textField2.setBounds(370, 190, 230, 30);    // set bounds
        textField2.setFont(new Font("Arial", Font.BOLD, 14));   // set up font
        add(textField2);    // add text field to window

        // add pin label
        label3 = new JLabel("PIN:");    // create label
        label3.setForeground(Color.WHITE);  // set text to white
        label3.setFont(new Font("Dialog", Font.BOLD, 28));  // set up font
        label3.setBounds(240, 230, 375, 30);    // set bounds
        add(label3);    // add label to window

        // add password field for pin
        passwordField2 = new JPasswordField(15);    // create password field
        passwordField2.setBounds(370, 230, 230, 30);    // set bounds
        passwordField2.setFont(new Font("Arial", Font.BOLD, 14));   // set up font
        add(passwordField2);    // add password field to window

        // set background of window
        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg2.jpg"));   // load the image
        Image bg2 = bg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon bg3 = new ImageIcon(bg2); // create a new ImageIcon to store the resized image
        JLabel bgImage = new JLabel(bg3);   // add image to a label
        bgImage.setBounds(0, 0, 850, 480);  // resize and position the label
        add(bgImage);   // add label to window

        setVisible(true);   // make window visible
    }
    public static void main(String[] args){
        new Login();
    }
}
