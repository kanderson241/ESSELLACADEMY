import javax.swing.*;
import java.io.*;                   // for general file handling
public class FILEWRITECSV
{
   // file object to open, read and close a file
   private FileWriter fWriter;     // an object to fetch data from file
   // (no class constructor, just use default constructor)
   public void writeCSVtable(String outBuffer) throws IOException
   {
       String csvFile;
       // Create a file chooser
       csvFile = "fridayOutput.csv";

       // open the file
       fWriter = new FileWriter(csvFile);   
       // write ALL the to the file in 1 burst
       fWriter.write(outBuffer);
       // close the file
       fWriter.close();
   }  
}