package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class BankStatementGUI implements MouseListener{
    
    private final JPanel panel;
    
    private JLabel message, resetPassword, logout;
    
    private JButton accountDetails, bankStatement, transaction;
    
    private Cursor defaultCursor, hoverCursor;
    
    public BankStatementGUI (JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setBankStatementGUI() {
      
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
        
        resetPassword = new JLabel("Reset Password?");
        resetPassword.setForeground(Color.WHITE);
        resetPassword.setBounds(480, 500, 120, 30);
        panel.add(resetPassword);
        
        logout = new JLabel("LogOut");
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 500, 120, 30);
        panel.add(logout);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);

        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        resetPassword.addMouseListener(this);
        logout.addMouseListener(this);
        
        panel.revalidate();
        panel.repaint();
        
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == accountDetails) {
            
            AccountDetailsGUI accountDetailsGUI = new AccountDetailsGUI(panel);
            accountDetailsGUI.setAccountDetailsGUI();
            
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
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == logout) {
            
            logout.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == resetPassword) {
            
            resetPassword.setCursor(hoverCursor);
            
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(me.getSource() == accountDetails) {
            
            accountDetails.setCursor(defaultCursor);
                
        }
        else if(me.getSource() == transaction) {
            
            transaction.setCursor(defaultCursor);
            
        }
        else if(me.getSource() == logout) {
            
            logout.setCursor(defaultCursor);
            
        }
        else if(me.getSource() == resetPassword) {
            
            resetPassword.setCursor(defaultCursor);
            
        }
    }
    
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}
    
}