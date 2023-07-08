package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WithdrawGUI {
    
     private JPanel panel;
    
    private JLabel fiveHundred, oneThousand, twoThousand, fiveThousand, otherAmount, logOut;
    
    private JLabel message, resetPassword;
    
    private JButton accountDetails, bankStatement, transaction;
    
    private Cursor defaultCursor, hoverCursor;
    
    public WithdrawGUI(JPanel panel){
    
        this.panel = panel;
    }
    public void setWithdrawGUI(){
        
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
        
        fiveHundred = new JLabel("500");
        fiveHundred.setForeground(Color.WHITE);
        fiveHundred.setBounds(10, 200, 100, 20);
        fiveHundred.setFont(fiveHundred.getFont().deriveFont(19f));
        panel.add(fiveHundred);
        
        oneThousand = new JLabel("1000");
        oneThousand.setForeground(Color.WHITE);
        oneThousand.setBounds(10, 300, 100, 20);
        oneThousand.setFont(oneThousand.getFont().deriveFont(19f));
        panel.add(oneThousand);
        
        twoThousand = new JLabel("2000");
        twoThousand.setForeground(Color.WHITE);
        twoThousand.setBounds(530, 200, 100, 20);
        twoThousand.setFont(twoThousand.getFont().deriveFont(19f));
        panel.add(twoThousand);
        
        fiveThousand = new JLabel("5000");
        fiveThousand.setForeground(Color.WHITE);
        fiveThousand.setBounds(530, 300, 100, 20);
        fiveThousand.setFont(fiveThousand.getFont().deriveFont(19f));
        panel.add(fiveThousand);
        
        otherAmount = new JLabel("Other Amount");
        otherAmount.setForeground(Color.WHITE);
        otherAmount.setBounds(10, 400, 130, 20);
        otherAmount.setFont(otherAmount.getFont().deriveFont(19f));
        panel.add(otherAmount);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        AccountDetailsMouseListener accountDetailsMouseListener = new AccountDetailsMouseListener();
        BankStatementMouseListener bankStatementMouseListener = new BankStatementMouseListener();
        TransactionMouseListener transactionMouseListener = new TransactionMouseListener();
        ResetPasswordMouseListener resetPasswordMouseListener = new ResetPasswordMouseListener();
        LogOutMouseListener logOutMouseListener = new LogOutMouseListener();
        OtherAmountMouseListener otherAmountMouseListener = new OtherAmountMouseListener();
        FiveHundredMouseListener fiveHundredMouseListener = new FiveHundredMouseListener();
        OneThousandMouseListener oneThousandMouseListener = new OneThousandMouseListener();
        TwoThousandMouseListener twoThousandMouseListener = new TwoThousandMouseListener();
        FiveThousandMouseListener fiveThousandMouseListener = new FiveThousandMouseListener();
        
        accountDetails.addMouseListener(accountDetailsMouseListener);
        bankStatement.addMouseListener(bankStatementMouseListener);
        transaction.addMouseListener(transactionMouseListener);
        resetPassword.addMouseListener(resetPasswordMouseListener);
        logOut.addMouseListener(logOutMouseListener);
        otherAmount.addMouseListener(otherAmountMouseListener);
        fiveHundred.addMouseListener(fiveHundredMouseListener);
        oneThousand.addMouseListener(oneThousandMouseListener);
        twoThousand.addMouseListener(twoThousandMouseListener);
        fiveThousand.addMouseListener(fiveThousandMouseListener);
        
        panel.revalidate();
        panel.repaint();
    }
    private class OtherAmountMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           
            WithdrawOtherAmount withdrawOtherAmount = new WithdrawOtherAmount(panel);
            withdrawOtherAmount.setWithdrawOtherAmount();
            
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            otherAmount.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
            otherAmount.setCursor(defaultCursor);
        }
    }
    private  class FiveHundredMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            fiveHundred.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
            fiveHundred.setCursor(defaultCursor);
        }
    }
    private  class OneThousandMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            oneThousand.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
            oneThousand.setCursor(defaultCursor);
        }
    }
    private  class TwoThousandMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           
           
            
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            twoThousand.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
            twoThousand.setCursor(defaultCursor);
        }
    }
    private  class FiveThousandMouseListener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            fiveThousand.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
            fiveThousand.setCursor(defaultCursor);
        }
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
