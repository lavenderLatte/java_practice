
package cis59_1016_exercise5;

import java.util.Arrays;

public class CIS59_1016_Exercise5 
{
    public static void main(String[] args) 
    {
        /* [ Exercise 5 – Main ]
            At minimum, make this code work by completing the Gradebook and Student class.
        
            Add other code in main as you like to test more functionality with Gradebook
        */        
        
        // initialize Gradebook by using second constructor
	Gradebook oop = new Gradebook("CIS059");
        
        // add students on the OOP class roster 
        oop.add_student(111, "John Smith", 93.2);
	oop.add_student(112, "Jane Doe", 76.8);
        
	Student s = new Student(113, "Phil Tayco", 84.3);
        oop.add_student(s); // s is only the reference(memory address): passing by reference  
        
        // check current status of OOP class roster
        System.out.println(Arrays.toString(oop.get_roster()));
        System.out.println("––––––––––––––––––––––––––");

        // exists + get_student
	if (oop.exists(112))
            System.out.println(oop.get_student(112));
        
        // exist + set_grade
        System.out.println(oop.set_grade(112, 95.5));
        
        // exist + remove_student
	if (oop.remove_student(111))
            System.out.println("Student removed");
        
        System.out.println(Arrays.toString(oop.get_roster()));
        System.out.println("––––––––––––––––––––––––––");
        
        System.out.println(oop);
        System.out.printf("The course average is %s\n", oop.get_avg());
        System.out.println("=================================================");
        
        
        // GRADEBOOK FOR JAVA CLASS
        Gradebook java = new Gradebook();
        
        java.add_student(211, "Bonnie", 99.99);
        java.add_student();
        java.add_student(213, "Chobi", 77.77);
        System.out.println(Arrays.toString(java.get_roster()));
        System.out.printf("The course average is %s\n", java.get_avg());
        System.out.println("––––––––––––––––––––––––––");
        
        
        
        
    }
    
}
