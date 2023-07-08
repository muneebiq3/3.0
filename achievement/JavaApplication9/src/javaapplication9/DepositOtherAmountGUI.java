package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class DepositOtherAmountGUI implements MouseListener{
    
    private JPanel panel;
    
    private JLabel message, back, depositOtherAmount;
    
    private JTextField depositOtherAmountText;
    
    private JButton accountDetails, bankStatement, transaction, enter;
    
    private Cursor defaultCursor, hoverCursor;
    
    public DepositOtherAmountGUI(JPanel panel) {
        
        this.panel = panel;
        
    }
    
    public void setDepositOtherAmountGUI() {
        
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
        
        depositOtherAmount = new JLabel("ENTER THE AMOUNT");
        depositOtherAmount.setForeground(Color.WHITE);
        depositOtherAmount.setFont(depositOtherAmount.getFont().deriveFont(17f));
        depositOtherAmount.setBounds(200, 250, 200, 20);
        panel.add(depositOtherAmount);
        
        depositOtherAmountText = new JTextField(6);
        depositOtherAmountText.setBackground(Color.WHITE);
        depositOtherAmountText.setForeground(Color.BLACK);
        depositOtherAmountText.setFont(depositOtherAmountText.getFont().deriveFont(19f));
        depositOtherAmountText.setBounds(200, 270, 200, 20);
        panel.add(depositOtherAmountText);
        
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
                
            DepositGUI depositGUI = new DepositGUI(panel);
            depositGUI.setDepositGUI();
                
        }
        
        if(me.getSource() == enter) {
            
            try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
            ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
                
                UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
                
                String depositOtherAmountString = depositOtherAmountText.getText();
                int depositOtherAmountInteger = Integer.parseInt(depositOtherAmountString);
                
                if(depositOtherAmountInteger > 0 && depositOtherAmountInteger % 500 == 0) {
                    
                    userCredentials.wallet.balance += depositOtherAmountInteger;
            
                    if (userCredentials.wallet.balance > 500000) {

                        userCredentials.wallet.balance -= depositOtherAmountInteger;
                        throw new Exception("Sorry! This transaction cannot be processed. Your Account limit is 500K.");

                    }

                    else {

                        credentialsIn.close();
                        objectIn.close();
                        
                        FileOutputStream credentialsOut = new FileOutputStream("credentials.txt");
                        ObjectOutputStream objectOut = new ObjectOutputStream(credentialsOut);
                        objectOut.writeObject(userCredentials);
                        
                        credentialsOut.close();
                        objectOut.close();

                        JOptionPane.showMessageDialog(null, "The amount of " + depositOtherAmountInteger + " has been successfully credited to your account.");

                        int option = JOptionPane.showOptionDialog(null, "Would you like to make another transaction?","Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes");

                        if(option == JOptionPane.YES_OPTION){

                            DepositGUI depositGUI = new DepositGUI(panel);
                            depositGUI.setDepositGUI();

                        }
                        else if(option == JOptionPane.NO_OPTION){

                            TransactionGUI transactionGUI = new TransactionGUI(panel);
                            transactionGUI.setTransactionGUI();

                        }
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