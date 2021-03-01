import java.util.*;
/**
 ** Word class
 *  This is the Word class; it is used to create word objects for the hashtable by being
 *   passed Strings. This class also deals with frequency and length because these are 
 *   required for the output of the program.
 */
public class Word implements Comparable<Word> {
    private String word; 
    private int frequency; 
    private int length;
    private Word next;
    
    public Word(String w) 
    {
        this.word = w;
        this.frequency = 0;
        this.length = word.length();
        this.next = null;
    }

    public static Comparator<Word> CompFreqDesc = new Comparator<Word>() 
        {
            public int compare( Word w1, Word w2) 
            {
                int f1 = w1.getFrequency(); 
                int f2 = w2.getFrequency();
                if (f2-f1 == 0) 
                    return w1.compareTo( w2);
                else
                    return f2 - f1; 
            }
        }
    ;

    public static Comparator<Word> CompFreqAsc = new Comparator<Word>() 
        {
            public int compare( Word w1, Word w2) 
            {
                int f1 = w1.getFrequency(); 
                int f2 = w2.getFrequency();
                if (f1 - f2 == 0) 
                    return w1.compareTo( w2);
                else
                    return f1 - f2; 
            }
        }
    ;

    public String getWord() 
    { 
        return word;
    }

    public int getFrequency() 
    { 
        return frequency;
    }

    public int getLength()
    {
        return length;
    }
    
    public Word getNext()
    {
        return next;
    }
    
    public void setNext(Word w)
    {
        next = w;
    }

    public void incrFrequency() 
    { 
        frequency++; 
    }

    public String toString() 
    { 
        return getWord() + " : " + getFrequency();
    }

    public boolean equals( Object other) 
    {
        if ( other == this) return true;
        if ( other == null) return false;
        if ( this.getClass() != other.getClass()) return false;
        Word p = (Word)other;
        return this.getWord().equals( p.getWord());
    }

    public int compareTo( Word o) 
    {
        if ( this.equals( o))
            return 0;
        else
            return this.getWord().compareTo( o.getWord()); 
    }
}