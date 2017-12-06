
// @author: hana ra
package inheritance;

import java.time.LocalDateTime;

public class Account 
{
    /* [ Account ]
        - A non-abstract superclass that has id, current balance, and created date info
        - Can withdraw as long as an amount doesn't exceed current balance
        - Can also deposit amount  
        - Inheriting classes are SavingsAccount, CheckingAccount, and LongTermSavingsAccount
    */
    
    // Data Attributes
    protected String id;
    protected double current_balance;
    protected Date created_date; // date of an account created
    
    // Constructor
    public Account()
    {
        id = "";
        current_balance = 0.0;
        set_created_date(); 
    }
    public Account(String i)
    {
        id = i;
        current_balance = 0.0;
        set_created_date(); 
    }
    public Account(String i, double b)
    {
        id = i;
        current_balance = b;
        set_created_date();
    }
    public Account(Account a) // copy constructor
    {
        id = a.get_id();
        current_balance = a.get_current_balance();
        created_date = a.get_created_date();
    }
    
    // Setters
    public void set_id(String i)
    {
        id = i;
    }
    public void set_current_balance(double b)
    {
        current_balance = b;
    } 
    protected void set_created_date() // Main can't access this
    {
        LocalDateTime now = LocalDateTime.now();
        created_date = new Date(now.getMonthValue(), now.getDayOfMonth(), now.getYear());
    }
    
    // Getters
    public String get_id()
    {
        return id;
    }
    public double get_current_balance()
    {
        return current_balance;
    }
    public Date get_created_date()
    {
        return created_date;
    }
    
    // Methods
    public boolean deposit(double amount)
    {
        current_balance += amount;
        return true;
    }    
    public boolean withdraw(double amount)
    {
        if (amount > current_balance) // low balance; can't withdraw 
            return false;

        current_balance -= amount;
        return true;
    }
    
    // toString
    @Override
    public String toString()
    {
        return String.format("Account# %s was created on %s. Current balance is $%.2f", id, created_date, current_balance);
    }
    
    
}
