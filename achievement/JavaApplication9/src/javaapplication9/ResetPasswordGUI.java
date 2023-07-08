package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ResetPasswordGUI implements MouseListener{
    
    private final JPanel panel;
    
    private JLabel currentPassword, newPassword, confirmPassword, message, back;
    
    private JButton accountDetails, bankStatement, transaction, continueButton;
    
    private JPasswordField currentPasswordText, newPasswordText, confirmPasswordText;
    
    private Cursor defaultCursor, hoverCursor;
    
    public ResetPasswordGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setResetPasswordGUI(){
        
        panel.removeAll();
        
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
        
        currentPassword = new JLabel("Current Password");
        currentPassword.setForeground(Color.WHITE);
        currentPassword.setBounds(240, 200, 130, 20);
        currentPassword.setFont(currentPassword.getFont().deriveFont(12f));
        panel.add(currentPassword);
        
        currentPasswordText = new JPasswordField(16);
        currentPasswordText.setBackground(Color.WHITE);
        currentPasswordText.setForeground(Color.BLACK);
        currentPasswordText.setBounds(240, 220, 130, 20);
        currentPasswordText.setFont(currentPasswordText.getFont().deriveFont(12f));
        panel.add(currentPasswordText);
        
        newPassword = new JLabel("New Password");
        newPassword.setForeground(Color.WHITE);
        newPassword.setBounds(240, 260, 130, 20);
        newPassword.setFont(newPassword.getFont().deriveFont(12f));
        panel.add(newPassword);
        
        newPasswordText = new JPasswordField(16);
        newPasswordText.setBackground(Color.WHITE);
        newPasswordText.setForeground(Color.BLACK);
        newPasswordText.setBounds(240, 280, 130, 20);
        newPasswordText.setFont(newPasswordText.getFont().deriveFont(12f));
        panel.add(newPasswordText);
        
        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setForeground(Color.WHITE);
        confirmPassword.setBounds(240, 320, 130, 20);
        confirmPassword.setFont(confirmPassword.getFont().deriveFont(12f));
        panel.add(confirmPassword);
        
        confirmPasswordText = new JPasswordField(16);
        confirmPasswordText.setBackground(Color.WHITE);
        confirmPasswordText.setForeground(Color.BLACK);
        confirmPasswordText.setBounds(240, 340, 130, 20);
        currentPasswordText.setFont(confirmPasswordText.getFont().deriveFont(12f));
        panel.add(confirmPasswordText);
        
        continueButton = new JButton("CONTINUE");
        continueButton.setForeground(Color.WHITE);
        continueButton.setBackground(Color.BLACK);
        continueButton.setBounds(260, 370, 90, 26);
        continueButton.setFont(continueButton.getFont().deriveFont(10f));
        panel.add(continueButton);
        
        back = new JLabel("Go Back>>");
        back.setForeground(Color.WHITE);
        back.setBounds(10, 500, 120, 30);
        panel.add(back);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        back.addMouseListener(this);
        continueButton.addMouseListener(this);
        
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
       
        if (me.getSource() == accountDetails) {
            
            AccountDetailsGUI accountDetailsGUI = new AccountDetailsGUI(panel);
            accountDetailsGUI.setAccountDetailsGUI();
 
        }
        
        else if(me.getSource() == bankStatement) {
            
            BankStatementGUI bankStatementGUI = new BankStatementGUI(panel);
            bankStatementGUI.setBankStatementGUI();
            
        }
        
        else if(me.getSource() == transaction) {
            
            TransactionGUI transactionGUI = new TransactionGUI(panel);
            transactionGUI.setTransactionGUI();
            
        }
        
        else if(me.getSource() == continueButton) {

            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                if(currentPasswordText.getText().isEmpty()){
                
                    throw new Exception("Current Password field can't be empty.");
                
                }
                
                else if(newPasswordText.getText().isEmpty()){
                
                    throw new Exception("New Password field can't be empty.");
                
                }
                
                else if(confirmPasswordText.getText().isEmpty()){
                
                    throw new Exception("Confirm Password field can't be empty.");
                
                }
            
                else if((currentPasswordText.getText().equals(userCredentials.confirmPassword)) == false){
                
                    throw new Exception("Invalid Password Entered!");
                
                }
                else if(newPasswordText.getText().length() < 8){
                
                    throw new Exception("New Password must be 8-character long.");
                
                }
                
                else if((newPasswordText.getText().equals(currentPasswordText.getText())) == true){
                
                    throw new Exception("New Password must be different from old password.");
                
                }
                
                else if((newPasswordText.getText().equals(confirmPasswordText.getText())) == false){
                
                    throw new Exception("Passwords don't match.");
                
                }
                
                else {
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                    userCredentials.confirmPassword = confirmPasswordText.getText();
                    
                    FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                    ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                    objectOut.writeObject(userCredentials);
                    objectOut.close();
                
                    JOptionPane.showMessageDialog(null, "Password Changed Successfully! Please login again.");
                    
                    FrontGUI frontGUI = new FrontGUI (panel);
                    frontGUI.setFrontGUI();
                
                }
            }
            catch(Exception ex){
            
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
        
        else if(me.getSource() == back) {
            
            AccountDetailsGUI accountDetailsGUI = new AccountDetailsGUI(panel);
            accountDetailsGUI.setAccountDetailsGUI();
            
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
        
        else if(me.getSource() == back) {
            
            back.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == continueButton) {
            
            continueButton.setCursor(hoverCursor);
            
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
        
        else if(me.getSource() == back) {
            
            back.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == continueButton) {
            
            continueButton.setCursor(defaultCursor);
            
        }
 
    }
    
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

}                   