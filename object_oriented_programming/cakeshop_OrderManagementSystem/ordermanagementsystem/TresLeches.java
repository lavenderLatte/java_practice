/* author: hana ra */
package ordermanagementsystem;

public class TresLeches extends Products
{
    // Constructors
    public TresLeches() // default size is 6-inches cake
    {
        price = 29.00;
        size = 6; 
    }
    public TresLeches(int s) // 6-inch: $ 29, 9-inch: $57
    {
        price = 57.00;
        size = s; 
    }
    public TresLeches(TresLeches t)
    {
        price = t.get_price();
        size = t.get_size();         
    }
    
    @Override
    public String toString()
    {
        return String.format("[Tres Leches] %d-inch: $%.2f", size, price);
    }  
}
