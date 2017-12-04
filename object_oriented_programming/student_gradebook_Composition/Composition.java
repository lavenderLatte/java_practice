
// @author hana ra

package composition;

import java.util.Arrays;

public class Composition 
{
    public static void main(String[] args) 
    {
        // testing Student-class
        Student s = new Student(323, "Hannah"); // creating Student-class object
        System.out.println(s.get_name());       // gets name 
        s.set_grade(89.0);                      // sets grade
        System.out.println(s);                  // prints out student object
        
        // testing Roster-class
        Roster oop = new Roster("CIS059");                     // creating Roster-class object
        System.out.println(Arrays.toString(oop.get_roster())); // prints out CIS059's Roster
        oop.add_student(197, "Ravi");                          // adds a student to CIS059's Roster
        oop.set_grade(197, 95);                                // sets grade
        oop.add_student(s);                                    // adds a student by using copy constructor
        oop.add_student(561, "Robin", 56);
        System.out.println(Arrays.toString(oop.get_roster())); 
        System.out.println(oop.class_avg());                   // gets class's grade average 
        System.out.println(oop.highest_grade());               // gets the highest grade
        oop.remove_student(561);                               // removes  a student ID# 561
        System.out.println(Arrays.toString(oop.get_roster()));        
    }  
}