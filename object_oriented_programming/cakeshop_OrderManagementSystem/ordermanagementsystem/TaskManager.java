/* author: hana ra */
package ordermanagementsystem;

public class TaskManager // holds all three types of tasks
{
    // Properties
    private Task[] all_tasks;
    private int num_tasks;
    
    // Constructor
    public TaskManager(int l)
    {
        all_tasks = new Task[l];
        num_tasks = 0;
    }
    
    // Getters 
    public Task[] get_all_tasks()
    {
        return all_tasks;
    }
    public int get_num_tasks()
    {
        return num_tasks;
    } 
     
    // Method      
    public boolean add_task(Task t)
    {
        if (num_tasks != all_tasks.length)
        {
            all_tasks[num_tasks++] = t;
            return true;
        } 
        return false;
    }
    
    @Override
    public String toString()
    {
        String output = "\n–––––––––––––– [ ALL TASKS ] ––––––––––––––\n";
        for(int i = 0; i < num_tasks; i++)
        {
            output += all_tasks[i].toString();
            output += "\n";
        }
        return output;
    }
}
