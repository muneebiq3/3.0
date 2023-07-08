package javaapplication9;

import javax.swing.*;
import java.awt.*;

public class Main {

    static JPanel panel;
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("COMSATS BANKING SYSTEM");
        
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setLayout(null);
        panel.setBackground(Color.getHSBColor(0.6f, 0.8f, 1.0f));
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        
        FrontGUI frontGUI = new FrontGUI(panel);
        frontGUI.setFrontGUI();
        
        frame.add(panel);
        frame.setVisible(true);
    }
 
}