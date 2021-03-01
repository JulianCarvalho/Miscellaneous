
import java.util.*;
import java.io.*;

/** 
 * COMP 2503 Winter 2018 Assignment 1 
 * 
 * This program reads a text file and compiles a list of the 
 * words together with how many each word appears. 
 *
 * Words from a standard list of stop words are not included.
 */
//I used the completed Assignment you posted online and expanded from there
public class A2 
{

    private ArrayList<Word> words = new ArrayList<Word>();

    private SLL listAll = new SLL<Word>();
    private SLL mostTen = new SLL<Word>();
    private SLL leastTen = new SLL<Word>();

    private String[] stopwords = { "a", "about", "all", "am", "an", 
            "and", "any", "are", "as", "at", "be", "been", "but", "by", "can", 
            "cannot", "could", "did", "do", "does", "else", "for", "from", 
            "get", "got", "had", "has", "have", "he", "her", "hers", "him", 
            "his", "how", "i", "if", "in", "into", "is", "it", "its", "like", 
            "more", "me", "my", "no", "now", "not", "of", "on", "one", 
            "or", "our", "out", "said", "say", "says", "she", "so", "some",
            "than", "that", "the", "their", "them", "then", "there", "these", 
            "they", "this", "to", "too", "us", "upon", "was", "we", "were", 
            "what", "with", "when", "where", "which", "while", "who", 
            "whom", "why", 
            "will", "you", "your"};

    private int totalwordcount = 0;

    private int stopwordcount = 0;

    private Scanner inp = new Scanner( System.in);

    private File file = new File("inp2.txt");
    //private Scanner inFile = new Scanner(file); 

    public static void main( String[ ] args) throws IOException
    {	
        A2 a2 = new A2();
        a2.run();
    }

    /**
     * Check if the word given is in the stopword list.
     * @param w a word 
     * @return true if w is a stopword, false otherwise
     */
    private boolean stopword( String w) 
    {
        boolean found = false;
        int i = 0;
        while (i < stopwords.length && !found) 
        {
            if ( w.equals( stopwords[i])) 
            {
                found = true;
            }
            i++;
        }
        return found;
    }

    
    private void printResults() 
    {
        System.out.println("Total Words: " + totalwordcount);
        System.out.println("Unique Words: " + listAll.countList());
        System.out.println("Stop Words: " + stopwordcount);
        System.out.println();
        listAll.printFull();
    }
    
    
    /**  
    Read the input file and process it. 
    Input is on standard input and is read one 
    word at a time -- separated by whitespace. 

    All non alphabetic characters are stripped out and 
    words are all converted to lower case. 

    Any non-stopword word is stored in the list of words 
    and the number of occurances is tracked.
     */
    private void readFile() throws IOException
    {
        //File file = new File("inp2.txt");
        Scanner inFile = new Scanner(file);
        while (inFile.hasNext()) 
        {
            String word = inp.next().toLowerCase().trim().replaceAll( "[^a-z]","");

            if ( word.length() > 0) 
            { 
                totalwordcount++; 
                if (stopword( word)) 
                {
                    stopwordcount++;
                }
                else
                {
                    Word w = new Word( word);
                    w.incrCount();
                    //this spot needed to be edited to work with nodes and linked lists
                    if ( words.contains(w))
                    {
                        words.get(words.indexOf(w)).incrCount();
                    }
                    else 
                    { 
                        listAll.addAlpha(w);
                    }
                }
            }
        }
    }

    /** Run the program. Read the file, then print the results. 
     */
    public void run() throws IOException
    {
        readFile();
        printResults();
    }
}