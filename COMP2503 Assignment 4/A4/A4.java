import java.io.*;
import java.util.*;
import java.lang.*;
public class A4 <T>
{
    private Scanner inp = new Scanner( System.in);

    // this was used for testing
    private File file = new File("words.txt");

    private String[] stopwords = { 
            "a", "about",  "all", "am", "an", "and",  "any", "are", "as", "at", 
            "be", "been", "but", "by", "can", "cannot", "could", "did", "do", 
            "does", "else", "for", "from", "get", "got", "had", "has", "have", 
            "he", "her", "hers", "him", "his", "how", "i", "if", "in", "into", 
            "is", "it", "its", "like", "more", "me", "my", "no", "now", "not", 
            "of", "on", "one", "or", "our", "out", "said", "say", "says", "she", 
            "so", "some","than", "that", "thats", "the", "their", "them", "then", 
            "there", "these", "they", "this", "to", "too", "us", "upon", "was", 
            "we", "were", "what", "with", "when", "where", "which", "while", "who", 
            "whom", "why", "will", "you", "your", "up", "down", "left", "right","man", 
            "woman", "would", "should", "dont", "after", "before", "im", "men"};

    public static void main() throws IOException
    {
        A4 a4 = new A4();
        a4.run();
    }

    private void run() throws IOException
    {
        // this was used for testing
        Scanner inFile = new Scanner(file); 
        
        BST<String> abcBST = new BST<String>(); 
        while(inp.hasNext())
        {
            String word = inp.next().toLowerCase().trim().replaceAll( "[^a-z]","");
            abcBST.add(word);
        }

        BST<String> stopBST = new BST<String>(); 
        for(int count = 0; count < stopwords.length; count++)
        {
            String stopWord = stopwords[count];
            stopBST.add(stopWord);
        }

        abcBST.deleteStops(stopBST);

        BST<String> freqBST = new BST<String>(); 
        freqBST.loadBST(abcBST, 0);

        BST<String> lenBST = new BST<String>();
        lenBST.loadBST(abcBST, 1);

        /*
        System.out.println( "\nInorder\n========");
        bst.inOrder();
        System.out.println( "\npreorder\n========");
        bst.preOrder();
        System.out.println( "\nPostorder\n========");
        bst.postOrder();
        System.out.println( "\nLevelorder\n========");
        bst.levelOrder();
        System.out.println( "The tree has " + bst.size() 
        + " nodes and height " + bst.height()); 
         */

        printSpacing();
        
        System.out.println("Total Words: " + abcBST.totalWord());
        System.out.println("Stop Words: " + abcBST.stopWord());
        System.out.println("Unique Words: " + abcBST.size());

        printSpacing();
        
        System.out.println("20 Most Frequent");
        freqBST.inOrderPrint();
        
        printSpacing();
        
        System.out.println("20 Least Frequent");
        freqBST.inOrderReverse();
        
        printSpacing();
        
        System.out.println("The longest word is " + lenBST.maxLen());
        System.out.println("The average word length is " + lenBST.avgLen());
        
        printSpacing();
        
        System.out.println("All Words");
        abcBST.inOrderPrint();
        
        printSpacing();
        
        System.out.println("Alphabetic Tree:  ( Optimum Height: " + abcBST.optimalHeight() + ") ( Actual Height: " + abcBST.height() + ")");
        System.out.println("Frequency Tree: ( Optimum Height: " + freqBST.optimalHeight() + ") ( Actual Height: " + freqBST.height() + ")");
        System.out.println("Length Tree: ( Optimum Height: " + lenBST.optimalHeight() + ") ( Actual Height: " + lenBST.height() + ")");
        
        printSpacing();
    }
    // i didnt want to print copy paste these lines over and over again
    private void printSpacing()
    {
        System.out.println();
        System.out.println("------");
        System.out.println();
    }
}
