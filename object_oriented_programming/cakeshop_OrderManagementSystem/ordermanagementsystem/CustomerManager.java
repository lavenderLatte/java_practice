/* author: hana ra */
package ordermanagementsystem;

public class CustomerManager
{
    // Properties
    private Customer[] all_customers;
    private int num_customers;
    
    // Constructor
    public CustomerManager(int l)
    {
        all_customers= new Customer[l];
        num_customers = 0;
    }
    
    // Getters
    public Customer[] get_all_customers()
    {
        return all_customers;
    }
    public int get_num_customers()
    {
        return num_customers;
    }   
    
    // Methods
    public boolean does_exist(Customer c)
    {
        return (check_idx(c) != -1);
    }
    
    public int check_idx(Customer c)
    {
        int customer_idx = -1;
        
        for (int idx = 0; idx < num_customers; idx++)
        {
            Customer current_customer = all_customers[idx];
            if (current_customer != null)
            {
                if (current_customer.get_cid() == c.get_cid())
                {
                    customer_idx = idx;
                }    
            }           
        }
        return customer_idx;
    }
    
    public Customer get_customer(int i) //let's assume every customer knows their id
    {
        Customer customer = null;
        
        for (int idx = 0; idx < num_customers; idx++)
        {
            Customer current_customer = all_customers[idx];
            if (current_customer != null)
            {
                if (current_customer.get_cid() == i)
                {
                    customer = current_customer;
                }  
            }          
        }
        return customer;        
    }
    
    public boolean add_customer(Customer c)
    {
        if (num_customers != all_customers.length)
        {
            if (does_exist(c) == false)
            {
                all_customers[num_customers++] = c;
                return true;
            }
        }      
        return false;        
    }
    
    public boolean del_customer(Customer c)
    {
        if (does_exist(c))
        {
            // filling up the hole after deleting Customer object with the last object in array
            all_customers[check_idx(c)] = all_customers[--num_customers]; 
            all_customers[num_customers] = null; // setting the last element in the array as null
            return true; 
        }
        return false;
    }
    @Override
    public String toString()
    {
        String output = "\n–––––––––––––– [ ALL CUSTOMERS ] ––––––––––––––\n";
        for(int i = 0; i < num_customers; i++)
        {
            output += all_customers[i].toString();
            output += "\n";
        }
        return output;
    }
}
