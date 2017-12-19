/* author: hana ra */
package ordermanagementsystem;

import java.time.LocalDateTime;

public class NowDateTime 
{
    // Properties
    private static boolean debug_mode = false;        
    private static DateTime manip_now = new DateTime();
    
    // Setter
    public static void set_debug_mode(boolean val)
    {
        debug_mode = val;
    }
    
    public static void set_DateTime(DateTime d) // being used from main
    {
        if (debug_mode == true)
        {
            manip_now = d;
        }
    }
    
    // Getter
    public static boolean get_debug_mode()
    {
        return debug_mode;
    }
    
    public static DateTime get_current_time()
    {
        DateTime whats_now;
        
        if (debug_mode == true) 
        {
            whats_now = manip_now;
        }
        else
        {
            LocalDateTime now = LocalDateTime.now();
            whats_now = new DateTime(now.getMonthValue(), now.getDayOfMonth(), now.getYear(), now.getHour(), now.getMinute());
        }
        return whats_now;
    }
}
