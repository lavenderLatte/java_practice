/* author: hana ra */
package ordermanagementsystem;

import java.time.LocalDateTime;

public class Task 
{
    // Property 
    protected static int next_task_id = 0; //If need to understand this part better
    protected int task_id;
    protected SalesTransaction sale;
    protected String description;
    protected DateTime start_date;
    protected int status;
    protected static final int SCHEDULED = 1;
    protected static final int STARTED = 2;
    protected static final int COMPLETED = 3;
    protected static final int CANCELLED = 9;
    
    // Constructor
    public Task()
    {
        task_id = next_task_id++;
        start_date = new DateTime();
        status = SCHEDULED;
    }
    public Task(SalesTransaction s)
    {
        this();
        sale = s;
        start_date = s.get_pickup_date(); 
    }
    public Task(DateTime d)
    {
        this();
        start_date = d;
    }
    
    // Setter
    public void set_description(String s)
    {
        this.description = s;
    }
    
    // Getter
    public int get_task_id()
    {
        return task_id;
    }
    public DateTime get_start_date()
    {
        return start_date;
    }
    public int get_status()
    {
        update_status();
        return status;
    }
    
    // Methods
    protected DateTime whats_now()
    {
        return NowDateTime.get_current_time();
    }
    
    public void update_status(int s)
    {
        // user gives the int value to MANUALLY update the task status
        // the manual update gets presedence of automated update
        // for example, when user update the status to 9, and the system shouldn't overwrite that to 2 just because today is after the start date             
        status = s;
    }
    
    public int update_status()
    {
        // update the status AUTOMATICALLY once the start_date passes only when it was scheduled status
        // when pickup date is 12/12/2017 and today is 12/12/2017, the status automatiically changes to STARTED
        DateTime rightnow = whats_now();
        // automatically updating task status as time progress 
        if (status == COMPLETED || status == CANCELLED)
        {
            return status;
        }     
        
        if (rightnow.compareTo(start_date) >= 0)
        {
            status =  STARTED;           
        }
        else
        {
            status = SCHEDULED;
        }
        return status;
    }
    
//    protected DateTime whats_today() 
//    {        
//        LocalDateTime now = LocalDateTime.now();
//        DateTime today = new DateTime(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
//        return today;
//    }
//    protected DateTime whats_today(int m, int d, int y) // manipulated today 
//    {
//        DateTime manip_today = new DateTime(m, d, y);
//        return manip_today;
//    }

//    protected DateTime whats_now()
//    {        
//        LocalDateTime now = LocalDateTime.now();
//        DateTime rightnow = new DateTime(now.getMonthValue(), now.getDayOfMonth(), now.getYear(), now.getHour(), now.getMinute());
//        return rightnow;
//    }    
//    protected DateTime whats_now(int m, int d, int y, int h, int min) // manipulated now
//    {        
//        DateTime manip_rightnow = new DateTime(m, d, y, h, m);
//        return manip_rightnow;
//    }
    
    //toString
    @Override
    public String toString()
    {
        return "not specified task";
    }
  
}
