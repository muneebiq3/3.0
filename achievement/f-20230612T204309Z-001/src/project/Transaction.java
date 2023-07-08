package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction {
    
    private JPanel panel;
    
    private JLabel message, resetPassword, withdrawLabel, depositLabel, logOut;
    
    private JButton accountDetails, bankStatement, transaction;
    
    private Cursor defaultCursor, hoverCursor;
    
    private JRadioButton withdraw, deposit;
    
    public Transaction(JPanel panel){
    
        this.panel = panel;
    }
    
    public void setTransactionGUI()  {
        
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
        
        logOut = new JLabel("LogOut");
        logOut.setForeground(Color.WHITE);
        logOut.setBounds(5, 500, 120, 30);
        panel.add(logOut);
        
        withdrawLabel = new JLabel("Withdraw");
        withdrawLabel.setBounds(240, 240, 90, 40);
        withdrawLabel.setForeground(Color.WHITE);
        withdrawLabel.setFont(withdrawLabel.getFont().deriveFont(16f));
        panel.add(withdrawLabel);
        
        withdraw = new JRadioButton();
        withdraw.setBounds(210, 247, 20, 30);
        withdraw.setBackground(Color.getHSBColor(0.6f, 0.8f, 1.0f));
        panel.add(withdraw);
        
        depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(240, 280, 90, 40);
        depositLabel.setForeground(Color.WHITE);
        depositLabel.setFont(withdrawLabel.getFont().deriveFont(16f));
        panel.add(depositLabel);
        
        deposit = new JRadioButton();
        deposit.setBounds(210, 287, 20, 30);
        deposit.setBackground(Color.getHSBColor(0.6f, 0.8f, 1.0f));
        panel.add(deposit);
        
        ButtonGroup radioButton = new ButtonGroup();
        radioButton.add(withdraw);
        radioButton.add(deposit);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        AccountDetailsMouseListener accountDetailsMouseListener = new AccountDetailsMouseListener();
        BankStatementMouseListener bankStatementMouseListener = new BankStatementMouseListener();
        TransactionMouseListener transactionMouseListener = new TransactionMouseListener();
        ResetPasswordMouseListener resetPasswordMouseListener = new ResetPasswordMouseListener();
        LogOutMouseListener logOutMouseListener = new LogOutMouseListener();
        
        accountDetails.addMouseListener(accountDetailsMouseListener);
        bankStatement.addMouseListener(bankStatementMouseListener);
        transaction.addMouseListener(transactionMouseListener);
        resetPassword.addMouseListener(resetPasswordMouseListener);
        logOut.addMouseListener(logOutMouseListener);
        
        RadioButtonHandler handler = new RadioButtonHandler();
        withdraw.addActionListener(handler);
        deposit.addActionListener(handler);
        
        panel.revalidate();
        panel.repaint();
        
    }
    
    private class RadioButtonHandler implements ActionListener, MouseListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource()==withdraw){
             
                WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
                withdrawGUI.setWithdrawGUI();
                
            }
            if(e.getSource()==deposit){
                
                DepositGUI depositGUI = new DepositGUI(panel);
                depositGUI.setDepositGUI();
                
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {
            deposit.setCursor(hoverCursor);
            withdraw.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            deposit.setCursor(defaultCursor);
            withdraw.setCursor(defaultCursor);
        }
    
    }
    private class AccountDetailsMouseListener implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent me) {
            accountDetails.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            accountDetails.setCursor(defaultCursor);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
        
            
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }
    private  class BankStatementMouseListener implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent me) {
            bankStatement.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            bankStatement.setCursor(defaultCursor);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
        
            
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }
    private class TransactionMouseListener implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent me) {
            transaction.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            transaction.setCursor(defaultCursor);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
        
            Transaction transaction = new Transaction(panel);
            transaction.setTransactionGUI();
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }
    private  class ResetPasswordMouseListener implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent me) {
            resetPassword.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            resetPassword.setCursor(defaultCursor);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
        
            
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }
    private class LogOutMouseListener implements MouseListener {
        
        @Override
        public void mouseEntered(MouseEvent me) {
            logOut.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
            logOut.setCursor(defaultCursor);
        }
        @Override
        public void mouseClicked(MouseEvent me) {
        
            Home home = new Home(panel);
            home.setHome();
            
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }
}
