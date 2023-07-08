package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class SignupFormGUI implements MouseListener{
    
    private final JPanel panel;

    private JLabel message, username, firstName, lastName, city, dateOfBirth, CNIC, Phone, password, confirmPassword, back;

    private JTextField usernameText, firstNameText, lastNameText, cityText, dateOfBirthText, CNICText, phoneText;
    
    private JPasswordField  passwordText, confirmPasswordText;
    
    private JButton proceed;

    private Cursor defaultCursor, hoverCursor;
    
    
    public SignupFormGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setSignupFormGUI() {
        
        panel.removeAll();
        
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, 0, 300, 100);
        panel.add(message);

        back = new JLabel("Go Back>>");
        back.setForeground(Color.WHITE);
        back.setFont(back.getFont().deriveFont(10f));
        back.setBounds(60, 45, 60, 20);
        panel.add(back);

        username = new JLabel("Username");
        username.setForeground(Color.WHITE);
        username.setBounds(60, 120, 80, 20);
        panel.add(username);

        usernameText = new JTextField(15);
        usernameText.setBackground(Color.WHITE);
        usernameText.setForeground(Color.BLACK);
        usernameText.setBounds(180, 120, 200, 20);
        panel.add(usernameText);

        firstName = new JLabel("First Name");
        firstName.setForeground(Color.WHITE);
        firstName.setBounds(60, 160, 100, 20);
        panel.add(firstName);

        firstNameText = new JTextField(30);
        firstNameText.setBackground(Color.WHITE);
        firstNameText.setForeground(Color.BLACK);
        firstNameText.setBounds(180, 160, 200, 20);
        panel.add(firstNameText);

        lastName = new JLabel("Last Name");
        lastName.setForeground(Color.WHITE);
        lastName.setBounds(60, 200, 100, 20);
        panel.add(lastName);

        lastNameText = new JTextField(30);
        lastNameText.setBackground(Color.WHITE);
        lastNameText.setForeground(Color.BLACK);
        lastNameText.setBounds(180, 200, 200, 20);
        panel.add(lastNameText);

        city = new JLabel("City");
        city.setForeground(Color.WHITE);
        city.setBounds(60, 240, 100, 20);
        panel.add(city);

        cityText = new JTextField(20);
        cityText.setBackground(Color.WHITE);
        cityText.setForeground(Color.BLACK);
        cityText.setBounds(180, 240, 200, 20);
        panel.add(cityText);

        dateOfBirth = new JLabel("Date of Birth");
        dateOfBirth.setForeground(Color.WHITE);
        dateOfBirth.setBounds(60, 280, 100, 20);
        panel.add(dateOfBirth);

        dateOfBirthText = new JTextField(10);
        dateOfBirthText.setBackground(Color.WHITE);
        dateOfBirthText.setForeground(Color.BLACK);
        dateOfBirthText.setBounds(180, 280, 200, 20);
        panel.add(dateOfBirthText);

        CNIC = new JLabel("CNIC");
        CNIC.setForeground(Color.WHITE);
        CNIC.setBounds(60, 320, 100, 20);
        panel.add(CNIC);

        CNICText = new JTextField(17);
        CNICText.setBackground(Color.WHITE);
        CNICText.setForeground(Color.BLACK);
        CNICText.setBounds(180, 320, 200, 20);
        panel.add(CNICText);

        Phone = new JLabel("Phone");
        Phone.setForeground(Color.WHITE);
        Phone.setBounds(60, 360, 100, 20);
        panel.add(Phone);

        phoneText = new JTextField(15);
        phoneText.setBackground(Color.WHITE);
        phoneText.setForeground(Color.BLACK);
        phoneText.setBounds(180, 360, 200, 20);
        panel.add(phoneText);

        password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setBounds(60, 400, 100, 20);
        panel.add(password);
        
        passwordText = new JPasswordField(16);
        passwordText.setForeground(Color.BLACK);
        passwordText.setBackground(Color.WHITE);
        passwordText.setBounds(180, 400, 200, 20);
        panel.add(passwordText);

        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setForeground(Color.WHITE);
        confirmPassword.setBounds(60, 440, 120, 20);
        panel.add(confirmPassword);

        confirmPasswordText = new JPasswordField(16);
        confirmPasswordText.setForeground(Color.BLACK);
        confirmPasswordText.setBackground(Color.WHITE);
        confirmPasswordText.setBounds(180, 440, 200, 20);
        panel.add(confirmPasswordText);
        
        proceed = new JButton("Proceed");
        proceed.setBounds(230, 480, 90, 25);
        proceed.setBackground(Color.BLACK);
        proceed.setForeground(Color.WHITE);
        panel.add(proceed);

        back.addMouseListener(this);
        proceed.addMouseListener(this);
        firstNameText.addMouseListener(this);
        lastNameText.addMouseListener(this);
        cityText.addMouseListener(this);
        CNICText.addMouseListener(this);
        phoneText.addMouseListener(this);
        passwordText.addMouseListener(this);
        confirmPasswordText.addMouseListener(this);
        
        defaultCursor = proceed.getCursor();
        hoverCursor = new Cursor(Cursor.HAND_CURSOR);
        
        panel.revalidate();
        panel.repaint();
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource() == back) {
                
            FrontGUI frontGUI = new FrontGUI(panel);
            frontGUI.setFrontGUI();
                
        }

        else if(e.getSource() == proceed) {
            
            try {
                
                if (usernameText.getText().isEmpty()) {
                    
                    throw new Exception("Username field can't be empty.");
                    
                }
                
                if (firstNameText.getText().isEmpty()) {
                    
                    throw new Exception("First name field can't be empty.");
                    
                }
                
                if (isValidName(firstNameText.getText()) == false) {
                    
                    throw new Exception("First name can contain alphabets only.");
                    
                }
                
                if (lastNameText.getText().isEmpty()) {
                    
                    throw new Exception("Last name field can't be empty.");
                    
                }
                
                if (isValidName(lastNameText.getText()) == false) {
                    
                    throw new Exception("Last name can contain alphabets only.");
                    
                }
                
                if (cityText.getText().isEmpty()) {
                    
                    throw new Exception("City field can't be empty.");
                    
                }
                
                if (isValidName(cityText.getText()) == false) {
                    
                    throw new Exception("City can contain alphabets only.");
                    
                }
                
                if (dateOfBirthText.getText().isEmpty()) {
                    
                    throw new Exception("Date of Birth field can't be empty.");
                    
                }
                
                if (CNICText.getText().isEmpty()) {
                    
                    throw new Exception("CNIC field can't be empty.");
                    
                }
                
                if (isValidNumber(CNICText.getText()) == false) {
                    
                    throw new Exception("Invalid Input Method!");
                    
                }
                
                if (CNICText.getText().length() != 13) {
                    
                    throw new Exception("CNIC Number must contain 13 digits.");
                    
                }
                
                if (phoneText.getText().isEmpty()) {
                    
                    throw new Exception("Phone Number field can't be empty.");
                    
                }
                
                if (isValidNumber(phoneText.getText()) == false) {
                    
                    throw new Exception("Invalid Input Method!");
                    
                }
                
                if (phoneText.getText().length() != 11) {
                    
                    throw new Exception("Phone Number must contain 11 digits.");
                    
                }
                
                if ((phoneText.getText().startsWith("030") == false) && (phoneText.getText().startsWith("031") == false)&& 
                        
                (phoneText.getText().startsWith("033") == false) && (phoneText.getText().startsWith("034") == false) && 
                        
                (phoneText.getText().startsWith("035") == false)) {
                    
                    throw new Exception("Phone number should start be acc to pakistan's policy");
                    
                }
                
                if (passwordText.getText().isEmpty()) {
                    
                    throw new Exception("Password field can't be empty.");
                    
                }
                
                if(passwordText.getText().length() < 8) {
                    
                    throw new Exception("Weak Password! Password must be 8-character long.");
                    
                }
                
                if (confirmPasswordText.getText().isEmpty()) {
                    
                    throw new Exception("Confirm Password field can't be empty.");
                    
                }
                
                if ((confirmPasswordText.getText().matches(passwordText.getText())) == false) {
                    
                    throw new Exception("Passwords don't match.");
                    
                }
                else {
                    
                    CredentialsFormGUI credentialsFormGUI = new CredentialsFormGUI(panel);
                    credentialsFormGUI.setData(usernameText.getText(), firstNameText.getText(), 
                    lastNameText.getText(), cityText.getText(), dateOfBirthText.getText(), CNICText.getText(), phoneText.getText(), confirmPasswordText.getText());
                    credentialsFormGUI.setCredentialsFormGUI();
                    
                }
                
            }
            catch (Exception ex) {
                    
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
            }
                
        }
            
    }
    @Override
    public void mouseEntered(MouseEvent e) {
            
        if(e.getSource() == back) {
                
            back.setCursor(hoverCursor);
                
        }
            
        else if(e.getSource() == proceed) {
                
            proceed.setCursor(hoverCursor);
            
        }
                
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == back) {
                
            back.setCursor(defaultCursor);
                
        }
            
        else if(e.getSource() == proceed) {
                
            proceed.setCursor(defaultCursor);
        }
        
    }
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
    
    private boolean isValidNumber(String number) {
        
        return number.matches("[0-9]+");
    }
     
    private boolean isValidName(String name) {
         
       return name.matches("[a-zA-Z]+");
        
   }
}