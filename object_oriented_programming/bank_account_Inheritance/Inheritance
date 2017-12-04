
package cis59_1030_exercise6;

public class CIS59_1030_Exercise6 
{
    public static void main(String[] args) 
    {
//        Customer c = new Customer();
//        if (c.addAccount("1A2B3C"))
//            System.out.println("Account added");
//        
//        System.out.printf("id of Customer: %s\n", c.get_Cid());
//        System.out.printf("id of SavingsAccount: %s\n", c.get_SAid());
//        
//        
//        SavingsAccount a = new SavingsAccount();
//        System.out.println(a.get_id());
//        
//        SavingsAccount b = new SavingsAccount("1A2B3C");
//        System.out.println(b.get_id());
        
        
        // Testing Account-class
        Account a = new Account("1A2B3C");
        a.set_current_balance(14.55); 
        System.out.println(a.get_created_date()); // testing: set_created_date() in a constructor  
        System.out.println(a); // tesing: constructor, set_current_balance(), and set_created_date()
        
        
        // Testing SavingsAccount-class
        SavingsAccount sa = new SavingsAccount("1A2B3C");
        sa.set_current_balance(20.19); // tesing: accessing set_current_balance in Superclass?
        System.out.println(sa.get_created_date()); // tesing: accessing get_created_date() in Superclass?
        System.out.println(sa);
        System.out.println(sa.get_interest_rate()); // testing: accessing Subclass getter
        
        
        // Testing CheckingAccount
        CheckingAccount ca = new CheckingAccount("1A2B3C", 71249050);
        System.out.println(String.format("%010d", ca.get_routing_num())); // testing: 10-digit that could start with a 0
        System.out.println(ca);
        
        ca.deposit(10.00);                           // testing: deposit() in Superclass
        System.out.println(ca.get_current_balance());
        ca.withdraw(7.00);                           // tesing: withdraw() in Sublcass
        System.out.println(ca.get_current_balance());
        ca.withdraw(7.00);                           // testing: withdraw() in Sublcass; negative balance possible??
        System.out.println(ca.get_current_balance());
        System.out.printf("balance <= 0? %s\n", ca.check_neg_bal());
        ca.deposit(10.00);
        System.out.println(ca.get_current_balance());
        System.out.printf("balance <= 0? %s\n", ca.check_neg_bal());
        ca.withdraw(20.00);
        System.out.println(ca.get_current_balance());
                
        
        // Testing LongtermSavingsAccount - class 
        LongTermSavingsAccount ltsa = new LongTermSavingsAccount();        
        System.out.println(ltsa);
        System.out.println(ltsa.within_period());
        
        ltsa.deposit(5.55);
        System.out.println(ltsa.get_current_balance());
        
        
        
       
        
        
        
        
        
    }
}
   