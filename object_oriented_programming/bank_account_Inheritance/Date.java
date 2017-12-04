
// @author: hana ra
package inheritance;

public class Date
{
    // Data Attributes
    private int month;
    private int day;
    private int year;
    
    // Constructors 
    public Date()
    {
        month = 1;
        day = 1;
        year = 1900;
    }    
    public Date(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }   
    public Date(Date d) // Copy constructor
    {
        month = d.get_month();
        day = d.get_day();
        year = d.get_year();
    }
    
    // Setters     
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
    
    // Getters 
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

    @Override
    public String toString()
    {
        return String.format("%02d/%02d/%04d", month, day, year);
    }    
}
