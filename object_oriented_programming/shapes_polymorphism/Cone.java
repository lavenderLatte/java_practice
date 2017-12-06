// @Author: hanara
package polymorphism;

import java.text.DecimalFormat;

/* [ Cone ]
    - Subclass of ThreeDimShape
    - Has two properties: radius and height 
*/
public class Cone extends ThreeDimShape
{
    // Properties
    private double height;
    private double radius;
    
    // Constructors
    public Cone()
    {
        height = 0.0;   
        radius = 0.0;
    }
    public Cone(double h, double r)
    {
        height = h;
        radius = r;
    }
    public Cone(Cone c)
    {
        height = c.get_height();
        radius = c.get_radius();
    }
    
    // Setters
    public void set_height(double h)
    {
        height = h;
    }
    public void set_radius(double r)
    {
        radius = r;
    }
    
    // Getters
    public double get_height()
    {
        return height;
    }
    public double get_radius()
    {
        return radius;
    }
    
    // Abstract Method Overriding
    @Override
    public double calculate_volume()
    {
        return Math.PI * Math.pow(radius, 2) * (height/3.0);
    }
    
    @Override
    public double calculate_surfaceArea()
    {
        return Math.PI * radius * (radius + Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2)));
    }
    
    // toString Method
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        
        String output = "[Cone] Radius = " + get_radius();
        output += ", Height = " + get_height();        
        output += ", Volume = " + df.format(calculate_volume());
        output += ", Surface area = " + df.format(calculate_surfaceArea());  
        
        return output;        
    }
    
    
    
}
