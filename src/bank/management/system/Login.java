package bank.management.system;

import java.awt.Image;

import javax.swing.*;

public class Login extends JFrame{

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
        JLabel bankImage = new JLabel(bank3);   // add image to a JLabel
        bankImage.setBounds(370, 10, 100, 100); // resize and position the JLabel
        add(bankImage); // add JLabel to window

        // add card icon to window
        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icons/card.png"));   // load the image
        Image card2 = card1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon card3 = new ImageIcon(card2); // create a new ImageIcon to store the resized image
        JLabel cardImage = new JLabel(card3);   // add image to a JLabel
        cardImage.setBounds(700, 345, 100, 100);    // resize and position the JLabel
        add(cardImage); // add JLabel to window

        // set background of window
        ImageIcon bg1 = new ImageIcon(ClassLoader.getSystemResource("icons/backbg.png"));   // load the image
        Image bg2 = bg1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);    // resize the image
        ImageIcon bg3 = new ImageIcon(bg2); // create a new ImageIcon to store the resized image
        JLabel bgImage = new JLabel(bg3);   // add image to a JLabel
        bgImage.setBounds(0, 0, 850, 480);  // resize and position the JLabel
        add(bgImage);   // add JLabel to window

        setVisible(true);   // make window visible
    }
    public static void main(String[] args){
        new Login();
    }
}
