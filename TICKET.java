
import javax.swing.*;
import java.io.*;

public class TICKET
{
    private String customerId;  
    private String ticketId;
    private int noOfTickets;
    private String methodOfPurchase;

    public TICKET()
    {
        //declaring variables
        customerId = "";
        ticketId = "";
        noOfTickets = 0;
        methodOfPurchase = "";
    }
    
    public String getCustomerId()
    {
        return customerId;
    }
    
    public String getTicketId()
    {
        return ticketId;
    }
    
    public int getNoOfTickets()
    {
        return noOfTickets;
    }
    
    public String getMethodOfPurchase()
    {
        return methodOfPurchase;
    }
    
    public void readTicketDetails(String dataItems)
    {
        //sets up reading file
        String[] rowItems = dataItems.split(",");
        customerId = (rowItems[0]);
        ticketId = (rowItems[1]);
        noOfTickets = (Integer.parseInt(rowItems[2]));
        methodOfPurchase = (rowItems[3]);
    }

    public String writeDetails()
    {
        // adding the variables to a string
        String memberData = "";
        memberData = memberData.concat(customerId);
        memberData = memberData.concat(",");
        memberData = memberData.concat(ticketId);
        memberData = memberData.concat(",");
        memberData = memberData.concat(Integer.toString(noOfTickets));
        memberData = memberData.concat(",");
        memberData = memberData.concat(methodOfPurchase);
        return memberData;  
    }
    
   
}