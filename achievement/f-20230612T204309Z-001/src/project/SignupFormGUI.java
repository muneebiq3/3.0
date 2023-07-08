package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupFormGUI {
    private JPanel panel;

    private JLabel message, username, firstName, lastName, city, dateOfBirth, CNIC, mobileNumber, password, confirmPassword, back;

    static JTextField usernameText, firstNameText, lastNameText, cityText, dateOfBirthText, CNICText, mobileNumberText, passwordText, confirmPasswordText;

    private JButton proceed;

    private Cursor defaultCursor, hoverCursor;

    public SignupFormGUI(JPanel panel) {
        this.panel = panel;
    }

    public void setSignupFormGUI() {
        message = new JLabel("COMSATS BANKING SYSTEM");
        message.setForeground(Color.WHITE);
        message.setFont(message.getFont().deriveFont(21f));
        message.setBounds(135, 0, 300, 100);
        panel.add(message);

        back = new JLabel("Go Back>>");
        back.setForeground(Color.WHITE);
        back.setFont(back.getFont().deriveFont(10f));
        back.setBounds(60, 45, 60, 20);
        panel.add(back);

        username = new JLabel("Username");
        username.setForeground(Color.WHITE);
        username.setBounds(60, 120, 80, 20);
        panel.add(username);

        usernameText = new JTextField(15);
        usernameText.setBackground(Color.WHITE);
        usernameText.setForeground(Color.BLACK);
        usernameText.setBounds(180, 120, 200, 20);
        panel.add(usernameText);

        firstName = new JLabel("First Name");
        firstName.setForeground(Color.WHITE);
        firstName.setBounds(60, 160, 100, 20);
        panel.add(firstName);

        firstNameText = new JTextField(30);
        firstNameText.setBackground(Color.WHITE);
        firstNameText.setForeground(Color.BLACK);
        firstNameText.setBounds(180, 160, 200, 20);
        panel.add(firstNameText);

        lastName = new JLabel("Last Name");
        lastName.setForeground(Color.WHITE);
        lastName.setBounds(60, 200, 100, 20);
        panel.add(lastName);

        lastNameText = new JTextField(30);
        lastNameText.setBackground(Color.WHITE);
        lastNameText.setForeground(Color.BLACK);
        lastNameText.setBounds(180, 200, 200, 20);
        panel.add(lastNameText);

        city = new JLabel("City");
        city.setForeground(Color.WHITE);
        city.setBounds(60, 240, 100, 20);
        panel.add(city);

        cityText = new JTextField(20);
        cityText.setBackground(Color.WHITE);
        cityText.setForeground(Color.BLACK);
        cityText.setBounds(180, 240, 200, 20);
        panel.add(cityText);

        dateOfBirth = new JLabel("Date of Birth");
        dateOfBirth.setForeground(Color.WHITE);
        dateOfBirth.setBounds(60, 280, 100, 20);
        panel.add(dateOfBirth);

        dateOfBirthText = new JTextField(10);
        dateOfBirthText.setBackground(Color.WHITE);
        dateOfBirthText.setForeground(Color.BLACK);
        dateOfBirthText.setBounds(180, 280, 200, 20);
        panel.add(dateOfBirthText);

        CNIC = new JLabel("CNIC");
        CNIC.setForeground(Color.WHITE);
        CNIC.setBounds(60, 320, 100, 20);
        panel.add(CNIC);

        CNICText = new JTextField(17);
        CNICText.setBackground(Color.WHITE);
        CNICText.setForeground(Color.BLACK);
        CNICText.setBounds(180, 320, 200, 20);
        panel.add(CNICText);

        mobileNumber = new JLabel("Mobile Number");
        mobileNumber.setForeground(Color.WHITE);
        mobileNumber.setBounds(60, 360, 100, 20);
        panel.add(mobileNumber);

        mobileNumberText = new JTextField(15);
        mobileNumberText.setBackground(Color.WHITE);
        mobileNumberText.setForeground(Color.BLACK);
        mobileNumberText.setBounds(180, 360, 200, 20);
        panel.add(mobileNumberText);

        password = new JLabel("Password");
        password.setForeground(Color.WHITE);
        password.setBounds(60, 400, 100, 20);
        panel.add(password);

        passwordText = new JTextField(16);
        passwordText.setForeground(Color.BLACK);
        passwordText.setBackground(Color.WHITE);
        passwordText.setBounds(180, 400, 200, 20);
        panel.add(passwordText);

        confirmPassword = new JLabel("Confirm Password");
        confirmPassword.setForeground(Color.WHITE);
        confirmPassword.setBounds(60, 440, 120, 20);
        panel.add(confirmPassword);

        confirmPasswordText = new JTextField(16);
        confirmPasswordText.setForeground(Color.BLACK);
        confirmPasswordText.setBackground(Color.WHITE);
        confirmPasswordText.setBounds(180, 440, 200, 20);
        panel.add(confirmPasswordText);

        proceed = new JButton("Proceed");
        proceed.setBounds(230, 480, 90, 25);
        proceed.setBackground(Color.BLACK);
        proceed.setForeground(Color.WHITE);
        panel.add(proceed);

        defaultCursor = proceed.getCursor();
        hoverCursor = new Cursor(Cursor.HAND_CURSOR);

        ProceedMouseListener proceedMouseListener = new ProceedMouseListener();
        BackMouseListener backMouseListener = new BackMouseListener();

        proceed.addMouseListener(proceedMouseListener);
        back.addMouseListener(backMouseListener);
    }

    private class BackMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Home home = new Home(panel);
            home.setHome();
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            back.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            back.setCursor(defaultCursor);
        }
    }

    private class ProceedMouseListener implements MouseListener {
        @Override
        public void mouseEntered(MouseEvent e) {
            proceed.setCursor(hoverCursor);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            proceed.setCursor(defaultCursor);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                validateInputs();
                CredentialsFormGUI credentialsFormGUI = new CredentialsFormGUI(panel);
                credentialsFormGUI.setCredentialsFormGUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}
    }

    private void validateInputs() throws Exception {
        String phoneNumber = mobileNumberText.getText();
        String cnic = CNICText.getText();
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        String username = usernameText.getText();
        String password = passwordText.getText();

         if (!isValidName(firstName) || !isValidName(lastName) || !isValidName(username)) {
            throw new Exception("First name, last name, and username should not contain special characters");
        }
        if (phoneNumber.length() > 11) {
            throw new Exception("Phone number should not contain more than 11 digits");
        }
        if (!phoneNumber.startsWith("033") && !phoneNumber.startsWith("030") && !phoneNumber.startsWith("034") &&
                !phoneNumber.startsWith("032") && !phoneNumber.startsWith("031")) {
            throw new Exception("Phone number should start be acc to pakistan's policy");
        }

        if (cnic.length() < 13) {
            throw new Exception("CNIC should have at least 13 digits");
        }

        

       

        if (password.length() < 8) {
            throw new Exception("Weak password. Password should have at least 8 characters");
        }
         if (!password.equals(confirmPassword)) {
            throw new Exception("Password doesn't match");
        }
    }

    private boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}