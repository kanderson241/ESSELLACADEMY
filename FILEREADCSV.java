
import javax.swing.*;
import java.io.*;                   // for general file handling
public class FILEREADCSV
{
   private FileReader fReader;   // an object to fetch data from file


   public String[] readCSVtable() throws IOException {

       File currentDir = new File("").getAbsoluteFile();
       final JFileChooser fc = new JFileChooser(currentDir);
       int returnVal = fc.showOpenDialog(null);
       File csvFile = fc.getSelectedFile();

       char[] inBuffer = new char[5000];

       fReader = new FileReader(csvFile);
       int size = fReader.read(inBuffer);
       fReader.close();

       String fileContent = String.valueOf(inBuffer).substring(0,size);

       return fileContent.split("\n");
   }
}
