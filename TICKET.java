
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
        customerId = "";
        ticketId = "";
        noOfTickets = 0;
        methodOfPurchase = "";
    }
    
    public void readTickets(String dataItems)
    {
       String[] rowItems = dataItems.split(",");
       customerId = (rowItems[1]);
       ticketId = (rowItems[2]);
       noOfTickets = (Integer.parseInt(rowItems[3]));
       methodOfPurchase = (rowItems[4]);
    }
    
    public String writeDetails()
    {
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