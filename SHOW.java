import javax.swing.JOptionPane;
import java.io.*;
public class SHOW
{
    private TICKET orderList[];
    int noOfTickets;
    FILEREADCSV orderFile;
    int total;
    String mostPopularMethod;
    public SHOW()
    {

        orderFile = new FILEREADCSV();

    }

    public void processTicketOrder() throws IOException
    {
        setUpOrderList();
        totalMoneyRaised();
        mostPopularMethod();
    }

    public void setUpOrderList() throws IOException
    {
        System.out.println("client order");
        System.out.println("** Preparing to read data file.");

        // read file, fetch data as String array containing the rows
        String[] dataRows = orderFile.readCSVtable();
        noOfTickets = dataRows.length ;
        System.out.println("** " + noOfTickets + " rows read.\n\n");
        orderList = new TICKET[noOfTickets];
        for  (int i = 0; i < noOfTickets; i++) {
            orderList[i] = new TICKET();
            orderList[i].readTicketDetails(dataRows[i]);
        }

    }

    public void totalMoneyRaised()
    {
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
}
