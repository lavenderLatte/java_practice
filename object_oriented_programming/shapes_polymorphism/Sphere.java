// @Author: hanara
package polymorphism;

import java.text.DecimalFormat;

/* [ Sphere ]
    - Subclass of ThreeDimShape
    - Has one property: radius 
*/

public class Sphere extends ThreeDimShape
{
    // Properties
    private double radius;
    
    // Constructors
    public Sphere()
    {
        radius = 0.0;
    }
    public Sphere(double r)
    {
        radius = r;
    }
    public Sphere(Sphere s)
    {
        radius = s.get_radius();
    } 
    
    // Setters
    public void set_radius(double r)
    {
        radius = r;
    }    
    
    // Getters
    public double get_radius()
    {
        return radius;
    }
    
    // Abstract Method Overriding
    @Override
    public double calculate_volume()
    {
        return (4.0/3.0) * Math.PI * Math.pow(radius, 3); //the division should be double form
    }
    
    @Override
    public double calculate_surfaceArea()
    {
        return 4.0 * Math.PI * Math.pow(radius, 2);
    }
    
    // toString Method
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        
        String output = "[Sphere] Radius = " + get_radius();
        output += ", Volume = " + df.format(calculate_volume());
        output += ", Surface Area = " + df.format(calculate_surfaceArea());   
                
        return output;        
    }
    
}