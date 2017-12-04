// @author hana ra

package composition;

/* [ Roster ]
    - Maintains a roster of each course
    - Can get roster info such as its course name or roster itself
    - Can add or remove a student from the roster
    - Can set a student's grade of the course or get info about a student
    - Can check the mean or the highest grade of the course
*/

public class Roster 
{
    // Data Attributes
    private String course_name;
    private Student[] roster;
    private int number_of_students = 0; // total number of enrolled students
    private int ROSTER_SIZE = 10;  
    
    // Default and Overloaded Constructors
    public Roster()
    {   
        course_name = "";
        roster = new Student[ROSTER_SIZE];           
    }    
    public Roster(String s)            
    {
        course_name = s;
        roster = new Student[ROSTER_SIZE];
    }
    public Roster(Roster r)
    {
        course_name = r.get_course_name();
        roster = r.get_roster();
    }
    
    // Getter
    public String get_course_name()
    {
        return course_name;
    }   
    public Student[] get_roster()
    {
       return roster;
    }
    
    // Setter 
    public void set_course_name(String s)
    {
        course_name = s;
    }
    
    // does_exist method
    //: returns False if check_student_idx(i) == -1, meaning SID doesn't exist in roster
    public boolean does_exist(int id)  
    {
        return (check_idx(id) != -1); 
    }
    
    // check_idx method
    // : returns index number of matching given id# if exist in roster array, otherwise returns -1
    private int check_idx(int id)
    {
        int student_idx = -1;
        
        for (int idx = 0; idx < number_of_students; idx++)
        {
            Student CURRENT_STUDENT = roster[idx];
            if (CURRENT_STUDENT != null)
                if (CURRENT_STUDENT.get_id() == id)
            {
                student_idx = idx;
            }               
        }
        return student_idx;
    }         
    
    // add_student method
    // : add Student class object in Roster array    
    public void add_student(int i, String s, double d)
    {
        // adding Student object only when the id is not already exist on roster
        if (does_exist(i) == false)         
            roster[number_of_students++] = new Student(i, s, d);                     
    }     
    public void add_student(int i, String s)
    {
        if (does_exist(i) == false)  
            roster[number_of_students++] = new Student(i, s); 
    }
    public void add_student(Student s) // input parameter is student object: passing by reference           
    {
        if (does_exist(s.get_id()) == false) 
            roster[number_of_students++] = new Student(s); // using copy constructor of Student
    } 
    
    // remove_student method
    // : removes student that matches to given id# from Roster array
    public boolean remove_student(int id)
    {
        if (does_exist(id))
        {
            // removing the Current Student by replacing it with last item in array intead of leaving it null
            roster[check_idx(id)] = roster[--number_of_students]; // index value is 1 less than number_of_students value
            roster[number_of_students] = null; // deleting the last element in the array
            return true;
            
        }
        return false;
    }
   
    // student_info method
    // : returns Student object in array that matches to given id#
    public Student student_info(int id)
    {
        if (does_exist(id))
            return roster[check_idx(id)];  
        
        return null;
    }
    
    // set_grade method
    // : sets grade for a Student with matching id#
    public void set_grade(int id, double g)
    {
        if (does_exist(id))
            roster[check_idx(id)].set_grade(g);        
    }
    
    // class_avg method
    // : calculates grade average of a class
    public double class_avg()
    {
        double grade_sum = 0.0;
        
        for (int idx = 0; idx < number_of_students; idx++)
        {
            grade_sum += roster[idx].get_grade();
        }
        
        return grade_sum/number_of_students;
    }
    
    public double highest_grade()
    {
        double highest = 0.0;
        
        for (int idx = 0; idx < number_of_students; idx++)
        {
            if (roster[idx].get_grade() > highest)
                highest = roster[idx].get_grade();
        }        
        return highest;
    }
}