import java.util.*;
import java.io.*;
/**
 * Write a description of class A1 here.
 *
 * @author (Julian Carvalho)
 * @version (Version 1 01/23/2018)
 */
public class A1
{
    //ArrayList takes in words and word frequency
    public static ArrayList<Word> wordList = new ArrayList<Word>();

    //Scanner to take in files
    public static Scanner input = new Scanner(System.in);

    //Counter for Total Words
    public static int wordCount = 0;

    //Boolean for the Same Words
    public static boolean sameWord = false;

    //Boolean for Stop Words
    public static boolean stopWord = false;

    //Counter for Stop Words
    public static int stopCount = 0;

    public static void main(String Args[]) throws IOException
    {
        execute();
    }

    public static void execute()
    {
        while(input.hasNext())
        {
            /*toLowercase converts string to lower case
             *trim eliminates spaces before and after the string
             *replaceAll replaces the first parameter with the second parameter
             *  /d refers to digits and /W refers to non-word characters*/

            String word = input.next().toLowerCase().trim().replaceAll("/d","").replaceAll("/W","");
            wordCount++;

            String check = "";
            int increment = 0;
            
            //Confirms whether the word 
            stopCheck(word);

            if(stopWord == true)
            {
                stopCount++; 
                stopWord = false;
            }
            else 
            {
                checkList(word);
                if(sameWord = false)
                {
                    wordList.add(new Word(word, 1));
                }
                else
                {
                    for(int count = 0; count<(wordList.size()-1); count++)
                    {
                        check = wordList.get(count).getWord();
                        if(word.equals(check))
                        {
                            increment = wordList.get(count).getFrequency();
                            increment++;
                            wordList.set(count,(new Word(check, increment)));
                        }
                    }
                }
            }
        }
        
        //Calls Print method
        print();
    }

    //Method to check if the Word that is passed in is a Stop Word
    public static void stopCheck(String word)
    {
        String check = word;

        //Array for Stop Words
        String stopWordList[] = {"a", "about", "all" , "am", "an", "and", "any", "are", "as", 
                "at", "be","been", "but", "by", "can", "cannot", "could", "did", "do", "does", "else", 
                "for", "from", "get", "got", "had", "has", "have", "he", "her","hers", "him", "his", 
                "how", "i", "if", "in", "into", "is", "it", "its", "like" , "more", "me", "my", "no", 
                "now", "not","of", "on", "one", "or", "our", "out", "said", "say", "says", "she", "so", 
                "some", "than", "that", "the", "their","them", "then", "there", "these", "they", "this", 
                "to", "too", "us", "upon", "was", "we", "were", "what", "with", "when", "where", "which", 
                "while", "who", "whom", "why", "will", "you", "your"};

        //If the word is a Stop Word then the boolean changes which affects the Execute method
        for(int count = 0; count<stopWordList.length ; count++)
        {
            if(check.equals(stopWordList[count]))
            {
                stopWord = true;
            }
        }
    }

    //Method to check if a given word is already in the loop
    public static void checkList(String word)
    {
        String check = word;
        for(int count = 0; count<(wordList.size()-1); count++)
        {
            if(check.equals(wordList.get(count)))
            {
                sameWord = true;
            }
        }
    }

    //Print method that prints all of the required ouputs
    public static void print()
    {
        //Total Words output
        System.out.println("Total Words: "+ wordCount);
        
        //Unique Words output
        System.out.println("Unique Words: "+ (wordList.size()));
        
        //Stop Words output
        System.out.println("Stop Words: "+ stopCount);
        
        //10 Most Frequent Words output
        System.out.println("\n10 Most Frequent ");
        
        Collections.sort(wordList);
        for(int count = 0; count < 10; count++)
        {
            System.out.println(wordList.get(count).getWord() + " : " + wordList.get(count).getFrequency());
        }
        
        //10 Least Frequent Words output
        System.out.println("\n10 Least Frequent ");
        for(int count = 0; count < 10; count++)
        {
            System.out.println(wordList.get(count).getWord() + " : " + wordList.get(count).getFrequency());
        }
        
        //Alphabetical order output
        System.out.println("\nAll ");
        Collections.sort(wordList);
        for(int count = 0; count < wordList.size()-1; count++)
        {
            System.out.println(wordList.get(count).getWord() + " : " + wordList.get(count).getFrequency());
        }
    }
}

