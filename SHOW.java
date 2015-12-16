import javax.swing.JOptionPane;
import java.io.*;
public class SHOW
{
    private TICKET orderList[];
    int noOfTickets;
    FILEREADCSV orderFile;
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
        noOfTickets = dataRows.length - 1;

        System.out.println("** " + noOfTickets + " rows read.\n\n");
        orderList = new TICKET[noOfTickets];
        for  (int i = 0; i < noOfTickets; i++) {
            orderList[i] = new TICKET();
            orderList[i].readTicketDetails(dataRows[i]);
        }

    }

    public void totalMoneyRaised()
    {
        // placeholder, add detail later
    }

    public void mostPopularMethod()
    {

    }

    public void displayTicketOrders() {
        // Heading for the display
        System.out.println("A listing of all applicants for the next year\n");

        for  (int i = 0; i < noOfTickets; i++) {
            orderList[i].displayDetails();
        }
        // 2 blank line to separate this report from others.
        System.out.print("\n\n\n");
    }

}