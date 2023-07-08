package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class Main{
    
    static JPanel panel;
        
    static JLabel message, username, password, newHere, signUp;
        
    static JTextField usernameText, passwordText;
        
    static JButton logIn;
        
    static Cursor defaultCursor, hoverCursor;
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame ("COMSATS BANKING SYSTEM");

        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0.6f, 0.8f, 1.0f));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    private static class SignUpMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            
            signUp.setCursor(hoverCursor); 
            
        }
        @Override
        public void mouseExited(MouseEvent e) {
            
            signUp.setCursor(defaultCursor); 
            
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            
            // Handle signUp label click event
            panel.removeAll();
            
            
            SignupFormGUI signupFormGUI = new SignupFormGUI(panel);
            signupFormGUI.setSignupFormGUI();
            
            panel.revalidate();
            panel.repaint();
            
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
    }

    private static class LogInMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            
            logIn.setCursor(hoverCursor);
            
        }
        @Override
        public void mouseExited(MouseEvent e) {
        
            logIn.setCursor(defaultCursor);
        
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            
            panel.removeAll();
            
            MenuGUI menuGUI = new MenuGUI(panel);
            menuGUI.setMenuGui();
            
            panel.revalidate();
            panel.repaint();
            
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
    }
}