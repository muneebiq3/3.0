package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TransactionGUI implements ActionListener, MouseListener{
    
    private final JPanel panel;
    
    private JLabel message, withdrawLabel, depositLabel, resetPassword, logout;
    
    private JButton accountDetails, bankStatement, transaction;
    
    private Cursor defaultCursor, hoverCursor;
    
    private JRadioButton withdraw, deposit;
    
    public TransactionGUI(JPanel panel){
    
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
        
        resetPassword = new JLabel("Reset Password?");
        resetPassword.setForeground(Color.WHITE);
        resetPassword.setBounds(480, 500, 120, 30);
        panel.add(resetPassword);
        
        logout = new JLabel("LogOut");
        logout.setForeground(Color.WHITE);
        logout.setBounds(10, 500, 120, 30);
        panel.add(logout);
        
        
        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==withdraw){
             
            WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
            withdrawGUI.setWithdrawGUI();
                
        }
        else if(ae.getSource()==deposit){
                
            DepositGUI depositGUI = new DepositGUI(panel);
            depositGUI.setDepositGUI();
                
        }
        
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