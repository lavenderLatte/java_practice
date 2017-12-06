// @Author: hanara
package polymorphism;

/* [ ShapesArray ]
    - Maintains array of ThreeDimShape type objects
    - Can add and check the number of ThreeDimShape type obejcts to an array
*/

public class ShapesArray 
{
    // Property
    private ThreeDimShape[] shapes;// I am NOT instantiating abstract class object. 
    private int num_of_shapes;
    private int array_length;
    
    // Constructor
    public ShapesArray(int l)
    {
        // : create an array of specified len and initialize num_of_shapes
        shapes = new ThreeDimShape[l]; 
        num_of_shapes = 0;
        array_length = l;
    }
    
    // Getter
    public ThreeDimShape[] get_shapes_array()
    {
        return shapes;
    }
    public int get_num_of_shapes()
    {
        return num_of_shapes;
    }
      
    // Method 
    // : adding an ThreeDimShape's subclass objects as an element of array depends on the number of parameters
    // useful to set values of properties an object in Array!!!
    public void add_shape(double r) 
    {
        // add ThreeDimShape object only when the array is not full
        if (num_of_shapes != array_length) 
            // passign 1 parameter creates Sphere-class object
            shapes[num_of_shapes++] = new Sphere(r);
    }
    public void add_shape(double h, double r)  
    {
        if (num_of_shapes != array_length) 
            // passign 2 parameters creates Cone-class object
            shapes[num_of_shapes++] = new Cone(h, r);
    }
    public void add_shape(double l, double w, double h)  
    {
        if (num_of_shapes != array_length) 
            // passign 3 parameters creates RectangularPrism-class object
            shapes[num_of_shapes++] = new RectangularPrism(l, w, h);
    }    
}
