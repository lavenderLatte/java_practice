
package cis84_1031_week8;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class DiceTally_mod 
{
    /* [ Excercise 6 ] 
        Modify the solution of exercise 5 to use an array 
        and ask user how many sides are on each of 2 dices. 
        The maximum nuber of sides of the dice is 50. 
    */
    
    public static int roll(int lowerBound, int a_upperBound, int b_upperBound)
    {
        int sum;
        
        Random generator = new Random();
        int dice_a = generator.nextInt(a_upperBound) + lowerBound;
        int dice_b = generator.nextInt(b_upperBound) + lowerBound;
        sum = dice_a + dice_b;
        
        return sum;
    }
    
    public static int[] tally()        
    {
        /* 
        When function tally() is called, it will ask user to decide the number of sides of each dice.
        Once that's done it will create an array that is 1 size longer than the sum of two dice. 
        For each toss, it will call roll() function to get result and simultaneously update the number of result in the array.
        Once complete all the rolls, it will return the tally result array. 
        */        
        
        // get the number of side for each dice 
        Scanner user_input = new Scanner(System.in);
        
        System.out.print("how many side for the 1st dice? ");        
        int a_side = user_input.nextInt();
        
        System.out.print("how many side for the 2nd dice? ");
        int b_side = user_input.nextInt();
              
        
        // create tally array that the length of it is possible max value + 1
        // length is 13 for two of 6-sided dice, but the last index num is 12
        // this is to make the arry to store, for example, dice sum value 5's info in index# 5
        // so that I don't have to code like if sum == 5, tally_arry[index] += 1 */
        int[] tally_arry = new int[a_side + b_side + 1]; 
        System.out.println(Arrays.toString(tally_arry));        
        
        int result;
        int roll_num = 600000;        
        // rolling two dice "roll_num" times
        for(int c = 0; c < roll_num; c++)
        {
            result = roll(1, a_side, b_side);
            tally_arry[result]++;
        }
        System.out.println(Arrays.toString(tally_arry));
        
        return tally_arry;    
    }
    
    public static void main(String[] args) 
    {
        // call tally-function
        int[] result_tally = tally();
        
        // print tally resutl from the array starting from index# 2
        for (int idx = 2; idx < result_tally.length; idx++)
        {
            System.out.printf("%s: %s\n", idx, result_tally[idx]);
        }
    }
       
}
