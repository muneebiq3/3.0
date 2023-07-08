package project;
import java.io.*;
public class Data implements Serializable{
    String username, firstName, lastName, city, dateOfBirth, CNIC, mobileNumber, confirmPassword, accountNumber, CVCNumber, confirmPIN;
    public Data(){}
    public void setAll(String username, String firstName, String lastName, String city, String dateOfBirth, String CNIC, String mobileNumber, String confirmPassword, String accountNumber, String CVCNumber, String confirmPIN){
    
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
        
    }
   
}
