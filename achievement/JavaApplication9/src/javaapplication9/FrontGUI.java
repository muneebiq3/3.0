package javaapplication9;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class FrontGUI implements MouseListener{
    
    private final JPanel panel;

    private JLabel message, username, password, newHere, signup;
        
    private JTextField usernameText;
    
    private JPasswordField  passwordText;
        
    private JButton logIn;
        
    private Cursor defaultCursor, hoverCursor;
    
    public FrontGUI(JPanel panel) {
        
        this.panel = panel;
    }
    
    public void setFrontGUI() {
        
        panel.removeAll();
        
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, 0, 300, 100);
        panel.add(message);
        
        username = new JLabel("Username");
        username.setForeground(Color.WHITE);
        username.setBounds(160, 140, 100, 20);
        username.setFont(username.getFont().deriveFont(16f));
        panel.add(username);
        
        usernameText = new JTextField(100);
        usernameText.setBackground(Color.WHITE);
        usernameText.setForeground(Color.BLACK);
        usernameText.setBounds(245, 140, 150, 20);
        panel.add(usernameText);
        
        password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setBounds(160, 180, 100, 20);
        password.setFont(password.getFont().deriveFont(16f));
        panel.add(password);
        
        passwordText = new JPasswordField(16);
        passwordText.setBackground(Color.WHITE);
        passwordText.setForeground(Color.BLACK);
        passwordText.setBounds(245,180,150,20);
        panel.add(passwordText);
        
        logIn = new JButton("LOGIN");
        logIn.setBounds(285, 210, 70, 25);
        logIn.setForeground(Color.WHITE);
        logIn.setBackground(Color.BLACK);
        panel.add(logIn);
        
        newHere = new JLabel("New Here?");
        newHere.setForeground(Color.WHITE);
        newHere.setFont(newHere.getFont().deriveFont(12f));
        newHere.setBounds(266, 240, 70, 15);
        panel.add(newHere);
        
        signup = new JLabel("SIGNUP");
        signup.setForeground(Color.BLACK);
        signup.setFont(signup.getFont().deriveFont(12f));
        signup.setBounds(329, 240, 50, 15);
        panel.add(signup);
        
        logIn.addMouseListener(this);
        signup.addMouseListener(this);
        
        defaultCursor=signup.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR);
        
        panel.revalidate();
        panel.repaint();
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
        if(me.getSource() == logIn) {
            
            if(checkCredentials() == true){
                
                LoginMenuGUI loginMenuGUI = new LoginMenuGUI(panel);
                loginMenuGUI.setMenuGui();
            }
            
            else {
                
                try(FileInputStream credentialsIn = new FileInputStream("credentials.txt");
                ObjectInputStream objectIn = new ObjectInputStream(credentialsIn)) {
            
                    UserCredentials userCredentials = (UserCredentials) objectIn.readObject();
            
                    if (usernameText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter your username to login.");
                    
                    }
                    
                    else if (passwordText.getText().isEmpty()) {
                    
                        throw new Exception("You must enter your password to login.");
                    
                    }
                    
                    else if((usernameText.getText().equals(userCredentials.username)) == false){
                
                        throw new Exception("User not found.");
                
                    }
                    
                    else if((passwordText.getText().equals(userCredentials.confirmPassword)) == false){
                
                        throw new Exception("Invalid Password entered!");
                
                    }
                    
                    credentialsIn.close();
                    objectIn.close();
                    
                }
                
                catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                    
                }
                
            } 
            
        }
        
        else if(me.getSource() == signup) {
            
            SignupFormGUI signupFormGUI = new SignupFormGUI(panel);
            signupFormGUI.setSignupFormGUI();
            
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
        if(me.getSource() == logIn) {
            
            logIn.setCursor(hoverCursor);
        }
        
        else if(me.getSource() == signup) {
            
            signup.setCursor(hoverCursor);
            
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
        if(me.getSource() == logIn) {
            
            logIn.setCursor(defaultCursor);
            
        }
        
        else if(me.getSource() == signup) {
            
            signup.setCursor(defaultCursor);
            
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
            
            if(((usernameText.getText().equals(userCredentials.username)) == true) && 
            ((passwordText.getText().equals(userCredentials.confirmPassword)) == true)){
                
                credentialsIn.close();
                objectIn.close();
                
                return true;
                
            }
            else {
                
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