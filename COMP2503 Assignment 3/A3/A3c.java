import java.util.*;
import java.io.*;
/**
 * Write a description of class A3c here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class A3c 
{
    private Scanner inp = new Scanner( System.in);
    //I hard coded the file in so I could test it without 
    private File file = new File("stocks.txt");

    private int buyAmt, buyPrice, sellAmt, sellPrice;

    private PriorityQueue<Integer> stocksBought = new PriorityQueue<Integer>();

    private PriorityQueue<Integer> priceBought = new PriorityQueue<Integer>();

        
    public static void main(String Args []) throws IOException
    {
        A3c capitalGains = new A3c();
        capitalGains.run();
    }

    public void run() throws IOException
    {
        //I used this for testing with a hard coded file
        Scanner inFile = new Scanner(file); 

        while(inFile.hasNext())
        {
        }
    }
}
