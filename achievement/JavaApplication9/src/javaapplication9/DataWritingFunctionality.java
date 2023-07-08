package javaapplication9;

import java.io.*;

public class DataWritingFunctionality {
    
    public void saving(VolatileDataStoringFunctionality data) throws FileNotFoundException, IOException{
        
        FileOutputStream fAll = new FileOutputStream("data.txt", true);
        ObjectOutputStream objout = new ObjectOutputStream(fAll);
        objout.writeObject(data);
        
        fAll.close();
        objout.close();
        
        FileOutputStream fCredentials = new FileOutputStream("credentials.txt", true);
        ObjectOutputStream objCredentials = new ObjectOutputStream(fCredentials);
        
        UserCredentials userCredentials = new UserCredentials(data.username, data.firstName, data.lastName, data.city, data.dateOfBirth, data.CNIC, data.phone, data.password, data.accountNumber, data.CVCNumber, data.PIN, data.wallet, data.statement);
        objCredentials.writeObject(userCredentials);
        
        fCredentials.close();
        objCredentials.close();
    } 
}