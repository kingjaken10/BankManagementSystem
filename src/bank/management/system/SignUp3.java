package bank.management.system;

import java.awt.*;

import javax.swing.*;
 
public class SignUp3 extends JFrame{

    // components to be placed on window
    JRadioButton savingAcctButton, currAcctButton, fixedDepAcctButton, recurDepAcctButton;  // radio buttons
    JCheckBox atmCheckBox, mobileCheckBox, checkBookCheckBox, internetCheckBox, emailCheckBox, eStatementCheckBox; // checkboxes
    JButton submitButton, cancelButton; // buttons

    String formNo; // String to store form number

    SignUp3(String formNo){
        super("APPLICATION FORM (CONTINUED"); // call parent constructor   
        
        // set up window
        setLayout(null);
        getContentPane().setBackground(new Color(215, 252, 252));   // set window background color
        setSize(850, 800);  // set window size
        setLocationRelativeTo(null);    // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        
        // add bank icon to window
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));   // load the image
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // resize the image
        ImageIcon bank3 = new ImageIcon(bank2); // create a new ImageIcon to store the resized image
        JLabel bankImage = new JLabel(bank3);   // add image to a label
        bankImage.setBounds(25, 10, 100, 100); // resize and position the label
        add(bankImage); // add image to window

        this.formNo = formNo;   // store form number

        // add labels and respective components to window
        // add application label
        JLabel appLabel = new JLabel("APPLICATION (CONTINUED)");   // create application label
        appLabel.setFont(new Font("Raleway", Font.BOLD, 40));   // set font
        appLabel.setBounds(170, 45, 600, 40);  // set bounds
        appLabel.setForeground(Color.BLACK);    // set text color to black
        add(appLabel);  // add application label to window

        // add page label
        JLabel pageLabel = new JLabel("Page 3");   // create page label
        pageLabel.setFont(new Font("Raleway", Font.BOLD, 18));   // set font
        pageLabel.setBounds(400, 90, 600, 30);  // set bounds
        pageLabel.setForeground(Color.BLACK);    // set text color to black
        add(pageLabel);  // add page label to window

        // add page description label
        JLabel pageDescLabel = new JLabel("Account Information");   // create page description label
        pageDescLabel.setFont(new Font("Raleway", Font.BOLD, 18));   // set font
        pageDescLabel.setBounds(335, 110, 600, 30);  // set bounds
        pageDescLabel.setForeground(Color.BLACK);    // set text color to black
        add(pageDescLabel);  // add page description label to window

        // add form number label
        JLabel formNoLabel = new JLabel("Form No: " + formNo);   // create form number label
        formNoLabel.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        formNoLabel.setBounds(720, 10, 200, 20);  // set bounds
        formNoLabel.setForeground(Color.BLACK);    // set text color to black
        add(formNoLabel);  // add form number label to window

        // add account type label
        JLabel acctType = new JLabel("Account Type:" );   // create account type label
        acctType.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        acctType.setBounds(100, 170, 300, 30);  // set bounds
        acctType.setForeground(Color.BLACK);    // set text color to black
        add(acctType);  // add account type label to window

        // add account type radio buttons
        // add saving account radio button
        savingAcctButton = new JRadioButton("Saving Account");   // create saving account radio button
        savingAcctButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        savingAcctButton.setBounds(100, 210, 200, 30);   // set bounds
        savingAcctButton.setForeground(Color.BLACK); // set text color to black
        savingAcctButton.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(savingAcctButton);   // add saving account radio button to window

        // add current account radio button
        currAcctButton = new JRadioButton("Current Account");   // create current account radio button
        currAcctButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        currAcctButton.setBounds(100, 250, 200, 30);   // set bounds
        currAcctButton.setForeground(Color.BLACK); // set text color to black
        currAcctButton.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(currAcctButton);   // add current account radio button to window
        
        // add fixed deposit account radio button
        fixedDepAcctButton = new JRadioButton("Fixed Deposit Account");   // create fixed deposit account radio button
        fixedDepAcctButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        fixedDepAcctButton.setBounds(350, 210, 300, 30);   // set bounds
        fixedDepAcctButton.setForeground(Color.BLACK); // set text color to black
        fixedDepAcctButton.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(fixedDepAcctButton);   // add fixed deposit account radio button to window

        // add recurring deposit account radio button
        recurDepAcctButton = new JRadioButton("Recurring Deposit Account");   // create recurring deposit account radio button
        recurDepAcctButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        recurDepAcctButton.setBounds(350, 250, 300, 30);   // set bounds
        recurDepAcctButton.setForeground(Color.BLACK); // set text color to black
        recurDepAcctButton.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(recurDepAcctButton);   // add recurring deposit account radio button to window

        // group the radio buttons so only one of the four account types can be selected
        ButtonGroup buttonGroup = new ButtonGroup();    // create ButtonGroup object
        buttonGroup.add(savingAcctButton);    // add saving account radio button
        buttonGroup.add(currAcctButton);  // add current account radio button
        buttonGroup.add(fixedDepAcctButton);    // add fixed deposit account radio button
        buttonGroup.add(recurDepAcctButton);  // add recurring deposit account radio button

        // add card number labels
        JLabel cardNoLabel1 = new JLabel("Card Number:" );   // create card number label
        cardNoLabel1.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        cardNoLabel1.setBounds(100, 320, 300, 30);  // set bounds
        cardNoLabel1.setForeground(Color.BLACK);    // set text color to black
        add(cardNoLabel1);  // add card number label to window

        JLabel cardNoLabel2 = new JLabel("(Your 16-digit card number)" );   // create card number label
        cardNoLabel2.setFont(new Font("Raleway", Font.BOLD, 12));   // set font
        cardNoLabel2.setBounds(100, 345, 300, 30);  // set bounds
        cardNoLabel2.setForeground(Color.BLACK);    // set text color to black
        add(cardNoLabel2);  // add card number label to window

        // add card number info labels
        JLabel cardNoInfo1 = new JLabel("XXXX-XXXX-XXXX-4184" );   // create card number info label
        cardNoInfo1.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        cardNoInfo1.setBounds(350, 320, 300, 30);  // set bounds
        cardNoInfo1.setForeground(Color.BLACK);    // set text color to black
        add(cardNoInfo1);  // add card number info label to window

        JLabel cardNoInfo2 = new JLabel("It would appear on ATM Card/Check Book and Statements" );   // create card number info label
        cardNoInfo2.setFont(new Font("Raleway", Font.BOLD, 11));   // set font
        cardNoInfo2.setBounds(350, 345, 400, 30);  // set bounds
        cardNoInfo2.setForeground(Color.BLACK);    // set text color to black
        add(cardNoInfo2);  // add card number info label to window

        // add pin labels
        JLabel pinLabel1 = new JLabel("PIN:" );   // create pin label
        pinLabel1.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        pinLabel1.setBounds(100, 380, 300, 30);  // set bounds
        pinLabel1.setForeground(Color.BLACK);    // set text color to black
        add(pinLabel1);  // add pin label to window

        JLabel pinLabel2 = new JLabel("(4-digit password)" );   // create pin label
        pinLabel2.setFont(new Font("Raleway", Font.BOLD, 11));   // set font
        pinLabel2.setBounds(100, 405, 300, 30);  // set bounds
        pinLabel2.setForeground(Color.BLACK);    // set text color to black
        add(pinLabel2);  // add pin label to window

        // add pin info label
        JLabel pinLabel = new JLabel("XXXX");   // create pin info label
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        pinLabel.setBounds(350, 380, 300, 30);  // set bounds
        pinLabel.setForeground(Color.BLACK);    // set text color to black
        add(pinLabel);  // add pin info label to window

        // add services label
        JLabel serviceLabel = new JLabel("Services:" );   // create service label
        serviceLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        serviceLabel.setBounds(100, 475, 300, 30);  // set bounds
        serviceLabel.setForeground(Color.BLACK);    // set text color to black
        add(serviceLabel);  // add service label to window

        // add checkboxes for all services (multiple can be selected)
        // add ATM card checkbox
        atmCheckBox = new JCheckBox("ATM Card");    // create ATM card checkbox
        atmCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        atmCheckBox.setBounds(100, 515, 100, 30);   // set bounds
        atmCheckBox.setForeground(Color.BLACK); // set text color to black
        atmCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(atmCheckBox);   // add ATM card checkbox to window

        // add mobile banking checkbox
        mobileCheckBox = new JCheckBox("Mobile Banking");    // create mobile banking checkbox
        mobileCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        mobileCheckBox.setBounds(100, 555, 200, 30);   // set bounds
        mobileCheckBox.setForeground(Color.BLACK); // set text color to black
        mobileCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(mobileCheckBox);   // add mobile banking checkbox to window

        // add checkbook checkbox
        checkBookCheckBox = new JCheckBox("Check Book");    // create checkbook checkbox
        checkBookCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        checkBookCheckBox.setBounds(100, 595, 200, 30);   // set bounds
        checkBookCheckBox.setForeground(Color.BLACK); // set text color to black
        checkBookCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(checkBookCheckBox);   // add checkbook checkbox to window

        // add internet banking checkbox
        internetCheckBox = new JCheckBox("Internet Banking");    // create internet banking checkbox
        internetCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        internetCheckBox.setBounds(350, 515, 300, 30);   // set bounds
        internetCheckBox.setForeground(Color.BLACK); // set text color to black
        internetCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(internetCheckBox);   // add internet banking checkbox to window

        // add email alerts checkbox
        emailCheckBox = new JCheckBox("Email Alerts");    // create email alerts checkbox
        emailCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        emailCheckBox.setBounds(350, 555, 300, 30);   // set bounds
        emailCheckBox.setForeground(Color.BLACK); // set text color to black
        emailCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(emailCheckBox);   // add email alerts checkbox to window

        // add e-statement checkbox
        eStatementCheckBox = new JCheckBox("E-Statement");    // create e-statement checkbox
        eStatementCheckBox.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        eStatementCheckBox.setBounds(350, 595, 300, 30);   // set bounds
        eStatementCheckBox.setForeground(Color.BLACK); // set text color to black
        eStatementCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(eStatementCheckBox);   // add e-statement checkbox to window

        // add acknowledgment statement checkbox
        JCheckBox acknowledgmentStatementCheckBox = new JCheckBox("I hereby acknowledge that the information entered "
                                                           + "is correct to the best of my knowledge."); // create acknowledgment statement checkbox
        acknowledgmentStatementCheckBox.setFont(new Font("Raleway", Font.BOLD, 12));    // set font
        acknowledgmentStatementCheckBox.setBounds(100, 670, 700, 30);   // set bounds
        acknowledgmentStatementCheckBox.setForeground(Color.BLACK); // set text color to black
        acknowledgmentStatementCheckBox.setBackground(new Color(215, 252, 252));    // set background color to same as window's
        add(acknowledgmentStatementCheckBox);   // add acknowledgment statement checkbox to window
        
        // add submit button
        submitButton = new JButton("Submit");   // submit next button
        submitButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        submitButton.setBounds(300, 720, 100, 30); // set bounds
        submitButton.setBackground(Color.BLACK);  // set button color to black
        submitButton.setForeground(Color.WHITE);  // set text color to white
        add(submitButton);    // submit next button to window

        // add cancel button
        cancelButton = new JButton("Cancel");   // create cancel button
        cancelButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        cancelButton.setBounds(450, 720, 100, 30); // set bounds
        cancelButton.setBackground(Color.BLACK);  // set button color to black
        cancelButton.setForeground(Color.WHITE);  // set text color to white
        add(cancelButton);    // add cancel button to window

        setVisible(true);   // make window visible
    }

    public static void main(String[] args){
        new SignUp3("");
    }
}
