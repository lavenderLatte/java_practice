/* author: hana ra */   
package ordermanagementsystem;

import java.util.Scanner;

public class OrderManagementSystem 
{
    private static CustomerManager cm = new CustomerManager(100);
    private static TaskManager tm = new TaskManager(100);
    private static SalesTransactionManager stm = new SalesTransactionManager(50);
    
    public static void main(String[] args) 
    {
        Scanner user_input = new Scanner(System.in); 
        
        int option = -1;
        do
        {
            System.out.println("\n||*|*|*|*|*|*|*|*|*|*| Crixa Internal Mangement System |*|*|*|*|*|*|*|*|*|*||");
            System.out.println("1) Add Cake Reservation");
            System.out.println("2) Cancel Cake Reservation");
            System.out.println("3) Show All Task Status");
            System.out.println("4) Mark Completed Task");
            System.out.println("5) Show All Sales");
            System.out.println("6) Show All Customers");
            System.out.println("7) DEBUG: Change Current Time");
            System.out.println("8) DEBUG: Toggle Debug Mode");
            System.out.println("0) Exit"); 
            System.out.println(""); 
            System.out.print("Choose Option: ");
            
            try
            {
                option = user_input.nextInt();
            }
            catch (Exception e)
            {
                option = -1;
                user_input.next();
            }
            
            switch (option)
            {
                case 1:
                    create_sale();
                    break;
                case 2: 
                    cancel_reservation();
                    break;
                case 3:
                    show_all_tasks();
                    break;
                case 4:
                    mark_complete();
                    break;
                case 5:
                    show_all_sales();
                    break;
                case 6:
                    show_all_customers();
                    break;
                case 7:
                    manipulate_time();
                    break;
                case 8:
                    toggle_debug_mode();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }
    
    // << OPTION 1 >>
    private static void create_sale()
    {
        Scanner user_input = new Scanner(System.in);
        
        System.out.println("1) Tiramisu, 2) Tres Leches");
        System.out.print("Which Cake? ");
        int option = user_input.nextInt();
        Products cake = null;
        if (option == 1)
        {
            cake = new Tiramisu();
        }
        else 
        {
            cake = new TresLeches();
        }
        
        System.out.print("How Many? ");
        int qty = user_input.nextInt();
        
        System.out.print("Pickup Date(m d y)? ");
        DateTime pickupdate = read_date();      

        Customer c = get_customer_info();
        SalesTransaction st = new SalesTransaction(cake, qty, pickupdate, c);
        stm.add_sale(st);
        
        add_cake_reservation(st);
        
//        System.out.println(st);
    }
    
    private static Customer get_customer_info()
    {
        // if customer id == -1, then it is a new customer.
        //  otherwise, use the input as a exisiting customer id and check if it exists.
        Scanner user_input = new Scanner(System.in);
        
        System.out.println("Enter Customer id# for for returning customer");
        System.out.print("Or, enter -1 to create a new customer account: ");
        int cid;
        boolean is_valid = true;
        Customer c = null;
        do 
        {
            if (is_valid == false)
            {
                System.out.println("Invalid Input!");
                System.out.println("Enter Customer id# for for returning customer");
                System.out.print("Or, enter -1 to create a new customer account: ");
            }
            
            cid = user_input.nextInt();
            
            if (cid != -1)
            {
                c = cm.get_customer(cid);
                if( c == null) 
                {
                    is_valid = false;
                }                    
                else 
                {
                    is_valid = true;
                }
            }
            else
            {
                System.out.print("Enter firstname: ");
                String fn = user_input.next();
                System.out.print("Enter lastname: ");
                String ln = user_input.next();
                c = new Customer(fn, ln);
                cm.add_customer(c);
                is_valid = true;
            }
        } while (is_valid == false);
        return c;
    }  
    
    private static void add_cake_reservation(SalesTransaction s)
    {        
        Task adv_order = new AdvancedOrder(s);
        Task pickup_call = new PickUpCall(adv_order, s);
        
        System.out.println("");
        System.out.println("–––––––––––––– [ CURRENT OVEN SCHEDULE STATUS ] ––––––––––––––");
        Task[] tasks = tm.get_all_tasks();
        for (int idx = 0; idx < tasks.length; idx++)
        {
            if (tasks[idx] instanceof OvenSchedule)
                System.out.println(tasks[idx]);
        }
        
        boolean overlap = false;
        boolean end_before_start = false;
        DateTime start_time;
        DateTime end_time;                
        do
        {
            if (overlap == true)
            {
                System.out.println("Time slot overlaps. Choose different time!");
            }
            if (end_before_start == true)
            {
                System.out.println("End of oven time is before the Start time!");
            }
            System.out.print("Enter Oven Start Date & Time(m d y h min): ");
            start_time = read_datetime();
            System.out.print("Enter Oven End Date & Time(m d y h min): ");
            end_time = read_datetime();
            
            // checking whether end_time is before start_time
            if (end_time.compareTo(start_time) == -1)
            {  
                end_before_start = true;
            }
            else
            {
                end_before_start = false;
            }
            // checking given start and end time is already taken 
            overlap = does_overlap(start_time, end_time);
        } while (overlap == true || end_before_start == true);
        
        Task oven_schedule = new OvenSchedule(start_time, end_time, s);

        tm.add_task(adv_order);
        tm.add_task(pickup_call);
        tm.add_task(oven_schedule);

//        System.out.println(tm);
    }
    
    
    // DATETIME RELATED FUNCTIONS
    private static DateTime read_date()
    {
        Scanner user_input = new Scanner(System.in);
        
        boolean is_valid = true;
        DateTime date = null;
        do 
        {
            if (is_valid == false)
            {
                System.out.print("Invalid Input! Enter Again? ");
            }
            try
            {
            int month = user_input.nextInt();
            int day = user_input.nextInt();
            int year = user_input.nextInt();
            date = new DateTime(month, day, year);
            is_valid = date.is_valid();
            }
            catch (Exception e)
            {
                is_valid = false;
                user_input.next();
            }
        } while (is_valid == false);
        return date;
    }
    
    private static DateTime read_datetime()
    {
        Scanner user_input = new Scanner(System.in);
        
        boolean is_valid = true;
        DateTime datetime = null;
        do 
        {
            if (is_valid == false)
            {
                System.out.print("Invalid Input! Enter Again? ");
            }
            try
            {
            int month = user_input.nextInt();
            int day = user_input.nextInt();
            int year = user_input.nextInt();
            int hour = user_input.nextInt();
            int min = user_input.nextInt();
            datetime = new DateTime(month, day, year, hour, min);
            is_valid = datetime.is_valid();
            }
            catch (Exception e)
            {
                is_valid = false;
                user_input.next();
            }
        } while (is_valid == false);
        return datetime;
    }
    
    private static boolean does_overlap(DateTime s, DateTime e)
    {
        Task[] tasks = tm.get_all_tasks();
        OvenSchedule temp;
        for (int idx = 0; idx < tasks.length; idx++)
        {
            if (tasks[idx] instanceof OvenSchedule)
            {
                temp = (OvenSchedule) tasks[idx];
                DateTime ts = temp.get_start_datetime();
                DateTime te = temp.get_end_datetime();
                // if s>ts && s<te -> overlap
                // is e>ts && e<te -->overlap
                // if ts>s && ts<e --> overlap
                if (s.compareTo(ts) > 0 && s.compareTo(te) < 0) return true;
                if (e.compareTo(ts) > 0 && e.compareTo(te) < 0) return true;
                if (ts.compareTo(s) > 0 && ts.compareTo(e) < 0) return true;    
            }
        }
        return false;
    }
    

    // << OPTION 2 >>
    private static void cancel_reservation()
    {
        Scanner user_input = new Scanner(System.in);
        
        System.out.println(stm);
        System.out.print("Enter the order# to cancel: ");
        int order_id = user_input.nextInt();
        
        Task[] tasks = tm.get_all_tasks();
        for (int idx = 0; idx < tm.get_num_tasks(); idx++)
        {
            if (tasks[idx].sale.order_id == order_id)
            {
                tasks[idx].update_status(Task.CANCELLED);
            }   
        }
    }
    
    // << OPTION 3 >>
    private static void show_all_tasks()
    {
        System.out.println("");
        System.out.println(tm);
    }
    
    // << OPTION 4 >>
    private static void mark_complete()
    {
        Scanner user_input = new Scanner(System.in);
        
        show_all_tasks();
        System.out.print("Enter task# to mark as complete: ");
        int task_id = user_input.nextInt();
        
        Task[] tasks = tm.get_all_tasks();
        for (int idx = 0; idx < tm.get_num_tasks(); idx++)
        {
            if (tasks[idx].get_task_id() == task_id)
            {
                tasks[idx].update_status(Task.COMPLETED);
            }   
        }
        
        show_all_tasks();
    }
    
    // << OPTION 5 >>
    private static void show_all_sales()
    {
        System.out.println("");
        System.out.println(stm);
    }
    
    // << OPTION 6 >>
    private static void show_all_customers()
    {
        System.out.println("");
        System.out.println(cm);
    }
    
    // << OPTION 7 >>
    private static void manipulate_time()
    {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Current manipulated date & time : " + NowDateTime.get_current_time());
        System.out.print("Change the current date and time to(m d y h min): ");
        DateTime dt = read_datetime();
        
        NowDateTime.set_DateTime(dt);
    }
    
    // << OPTION 8 >>
    private static void toggle_debug_mode()
    {
        if (NowDateTime.get_debug_mode() == true)
        {
            NowDateTime.set_debug_mode(false);
        }
        else
        {
            NowDateTime.set_debug_mode(true);
        }
        System.out.println("Debugging mode: " + NowDateTime.get_debug_mode());
    }
    
    
    // Just to test each classes
    public static void runtest_timemanipu()
    {
        NowDateTime.set_debug_mode(true);
        NowDateTime.set_DateTime(new DateTime(12, 16, 2017, 13, 45));
        
//        DateTime start = new DateTime(12, 17, 2017, 13, 10);
//        DateTime end = new DateTime(12, 17, 2017, 13, 30);
//        Task oven = new OvenSchedule(start, end);
//        
//        System.out.println(oven.get_status());
//        System.out.println(oven);
        
        DateTime advOrderStart = new DateTime(12, 17, 2017);
        DateTime pickupOrderStart = new DateTime(12, 17, 2017);
        Task advOrder = new AdvancedOrder(advOrderStart);
        Task pickUpOrder = new PickUpCall(advOrder);
        System.out.println(NowDateTime.get_current_time());
        System.out.println(advOrder);
        System.out.println(pickUpOrder);
        
        
        NowDateTime.set_DateTime(new DateTime(12, 17, 2017, 13, 45));
        System.out.println(NowDateTime.get_current_time());
        System.out.println(advOrder);
        System.out.println(pickUpOrder);
        
        advOrder.update_status(Task.COMPLETED);
        System.out.println(NowDateTime.get_current_time());
        System.out.println(advOrder);
        System.out.println(pickUpOrder);
        
        
        NowDateTime.set_DateTime(new DateTime(12, 15, 2017, 13, 45));
        System.out.println(NowDateTime.get_current_time());
        System.out.println(advOrder);
        System.out.println(pickUpOrder);
    }
    public static void runtest()    
    {
        // TESTING: Products and its Subclasses 
//        Products bomb = new Tiramisu();
//        System.out.println(bomb);
//        
//        Products delicious = new TresLeches(9);
//        System.out.println(delicious);   
        
        
        // TESTING: Time
//        Time now = new Time(15, 32);
//        Time later = new Time(18, 32);
//        Time time = new Time (25, 66);
//        System.out.println(now.compareTo(later));
//        System.out.println(time.is_valid());
        
        
        // TESTING: DateTime
//        DateTime requested_pickup_date = new DateTime(12, 15, 2017);
//        DateTime today = new DateTime(12, 16 , 2017);
//        System.out.println(requested_pickup_date);
//        System.out.println(requested_pickup_date.is_valid());
//        System.out.println(today.compareTo(requested_pickup_date));
//        
//        DateTime oven_time = new DateTime(12, 14, 2017, 8, 30, 00);
//        System.out.println(oven_time);         
        
        
        // TESTING: Customer and CustomerManager
//        Customer c1 = new Customer();
//        Customer c2 = new Customer("h", "r");
//        Customer c3 = new Customer("r", "c");
//        Customer c4 = new Customer(c3);
//        Customer c5 =  new Customer();
//        System.out.println(c4);
//        
//        CustomerManager cm = new CustomerManager(5);
//        cm.add_customer(c1);
//        cm.add_customer(c2);
//        cm.add_customer(c3);
//        cm.add_customer(c4);
//        System.out.println(cm);
//        System.out.println(Arrays.toString(cm.get_all_customers()));
//        System.out.println(cm.del_customer(c5));
//        
//        cm.del_customer(c2);
//        System.out.println(Arrays.toString(cm.get_all_customers()));
            
        
        // TESTING: SalesTransaction and SalesTransactionManager
//        Products t = new Tiramisu();
//        DateTime requested_pickup_date = new DateTime(12, 15, 2017);    
////        Customer cst1 = new Customer();
////        Customer cst2 = new Customer("hana", "ra");
//        
//        SalesTransaction sale1 = new SalesTransaction();
//        SalesTransaction sale2 = new SalesTransaction(t, 1, requested_pickup_date);
//        SalesTransaction sale3 = new SalesTransaction(t, 1, requested_pickup_date, c1);
//        SalesTransaction sale4 = new SalesTransaction(t, 1, requested_pickup_date, c2);
//        
//        System.out.println(sale1);
//        System.out.println(sale2);
//        System.out.println(sale3);
//        System.out.println(sale4);

//        SalesTransactionManager stm = new SalesTransactionManager(3);
//        stm.add_sale(sale1);
//        stm.add_sale(sale2);
//        stm.add_sale(sale3);
//        stm.add_sale(sale4);
//        System.out.println(Arrays.toString(stm.get_all_sales())); 
        
        
        //  TESTING: Task and its Subclasses
//        Task cake = new AdvancedOrder(sale2);
//        System.out.println(cake);
//               
//        Task call = new PickUpCall(cake); // linking dep task with indep task
//        System.out.println(call);
//        
//        cake.update_status(3); 
//        System.out.println(cake); 
//        System.out.println(call); // status of both task changes after indep gets update as "complete"
//        
//        cake.update_status(9);
//        System.out.println(cake); 
//        System.out.println(call);        
//        
//        System.out.println(call.get_status()); // able to use method in superclass
//        System.out.println(call.get_start_date()); // call is Task type, therefore, it can't access to the method in subclass 
//        PickUpCall temp = (PickUpCall) call;        // For the issue I need to CAST it to PickUpCall type
//        System.out.println(temp.get_call_date());   // now, I am able to access the methods in subclasses
//
//        System.out.println(call.get_task_id());
//        System.out.println(cake.get_task_id());
        
//        DateTime start = new DateTime(12, 17, 2017, 13, 10);
//        DateTime end = new DateTime(12, 17, 2017, 13, 30);
//        Task oven = new OvenSchedule(start, end);
//        System.out.println(oven.get_status());
//        oven.update_status(1);
//        System.out.println(oven.get_status());
//        System.out.println(oven);
              
//        OvenSchedule temp = (OvenSchedule) oven;
//        temp.update_status(12, 17, 2017, 10, 1);
//        System.out.println(oven);
//        System.out.println(oven.get_status());
        
//        // TESTING: TaskManager        
//        TaskManager this_week = new TaskManager();
//        this_week.add_task(cake);
//        this_week.add_task(call);
//        this_week.add_task(oven);
//        System.out.println(Arrays.toString(this_week.get_all_tasks()));        
    }    
}
