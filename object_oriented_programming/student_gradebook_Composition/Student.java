// @author hana ra

package composition;

/* [ Student Class ]
    - Stores information such as id, name, and grade of each student
    - Can set or get these information from the main function 
*/

public class Student 
{
    // Data Attributes
    private int id;
    private String name;
    private double grade;
    
    // Default and Overloaded Constructors
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
    public Student(int i, String s)
    {
        id = i;
        name = s;
        grade = 0.0;
    }
    public Student(Student s) // copy constructor
    {
        id = s.get_id();
        name = s.get_name();
        grade = s.get_grade();
    }
    
    // Setters
    public void set_id(int i)
    {
        id = i;
    }
    public void set_name(String n)
    {
        name = n;
    }
    public void set_grade(double g)
    {
        grade = g;
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
    @Override
    public String toString()
    {
        return String.format("%s(SID: %04d): %.2f ", name, id, grade);  
    }
}