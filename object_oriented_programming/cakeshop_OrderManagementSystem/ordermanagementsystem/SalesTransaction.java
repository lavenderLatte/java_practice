/* author: hana ra */
package ordermanagementsystem;

public class SalesTransaction  // != from TaskManager, this holds only order related info
{
    // Properties
    private static int next_order_id = 0;
    protected int order_id;
    private Products product;
    private int quantity;
    private DateTime pickup_date;
    private Customer customer;
    
    // Constructors
    public SalesTransaction()
    {
        order_id = next_order_id++;
        quantity = 0;
        
    }
    public SalesTransaction(Products p, int q, DateTime d)
    {
        order_id = next_order_id++;
        product = p;
        quantity = q;
        pickup_date = d;
    } 
    public SalesTransaction(Products p, int q, DateTime d, Customer c)
    {
        order_id = next_order_id++;
        product = p;
        quantity = q;
        pickup_date = d;
        customer = c; // creating new customer and looking up existing customer??? // only need the id or full customer info?
    }
    
    // Setters
    public void set_product(Products p)
    {
        product = p;
    }
    public void set_quantity(int q)
    {
        quantity = q;
    }
    public void set_pickup_date(DateTime d)
    {
        pickup_date = d;
    }
    public void set_pickup_date(int m, int d, int y)
    {
        pickup_date = new DateTime(m, d, y);
    }
    public void set_customer(Customer c)
    {
        customer = c;
    }
    
    // Getters 
    public Products get_product()
    {
        return product;
    }
    public int get_quantity()
    {
        return quantity;
    }
    public DateTime get_pickup_date()
    {
        return pickup_date;
    }
    public Customer get_customer()
    {
        return customer;
    }
    
    // toString
    @Override
    public String toString()
    {
        return String.format("Order#%d, %s, Q'ty:%d, Pickup %s for Customer %s", order_id, product, quantity, pickup_date, customer);
    } 
   
}
