
package cis59_1016_exercise5;

public class Student 
{
    /* [ Exercise 5 – Student ]
        Complete the constructors, set/get functions toString and anything else 
        to support the main program code
    */
    
    // Data Attributes
    private int id;
    private String name;
    private double grade;
    
    // Constructors and overloaded ones
    public Student()
    {
        id = 0;
        name = "";
        grade = 0.0;
    }
    public Student(int i, String s, double d)
    {
        id = i;
        name = s;
        grade = d;                
    }     
    public Student(int i, String s) // when grade is unknown
    {
        id = i;
        name = s;
        grade = 0.0;
    }
    
    // Setters
    public void set_id(int i)
    {
        id = i;
    }
    public void set_name(String s)
    {
        name = s;
    }
    public void set_grade(double d)
    {
        grade = d;
    }
    
    // Getters
    public int get_id()
    {
        return id;
    }
    public String get_name()
    {
        return name;
    }
    public double get_grade()
    {
        return grade;
    }
    
    // toString method
    public String toString()
    {
        return String.format("%s(SID: %04d): %.2f ", get_name(), get_id(), get_grade());  
    }
    
    // anything else? equals method
    

    
}
