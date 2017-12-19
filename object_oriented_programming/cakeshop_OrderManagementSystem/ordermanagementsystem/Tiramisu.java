/* author: hana ra */
package ordermanagementsystem;

public class Tiramisu extends Products
{
    // Constructors
    public Tiramisu() // default size is 6-inches cake
    {
        price = 31.00;
        size = 6; 
    }
    public Tiramisu(int s) // 6-inch: $ 31, 9-inch: $62
    {
        price = 62.00;
        size = s; 
    }
    public Tiramisu(Tiramisu t)
    {
        price = t.get_price();
        size = t.get_size();         
    }
    
    @Override
    public String toString()
    {
        return String.format("[Tiramisu] %d-inch: $%.2f", size, price);
    }    
}
