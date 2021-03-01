/**
* <Driver Method: calls on other methods, takes input from player, finds output via methods>
* @author <Julian Carvalho>
* @version 2.0 (Version 1.0 was scrapped as it had a semantic problem that could not be determined as of November 11th 2015)
* Last Modified: <November 11, 2015> <Julian Carvalho>
*/
import java.util.*;
import java.lang.*;
public class TheGame
{
    public static void main(String Args[])
    {
        String userSelect, compSelect, gameResult;
        int compRNG;
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Welcome Human Player to: Rock, Paper Scissors Lizard, Spock!!!");
        System.out.println(" ");
        
        System.out.print("Choose one of the following R / P / S / L / SP: ");
        userSelect = keyboard.nextLine();
        
        TheMethods mthdObj = new TheMethods();
        compRNG = mthdObj.RNG(1,5);
        compSelect = mthdObj.compSelector(compRNG);
        
        System.out.println(" ");
        if (userSelect.equalsIgnoreCase("R"))
        {
            System.out.println("You chose: Rock");
            System.out.println("Computer chose: " + compSelect);
            gameResult  = mthdObj.pickedR(compSelect);
        }
        else
        {
            if (userSelect.equalsIgnoreCase("P"))
            {
                System.out.println("You chose: Paper");
                System.out.println("Computer chose: " + compSelect);
                gameResult  = mthdObj.pickedP(compSelect);
            }
            else
            {
                if (userSelect.equalsIgnoreCase("S"))
                {
                    System.out.println("You chose: Scissors");
                    System.out.println("Computer chose: " + compSelect);
                    gameResult  = mthdObj.pickedS(compSelect);
                }
                else
                {
                    if (userSelect.equalsIgnoreCase("L"))
                    {
                        System.out.println("You chose: Lizard");
                        System.out.println("Computer chose: " + compSelect);
                        gameResult  = mthdObj.pickedL(compSelect);
                    }
                    else
                    {
                       if (userSelect.equalsIgnoreCase("S"))
                       {
                           System.out.println("You chose: Spock");
                           System.out.println("Computer chose: " + compSelect);
                           gameResult  = mthdObj.pickedSP(compSelect);
                       }
                       else
                       {
                           System.out.println("You entered an invalid choice.");
                           System.out.println("You will soon be booted from the program."); 
                           System.out.println("feel free to try again later with a correct choice.");
                           System.exit(0);
                           gameResult = "NO GAME PLAYED";
                       }
                    }
                }
            }
        }
        System.out.println(" ");
        System.out.println(gameResult);
        System.out.println("GGWP");
    }
} 
