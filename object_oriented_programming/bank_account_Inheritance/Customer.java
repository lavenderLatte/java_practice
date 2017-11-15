
/*
improve it later: use polymorphism for acconts array?
*/

package cis59_1030_exercise6;

public class Customer 
{
    private String firstName;
    private String lastName;
    private String id;
    private SavingsAccount[] accounts;  
    private int activeAccounts;
    
    public Customer()
    {
        firstName = "";
        lastName = "";
        id = "";
        activeAccounts = 0;
        accounts = new SavingsAccount[5]; // one customer can have max 5 accouts
    }

    public boolean addAccount(String i)
    {
        // if # of active accounts is full, returns false
        if (activeAccounts == 5)
            return false;
        
        // if # of active account is not over the limit then,
        // creates a new SavingsAccount object from the given String i as an "id"
        SavingsAccount a = new SavingsAccount(i);
        
        // adds the new account to the accounts[]
        accounts[activeAccounts] = a; // "a" is SavingsAccount object
        activeAccounts++;
        
        return true;
    }
    
    public String get_Cid()
    {
        return id;
    }
    
    public String get_SAid()
    {
        for (int idx = 0; idx < accounts.length; idx++)
            if (accounts[idx] != null)
                return accounts[idx].get_id();
        
        return null;          
        
    }
}
