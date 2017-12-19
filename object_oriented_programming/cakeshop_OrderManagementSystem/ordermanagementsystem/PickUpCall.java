/* author: hana ra */
package ordermanagementsystem;

public class PickUpCall extends Task
{
    // Properties
    private Task prereq_task; // depends on this indep task
    
    // Constructor
    public PickUpCall(Task adv_order, SalesTransaction s)
    {
        super(adv_order.get_start_date());
        this.sale = s;
        prereq_task = adv_order;
    }
    public PickUpCall(Task adv_order)
    {
        super(adv_order.get_start_date());
        prereq_task = adv_order;
    }
        
    // Setters
    
    // Getters
    public Task get_prereq_task()
    {
        return prereq_task;
    }
    
    // Methods
    @Override
    public int update_status()
    {
        // update the status AUTOMATICALLY once the start_date passes and prereq_task's status is COMPLETED
        DateTime rightnow = whats_now();
        
        if (prereq_task.get_status() == CANCELLED)
        {
            status = CANCELLED;
            return status;
        } 
        if (prereq_task.get_status() == COMPLETED) 
        {
            if (rightnow.compareTo(start_date) >= 0)
            {
                status =  STARTED;              
            }
            else
            {
                status = SCHEDULED;
            }
        }
        else
        {
            status = SCHEDULED;
        }
        return status;
    }
    
//    public int update_status()
//    {
//        // automated update will be used by the system to show the lastest task status
//        // when pickup date is 12/12/2017 and today is 12/12/2017, the status automatiically changes to 2                
//        DateTime today = whats_today();
//        
//        // updateing the status only when it's still in "scheduled" status to prevent overwriting the manually set status 
//        if (status == 1)
//        {
//            if (prereq_task.get_status() == 3) // ready to call customer to pick up only when the cake is ready
//            {
//                if ((today.compareTo(start_date) == 0) || (today.compareTo(start_date) > 0))
//                    status =  2;
//            }
//        }
//        if (prereq_task.get_status() == 9)
//        {
//            status = 9;
//        }
//        return status;
    
//    public int update_status(int m, int d, int y) // for debugging purpose
//    {
//        // automated update will be used by the system to show the lastest task status
//        // when pickup date is 12/12/2017 and today is 12/12/2017, the status automatiically changes to 2                
//        DateTime today = whats_today(m, d, y);
//        
//        // updateing the status only when it's still in "scheduled" status to prevent overwriting the manually set status 
//        if (status == 1)
//        {
//            if (prereq_task.get_status() == 3) // ready to call customer to pick up only when the cake is ready
//            {
//                if ((today.compareTo(start_date) == 0) || (today.compareTo(start_date) > 0))
//                    status =  2;
//            }
//        }
//        if (prereq_task.get_status() == 9)
//        {
//            status = 9;
//        }
//        return status;
//    }
    
    // toString
    @Override
    public String toString()
    {        
        String output = String.format("(%d) Customer Pick Up Call Reminder \n    Status: ", task_id);
        
        status = update_status();
        
        switch (status) 
        {
            case SCHEDULED:
                output += "call SCHEDULED";
                break;
            case STARTED:
                output += "give a call, STARTED";
                break;
            case COMPLETED:
                output += "spoke to customer, COMPLETED";
                break;
            case CANCELLED:
                output += "order CANCELLED";
                break;
            default:
                break;
        }
                
        output += "\n** This call is related to the order below.. \n";
        output += prereq_task.toString();
//        output += "\n";
        return output;
    }
}
