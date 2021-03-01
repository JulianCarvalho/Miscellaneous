import java.util.*;
import java.io.*;
//IMPORTANT DOES NOT WORK
//the part that is the addStacks method
/**
 * A3b reads in a file, takes in two strings from the file, 
 * stores numbers in two stacks based off of the strings,
 * adds them and stores them into a new stack, then prints 
 *
 * Julian Carvalho
 * March 3, 2019
 */
public class A3b
{
    private Scanner inp = new Scanner( System.in);
    //I hard coded the file in so I could test it without 
    //private File file = new File("numbers.txt");

    //String variables to store the numbers from the file as Strings
    private String num1;
    private String num2;
    
    //int for a carry over value if the sum is greater than 10
    private int carryOver;
    // 3 stacks, one for each number and then one for the sum
    private Stack<Integer> firstNum = new Stack<Integer>();
    private Stack<Integer> secondNum = new Stack<Integer>();
    private Stack<Integer> sumNum = new Stack<Integer>();

    public static void main(String Args []) throws IOException
    {
        //instantiating an A3b object
        A3b addNums = new A3b();
        //calling run which calls other methods for this program to function
        addNums.run();
    }

    public void run() throws IOException
    {
        //I used this for testing with a hard coded file
        //Scanner inFile = new Scanner(file); //i used this for testing with a hard coded file
        
        while(inp.hasNext())
        {
            //these 2 lines take in the numbers from the file as Strings
            num1 = inp.next();
            num2 = inp.next();
            //loading the stacks up with the numbers
            loadStack(num1, firstNum);
            loadStack(num2, secondNum);
            //adding the numbers from the 2 stacks
            addStacks();
            //printing the stacks
            print();
            System.out.println("");
            //empties the stacks so it's ready for the next loop iteration
            firstNum.empty(); secondNum.empty(); sumNum.empty();
        }
    }
    
    public void loadStack(String num, Stack numStack)
    {
        char digitChar;
        for(int count = 0; count < num.length(); count++)
        {
            digitChar = num.charAt(count);
            switch(digitChar)
            {
                case '0': numStack.push(0); break;
                case '1': numStack.push(1); break;
                case '2': numStack.push(2); break;
                case '3': numStack.push(3); break;
                case '4': numStack.push(4); break;
                case '5': numStack.push(5); break;
                case '6': numStack.push(6); break;
                case '7': numStack.push(7); break;
                case '8': numStack.push(8); break;
                case '9': numStack.push(9); break;
            }
        }
    }
    
    public void addStacks()
    {
        int digit1, digit2, sum;
        carryOver = 0;
        while(!firstNum.isEmpty() && !secondNum.isEmpty() && carryOver != 1)
        {
            if(firstNum.isEmpty())
            {
                digit1 = 0;
            }
            else
            {
                digit1 = firstNum.pop();
            }
            if(secondNum.isEmpty())
            {
                digit2 = 0;
            }
            else
            {
                digit2 = secondNum.pop();
            }
            
            sum = digit1 + digit2 + carryOver;
            carryOver = 0;

            if(sum > 10)
            {
                sum -= 10; carryOver = 1;
            }
            
            sumNum.push(sum);
        }
    }
    
    public void print()
    {
        System.out.println("  " + num1);
        System.out.println("+ " + num2);
        System.out.print("= ");
        while(!sumNum.isEmpty())
        {
            System.out.print(sumNum.pop());
        }
        System.out.println("");
    }
}
