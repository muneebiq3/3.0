package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class CredentialsFormGUI {
    
    private JPanel panel;
    
    static JLabel message, accountNumber, PIN, confirmPIN;
    
    static JTextField PINText, confirmPINText;
    
    static JButton submit;
    
    static Cursor defaultCursor, hoverCursor;
    
    static String generateAccountNumber=null, generateCVCNumber=null;
    
    public CredentialsFormGUI(JPanel panel){
    
        this.panel = panel;
    }
    public void generateAccountDetails() {
        
        Random random = new Random();
        long randomAccountNumber = (long) (random.nextDouble() * 9_000_000_000_000_0L) + 1_000_000_000_000_0L;
        int randomCVCNumber = random.nextInt(900) + 100;
        generateAccountNumber=String.valueOf(randomAccountNumber);
        generateCVCNumber=String.valueOf(randomCVCNumber);
        
    }
    public void setCredentialsFormGUI()  {
        
        panel.removeAll();
        
        generateAccountDetails();
        
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, -100, 300, 300);
        panel.add(message);
        
        accountNumber = new JLabel("");
        accountNumber.setText("ACCOUNT NUMBER: "+generateAccountNumber);
        accountNumber.setForeground(Color.WHITE);
        accountNumber.setFont(accountNumber.getFont().deriveFont(16f));
        accountNumber.setBounds(145,-50,300,300);
        panel.add(accountNumber);
        
        PIN = new JLabel("PIN");
        PIN.setForeground(Color.WHITE);
        PIN.setBounds(240, 140, 150, 20);
        PIN.setFont(PIN.getFont().deriveFont(12f));
        panel.add(PIN);
        
        PINText = new JTextField(4);
        PINText.setForeground(Color.BLACK);
        PINText.setBackground(Color.WHITE);
        PINText.setBounds(240,160,100,25);
        PINText.setFont(PINText.getFont().deriveFont(16f));
        panel.add(PINText);
        
                
        confirmPIN = new JLabel("Confirm PIN");
        confirmPIN.setForeground(Color.WHITE);
        confirmPIN.setBounds(240, 200, 150, 20);
        confirmPIN.setFont(confirmPIN.getFont().deriveFont(12f));
        panel.add(confirmPIN);
        
        
        confirmPINText = new JTextField(4);
        confirmPINText.setForeground(Color.BLACK);
        confirmPINText.setBackground(Color.WHITE);
        confirmPINText.setBounds(240,220,100,25);
        confirmPINText.setFont(confirmPINText.getFont().deriveFont(16f));
        panel.add(confirmPINText);
        
        submit = new JButton("SUBMIT");
        submit.setFont(submit.getFont().deriveFont(9f));
        submit.setBounds(250, 260, 70, 20);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        panel.add(submit);
        
        defaultCursor = submit.getCursor();
        hoverCursor = new Cursor(Cursor.HAND_CURSOR); 
        
        SubmitMouseListener submitMouseListener = new SubmitMouseListener();
        submit.addMouseListener(submitMouseListener);
        
        panel.revalidate();
        panel.repaint();
    }
    
    private class SubmitMouseListener implements MouseListener {

        @Override
        public void mouseEntered(MouseEvent me) {
        
            submit.setCursor(hoverCursor);
            
        }
        @Override
        public void mouseExited(MouseEvent me) {
            
            submit.setCursor(defaultCursor);
            
        } 
        @Override
        public void mouseClicked(MouseEvent me) {
            try {
            validateInputs();
            
            Data data = new Data();
            data.setAll(SignupFormGUI.usernameText.getText(), SignupFormGUI.firstNameText.getText(), SignupFormGUI.lastNameText.getText(), SignupFormGUI.cityText.getText(), SignupFormGUI.dateOfBirthText.getText(), SignupFormGUI.CNICText.getText(), SignupFormGUI.mobileNumberText.getText(), SignupFormGUI.confirmPasswordText.getText(), generateAccountNumber, generateCVCNumber, confirmPINText.getText());
            
            Write write = new Write();
            write.saving(data);
            
            Home home = new Home(panel);
            home.setHome();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
            
          
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
         private void validateInputs() throws Exception {
        String pin = PINText.getText();
        String confirmPin = confirmPINText.getText();
        
        if (pin.length() != 4) {
            throw new Exception("PIN should be exactly 4 digits");
        }
        
        if (!pin.equals(confirmPin)) {
            throw new Exception("PIN doesn't match");
        }
    }
        
    }
}