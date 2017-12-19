/* author: hana ra */
package ordermanagementsystem;

public class Products 
{
    // Properties
    protected double price;
    protected int size; // unit: inches

    // Constructors
    public Products()
    {
        price = 0.0;
        size = 0; 
    }
    public Products(double p, int s)
    {
        price = p;
        size = s; 
    }
    public Products(Products p)
    {
        price = p.get_price();
        size = p.get_size();         
    }
    
    // Setters
    public void set_price(double p)
    {
        price = p;
    }
    public void set_size(int s)
    {
        size = s;
    }
    
    // Getters
    public double get_price()
    {
        return price;
    }
    public int get_size()
    {
        return size;
    }
}
