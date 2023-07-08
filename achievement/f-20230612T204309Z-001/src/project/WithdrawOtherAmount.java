package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class WithdrawOtherAmount {
    
    private JPanel panel;
    
    private JLabel amount, logOut;
    
    private JTextField amountText;
    
    private JLabel message, resetPassword;
    
    private JButton accountDetails, bankStatement, transaction, withdraw;
    
    private Cursor defaultCursor, hoverCursor;
    
    public WithdrawOtherAmount(JPanel panel){
    
        this.panel = panel;
    }
    public void setWithdrawOtherAmount(){
        
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
        
        amount = new JLabel("Amount");
        amount.setForeground(Color.WHITE);
        amount.setBounds(200, 200, 100, 20);
        amount.setFont(amount.getFont().deriveFont(19f));
        panel.add(amount);
        
        amountText = new JTextField(5);
        amountText.setForeground(Color.BLACK);
        amountText.setBackground(Color.WHITE);
        amountText.setBounds(200, 220, 100, 20);
        panel.add(amountText);
        
        withdraw = new JButton("WITHDRAW");
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(210, 240, 80, 20);
        withdraw.setFont(withdraw.getFont().deriveFont(7f));
        panel.add(withdraw);
        
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
        
        panel.revalidate();
        panel.repaint();
    }
    private  class AccountDetailsMouseListener implements MouseListener {
        
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
