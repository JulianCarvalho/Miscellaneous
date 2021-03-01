import java.util.*;
import java.io.*;
/**
 * COMP 2503 Winter 2018: Assignment 3 - Part 1 of 3
 * 
 * A3a read in a file and goes 
 * through thefile seeing if the 
 * Strings in it are palindromes
 *
 * Julian Carvalho
 * March 2, 2018
 */
public class A3a
{
    private Scanner inp = new Scanner( System.in);
    //I hard coded the file in so I could test it without 
    private File file = new File("words.txt");

    //global variables
    //I needed a variable for a word and boolean
    private String word;
    private boolean isPalindrome = true;
    //regStk holds the characters in regular order
    private Stack<Character> regStk = new Stack<Character>();
    //rexStk hold sht e characters in reverse order
    private Stack<Character> revStk = new Stack<Character>();
    //tempStck is used to temporarily hold a copy of the regular order
    // which then gets reversed into the revStk
    private Stack<Character> tempStk = new Stack<Character>();

    //public static void main
    public static void main(String Args []) throws IOException
    {
        //instantiating an A3a object
        A3a palindrome = new A3a();
        //calling run which calls other methods for this program to function
        palindrome.run();
    }

    public void run() throws IOException
    {
        //I used this for testing with a hard coded file
        //Scanner inFile = new Scanner(file); 

        while(inp.hasNext())
        {
            //sets the variable to a word from the file
            word = inp.next();
            //calls the method that loads the stacks
            loadStack(word);
            //compares the characters in the stacks
            chkPlndrm();
            //prints the result for the word
            print(word);
            //resets the boolean for the next loop iteration
            isPalindrome = true;

            //empties the stacks so it's ready for the next lopp iteration
            regStk.empty(); revStk.empty(); tempStk.empty();
        }
        //repeats for each word
    }

    //passes in a word and this method loads up 
    public void loadStack(String word)
    {
        //the first for loop loads ths stacks with characters from the word
        for(int count = 0; count < word.length(); count++)
        {
            regStk.push(word.charAt(count));
            tempStk.push(word.charAt(count));
        }
        //the second for loop reverses one of the other stacks so the word is backwards
        for(int count = 0; count < word.length(); count++)
        {
            revStk.push(tempStk.pop());
        }
    }

    public void chkPlndrm()
    {
        /*I'm comparing the front half of each word to it's back half
         * if the word is a palindrome then the two halfs should match
         * else the boolean is changed
         * the reason why I'm doing half is to reduce time complexity
         */
        for(int count = 0; count < word.length()/2; count++)
        {
            //two variables to hold the chars
            char temp1 = regStk.pop();
            char temp2 = revStk.pop();

            //if compares the 2 chars to each other
            if(temp1 != temp2)
            {
                //if they don't match the boolean is changed to false
                isPalindrome = false;
                //otherwise it remains true
            }
        } 
    }

    //this method prints the result of cheicking if it's a palindrome
    public void print(String word)
    {
        if(isPalindrome == false)
        //if the boolean is false it means the word is not a palindrome
        {System.out.println(word + ": No");}
        else
        //if the boolean is true it means the word is a palindrome
        {System.out.println(word + ": Yes");}
    }
}
