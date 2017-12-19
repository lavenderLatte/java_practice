/* author: hana ra */
package ordermanagementsystem;

public class DateTime implements Comparable <DateTime>
{
    // Data Attributes
    private int month;
    private int day;
    private int year;
    private Time time; // "compostion"
    
    // Constructors
    public DateTime()
    {
        month = 0;
        day = 0;
        year = 0;   
        time = new Time();
    }
    public DateTime(int m, int d, int y, int h, int min)
    {
        month = m;
        day = d;
        year = y;   
        time = new Time(h, min);
    }    
    public DateTime(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;   
        time = new Time();      
    }
    public DateTime(int m, int d, int y, Time t)
    {
        month = m;
        day = d;
        year = y;   
        time = new Time(t.get_hr(), t.get_min());      
    }
    public DateTime(DateTime dt, Time t)
    {
        month = dt.get_month();
        day = dt.get_day();
        year = dt.get_year();
        time = new Time(t.get_hr(), t.get_min());
    }
    
    // Setter
    public void set_month(int m)
    {
        month = m;
    }
    public void set_day(int d)
    {
        day = d;       
    }
    public void set_year(int y)
    {
        year = y;
    }
    public void set_time(int h, int m, int s)
    {
        time.set_hr(h);
        time.set_min(m);
    }
    
    // Getter 
    public int get_month()
    {
        return month;
    }
    public int get_day()
    {
        return day;
    }
    public int get_year()
    {
        return year;
    }   
    public Time get_time()
    {
        return time;
    }
    
    // Predicate Method
    public boolean is_valid()
    {
        if ((month <= 12)&&(month > 0) && (day <= 31)&&(day > 0) && (year >= 2017))
            if (time.is_valid())
            {
                return true;
            }               
            else
            {
                return false;
            }
        else
        {
            return false;
        }
    }
    
    // Method
    @Override
    public int compareTo(DateTime other)
    {
        // this: today, other: task start date
        if (this.year < other.year) // today < task start date
            return -1;
        else if (this.year > other.year) // today > task start date
            return 1;
        
        // at this point, years are same
        if (this.month < other.month) // today < task start date
            return  -1;
        else if (this.month > other.month) // today > task start date
            return 1;
        
        // at this point, year and month are same
        if (this.day < other.day) // today < task start date
            return  -1;
        else if (this.day > other.day) // today > task start date
            return 1;
        
        return this.time.compareTo(other.time); // today = task start date
    }
    
    @Override
    public String toString()
    {
        String output = String.format("%02d/%02d/%04d ", month, day, year);
        output += time.toString();
        return output;
    }
}
