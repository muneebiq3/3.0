package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class Home{
    
    private JPanel panel;
        
    static JLabel message, username, password, newHere, signUp;
        
    static JTextField usernameText, passwordText;
        
    static JButton logIn;
        
    static Cursor defaultCursor, hoverCursor;
    
    public Home(JPanel panel){
        
        this.panel = panel;
    }
    
    public void setHome() {
        
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
        
        passwordText = new JTextField(16);
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
        
        signUp = new JLabel("SIGNUP");
        signUp.setForeground(Color.BLACK);
        signUp.setFont(signUp.getFont().deriveFont(12f));
        signUp.setBounds(329, 240, 50, 15);
        panel.add(signUp);
        
        defaultCursor=signUp.getCursor();
        hoverCursor=new Cursor(Cursor.HAND_CURSOR); 
        
        SignUpMouseListener signUpMouseListener = new SignUpMouseListener();
        LogInMouseListener logInMouseListener = new LogInMouseListener();

        signUp.addMouseListener(signUpMouseListener);
        logIn.addMouseListener(logInMouseListener);
        
        panel.revalidate();
        panel.repaint();
        
    }
    private class SignUpMouseListener implements MouseListener {
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
            
            SignupFormGUI sign = new SignupFormGUI(panel);
            sign.setSignupFormGUI();
            
            panel.revalidate();
            panel.repaint();
            
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
    }

    private  class LogInMouseListener implements MouseListener {
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
////            try{
//                FileInputStream fin = new FileInputStream("C:\\Users\\A1\\OneDrive\\Desktop\\data.txt");
//                ObjectInputStream objin = new ObjectInputStream(fin);
//                
//                try {
//                    while(true){
//                        
//                        Object object = objin.readObject();
//                        System.out.println(object.equals(data));
//                    }
//                }
//                catch (EOFException eo){}
//                finally {
//                    objin.close();
//                    fin.close();
//                }
//            }
//            catch(IOException | ClassNotFoundException eo){
//                eo.printStackTrace();
//            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}
    }
}