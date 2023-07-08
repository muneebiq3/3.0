package javaapplication9;

import java.io.*;

public class VolatileDataStoringFunctionality implements Serializable{
    
    public String username, firstName, lastName, city, dateOfBirth, CNIC, phone, password, accountNumber, CVCNumber, PIN, statement;
    
    public Wallet wallet;
    
    public VolatileDataStoringFunctionality (String username, String firstName, String lastName, 
    String city, String dateOfBirth, String CNIC, String phone, String password, String accountNumber, String CVCNumber, String PIN, Wallet wallet) {
        
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city; 
        this.dateOfBirth = dateOfBirth;
        this.CNIC = CNIC;
        this.phone = phone;
        this.password = password;
        this.accountNumber = accountNumber;
        this.CVCNumber = CVCNumber;
        this.PIN = PIN;
        this.wallet = wallet;
        
    }
    
}