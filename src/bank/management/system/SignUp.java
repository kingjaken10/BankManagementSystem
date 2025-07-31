package bank.management.system;

import java.util.Random;
import java.sql.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class SignUp extends JFrame implements ActionListener{

    // components to be placed on window
    JTextField firstNameText, lastNameText, emailText, addressText, cityText, stateText, zipText;   // text fields
    JDateChooser dateChooser;   // date chooser for DOB
    JRadioButton maleButton, femaleButton;  // radio buttons to indicate gender
    JRadioButton marriedButton, singleButton, otherButton;   // radio buttons to indicate marital status
    JButton nextButton; // button to move to next page

    // generate a random four digit number to use for the application form number
    Random ran = new Random();  // create a Random object to generate random numbers
    int fourDigitNum = ran.nextInt(9000) + 1000;   // generate a random 4 digit number
    String formNo = Integer.toString(fourDigitNum);  // convert number to a String

    SignUp(){
        super("APPLICATION FORM"); // call parent constructor   
        
        // set up window
        getContentPane().setBackground(new Color(188, 230, 250));    // set window background color
        setLayout(null);
        setSize(850, 800);  // set window size
        setLocationRelativeTo(null);    // center align window
        setResizable(false); // fix size of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation
        
        // add icons to window
        // add bank icon to window
        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));   // load the image
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // resize the image
        ImageIcon bank3 = new ImageIcon(bank2); // create a new ImageIcon to store the resized image
        JLabel bankImage = new JLabel(bank3);   // add image to a label
        bankImage.setBounds(25, 10, 100, 100); // resize and position the label
        add(bankImage); // add image to window

        // add labels and respective components to window
        // add application label
        JLabel appLabel = new JLabel("APPLICATION FORM NO. " + formNo);   // create application label
        appLabel.setFont(new Font("Raleway", Font.BOLD, 40));   // set font
        appLabel.setBounds(160, 45, 600, 40);  // set bounds
        appLabel.setForeground(Color.BLACK);    // set text color to black
        add(appLabel);  // add application label to window

        // add page label
        JLabel pageLabel = new JLabel("Page 1");   // create page label
        pageLabel.setFont(new Font("Raleway", Font.BOLD, 18));   // set font
        pageLabel.setBounds(400, 100, 600, 30);  // set bounds
        pageLabel.setForeground(Color.BLACK);    // set text color to black
        add(pageLabel);  // add page label to window

        // add page description label
        JLabel pageDescLabel = new JLabel("Personal Information");   // create page description label
        pageDescLabel.setFont(new Font("Raleway", Font.BOLD, 18));   // set font
        pageDescLabel.setBounds(335, 120, 600, 30);  // set bounds
        pageDescLabel.setForeground(Color.BLACK);    // set text color to black
        add(pageDescLabel);  // add page description label to window

        // add first name label
        JLabel firstNameLabel = new JLabel("First Name:");   // create first name label
        firstNameLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        firstNameLabel.setBounds(100, 190, 100, 30);  // set bounds
        firstNameLabel.setForeground(Color.BLACK);    // set text color to black
        add(firstNameLabel);  // add first name label to window
        
        // add first name text field
        firstNameText = new JTextField();   // create first name text field
        firstNameText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        firstNameText.setBounds(275, 190, 450, 30); // set bounds
        firstNameText.setForeground(Color.BLACK);   // set text color to black
        add(firstNameText); // add first name text field to window

        // add last name label
        JLabel lastNameLabel = new JLabel("Last Name:");   // create last name label
        lastNameLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        lastNameLabel.setBounds(100, 240, 100, 30);  // set bounds
        lastNameLabel.setForeground(Color.BLACK);    // set text color to black
        add(lastNameLabel);  // add last name label to window

        // add last name text field
        lastNameText = new JTextField();   // create last name text field
        lastNameText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        lastNameText.setBounds(275, 240, 450, 30); // set bounds
        lastNameText.setForeground(Color.BLACK);   // set text color to black
        add(lastNameText); // add last name text field to window

        // add gender label
        JLabel genderLabel = new JLabel("Gender:");   // create gender label
        genderLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        genderLabel.setBounds(100, 290, 100, 30);  // set bounds
        genderLabel.setForeground(Color.BLACK);    // set text color to black
        add(genderLabel);  // add gender label to window

        // add gender radio buttons
        // add male radio button
        maleButton = new JRadioButton("Male");  // create male radio button
        maleButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        maleButton.setBounds(275, 290, 100, 30);    // set bounds
        maleButton.setForeground(Color.BLACK);  // set text color to black
        maleButton.setBackground(new Color(188, 230, 250)); // set background color
        add(maleButton);    // add male radio button to window

        // add female radio button
        femaleButton = new JRadioButton("Female");  // create female radio button
        femaleButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        femaleButton.setBounds(450, 290, 100, 30);  // set bounds
        femaleButton.setForeground(Color.BLACK);    // set text color to black
        femaleButton.setBackground(new Color(188, 230, 250));   // set background color to be same as frame's
        add(femaleButton);  // add female radio button to window

        // group the radio buttons so only one can be selected: male or female
        ButtonGroup buttonGroup1 = new ButtonGroup();    // create ButtonGroup object
        buttonGroup1.add(maleButton);    // add male radio button
        buttonGroup1.add(femaleButton);  // add female radio button

        // add DOB label
        JLabel DOBLabel = new JLabel("Date of Birth:");   // create DOB label
        DOBLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        DOBLabel.setBounds(100, 340, 200, 30);  // set bounds
        DOBLabel.setForeground(Color.BLACK);    // set text color to black
        add(DOBLabel);  // add DOB label to window

        // add date chooser for DOB
        dateChooser = new JDateChooser();   // create date chooser
        dateChooser.setForeground(new Color(105, 105, 105));    // set color
        dateChooser.setBounds(275, 340, 450, 30);   // set bounds
        ((JTextFieldDateEditor) dateChooser.getDateEditor()).setForeground(Color.BLACK);    // set text color to black
        ((JTextFieldDateEditor) dateChooser.getDateEditor()).setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        add(dateChooser);   // add date chooser to window

        // add email label
        JLabel emailLabel = new JLabel("Email Address:");   // create email label
        emailLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        emailLabel.setBounds(100, 390, 200, 30);  // set bounds
        emailLabel.setForeground(Color.BLACK);    // set text color to black
        add(emailLabel);  // add email label to window

        // add email text field
        emailText = new JTextField();   // create email text field
        emailText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        emailText.setBounds(275, 390, 450, 30); // set bounds
        emailText.setForeground(Color.BLACK);   // set text color to black
        add(emailText); // add email text field to window
        
        // add marital status label
        JLabel maritalStatusLabel = new JLabel("Marital Status:");   // create marital status label
        maritalStatusLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        maritalStatusLabel.setBounds(100, 440, 200, 30);  // set bounds
        maritalStatusLabel.setForeground(Color.BLACK);    // set text color to black
        add(maritalStatusLabel);  // add marital status label to window

        // add marital status radio buttons
        // add married radio button
        marriedButton = new JRadioButton("Married");    // create married radio button
        marriedButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        marriedButton.setBounds(275, 440, 100, 30);  // set bounds
        marriedButton.setForeground(Color.BLACK);    // set text color to black
        marriedButton.setBackground(new Color(188, 230, 250));   // set background color to be same as frame's
        add(marriedButton);  // add married radio button to window

        // add single radio button
        singleButton = new JRadioButton("Single");    // create single radio button
        singleButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        singleButton.setBounds(450, 440, 100, 30);  // set bounds
        singleButton.setForeground(Color.BLACK);    // set text color to black
        singleButton.setBackground(new Color(188, 230, 250));   // set background color to be same as frame's
        add(singleButton);  // add single radio button to window

        // add other radio button
        otherButton = new JRadioButton("Other");    // create other radio button
        otherButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        otherButton.setBounds(625, 440, 100, 30);  // set bounds
        otherButton.setForeground(Color.BLACK);    // set text color to black
        otherButton.setBackground(new Color(188, 230, 250));   // set background color to be same as frame's
        add(otherButton);  // add other radio button to window

        // group the radio buttons so only one can be selected: married, single, or other
        ButtonGroup buttonGroup2 = new ButtonGroup();    // create ButtonGroup object
        buttonGroup2.add(marriedButton);    // add married radio button
        buttonGroup2.add(singleButton);  // add single radio button
        buttonGroup2.add(otherButton);  // add other radio button

        // add address label
        JLabel addressLabel = new JLabel("Address:");   // create address label
        addressLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        addressLabel.setBounds(100, 490, 200, 30);  // set bounds
        addressLabel.setForeground(Color.BLACK);    // set text color to black
        add(addressLabel);  // add address label to window

        // add address text field
        addressText = new JTextField();   // create address text field
        addressText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        addressText.setBounds(275, 490, 450, 30); // set bounds
        addressText.setForeground(Color.BLACK);   // set text color to black
        add(addressText); // add address text field to window

        // add city label
        JLabel cityLabel = new JLabel("City:");   // create city label
        cityLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        cityLabel.setBounds(100, 540, 200, 30);  // set bounds
        cityLabel.setForeground(Color.BLACK);    // set text color to black
        add(cityLabel);  // add city label to window

        // add city text field
        cityText = new JTextField();   // create city text field
        cityText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        cityText.setBounds(275, 540, 450, 30); // set bounds
        cityText.setForeground(Color.BLACK);   // set text color to black
        add(cityText); // add city text field to window

        // add state label
        JLabel stateLabel = new JLabel("State:");   // create state label
        stateLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        stateLabel.setBounds(100, 590, 200, 30);  // set bounds
        stateLabel.setForeground(Color.BLACK);    // set text color to black
        add(stateLabel);  // add state label to window

        // add state text field
        stateText = new JTextField();   // create state text field
        stateText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        stateText.setBounds(275, 590, 450, 30); // set bounds
        stateText.setForeground(Color.BLACK);   // set text color to black
        add(stateText); // add state text field to window

        // add zip code label
        JLabel zipLabel = new JLabel("Zip Code:");   // create zip code label
        zipLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        zipLabel.setBounds(100, 640, 200, 30);  // set bounds
        zipLabel.setForeground(Color.BLACK);    // set text color to black
        add(zipLabel);  // add zip code label to window

        // add zip code text field
        zipText = new JTextField();   // create zip code text field
        zipText.setFont(new Font("Arial", Font.BOLD, 14));    // set font
        zipText.setBounds(275, 640, 450, 30); // set bounds
        zipText.setForeground(Color.BLACK);   // set text color to black
        add(zipText); // add zip code text field to window

        // add next button
        nextButton = new JButton("Next");   // create next button
        nextButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        nextButton.setBounds(645, 690, 80, 30); // set bounds
        nextButton.setBackground(Color.BLACK);  // set button color to black
        nextButton.setForeground(Color.WHITE);  // set text color to white
        nextButton.addActionListener(this);
        add(nextButton);    // add next button to window
        
        setVisible(true);   // make window visible
    }

    @Override
    // next button is clicked
    public void actionPerformed(ActionEvent e){
        // get user information
        String firstName = firstNameText.getText(); // get first name
        String lastName = lastNameText.getText();   // get last name
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); // get DOB
        String email = emailText.getText(); // get email address
        String address = addressText.getText(); // get address
        String city = cityText.getText();   // get city
        String state = stateText.getText(); // get state
        String zipCode = zipText.getText(); // get zip code

        // get gender
        String gender = "";
        if(maleButton.isSelected()) gender = "Male";    // is male
        else if(femaleButton.isSelected()) gender = "Female";   // is female

        // get marital status
        String maritalStatus = "";
        if(marriedButton.isSelected()) maritalStatus = "Married";   // is married
        else if(singleButton.isSelected()) maritalStatus = "Single";    // is single
        else if(otherButton.isSelected()) maritalStatus = "Other";  // other

        try{
            // if all fields are filled, update the database
            if(!firstName.equals("") && !lastName.equals("") && !dob.equals("" ) && !gender.equals("") 
               && !email.equals("") && !maritalStatus.equals("") && !address.equals("")&& !city.equals("") 
               && !state.equals("") && !zipCode.equals("")){
                
                Connect con1 = new Connect();   // create a Connect object
                Connection conn = con1.getConnection(); // get the connection from the Connect class

                // String q = "insert into SignUp values('"+formNo+"', '"+firstName+"', '"+lastName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+zipCode+"')";
                
                String query = "INSERT INTO SignUp (Form_No, First_Name, Last_Name, DOB, Gender, Email_Address, Marital_Status, Address, City, State, Zip_Code) "
                           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";   // String that will be used to update database
                
                PreparedStatement preparedStatement = conn.prepareStatement(query); // prepare the SQL query for execution

                // set the parameters for the query
                preparedStatement.setString(1, formNo);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, lastName);
                preparedStatement.setString(4, dob);
                preparedStatement.setString(5, gender);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, maritalStatus);
                preparedStatement.setString(8, address);
                preparedStatement.setString(9, city);
                preparedStatement.setString(10, state);
                preparedStatement.setString(11, zipCode);

                preparedStatement.executeUpdate();    // update database

                new SignUp2();  // go to next page in sign up process
                setVisible(false);  // make this frame invisible (this page dissappears)
            }
            else JOptionPane.showMessageDialog(null, "Fill in all fields"); // display message if all fields are not filled
        }
        catch(Exception E){
            E.printStackTrace();    // if exception is thrown, print stack trace
        }
    }

    public static void main(String[] args){
        new SignUp();
    }
}
