
// @author: hana ra
package inheritance;

public class CheckingAccount extends Account
{    
    /* class CheckingAccount
        - A subclass of Account
        - Uniquely has routing number info
        - Can withdraw even the amount exceed the current balance but once the blance becomes <= 0, withdraw disabled
        - By depositing some amount, it can enable the withdrawing
        - Follows Account way of depositing  
    */
    
    // Data Attribute
    private int routing_num; 
        
    // Constructors
    public CheckingAccount()
    {
        super();
        routing_num = 0;      
    }
    public CheckingAccount(String i)
    {
        super(i);
        routing_num = 0; 
    }
    public CheckingAccount(String i, double b)
    {
        super(i, b);
        routing_num = 0;      
    } 
    public CheckingAccount(String i, double b, int r)
    {
        super(i, b);
        routing_num = r;      
    }
    public CheckingAccount(String i, int r)
    {
        super(i);
        routing_num = r; 
    }
    public CheckingAccount(CheckingAccount ca) // copy consctructor
    {
        super(ca.get_id(), ca.get_current_balance());
        routing_num = ca.get_routing_num();      
    }
    
    // Setters
    public void set_routing_num(int r)
    {
        routing_num = r;
    }
    
    // Getters
    public int get_routing_num()
    {
        return routing_num;
    }
    
    // Method    
    public boolean check_neg_bal()
    {
        if (current_balance == 0 || current_balance < 0)
            return true;
        
        return false;
    }
    
    @Override
    public boolean withdraw(double amount)
    {
        if (check_neg_bal() == true) // allows to withdraw even if withdraw amount > current_balance
            return false;
        
        current_balance -= amount;
        return true;
    }
    
    // toString
    @Override
    public String toString()
    {
        return String.format("Checking Account# %s was created on %s and the routing number is %010d", id, created_date, routing_num);
    }    
}
