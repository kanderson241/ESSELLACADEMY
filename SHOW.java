import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{
    private TICKET orderList[];
    int noOfTickets;
    FILEREADCSV orderFile;      // reads the file
    FILEWRITECSV resultFile;    // to write data to storage
    int total;
    String mostPopularMethod;
    public SHOW()
    {
        orderFile = new FILEREADCSV();
        resultFile = new FILEWRITECSV() ;
    }

    public void processTicketOrder() throws IOException
    {
        // declaring variables
        setUpOrderList();
        totalMoneyRaised();
        mostPopularMethod();
        displayData();
        writeFile();
    }

    public void setUpOrderList() throws IOException
    {

        // read file, fetch data as String array containing the rows
        String[] dataRows = orderFile.readCSVtable();
        noOfTickets = dataRows.length;
        orderList = new TICKET[noOfTickets];
        for  (int i = 0; i < noOfTickets; i++) {
            orderList[i] = new TICKET();
            orderList[i].readTicketDetails(dataRows[i]);
        }

    }

    public void totalMoneyRaised()
    {
        // decides wehther the ticket is a friday ticket or not so the price can be declared
        for(int i = 0; i < noOfTickets; i++)
        {
            if (orderList[i].getTicketId().startsWith("F"))
            {
                total = total+orderList[i].getNoOfTickets()*10;
            }
            else
            {
                total = total+orderList[i].getNoOfTickets()*5;
            }
        }
    }

    public void mostPopularMethod()
    {
        // finds the most popular method for purchase
        int schoolPurchases = 0;
        int websitePurchases = 0;
        for(int i = 0; i < noOfTickets; i++) 
        {
            if(orderList[i].getMethodOfPurchase().startsWith("S"))
            {
                schoolPurchases = schoolPurchases +1;  
            }
            else
            {
                websitePurchases = websitePurchases +1;   
            }
        }
        if(schoolPurchases > websitePurchases)
        {
            mostPopularMethod ="school";
        }
        else
        {
            mostPopularMethod ="website";
        }

    }

    public void writeFile() throws IOException
    {
        //writes the data files
        String fileContent ="";
        int count = 0;
        for(int i = 0; i < noOfTickets; i++)
        {
            count = count + 1;

            if (orderList[i].getTicketId().startsWith("F"))
            {
                fileContent = fileContent.concat(orderList[i].writeDetails());
                if (count>1)
                {
                    fileContent = fileContent.concat("\n");
                }

            } 
            

        }

        System.out.println("** Preparing to write friday data file.");
        resultFile.writeCSVtable(fileContent);
        System.out.println("** File written and closed.");

    }

    public void displayData()
    {

        System.out.println("Essell Academy Choral Shield" +Calendar.getInstance().get(Calendar.YEAR));
        System.out.println("The mostpopular method of purchase is: " + mostPopularMethod);
        System.out.println("The total raisedfor charity is: £" + total);

    }  
}

