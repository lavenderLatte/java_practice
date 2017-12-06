// @Author: hanara
package polymorphism;

import java.text.DecimalFormat;

/* [ RectangularPrism ]
    - Subclass of ThreeDimShape
    - Has three properties: length, width, and height
*/
public class RectangularPrism extends ThreeDimShape
{
    // Properties
    private double length;
    private double width;
    private double height;
    
    // Constructors
    public RectangularPrism()
    {
        length = 0.0;
        width = 0.0;
        height = 0.0;
    }
    public RectangularPrism(double l, double w, double h)
    {
        length = l;
        width = w;
        height = h;
    }
    public RectangularPrism(RectangularPrism rp)
    {
        length = rp.get_length();
        width = rp.get_width();
        height = rp.get_height();       
    }
    
    // Setters
    public void set_length(double l)
    {
        length = l;        
    }
    public void set_width(double w)
    {
        width = w;
    }
    public void set_height(double h)
    {
        height = h;
    }           
    
    // Getters
    public double get_length()
    {
        return length;
    }
    public double get_width()
    {
        return width;
    }
    public double get_height()
    {
        return height;
    }
    
    // Abstract Method Overriding
    @Override
    public double calculate_volume()
    {
        return length * width * height;
    }
    
    @Override
    public double calculate_surfaceArea()
    {
        return 2.0 * (width*length + height*length + height*width);
    }
    
    // toString Method
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        
        String output = "[RectangluarPrism], Length = " + get_length();
        output += ", Width = " + get_width();
        output += ", Height = "+ get_height();        
        output += ", Volume = " + df.format(calculate_volume());
        output += ", Surface Area = " + df.format(calculate_surfaceArea());  
        
        return output;        
    }
}
