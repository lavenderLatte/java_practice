/*
add : add bonus at the end of saving_period, convert LTSA into Checking account at the end of saving_period
*/

package cis59_1030_exercise6;

import java.time.LocalDateTime;

public class LongTermSavingsAccount extends Account
{
    /* class LongTermSavingsAccount
        - a Subclass of Account
        - uniquely has saving period and bonus info
        - can't withdraw nor deposit during the saving period time
        - once saving period time is over, can withdraw but still can't deposit 
    */
    
    // Data Attribute
    private int saving_period; // unit: day
    private double bonus;
    private int max_saving_period = 365*2; // unit: day, just setting a default value. shorter/longer possible by setter
    private Date today;
    
    // Constructors
    public LongTermSavingsAccount()
    {
        super();
        saving_period = max_saving_period;
        bonus = 0.0;               
    }
    public LongTermSavingsAccount(String i)
    {
        super(i);
        saving_period = max_saving_period;
        bonus = 0.0;               
    }
    public LongTermSavingsAccount(String i, double b)
    {
        super(i, b);
        saving_period = max_saving_period;
        bonus = 0.0;               
    }
    public LongTermSavingsAccount(String i, double b, int p, double bn)
    {
        super();
        saving_period = p;
        bonus = bn;               
    }
    public LongTermSavingsAccount(LongTermSavingsAccount ltsa)
    {
        super(ltsa.get_id(), ltsa.get_current_balance());
        saving_period = ltsa.get_saving_period();
        bonus = ltsa.get_bonus();               
    }
    
    // Setters
    public void set_saving_period(int p)
    {
        saving_period = p;
    }
    public void set_bonus(double bn)
    {
        bonus = bn;
    }    
    
    // Gettert
    public int get_saving_period()
    {
        return saving_period;
    }
    public double get_bonus()
    {
        return bonus;
    }
    
    // Methods
    private void whats_today() 
    {        
        LocalDateTime now = LocalDateTime.now();
        today = new Date(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
    }
    public boolean within_period()
    {
        whats_today();
        
        int month_left = (today.get_month() - created_date.get_month()) * 30;
        int day_left = today.get_day() - created_date.get_day();
        int year_left = (today.get_year() - created_date.get_year()) * 365;    
        int total_days_left = month_left + day_left + year_left;                 
        
        if (total_days_left > 0 || total_days_left == 0) // total_days_left >= 0, means it's within peirod
            return true;
        return false;          
    }    
    
    @Override
    public boolean deposit(double amount)
    {
        if (within_period() == true || within_period() == false) // during and even after the saving's period, deposit is not possible
            return false; 
        return false;
    }    
    @Override
    public boolean withdraw(double amount) // during saving's period deposit is not possible
    {
        if (within_period() == true) 
            return false;
        
        current_balance -= amount;
        return true;
    }
    
    
    // toString 
    @Override
    public String toString()
    {
        return String.format("Longterm Saving Account# %s was created on %s", id, created_date);
    } 
            
    
   
}
