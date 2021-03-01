import java.util.*;
import java.io.*;
/** DOES NOT WORK, DID NOT FINISH
 ** A5 class
 *  This is the main; it will read in the file, create an ArrayList of Strings,and
 *   pass the ArrayList to the hashtable method which will populate the hashtable
 *   and do all of the processing such as counting the total/stop/unique words,
 *   stop words, and printing.
 */
public class A5
{
    private Scanner inp = new Scanner( System.in);
    private ArrayList wordList = new ArrayList();
    private File file = new File("inp1.txt");
    
    public static void main(String Args[]) throws IOException
    {
        A5 asg = new A5(); 
        asg.run();
    }
    
    private void run() throws IOException
    { 
        Scanner inFile = new Scanner(file); 
        String word;
        int count = 0;
        while(inFile.hasNext())
        {
            word = inFile.next().toLowerCase().trim().replaceAll( "[^a-z]","");
            wordList.add(word);
            count++;
        }
        
        Hashtable hash = new Hashtable(wordList, count);
    }
}
