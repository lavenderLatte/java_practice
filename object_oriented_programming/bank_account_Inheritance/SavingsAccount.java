/*
improve it later: apply interest rate once after each month
*/

package cis59_1030_exercise6;

public class SavingsAccount extends Account
{
    /* class SavingsAccount
        - a Subclass of Account
        - uniquely has interest rate and the number of withdraw execution info
        - can withdraw as long as the amount doesn't exceed the current balance and the number of allowed withdrawal 
        - follows Account's way of depositing  
    */
    
    // Data Attributes
    private double interest_rate;
    private int withdraw_limited; // max number of times can withdraw per month
    private int monthly_withdraw_allowed = 5;
    
    // Constructors
    public SavingsAccount()
    {
        super();
        interest_rate = 0.0;
        withdraw_limited = monthly_withdraw_allowed;
        
        // Don'tbeed this. set_created_date() in Superclass' constructor will take care of it.
//        created_date = new Date();
    }    
    public SavingsAccount(String i)
    {
        super(i);
        interest_rate = 0.0;   
        withdraw_limited = monthly_withdraw_allowed;
    }
    public SavingsAccount(String i, double b, double ir)
    {
        super(i, b);
        interest_rate = ir;
        withdraw_limited = monthly_withdraw_allowed;
    }
    public SavingsAccount(SavingsAccount sa)
    {
        super(sa.get_id(), sa.get_current_balance());
        interest_rate = sa.get_interest_rate();
        withdraw_limited = sa.get_withdraw_limited();
    }
    
    // Setters
    public void set_interest_rate(double ir)
    {
        interest_rate = ir;
    }
    
    // Getters
    public double get_interest_rate()
    {
        return interest_rate;
    }
    public int get_withdraw_limited()
    {
        return withdraw_limited;
    }
    
    // Method
    @Override
    public boolean withdraw(double amount)
    {
        if (amount > current_balance || withdraw_limited == 0) // either of two condition will fail to withdraw
            return false;
        
        current_balance -= amount;
        withdraw_limited--; // counting down
        return true;
    }
    
    // toString
    @Override
    public String toString()
    {
        return String.format("Savings Account# %s was created on %s. Current balance is $%.2f", id, created_date, current_balance);
    }
    

}
