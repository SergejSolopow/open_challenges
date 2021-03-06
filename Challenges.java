package solopow.anytest;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Iterator;



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
    
    public static ArrayList primeFinder(int n) 
    {        
        /*
        initialise ArrayList of the Ineger type. 
        */
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        
        /*
        find out prime numbers using for() control flow
        add primes to the arr using add method
        */        
        for(int i = 2; i <= n; i++ )
        {
            for(int j = 2; j <= i; j++)
            {                
                if(i%j == 0 && j != i)
                {
                    break;
                }                
                else if(i%j == 0 && j == i)
                {
                    primeList.add(j);
                }
            }
        }
        
        return primeList; 
    }
    
    public static int[] missingNos(int[] array, int k) 
    {
    
        int[] toReturn = new int[k];
        int[] tempArr = new int[array.length + k];
        int index = 0;
        for(int i : array)
        {
            tempArr[i - 1] = i;
        }
        
        for(int i = 0; i < tempArr.length; i++)
        {
            if(tempArr[i] == 0)
            {
                toReturn[index] = i + 1;
                index++;
            }
        }        
        return toReturn;
    }
    
    public static int[] flattenArray(int[][] input)     {
    
        int[] toReturn = new int[input[0].length + input[1].length];
    
        int k = 0;
        for(int[] i : input)
        {
            for(int j : i)
            {
                toReturn[k] = j;
                k++;
            }
        }
        return toReturn;    
    }
    
    public static int[] productOfTheOthers(int[] array)
    {
    
        int[] toReturn = new int[array.length];
        int product;
        for(int i = 0; i < array.length; i++)
        {   
            product = 1; 
            for(int j = 0; j < array.length; j++)
            {
                if(i == j)
                {
                    product *= 1;
                }
                else
                {
                    product *= array[j];
                }
            }
            
            toReturn[i] = product;
        }        
        return toReturn;
    }
    
    public static double[] statsFinder(int[] array) 
    {
        double[] toReturn = new double[2];
        //mean value
        double sum = 0;
        for(int i : array)
        {
            sum += i;
        }
        toReturn[0] = sum / array.length;

        //finde out mode
        //create ArrayList with unic modes
        ArrayList<Integer> unicList = new ArrayList<Integer>();
        boolean isThere = false;
        
        for(int i : array)
        {
            for(int j : unicList)
            {
                if(i == j)
                {
                    isThere = true;
                    break;
                }
                else if(i != j)
                {
                    isThere = false;
                }
            }
            
            if(isThere == false)
            {
                unicList.add(i);
            }
        }        
        
        //Array with a mode intensity
        int[] modeIntens = new int[unicList.size()];
        for(int i = 0; i < unicList.size(); i++)
        {
            for(int j : array)
            {
                if(unicList.get(i) == j)
                {
                    modeIntens[i] += 1;
                }
            }
        }        
        
        //compare mode intensity, finde out the most occuring value
        //create ArrayList for the case of more than one mode
        int position = 0;      
        
        for(int i = 0; i < modeIntens.length - 1; i++)
        {
            if(modeIntens[i] > modeIntens[position])
            {
                position = i;
            }            
        }
        toReturn[1] = unicList.get(position);

        return toReturn;
    }
    
    public static int fibFinder(int n) 
    {
       
       int toReturn = 0;
       //last two members in the Fibonacci sequence
       int k1 = 0;
       int k2 = 1;
       
       for(int i = 0; i <= n; i++)
       {
           if(i == 0)
           {
               toReturn = k1;
           }
           else if(i == 1)
           {
               toReturn = k2;
           }
           else
           {
               toReturn = k1 + k2;
               k1 = k2;
               k2 = toReturn;
           }
       }
          
       return toReturn;
    }
    
   public static int[] scoreSorter(int[] array, int topScore) 
   {
        
        boolean isReplaced = true; 
        int tempIndex;
        while(isReplaced)
        {
            isReplaced = false;
            for(int i = 0; i < array.length - 1; i++)
            {            
                if(array[i] < array[i + 1])
                {
                    tempIndex = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tempIndex;
                    isReplaced = true;
                }
            }
        }
    
        return array;
    }
   
   
    public static int capturingRainwater(int[] heights) 
    {
        int toReturn = 0;
        /*
        Subrutine. Figure out the highest height. 
        It will be used for flow control 
        */
        int maxHeight = 0;
        for(int i : heights)
        {
            if(i > maxHeight)
            {
                maxHeight = i;
            }
        }
        
        boolean fixHeight;
        int tempSum;
        int k = 0;
        
        while(k != maxHeight)
        {   
            tempSum = 0;
            fixHeight = false;
            
            for(int i : heights)
            {
                if(i > k && fixHeight == false)
                {
                    fixHeight = true;
                }
                else if(i <= k && fixHeight == true)
                {
                    tempSum++;
                }
                else if(i > k && fixHeight == true)
                {                    
                    toReturn = toReturn + tempSum;
                    tempSum = 0;
                }
            }
            k++;
        }
        
        return toReturn;                
    }
    
    public static int[] maxProfitDays(int[] stockPrices) 
    {
    // Add your code here
        int[] toReturn = new int[2];
        int maxRevenue = 0;
        
        for(int i = 0; i <= stockPrices.length; i++)
        {
            for(int j = i;   j < stockPrices.length; j++ )
            {
                if(stockPrices[j] - stockPrices[i] > maxRevenue)
                {
                    maxRevenue = stockPrices[j] - stockPrices[i];
                    toReturn[0] = i;
                    toReturn[1] = j;
                }
            }
        }

        return toReturn;
    }
    
    public static int sumOfPrimeFactors(int n) 
    {   
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        int sum = 0;
        //first, the integer has to be prime
        //second, the integer has to be factor of the "n"
        for(int i = 2; i <= n; i++)
            {
                for(int j = 2; j <= i; j++)
                {                
                    if(i%j == 0 && j != i)
                {
                    break;
                }                
                else if(i%j == 0 && j == i && n%j == 0)
                {
                    primeList.add(j);
                }
            }
        }
    
        /* 
        Let's make different from for() flow control
        and iterate with Iterator interface class  
        */
    
        Iterator iter = primeList.iterator();
        while(iter.hasNext())
        {
            //(int) has to be used in order to unwrape <Integer> class
            sum += (int)iter.next();
        }
        return sum;    
    }
    
    //find out pairs of elements in the array which sum results any given value
    //I have returned the answer as 2D ArrayList of the type Integer
    public static ArrayList<ArrayList<Integer>> findSumElementsInArrayMatchingTheTarget(int[] list, int target)
    {
        ArrayList<ArrayList<Integer>> toReturn = new ArrayList<>();
        int numOfPairs = 0;
        for(int i = 0; i < list.length - 1; i++)
        {
            int j = list.length - 1;
            while(j != i)
            {
                if(list[i] + list[j] == target)
                {   
                    toReturn.add(new ArrayList<>());
                    toReturn.get(numOfPairs).add(list[i]);
                    toReturn.get(numOfPairs).add(list[j]);
                    numOfPairs++;    
                }                
                j--;
            }
        }
        return toReturn;
    }
     
    public static void main(String[] args)
    {  
       //Test all the methods
       System.out.println(fizzbuzz(16));
       System.out.println(primeFinder(13));
       System.out.println(Arrays.toString(missingNos(new int[]{1, 2, 4, 5, 6, 7, 8, 10}, 2)));
       System.out.println(Arrays.toString(flattenArray(new int[][]{{1, 2}, {3, 4, 5}})));
       System.out.println(Arrays.toString(productOfTheOthers(new int[]{1, 2, 3, 4, 5})));
       System.out.println(Arrays.toString(statsFinder(new int[]{500, 400, 400, 375, 300, 350, 325, 300})));
       System.out.println(fibFinder(6));
       System.out.println(Arrays.toString(scoreSorter(new int[]{1, 2, 3, 9999, 13}, 10000)));
       System.out.println(capturingRainwater(new int[] {4, 2, 1, 3, 0, 1, 2}));
       System.out.println(Arrays.toString(maxProfitDays(new int[]{17, 11, 60, 25, 150, 1, 31, 150})));
       System.out.println(sumOfPrimeFactors(91));
       System.out.println(findSumElementsInArrayMatchingTheTarget(new int[]{1,1,4,3,2,2,5,6}, 7).get(0));
    }
}    