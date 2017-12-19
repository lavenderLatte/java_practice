/* author: hana ra */
package ordermanagementsystem;

public class SalesTransactionManager 
{
    // Properties
    private SalesTransaction[] all_sales;
    private int num_sales;
    
    // Constructor
    public SalesTransactionManager(int l)
    {
        all_sales= new SalesTransaction[l];
        num_sales = 0;
    }
    
    // Getters
    public SalesTransaction[] get_all_sales()
    {
        return all_sales;
    }
    public int get_num_customers()
    {
        return num_sales;
    }   
    
    // Methods
    public boolean add_sale(SalesTransaction s)
    {
        if (num_sales != all_sales.length)
        {
            all_sales[num_sales++] = s;
            return true;
        }      
        return false;        
    }
    
    @Override
    public String toString()
    {
        String output = "\n–––––––––––––– [ ALL SALES ] ––––––––––––––\n";
        for(int i = 0; i < num_sales; i++)
        {
            output += all_sales[i].toString();
            output += "\n";
        }
        return output;
    }
}
