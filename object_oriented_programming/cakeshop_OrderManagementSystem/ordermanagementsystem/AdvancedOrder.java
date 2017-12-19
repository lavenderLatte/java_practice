/* @author hana ra */
package ordermanagementsystem;

public class AdvancedOrder extends Task
{
    // Property
    
    // Constructor
    public AdvancedOrder(SalesTransaction s)
    {
        super(s); // task_id++, start_date = s.pickup_date, status = 1
    }    
    public AdvancedOrder(DateTime d)
    {
        super(d);
    }
    
    // Setter  
    // Getter   
    
    // Methods
//    public int update_status()
//    {
//        // automated update will be used by the system to show the lastest task status
//        // when pickup date is 12/12/2017 and today is 12/12/2017, the status automatiically changes to 2                
//        DateTime today = whats_today();
//        
//        // updateing the status only when it's still in "scheduled" status to prevent overwriting the manually set status 
//        if (status == SCHEDULED)
//        {
//            if ((today.compareTo(start_date) == 0) || (today.compareTo(start_date) > 0))
//                status =  2;
//        }
//        return status;
//    }
//    public void update_status(int m, int d, int y) // for debugging purpose
//    {
//        // automated update will be used by the system to show the lastest task status
//        // when pickup date is 12/12/2017 and today is 12/12/2017, the status automatiically changes to 2                
//        DateTime today = whats_today(m, d, y);
//        
//        // updateing the status only when it's still in "scheduled" status to prevent overwriting the manually set status 
//        if (status == 1)
//        {
//            if ((today.compareTo(start_date) == 0) || (today.compareTo(start_date) > 0))
//                status =  2;
//        }  
//    }
    
    // toString
    @Override
    public String toString()
    {        
        String output = String.format("(%d) Advanced Cake Order \n    Requested pickup date %s: \n    Status: ", task_id, start_date);
        
        status = update_status();
        
        switch (status) 
        {
            case SCHEDULED:
                output += "Order SCHEDULED";
                break;
            case STARTED:
                output += "Cake Making STARTED";
                break;
            case COMPLETED:
                output += "cake is ready COMPLETED";
                break;
            case CANCELLED:
                output += "order CANCELLED";
                break;
            default:
                break;
        }
        output += "\n";
        return output;
        
    }
}
