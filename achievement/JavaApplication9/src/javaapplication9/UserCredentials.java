package javaapplication9;

import java.io.*;

public class UserCredentials implements Serializable {
    
    String  username,
            firstName,
            lastName, 
            city,
            dateOfBirth,
            CNIC, 
            mobileNumber,
            confirmPassword, 
            accountNumber,
            CVCNumber,
            confirmPIN,
            statement;
    
    Wallet wallet;
    
    public UserCredentials(String username, String firstName, String lastName, String city, String dateOfBirth, String CNIC, String mobileNumber, String confirmPassword, String accountNumber, String CVCNumber, String confirmPIN, Wallet wallet, String statement){
        
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.dateOfBirth = dateOfBirth;
        this.CNIC = CNIC;
        this.mobileNumber = mobileNumber;
        this.confirmPassword = confirmPassword;
        this.accountNumber = accountNumber;
        this.CVCNumber = CVCNumber;
        this.confirmPIN = confirmPIN;
        this.wallet = wallet;
        this.statement = statement;
        
    }
}