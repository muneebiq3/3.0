package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class LoginMenuGUI implements MouseListener{
    
    private final JPanel panel;
    
    private JLabel message, logout, PIN;

    private JPasswordField PINText;
    
    private JButton accountDetails, bankStatement, transaction, continueButton;
    
    private Cursor defaultCursor, hoverCursor;
    
    public LoginMenuGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setMenuGui(){
        
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
        
        PIN = new JLabel("PIN");
        PIN.setForeground(Color.WHITE);
        PIN.setBounds(240, 200, 100, 20);
        PIN.setFont(PIN.getFont().deriveFont(19f));
        panel.add(PIN);
        
        PINText = new JPasswordField(4);
        PINText.setBackground(Color.WHITE);
        PINText.setForeground(Color.BLACK);
        PINText.setBounds(240, 230, 100, 20);
        PINText.setFont(PINText.getFont().deriveFont(19f));
        panel.add(PINText);
        
        continueButton = new JButton("CONTINUE");
        continueButton.setForeground(Color.WHITE);
        continueButton.setBackground(Color.BLACK);
        continueButton.setBounds(250, 260, 80, 20);
        continueButton.setFont(continueButton.getFont().deriveFont(7f));
        panel.add(continueButton);
        
        logout = new JLabel("LogOut");
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 500, 120, 30);
        panel.add(logout);
        
        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        logout.addMouseListener(this);
        continueButton.addMouseListener(this);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        panel.revalidate();
        panel.repaint();
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    
        if(me.getSource() == continueButton) {
            
            if(checkCredentials() == true){
                
                AccountDetailsGUI accountDetailsGUI = new AccountDetailsGUI(panel);
                accountDetailsGUI.setAccountDetailsGUI();
            }

            else {
                
                try {
                
                    if (PINText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter a PIN to go through.");
                    
                    }
                    
                    else {
                        
                        throw new Exception("Wrong PIN Entered!");
                        
                    }
                }
                
                catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } 
            
        }
        
        else if (me.getSource() == accountDetails) {
            
            if(checkCredentials() == true){
                
                AccountDetailsGUI accountDetailsGUI = new AccountDetailsGUI(panel);
                accountDetailsGUI.setAccountDetailsGUI();
            }
            
            
            else {
                
                try {
                
                    if (PINText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter a PIN to go through.");
                    
                    }
                    
                    else {
                        
                        throw new Exception("Wrong PIN Entered!");
                        
                    }
                }
                
                catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } 
        }
        
        else if (me.getSource() == transaction) {
            
            if(checkCredentials() == true){
                
                TransactionGUI transactionGUI = new TransactionGUI(panel);
                transactionGUI.setTransactionGUI();
                
            }

            else {
                
                try {
                
                    if (PINText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter a PIN to go through.");
                    
                    }
                    
                    else {
                        
                        throw new Exception("Wrong PIN Entered!");
                        
                    }
                }
                
                catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } 
            
        }
        
        else if(me.getSource() == bankStatement) {
            
            if(checkCredentials() == true){
                
                BankStatementGUI bankStatementGUI = new BankStatementGUI(panel);
                bankStatementGUI.setBankStatementGUI();
                
            }

            else {
                
                try {
                
                    if (PINText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter a PIN to go through.");
                    
                    }
                    
                    else {
                        
                        throw new Exception("Wrong PIN Entered!");
                        
                    }
                }
                
                catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } 
            
        }
  
        else if(me.getSource() == logout) {
            
            FrontGUI frontGUI = new FrontGUI(panel);
            frontGUI.setFrontGUI();
            
        }
    
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
         
        if(me.getSource() == continueButton) {
            
            continueButton.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == accountDetails) {
            
            accountDetails.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == bankStatement) {
            
            bankStatement.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(hoverCursor);
            
        }
 
        else if(me.getSource() == logout) {
            
            logout.setCursor(hoverCursor);
            
        }
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
    
        if(me.getSource() == continueButton) {
            
            continueButton.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == accountDetails) {
            
            accountDetails.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == bankStatement) {
            
            bankStatement.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == logout) {
            
            logout.setCursor(defaultCursor);
            
        }
        
    }
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}
    
    private boolean checkCredentials(){
        
        try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
        ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
            UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
            
            if(PINText.getText().equals(userCredentials.confirmPIN)){
                
                credentialsIn.close();
                objectIn.close();
                
                return true;
                
            }
            else{
                
                credentialsIn.close();
                objectIn.close();
            
                return false;
                
            }
        }
        catch(IOException | ClassNotFoundException e){
            
            
            
            return false;
            
        }
    }
    
}