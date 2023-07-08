package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class WithdrawGUI implements MouseListener{
    
    private final JPanel panel;
    
    private JLabel message, back, fiveHundred, oneThousand, twoThousand, fiveThousand, otherAmount, balanceInquiry;

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
        
        back = new JLabel("Go Back>>");
        back.setForeground(Color.WHITE);
        back.setFont(back.getFont().deriveFont(10f));
        back.setBounds(10, 500, 120, 30);
        panel.add(back);
        
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
        
        balanceInquiry = new JLabel("BALANCE INQUIRY");
        balanceInquiry.setForeground(Color.WHITE);
        balanceInquiry.setBounds(400, 400, 200, 20);
        balanceInquiry.setFont(balanceInquiry.getFont().deriveFont(19f));
        panel.add(balanceInquiry);
        
        otherAmount = new JLabel("Other Amount");
        otherAmount.setForeground(Color.WHITE);
        otherAmount.setBounds(10, 400, 130, 20);
        otherAmount.setFont(otherAmount.getFont().deriveFont(19f));
        panel.add(otherAmount);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        back.addMouseListener(this);
        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        otherAmount.addMouseListener(this);
        fiveHundred.addMouseListener(this);
        oneThousand.addMouseListener(this);
        twoThousand.addMouseListener(this);
        fiveThousand.addMouseListener(this);
        balanceInquiry.addMouseListener(this);
        
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == back) {
                
            TransactionGUI transactionGUI = new TransactionGUI(panel);
            transactionGUI.setTransactionGUI();
                
        }
        
        else if(me.getSource() == balanceInquiry) {
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
                
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                JOptionPane.showMessageDialog(null, "Your account balance is " + userCredentials.wallet.balance +" PKR.");
                
                credentialsIn.close();
                objectIn.close();
            
                
            }
            
            catch(Exception e) {}
                
        }
        
        else if(me.getSource() == otherAmount) {
            
            WithdrawOtherAmountGUI withdrawOtherAmountGUI = new WithdrawOtherAmountGUI(panel);
            withdrawOtherAmountGUI.setWithdrawOtherAmountGUI();
            
        }
        
        else if(me.getSource()==fiveHundred){
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                userCredentials.wallet.balance -= 500; 
            
                if (userCredentials.wallet.balance < 0) {
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                    userCredentials.wallet.balance += 500;
                    throw new Exception("Sorry! This transaction cannot be processed.");
                
                }
                else {
                    
                    credentialsIn.close();
                    objectIn.close();
            
                    FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                    ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                    objectOut.writeObject(userCredentials);
                    
                    credentialsOut.close();
                    objectOut.close();
                        
                    JOptionPane.showMessageDialog(null, "The amount of 500 has been successfully withdrawn from your account.");
            
                    int option = JOptionPane.showOptionDialog(null, "Would you like to make another transaction?","Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes");
            
                    if(option == JOptionPane.YES_OPTION){
                
                        WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
                        withdrawGUI.setWithdrawGUI();
                
                    }
                    else if(option == JOptionPane.NO_OPTION){
                
                        TransactionGUI transactionGUI = new TransactionGUI(panel);
                        transactionGUI.setTransactionGUI();
                    
                    }
                        
                }
                    
            }
                
            catch (Exception ex) {
                    
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
           }

        }
        
        else if(me.getSource() == oneThousand){
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                userCredentials.wallet.balance -= 1000; 
            
                if (userCredentials.wallet.balance < 0) {
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                    userCredentials.wallet.balance += 1000;
                    throw new Exception("Sorry! This transaction cannot be processed.");
                
                }
                else {
                    
                    credentialsIn.close();
                    objectIn.close();
            
                    FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                    ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                    objectOut.writeObject(userCredentials);
                    
                    credentialsOut.close();
                    objectOut.close();
                    
                    JOptionPane.showMessageDialog(null, "The amount of 1000 has been successfully withdrawn from your account.");
            
                    int option = JOptionPane.showOptionDialog(null, "Would you like to make another transaction?","Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes");
            
                    if(option == JOptionPane.YES_OPTION){
                
                        WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
                        withdrawGUI.setWithdrawGUI();
                
                    }
                    
                    else if(option == JOptionPane.NO_OPTION){
                
                        TransactionGUI transactionGUI = new TransactionGUI(panel);
                        transactionGUI.setTransactionGUI();
                    
                    }
                }
                    
            }
                
            catch (Exception ex) {
                    
                 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
            }
            
        }
        
        else if(me.getSource() == twoThousand){
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                userCredentials.wallet.balance -= 2000; 
            
                if (userCredentials.wallet.balance < 0) {
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                    userCredentials.wallet.balance += 2000;
                    throw new Exception("Sorry! This transaction cannot be processed.");
                
                }
                else {
                    
                    credentialsIn.close();
                    objectIn.close();
            
                    FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                    ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                    objectOut.writeObject(userCredentials);
                    
                    credentialsOut.close();
                    objectOut.close();
                    
                    
                    JOptionPane.showMessageDialog(null, "The amount of 2000 has been successfully withdrawn from your account.");
            
                    int option = JOptionPane.showOptionDialog(null, "Would you like to make another transaction?","Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes");
            
                    if(option == JOptionPane.YES_OPTION){
                
                        WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
                        withdrawGUI.setWithdrawGUI();
                
                    }
                    
                    else if(option == JOptionPane.NO_OPTION){
                
                        TransactionGUI transactionGUI = new TransactionGUI(panel);
                        transactionGUI.setTransactionGUI();
                    
                    }
                }
                    
            }
                
            catch (Exception ex) {
                    
                 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
            }
            
        }
        
        else if(me.getSource() == fiveThousand){
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                userCredentials.wallet.balance -= 5000; 
            
                if (userCredentials.wallet.balance < 0) {
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                    userCredentials.wallet.balance += 5000;
                    throw new Exception("Sorry! This transaction cannot be processed.");
                
                }
                else {
                    
                    credentialsIn.close();
                    objectIn.close();
            
                    FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                    ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                    objectOut.writeObject(userCredentials);
                    
                    credentialsOut.close();
                    objectOut.close();

                    JOptionPane.showMessageDialog(null, "The amount of 5000 has been successfully withdrawn from your account.");
            
                    int option = JOptionPane.showOptionDialog(null, "Would you like to make another transaction?","Confirmation",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes");
            
                    if(option == JOptionPane.YES_OPTION){
                
                        WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
                        withdrawGUI.setWithdrawGUI();
                
                    }
                    
                    else if(option == JOptionPane.NO_OPTION){
                
                        TransactionGUI transactionGUI = new TransactionGUI(panel);
                        transactionGUI.setTransactionGUI();
                    
                    }
                }
                    
            }
                
            catch (Exception ex) {
                    
                 JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
            }
            
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        if(me.getSource() == back) {
                
            back.setCursor(hoverCursor);
                
        }
        
        else if(me.getSource() == balanceInquiry) {
                
            balanceInquiry.setCursor(hoverCursor);
                
        }
        
        else if(me.getSource() == otherAmount) {
            
            otherAmount.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == fiveHundred) {
            
            fiveHundred.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == oneThousand) {
            
            oneThousand.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == twoThousand) {
            
            twoThousand.setCursor(hoverCursor);
            
        }
        
        else if(me.getSource() == fiveThousand) {
            
            fiveThousand.setCursor(hoverCursor);
            
        }
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(me.getSource() == back) {
                
            back.setCursor(defaultCursor);
                
        }
        
        else if(me.getSource() == balanceInquiry) {
                
            balanceInquiry.setCursor(defaultCursor);
                
        }
        
        else if(me.getSource() == otherAmount) {
            
            otherAmount.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == fiveHundred) {
            
            fiveHundred.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == oneThousand) {
            
            oneThousand.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == twoThousand) {
            
            twoThousand.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == fiveThousand) {
            
            fiveThousand.setCursor(defaultCursor);
            
        }
 
    }
    
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {} 
}