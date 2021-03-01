import java.util.*;
/**
 ** Hashtable class
 *  This is the Hashtable class; this class is supposed to recieve an ArrayList of Strings, 
 *   count the stop words, create Word objects from the ArrayList, 
 *   load them into the hashtable, when there is a collision it loads it into a tree map,
 *   deletes the stop words from the hashtable, and prints out all the required information.
 */
public class Hashtable <T extends Comparable<Word>> 
{
    private int[] hashtable;
    private int size, totalWords, stopWords, uniqueWords;
    private ArrayList alist;
    private String[] stopList = { 
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

    public Hashtable(ArrayList l, int c)
    {
        alist = l;
        totalWords = c;
        stopWords = 0;
        uniqueWords = 0;
        
        hashtable = new int[c];
        
        loadHashTable();
    }

    private void loadHashTable()
    {
        String temp;
        for(int count1 = 0; count1 < alist.size(); count1++)
        {
            temp = alist(count1) ;
            for(int count2 = 0; count2 < stopList.length; count2++)
            {
                if(temp == stopList[count2])
                {
                    stopWords++;
                }
            }
            Word word = new Word(temp);
            int i = Math.abs(s.hashCode()) % size;
        }
    }
}
