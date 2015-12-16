import javax.swing.JOptionPane;
import java.io.*;
import java.util.Calendar;
public class SHOW
{
    private TICKET orderList[];
    int noOfTickets;
    FILEREADCSV orderFile;
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

    public void writeFile() throws IOException
    {
        String data = "";
        for(int i = 0; i < noOfTickets; i++)
        {
            if (orderList[i].getTicketId().startsWith("F"))
            {
                data.concat(orderList[i].writeDetails() + "\n");
            } 
        }
        resultFile.writeCSVtable(data);
    }
        public void displayData()
        {
            System.out.println("Essell Academy Choral Shield" +Calendar.getInstance().get(Calendar.YEAR));
            System.out.println("The mostpopular method of purchase is: " + mostPopularMethod);
            System.out.println("The total raisedfor charity is: £" + total);

        }
    }
