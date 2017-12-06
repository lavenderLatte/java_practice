// @Author: hanara
package polymorphism;

import java.util.Arrays;

public class Polymorphism 
{
    public static void main(String[] args) 
    {
        // Testing Sphere-class 
//        Sphere s = new Sphere();
//        s.set_radius(2.5); // Setter works
//        System.out.println(s); // toString and Getter works
//        System.out.println(s.calculate_volume()); // overriden method works
//        System.out.println(s.calculate_surfaceArea()); // overriden method works
        
        // Testing Cone-class
//        Cone c = new Cone();
//        c.set_height(2); // Setters works
//        c.set_radius(5);
//        System.out.println(c); // toString and Getter works
//        System.out.println(c.calculate_volume()); // overriden methods works
//        System.out.println(c.calculate_surfaceArea());
        
        // Testing RectangularPrism-class
//        RectangularPrism rp = new RectangularPrism();
//        rp.set_length(5); // Setter works
//        rp.set_width(6);
//        rp.set_height(12);
//        System.out.println(rp); // toString and Getter works
//        System.out.println(rp.calculate_volume()); // overriden methods works
//        System.out.println(rp.calculate_surfaceArea());
        
        // Version 1 – Creating an Array and Adding Objects        
//        ThreeDimShape[] all_shapes = new ThreeDimShape[10];       
//        all_shapes[0] = new Sphere();  // tedious 
//        all_shapes[0].set_radius(2.5); // not possible: all_shapes[0]'s only reference NOT an object!!!
        
        // Version 2 – Creating and Array and Adding Object by using add-to-array function
        ShapesArray sa = new ShapesArray(10); // create size 10 array
        sa.add_shape(4); // passign 1 parameter creates Sphere-class object
        sa.add_shape(27);
        sa.add_shape(12, 10); // passign 2 parameters creates Cone-class object
        sa.add_shape(9, 2);
        sa.add_shape(4, 7, 11); // passign 3 parameters creates RectangularPrism-class object
        sa.add_shape(1, 1, 1);
//        sa.add_shape(7);
//        sa.add_shape(8);
//        sa.add_shape(9);
//        sa.add_shape(10);
//        sa.add_shape(11);
//        sa.add_shape(12);
//        System.out.println(Arrays.toString(sa.get_shapes_array()));
        
        // A loop to demonstrate properties, volumes and surface areas of each object in the array
//        for (int idx = 0; idx < sa.get_shapes_array().length; idx++)
//        {
//            System.out.println(sa.get_shapes_array()[idx]);
//        }
        
        // Initialize Variables to Use in for-loop
        int array_len = sa.get_shapes_array().length;
        double largest_vol = 0.0;
        ThreeDimShape largest_vol_obj = sa.get_shapes_array()[0]; // just initializing with first element in array
        double total_surface_area = 0.0;             
      
        for (int idx = 0; idx < array_len; idx++)
        {
            ThreeDimShape current_obj = sa.get_shapes_array()[idx];
            
            if (current_obj != null)
            {
                // Demonstrate properties, volumes and surface areas of each object in an array
                System.out.println(current_obj);                       
            
                // Find Largest Volume  
                double current_vol = current_obj.calculate_volume();

                if (current_vol > largest_vol)
                {
                    largest_vol = current_vol;
                    largest_vol_obj = current_obj;
                }

                // Sum Surface Area to Calculate Average
                total_surface_area += current_obj.calculate_surfaceArea();
            }     
        }
        System.out.printf("Largest Volume: %.2f\n", largest_vol);
        System.out.printf("Largest Volume Object: %s\n", largest_vol_obj);
        
        double avg_surface_area = total_surface_area / sa.get_num_of_shapes();
        System.out.printf("Average of Surface Area of All Objects: %.2f\n", avg_surface_area);        


        

        


       
    }
    
}
