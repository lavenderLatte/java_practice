/* author: hana ra */
package ordermanagementsystem;

public class Customer 
{
    // Properties
    private String first_name;
    private String last_name;
    private static int next_cutomer_id = 0;
    private int customer_id;
    
    // Constructors
    public Customer()
    {
        first_name = "";
        last_name = "";
        customer_id = next_cutomer_id++;
    }
    public Customer(String f, String l)
    {
        first_name = f;
        last_name = l;
        customer_id = next_cutomer_id++;
    }
    public Customer(Customer c)
    {
        first_name = c.get_fname();
        last_name = c.get_lname();
        customer_id = next_cutomer_id++;       
    }
    
    // Setters
    public void set_fname(String f)
    {
        first_name = f;
    }
    public void set_lname(String l)
    {
        last_name = l;
    }
    
    // Getters
    public String get_fname()
    {
        return first_name;
    }
    public String get_lname()
    {
        return last_name;
    }
    public int get_cid()
    {
        return customer_id;
    }
     
    // method
//    public boolean add_order(String i)
//    {
//        // if # of order array is full, returns false
//        if (num_orders == 20)
//            return false;
//        
//        // creates a new SavingsAccount object from the given String i as an "id"
//        Task order = new AdvancedOrder(i);
//        
//        // adds the new account to the accounts[]
//        accounts[activeAccounts] = a; // "a" is SavingsAccount object
//        activeAccounts++;
//        
//        return true;
    
    @Override
    public String toString()
    {
        return String.format("#%s %s %s", customer_id, first_name, last_name);
    }
}
