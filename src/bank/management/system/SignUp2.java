package bank.management.system;

import java.awt.*;

import javax.swing.*;

public class SignUp2 extends JFrame{

    // components to be placed on window
    JTextField ageText, homePhoneText, workPhoneText;   // text fields
    JComboBox<String> ethnicityCombo, educationCombo, occupationCombo, incomeCombo; // combo boxes
    JRadioButton isSnrCitButton, notSnrCitButton, hasAcctButton, noAcctButton;   // radio buttons
    JButton nextButton;  // button to move to next page

    String formNo;  // String to store form number

    SignUp2(String formNo){
        super("APPLICATION FORM (CONTINUED"); // call parent constructor   
        
        // set up window
        setLayout(null);
        getContentPane().setBackground(new Color(138, 220, 200));    // set window background color
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
        JLabel pageLabel = new JLabel("Page 2");   // create page label
        pageLabel.setFont(new Font("Raleway", Font.BOLD, 18));   // set font
        pageLabel.setBounds(400, 90, 600, 30);  // set bounds
        pageLabel.setForeground(Color.BLACK);    // set text color to black
        add(pageLabel);  // add page label to window

        // add page description label
        JLabel pageDescLabel = new JLabel("Additional Information");   // create page description label
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

        // add instructions label
        JLabel instructionsLabel1 = new JLabel("Please fill in the following fields. If you cannot " 
                                                + "answer a field, fill in/select N/A." );   // create instructions label
        instructionsLabel1.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        instructionsLabel1.setBounds(75, 170, 700, 30);  // set bounds
        instructionsLabel1.setForeground(Color.BLACK);    // set text color to black
        add(instructionsLabel1);  // add instructions label to window

        // add age label
        JLabel ageLabel = new JLabel("Age:" );   // create age label
        ageLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        ageLabel.setBounds(100, 220, 100, 30);  // set bounds
        ageLabel.setForeground(Color.BLACK);    // set text color to black
        add(ageLabel);  // add age label to window

        // add age text field
        ageText = new JTextField();  // create age text field
        ageText.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        ageText.setBounds(275, 220, 450, 30);  // set bounds
        ageText.setForeground(Color.BLACK);    // set text color to black
        add(ageText);  // add age text field to window

        // add home phone number label
        JLabel homePhoneLabel = new JLabel("Home Phone:" );   // create home phone number label
        homePhoneLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        homePhoneLabel.setBounds(100, 270, 150, 30);  // set bounds
        homePhoneLabel.setForeground(Color.BLACK);    // set text color to black
        add(homePhoneLabel);  // add home phone number label to window

        // add home phone number text field
        homePhoneText = new JTextField();  // create home phone number text field
        homePhoneText.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        homePhoneText.setBounds(275, 270, 450, 30);  // set bounds
        homePhoneText.setForeground(Color.BLACK);    // set text color to black
        add(homePhoneText);  // add home phone number text field to window

        // add work phone number label
        JLabel workPhoneLabel = new JLabel("Work Phone:" );   // create work phone number label
        workPhoneLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        workPhoneLabel.setBounds(100, 320, 150, 30);  // set bounds
        workPhoneLabel.setForeground(Color.BLACK);    // set text color to black
        add(workPhoneLabel);  // add work phone number label to window

        // add work phone number text field
        workPhoneText = new JTextField();  // create work phone number text field
        workPhoneText.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        workPhoneText.setBounds(275, 320, 450, 30);  // set bounds
        workPhoneText.setForeground(Color.BLACK);    // set text color to black
        add(workPhoneText);  // add work phone number text field to window

        // add ethnicity label
        JLabel ethnicityLabel = new JLabel("Ethnicity:" );   // create ethnicity label
        ethnicityLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        ethnicityLabel.setBounds(100, 370, 100, 30);  // set bounds
        ethnicityLabel.setForeground(Color.BLACK);    // set text color to black
        add(ethnicityLabel);  // add ethnicity label to window

        // add ethnicity combo box
        String[] ethnicity = {"", "N/A", "White", "Hispanic or Latino", "African American", "Asian", "Native American", "Middle Eastern", "Native Hawaiian or Pacific Islander"};    // ethnicity options
        ethnicityCombo = new JComboBox<String>(ethnicity);  // create ethnicity combo box
        ethnicityCombo.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        ethnicityCombo.setBounds(275, 370, 450, 30);  // set bounds
        ethnicityCombo.setBackground(new Color(138, 220, 200));    // set background color to be same as window's
        add(ethnicityCombo);  // add ethnicity combo box to window

        // add education label
        JLabel educationLabel = new JLabel("Education:" );   // create education label
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        educationLabel.setBounds(100, 420, 100, 30);  // set bounds
        educationLabel.setForeground(Color.BLACK);    // set text color to black
        add(educationLabel);  // add education label to window

        // add education combo box
        String[] education = {"", "N/A", "High school diploma", "Undergraduate", "Graduate", "Doctorate", "Other"};    // education options
        educationCombo = new JComboBox<String>(education);  // create education combo box
        educationCombo.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        educationCombo.setBounds(275, 420, 450, 30);  // set bounds
        educationCombo.setBackground(new Color(138, 220, 200));    // set background color to be same as window's
        add(educationCombo);  // add education combo box to window

        // add occupation label
        JLabel occupationLabel = new JLabel("Occupation: ");   // create occupation label
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        occupationLabel.setBounds(100, 470, 100, 30);  // set bounds
        occupationLabel.setForeground(Color.BLACK);    // set text color to black
        add(occupationLabel);  // add occupation label to window

        // add occupation combo box
        String[] occupation = {"", "N/A", "Student", "Unemployed", "Self-Employed", "Employed", "Retired", "Other"};    // occupation options
        occupationCombo = new JComboBox<String>(occupation);  // create occupation combo box
        occupationCombo.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        occupationCombo.setBounds(275, 470, 450, 30);  // set bounds
        occupationCombo.setBackground(new Color(138, 220, 200));    // set background color to be same as window's
        add(occupationCombo);  // add occupation combo box to window

        // add income label
        JLabel incomeLabel = new JLabel("Income: ");   // create income label
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        incomeLabel.setBounds(100, 520, 100, 30);  // set bounds
        incomeLabel.setForeground(Color.BLACK);    // set text color to black
        add(incomeLabel);  // add income label to window

        // add income combo box
        String[] income = {"", "N/A", "<$50,000", "<$100,000", ">=$100,000"};    // income options
        incomeCombo = new JComboBox<String>(income);  // create income combo box
        incomeCombo.setFont(new Font("Raleway", Font.BOLD, 14));   // set font
        incomeCombo.setBounds(275, 520, 450, 30);  // set bounds
        incomeCombo.setBackground(new Color(138, 220, 200));    // set background color to be same as window's
        add(incomeCombo);  // add income combo box to window

        // add instructions label
        JLabel instructionsLabel2 = new JLabel("Please select an option for each category:" );   // create instructions label
        instructionsLabel2.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        instructionsLabel2.setBounds(75, 570, 500, 30);  // set bounds
        instructionsLabel2.setForeground(Color.BLACK);    // set text color to black
        add(instructionsLabel2);  // add instructions label to window

        // add senior citizen label
        JLabel snrCitLabel = new JLabel("Senior Citizen:");   // create senior citizen label
        snrCitLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        snrCitLabel.setBounds(100, 620, 300, 30);  // set bounds
        snrCitLabel.setForeground(Color.BLACK);    // set text color to black
        add(snrCitLabel);  // add senior citizen label to window

        // add senior citizen radio buttons
        // add yes radio button
        isSnrCitButton = new JRadioButton("Yes");   // create yes radio button
        isSnrCitButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        isSnrCitButton.setBounds(275, 620, 100, 30);    // set bounds
        isSnrCitButton.setForeground(Color.BLACK);  // set text color to black
        isSnrCitButton.setBackground(new Color(138, 220, 200)); // set background color to same as window's
        add(isSnrCitButton);    // add yes radio button to window

        // add no radio button
        notSnrCitButton = new JRadioButton("No");   // create no radio button
        notSnrCitButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        notSnrCitButton.setBounds(375, 620, 100, 30);   // set bounds
        notSnrCitButton.setForeground(Color.BLACK); // set text color to black
        notSnrCitButton.setBackground(new Color(138, 220, 200));    // set background color to same as window's
        add(notSnrCitButton);   // add no radio button to window

        // group the radio buttons so only one can be selected: yes or no
        ButtonGroup buttonGroup1 = new ButtonGroup();    // create ButtonGroup object
        buttonGroup1.add(isSnrCitButton);    // add yes radio button
        buttonGroup1.add(notSnrCitButton);  // add no radio button

        // add existing account label
        JLabel hasAccountLabel = new JLabel("Existing Account:");   // create existing account label
        hasAccountLabel.setFont(new Font("Raleway", Font.BOLD, 16));   // set font
        hasAccountLabel.setBounds(100, 670, 300, 30);  // set bounds
        hasAccountLabel.setForeground(Color.BLACK);    // set text color to black
        add(hasAccountLabel);  // add existing account label to window

        // add existing account radio buttons
        // add yes radio button
        hasAcctButton = new JRadioButton("Yes");   // create yes radio button
        hasAcctButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        hasAcctButton.setBounds(275, 670, 100, 30);    // set bounds
        hasAcctButton.setForeground(Color.BLACK);  // set text color to black
        hasAcctButton.setBackground(new Color(138, 220, 200)); // set background color to same as window's
        add(hasAcctButton);    // add yes radio button to window

        // add no radio button
        noAcctButton = new JRadioButton("No");   // create no radio button
        noAcctButton.setFont(new Font("Raleway", Font.BOLD, 14));    // set font
        noAcctButton.setBounds(375, 670, 100, 30);   // set bounds
        noAcctButton.setForeground(Color.BLACK); // set text color to black
        noAcctButton.setBackground(new Color(138, 220, 200));    // set background color to same as window's
        add(noAcctButton);   // add no radio button to window

        // group the radio buttons so only one can be selected: yes or no
        ButtonGroup buttonGroup2 = new ButtonGroup();    // create ButtonGroup object
        buttonGroup2.add(hasAcctButton);    // add yes radio button
        buttonGroup2.add(noAcctButton);  // add no radio button

        // add next button
        nextButton = new JButton("Next");   // create next button
        nextButton.setFont(new Font("Raleway", Font.BOLD, 14)); // set font
        nextButton.setBounds(645, 720, 80, 30); // set bounds
        nextButton.setBackground(Color.BLACK);  // set button color to black
        nextButton.setForeground(Color.WHITE);  // set text color to white
        add(nextButton);    // add next button to window

        setVisible(true);   // make window visible
    }

    public static void main(String[] args){
        new SignUp2("");
    }
}
