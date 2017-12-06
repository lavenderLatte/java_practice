// @Author: hanara
package polymorphism;

/* [ ThreeDimShape ]
	- An abstract superclass 
	- Has no properties
	- Only inherites two methods to calculate volumes and surface area
*/
public abstract class ThreeDimShape 
{            
    public abstract double calculate_volume();
    
    public abstract double calculate_surfaceArea();     
}
