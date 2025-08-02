package bank.management.system;

import java.awt.*;

import javax.swing.*;

public class main_Class extends JFrame{

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

        setVisible(true);   // make window visible
    }

    public static void main(String[] args) {
        new main_Class();
    }
}
