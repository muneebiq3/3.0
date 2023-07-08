package project;

import java.io.*;

public class Write {
    
    public Write(){}
    public void saving(Data data) throws FileNotFoundException, IOException{
        
        FileOutputStream fout = new FileOutputStream("C:\\Users\\Tcv\\Desktop\\data.txt", true);
        ObjectOutputStream objout = new ObjectOutputStream(fout);
        objout.writeObject(data);
        objout.close();
    }
    
}
