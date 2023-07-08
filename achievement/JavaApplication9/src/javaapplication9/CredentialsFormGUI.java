package javaapplication9;

import java.util.logging.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class CredentialsFormGUI implements MouseListener{
    
    private final JPanel panel;
    
    private JLabel message, accountNumber, PIN, confirmPIN;
    
    private JPasswordField PINText, confirmPINText;
    
    private JButton submit;
    
    private Cursor defaultCursor, hoverCursor;
    
    private String usernameString, firstNameString, lastNameString, cityString, dateOfBirthString, CNICString, phoneString, passwordString, generateAccountNumber=null, generateCVCNumber=null;;
    
    public CredentialsFormGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    private void generateAccountDetails() {
        
        Random random = new Random();
        long randomAccountNumber = (long) (random.nextDouble() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
        int randomCVCNumber = random.nextInt(900) + 100;
        generateAccountNumber=String.valueOf(randomAccountNumber);
        generateCVCNumber=String.valueOf(randomCVCNumber);
        
    }
     
    public void setData(String username, String firstName, String lastName, 
    String city, String dateOfBirth, String CNIC, String phone, String password) {
        
        this.usernameString = username;
        this.firstNameString = firstName;
        this.lastNameString = lastName;
        this.cityString = city; 
        this.dateOfBirthString = dateOfBirth;
        this.CNICString = CNIC;
        this.phoneString = phone;
        this.passwordString = password;
        
    }
    
    public void setCredentialsFormGUI() {
        
        panel.removeAll();
        
        generateAccountDetails();
        
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, 0, 300, 100);
        panel.add(message);
        
        accountNumber = new JLabel("");
        accountNumber.setText("ACCOUNT NUMBER: "+generateAccountNumber);
        accountNumber.setForeground(Color.WHITE);
        accountNumber.setFont(accountNumber.getFont().deriveFont(16f));
        accountNumber.setBounds(145, 50, 300, 80);
        panel.add(accountNumber);
        
        PIN = new JLabel("PIN");
        PIN.setForeground(Color.WHITE);
        PIN.setBounds(240, 140, 150, 20);
        PIN.setFont(PIN.getFont().deriveFont(12f));
        panel.add(PIN);
        
        PINText = new JPasswordField(4);
        PINText.setForeground(Color.BLACK);
        PINText.setBackground(Color.WHITE);
        PINText.setBounds(240,160,100,25);
        PINText.setFont(PINText.getFont().deriveFont(16f));
        panel.add(PINText);
        
        confirmPIN = new JLabel("Confirm PIN");
        confirmPIN.setForeground(Color.WHITE);
        confirmPIN.setBounds(240, 200, 150, 20);
        confirmPIN.setFont(confirmPIN.getFont().deriveFont(12f));
        panel.add(confirmPIN);
        
        
        confirmPINText = new JPasswordField(4);
        confirmPINText.setForeground(Color.BLACK);
        confirmPINText.setBackground(Color.WHITE);
        confirmPINText.setBounds(240,220,100,25);
        confirmPINText.setFont(confirmPINText.getFont().deriveFont(16f));
        panel.add(confirmPINText);
        
        submit = new JButton("SUBMIT");
        submit.setFont(submit.getFont().deriveFont(9f));
        submit.setBounds(250, 260, 70, 20);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        panel.add(submit);
        
        defaultCursor = submit.getCursor();
        hoverCursor = new Cursor(Cursor.HAND_CURSOR);
        
        submit.addMouseListener(this);
        
        panel.revalidate();
        panel.repaint();
        
    }
    @Override
    public void mouseEntered(MouseEvent me) {
        
        submit.setCursor(hoverCursor);
            
    }
    @Override
    public void mouseExited(MouseEvent me) {
            
        submit.setCursor(defaultCursor);
            
    } 
    @Override
    public void mouseClicked(MouseEvent me) {
        
        try {
            
            if(PINText.getText().isEmpty()) {
                
                throw new Exception("You need to set a PIN before opening an account.");
                
            }
            
            if(isValidNumber(PINText.getText()) == false) {
                
                throw new Exception("Invalid Input Method!");
                
            }
            
            if(PINText.getText().length() != 4) {
                
                throw new Exception("PIN can be of 4-digit only.");
                
            }
            
            if ((confirmPINText.getText().matches(PINText.getText())) == false) {
                    
                throw new Exception("PIN doesn't match.");
                    
            }
            
            else {
                
                Wallet wallet = new Wallet();
                
                VolatileDataStoringFunctionality volatileDataStoringFunctionality = new VolatileDataStoringFunctionality
                (usernameString, firstNameString, lastNameString, cityString, dateOfBirthString, CNICString, phoneString,
                passwordString, generateAccountNumber, generateCVCNumber, confirmPINText.getText(), wallet);
                
                try {
                    
                    DataWritingFunctionality dataWritingFunctionality = new DataWritingFunctionality();
                    dataWritingFunctionality.saving(volatileDataStoringFunctionality);
                    
                } 
                
                catch (IOException ex) {
                    
                    Logger.getLogger(CredentialsFormGUI.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
                
                FrontGUI frontGUI = new FrontGUI(panel);
                frontGUI.setFrontGUI();
                
            }
            
        }
        
        catch (Exception ex) {
                    
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
        }
 
    }
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}
    
    private boolean isValidNumber(String number) {
        
        return number.matches("[0-9]+");
    }
}