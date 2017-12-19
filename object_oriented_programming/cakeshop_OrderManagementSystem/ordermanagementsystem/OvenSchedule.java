/* author: hana ra */
package ordermanagementsystem;

public class OvenSchedule extends Task
{
    // Properties
    private DateTime start_datetime;
    private DateTime end_datetime;
    
    // Constructors
    public OvenSchedule(DateTime s, DateTime e, SalesTransaction st)
    {
        super();
        start_datetime = s;
        end_datetime = e;
        this.sale = st;
    }
    public OvenSchedule(DateTime s, DateTime e)
    {
        super();
        start_datetime = s;
        end_datetime = e;
    }
    // Setters
    public void set_start_datetime(DateTime s)
    {
        start_datetime = s;
    }
    public void set_end_datetime(DateTime e)
    {
        end_datetime = e;
    }
    
    // Getters
    public DateTime get_start_datetime()
    {
        return start_datetime;
    }
    public DateTime get_end_datetime()
    {
        return end_datetime;
    }
    
    // Methods 
    @Override
    public int update_status()
    {
        // update the status AUTOMATICALLY 
        // to STARTED when current time passes the start_datetime 
        // and to COMPLETED when when current time passes the end_datetime 
        DateTime rightnow = whats_now();

        if (status == CANCELLED)
        {
            return status;
        }
        if (rightnow.compareTo(end_datetime) >= 0)
        {
            status = COMPLETED;
        } 
        else if (rightnow.compareTo(start_datetime) >= 0)
        {
            status =  STARTED;              
        }
        else
        {
            status = SCHEDULED;
        }
        return status;
    }
//    public int update_status(int m, int d, int y, int h, int min) // for debugging purpose 
//    {
//        // update the status automatiically once the end time passes only when it was scheduled status
//        DateTime rightnow = whats_now(m, d, y, h, min);
//        // automatically updating task status as time progress 
//        if (status == 1)
//        {
//            if ((rightnow.compareTo(start_datetime) == 0) || (rightnow.compareTo(start_datetime) > 0))
//            {
//                status =  2;              
//            }
//        }
//        else if ((rightnow.compareTo(end_datetime) == 0) || (rightnow.compareTo(end_datetime) > 0))
//        {
//            status = 3;
//        } 
//        return status;  
//    }
    
    // toString
    @Override
    public String toString()
    {
        String output = String.format("(%d) Oven Slot Schedule \n    From %s to %s \n    Status: ", task_id, start_datetime, end_datetime);
                
        status = update_status();

        switch (status) 
        {
            case SCHEDULED:
                output += "oven slot SCHEDULED";
                break;
            case STARTED:
                output += "time slot open, STARTED";
                break;
            case COMPLETED:
                output += "time slot ended, COMPLETED";
                break;
            case CANCELLED:
                output += "time slot CANCELLED";
                break;
            default:
                break;
        }
        output += "\n\n";
        return output;
    }
}
