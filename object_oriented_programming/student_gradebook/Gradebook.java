
package cis59_1016_exercise5;

public class Gradebook 
{
    /* [ Exercise 5 – Gradebook ]
        Complete the constructors, addStudent, removeStudent, exists, getStudent and
        setGrade methods to support the main program.
    
        CHALLENGE: write a function that returns the average grade of all Students currently
        in the Gradebook roster 
    */
    
    // Data Attributes
    private String course_name;
    private Student[] roster;
    private int number_of_students = 0; // total number of enrolled students
    private int roster_idx_num = 0;     // index number to create Student object in array
    private int roster_size = 10;    
    
    // Constructors
    public Gradebook()
    {   
        course_name = "";
        roster = new Student[roster_size];
        
//        for (int idx = 0; idx < roster_size; idx++)
//            roster[idx] =  new Student();           
    }    
    public Gradebook(String s)            
    {
        course_name = s;
        roster = new Student[roster_size];
    }
    
    // getter
    public String get_course_name()
    {
        return course_name;
    }   
    public Student[] get_roster()
    {
       return roster;
    }
    // public void get_roster()
    // {
    //     System.out.println(Arrays.toString(roster));  
    // }   
    // shoudln't have print statment in here??? WHY?????
    //use this intead of get_roster --> and put println in main function!!!

       
    // add_student method aka Setter for Array
    public void add_student(int i, String s, double d)
    {
        roster[roster_idx_num++] = new Student(i, s, d); // increment array index number here
        number_of_students++; // how to do with one varaible?????? and what does the slides mean????
    }     
    public void add_student(int i, String s)
    {
        roster[roster_idx_num++] = new Student(i, s); 
        number_of_students++;
    }
    public void add_student(Student s) // input parameter is student object: passing by reference           
    {
        roster[roster_idx_num++] = new Student(s.get_id(), s.get_name(), s.get_grade()); 
        number_of_students++;
    } 
    public void add_student()            
    {
        roster[roster_idx_num++] = new Student(); 
        number_of_students++;
    } 
    
    // exists method
    // public boolean exists_1(int i) // the input parameter is student id
    // {        
    //     for (int idx = 0; idx < roster.length; idx++)
    //     {
    //         try
    //         {
    //             if (roster[idx].get_id() == i)
    //             {
    //                 item_idx_num = idx;
    //                 return true;        
    //             }             
    //         }
    //         catch (NullPointerException e)
    //         {
    //             continue;
    //         }
    //     }                    
    //     return false;  
    // }

    // public boolean exists_2(int i) // ?????? which one is better?
    // {
    //     for (int idx = 0; idx < roster.length; idx++)
    //     {
    //         if (roster[idx] != null && roster[idx].get_id() == i)
    //         {
    //             item_idx_num = idx;
    //             return true;
    //         }            
    //     }
    //     return false;
    // }
       
    public boolean exists(int i)  
    {
        return (check_student_idx(i) != -1); // if check_student_idx(i) == -1 --> False, SID doesn't exist in roster 
    }
    
    private int check_student_idx(int i) // returns -1 if doesn't exist 
    {
        int student_idx = -1;
        
        for (int idx = 0; idx < roster.length; idx++)
        {
            if (roster[idx] != null && roster[idx].get_id() == i)
            {
                student_idx = idx;
            }            
        }
        return student_idx;
    }
        
    // get_student method 
    public String get_student(int i)
    {
        int student_arry_idx = check_student_idx(i);
        if (student_arry_idx != -1)
            return String.format("Student name %s is enrolled in %s.", roster[student_arry_idx].get_name(), get_course_name());  ///????check_student_idx(i)ok?
        return String.format("Student id# %06d isn't enrolled in %s.", i, get_course_name());
    }
    
    // set_grade method
    public String set_grade(int i, double d)
    {
        if (exists(i))
        {
            roster[check_student_idx(i)].set_grade(d); 
            return String.format("Grade for %s has set successfully!", roster[check_student_idx(i)].get_name());
        }          
        return String.format("Student id# %06d isn't enrolled in %s.", i, get_course_name());                    
    }    
    
    // remove_student method
    public boolean remove_student(int i)
    {
        if (exists(i))
        {
            roster[check_student_idx(i)] = null;
            number_of_students -= 1;
            return true;
        }        
        return false;
    }  
        
    // get class average    
    public double get_avg()
    {   
        double grade_total = 0.0;
        
        for (int idx = 0; idx < roster.length; idx++)
        {
            try
            {
                grade_total += roster[idx].get_grade();
            }
            catch (NullPointerException e)
            {
                continue;
            }            
        }
        
        double average = grade_total / number_of_students;
        return average;
    }   
    
     // toString method
    public String toString()
    {
        return String.format("Currently %d students enrolled in %s", number_of_students, course_name);
    }  
       
}
