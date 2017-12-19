/* author: hana ra */
package ordermanagementsystem;

public class Time implements Comparable <Time>
{
    // Data Atrributes
    private int hour;
    private int minute;
    
    // Constructors
    public Time()
    {
        hour = 0;
        minute = 0;
    }
    public Time(int h, int m)
    {
        hour = h;
        minute = m;
    }
    
    // Setters
    public void set_hr(int h)
    {
        hour = h;
    }
    public void set_min(int m)
    {
        minute = m;
    }
    
    // Getters
    public int get_hr()
    {
        return hour;
    }
    public int get_min()
    {
        return minute;
    }
     
    // Predicate Method
    public boolean is_valid()
    {
        if ((0 <= hour) && (hour <= 23) && (0 <= minute)&& (minute <= 60))
        {
            return true;
        }               
        else
        {
            return false;
        }
    }
    
    // Method
    @Override
    public int compareTo(Time other)
    {
        // this: now, other: task start time
        if (this.hour < other.hour) // now < task start time
            return -1;
        else if (this.hour > other.hour) // now > task start time
            return 1;
        
        // at this point, hours are same
        if (this.minute < other.minute) // now < task start time
            return  -1;
        else if (this.minute > other.minute) // now > task start time
            return 1;
        
        return 0; // now = task start time
    }
    
    @Override
    public String toString()
    {
        return String.format("%02d:%02d", hour, minute);
    }
    
}
