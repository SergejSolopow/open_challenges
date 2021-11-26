package solopow.anytest;
import java.util.Arrays;
import java.util.ArrayList;



public class Challenges 
{    
    public static ArrayList fizzbuzz(int n) 
    {        
        /*
        initialise an instance of the class ArrayList with a name of arr.
        Use Object atribute as Superclass for String or int Integer classe
        */
      
        ArrayList<Object> arr = new ArrayList<Object>();
    
        /*
        iterate through the first n numbers using for(){} flow control
        and figutre out numbers with matching conditions. 
        Add to the ArrayyList arr wit add method. 
        */
    
        for(int i = 1; i <= n; i++)
        {
        if(i%3 == 0 && i%5 != 0)
        {
            arr.add("Fizz");
        }
        else if(i%5 == 0 && i%3 != 0)
        {
            arr.add("Buzz");
        }
        else if(i%5 == 0 && i%3 == 0)
        {
            arr.add("FizzBuzz");
        }
        else
        {
            arr.add(i);
        }
    }
    return arr;
  }   
   
    public static void main(String[] args)
    {       
       System.out.println(fizzbuzz(16));
    }
}
