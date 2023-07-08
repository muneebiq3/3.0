package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class WithdrawOtherAmountGUI implements MouseListener{
    
    private JPanel panel;
    
    private JLabel message, back, withdrawOtherAmount;
    
    private JTextField withdrawOtherAmountText;
    
    private JButton accountDetails, bankStatement, transaction, enter;
    
    private Cursor defaultCursor, hoverCursor;
    
    public WithdrawOtherAmountGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setWithdrawOtherAmountGUI() {
        
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
        
        withdrawOtherAmount = new JLabel("ENTER THE AMOUNT");
        withdrawOtherAmount.setForeground(Color.WHITE);
        withdrawOtherAmount.setFont(withdrawOtherAmount.getFont().deriveFont(17f));
        withdrawOtherAmount.setBounds(200, 250, 200, 20);
        panel.add(withdrawOtherAmount);
        
        withdrawOtherAmountText = new JTextField(6);
        withdrawOtherAmountText.setBackground(Color.WHITE);
        withdrawOtherAmountText.setForeground(Color.BLACK);
        withdrawOtherAmountText.setFont(withdrawOtherAmountText.getFont().deriveFont(19f));
        withdrawOtherAmountText.setBounds(200, 270, 200, 20);
        panel.add(withdrawOtherAmountText);
        
        enter = new JButton("ENTER");
        enter.setBackground(Color.BLACK);
        enter.setForeground(Color.WHITE);
        enter.setBounds(260, 290, 80, 20);
        panel.add(enter);
        
        back.addMouseListener(this);
        accountDetails.addMouseListener(this);
        bankStatement.addMouseListener(this);
        transaction.addMouseListener(this);
        enter.addMouseListener(this);
        
        defaultCursor=accountDetails.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        panel.revalidate();
        panel.repaint();
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == back) {
                
            WithdrawGUI withdrawGUI = new WithdrawGUI(panel);
            withdrawGUI.setWithdrawGUI();
                
        }
        
        if(me.getSource() == enter) {
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
                
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                String withdrawOtherAmountString = withdrawOtherAmountText.getText();
                int withdrawOtherAmountInteger = Integer.parseInt(withdrawOtherAmountString);
                
                if(withdrawOtherAmountInteger > 0 && withdrawOtherAmountInteger % 500 == 0) {
                    
                    if(withdrawOtherAmountInteger <= 10000) {
                        
                        userCredentials.wallet.balance -= withdrawOtherAmountInteger;
            
                        if (userCredentials.wallet.balance < 0) {

                            userCredentials.wallet.balance += withdrawOtherAmountInteger;
                            throw new Exception("Sorry! This transaction cannot be processed.");

                        }

                        else {

                            FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                            ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                            objectOut.writeObject(userCredentials);
                            objectOut.close();

                            JOptionPane.showMessageDialog(null, "The amount of " + withdrawOtherAmountInteger + " has been successfully withdrawn from your account.");

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
                    
                    else {
                        
                        throw new Exception("You can withdraw only 10,000 at a time.");
                        
                    }
                    
                }
                
                else {
                    
                    throw new Exception("Please enter the valid amount.");
                    
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
        
        else if(me.getSource() == accountDetails) {
                
            accountDetails.setCursor(hoverCursor);
                
        }
        
        else if(me.getSource() == bankStatement) {
                
            bankStatement.setCursor(hoverCursor);
                
        }
        
        else if(me.getSource() == transaction) {
                
            transaction.setCursor(hoverCursor);
                
        }
        
        else if(me.getSource() == enter) {
                
            enter.setCursor(hoverCursor);
                
        }
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(me.getSource() == back) {
                
            back.setCursor(defaultCursor);
                
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
        
        else if(me.getSource() == enter) {
                
            enter.setCursor(defaultCursor);
                
        }
        
    }
    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

}