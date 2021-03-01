import java.util.*;
public class Word implements Comparable<Word>, Comparator<Word> {
    private String word;
    private int frequency;

    public Word (String wrd, int frq)
    { 
        this.word = wrd; 
        this.frequency = frq;
    }

    public int compareTo(Word w0) {
        return this.word.compareTo(w0.getWord());
    }
    
    public int compare(Word w1, Word w2)
    {
        return w1.getWord().compareTo(w2.getWord());
    }

    public int getFrequency()
    {
        return frequency;
    }

    public String getWord()
    {
        return word;
    }
}
