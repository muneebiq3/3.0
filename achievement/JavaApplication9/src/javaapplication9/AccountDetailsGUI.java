package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AccountDetailsGUI implements MouseListener{
   
    private final JPanel panel;
    
    private JLabel message, 
            resetPassword, 
            logout, 
            username,
            name, 
            city,
            dateOfBirth,
            CNIC, 
            mobileNumber,
            accountNumber,
            CVCNumber;;
    
    private JButton accountDetails, bankStatement, transaction;
    
    private Cursor defaultCursor, hoverCursor;
    
    private String  usernameText,
            nameText, 
            cityText,
            dateOfBirthText,
            CNICText, 
            mobileNumberText,
            accountNumberText,
            CVCNumberText;
    
    public AccountDetailsGUI(JPanel panel){
        
        this.panel = panel;
        
    }
    
    public void setAccountDetailsGUI(){
        
        panel.removeAll();
        
        checkCredentials();
        
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, 0, 300, 100);
        panel.add(message);
        
        accountDetails = new JButton("Account Details");
        accountDetails.setForeground(Color.WHITE);
        accountDetails.setBackground(Color.BLACK);
        accountDetails.setBounds(0, 100, 200, 30);
        panel.add(accountDetails);
        
        bankStatement = new JButton("Bank Statement");
        bankStatement.setForeground(Color.WHITE);
        bankStatement.setBackground(Color.BLACK);
        bankStatement.setBounds(200, 100, 200, 30);
        panel.add(bankStatement);
        
        transaction = new JButton("Transaction");
        transaction.setForeground(Color.WHITE);
        transaction.setBackground(Color.BLACK);
        transaction.setBounds(400, 100, 200, 30);
        panel.add(transaction);
        
        accountNumber = new JLabel("Account Number "+accountNumberText);
        accountNumber.setForeground(Color.WHITE);
        accountNumber.setBounds(10, 170, 200, 20);
        panel.add(accountNumber);
        
        username = new JLabel("Username "+usernameText+" @cuibank.pk");
        username.setForeground(Color.WHITE);
        username.setBounds(10, 190, 200, 20);
        panel.add(username);
        
        name = new JLabel("Name "+nameText);
        name.setForeground(Color.WHITE);
        name.setBounds(10, 210, 200, 20);
        panel.add(name);
        
        city = new JLabel("City "+cityText);
        city.setForeground(Color.WHITE);
        city.setBounds(10, 230, 200, 20);
        panel.add(city);
        
        dateOfBirth = new JLabel("Date of Birth "+dateOfBirthText);
        dateOfBirth.setForeground(Color.WHITE);
        dateOfBirth.setBounds(10, 250, 200, 20);
        panel.add(dateOfBirth);
        
        CNIC = new JLabel("CNIC "+CNICText);
        CNIC.setForeground(Color.WHITE);
        CNIC.setBounds(10, 270, 200, 20);
        panel.add(CNIC);
        
        mobileNumber = new JLabel("Mobile Number "+mobileNumberText);
        mobileNumber.setForeground(Color.WHITE);
        mobileNumber.setBounds(10, 290, 200, 20);
        panel.add(mobileNumber);
        
        CVCNumber = new JLabel("CVC Number "+CVCNumberText);
        CVCNumber.setForeground(Color.WHITE);
        CVCNumber.setBounds(10, 310, 200, 20);
        panel.add(CVCNumber);
        
        resetPassword = new JLabel("Reset Password?");
        resetPassword.setForeground(Color.WHITE);
        resetPassword.setBounds(480, 500, 120, 30);
        panel.add(resetPassword);
        
        logout = new JLabel("LogOut");
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 500, 120, 30);
        panel.add(logout);
        
        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        resetPassword.addMouseListener(this);
        logout.addMouseListener(this);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        panel.revalidate();
        panel.repaint();
        
    }
    
    private boolean checkCredentials(){
        
        try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
        ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
            UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
            accountNumberText = userCredentials.accountNumber;
            usernameText = userCredentials.username;
            nameText = userCredentials.firstName+" "+userCredentials.lastName;
            cityText = userCredentials.city;
            dateOfBirthText = userCredentials.dateOfBirth;
            CNICText = userCredentials.CNIC;
            mobileNumberText = userCredentials.mobileNumber;
            CVCNumberText = userCredentials.CVCNumber;
            
            credentialsIn.close();
            objectIn.close();
          
            return true;
        }
        catch(IOException | ClassNotFoundException e){
            
            return false;
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == bankStatement) {
            
            BankStatementGUI bankStatementGUI = new BankStatementGUI(panel);
            bankStatementGUI.setBankStatementGUI();
            
        }
        
        else if(me.getSource() == transaction) {
            
            TransactionGUI transactionGUI = new TransactionGUI(panel);
            transactionGUI.setTransactionGUI();
            
        }
        
        else if(me.getSource() == logout) {
            
            FrontGUI frontGUI = new FrontGUI(panel);
            frontGUI.setFrontGUI();
            
        }
        
        else if(me.getSource() == resetPassword) {
            
            ResetPasswordGUI resetPasswordGUI = new ResetPasswordGUI(panel);
            resetPasswordGUI.setResetPasswordGUI();
            
        }
        
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
         
         if(me.getSource() == accountDetails) {
            
            accountDetails.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == bankStatement) {
            
            bankStatement.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == resetPassword) {
            
            resetPassword.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == logout) {
            
            logout.setCursor(hoverCursor);
            
        }
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(me.getSource() == accountDetails) {
            
            accountDetails.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == bankStatement) {
            
            bankStatement.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == resetPassword) {
            
            resetPassword.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == logout) {
            
            logout.setCursor(defaultCursor);
            
        }
        
    }

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {} 
}