
import java.util.*;

public class TheMethods
{
   public int RNG(int lowerBound, int upperBound)
   //generates random number between 1 and 5
   {
       int compRNG;
       Random gen = new Random();
       compRNG = gen.nextInt(upperBound - lowerBound + 1);
       return compRNG;
   }
   
   public String compSelector(int compNum)
   {
       String compSelect = "";
       if (compNum == 1)
       {
           compSelect = "Rock";
       }
       else
       {
           if (compNum == 2)
           {
               compSelect = "Paper";
           }
           else
           {
               if (compNum == 3)
               {
                   compSelect = "Scissors";
               }
               else
               {
                   if (compNum == 4)
                   {
                       compSelect = "Lizard";
                   }
                   else
                   {
                       compSelect = "Spock";
                   }
               }
           }
       }
       return compSelect;
    }
   
    public String pickedR (String compSelect)
   {
       String badObjName = "";
       if (compSelect == "Rock")
       {
           badObjName = "Rock is neutral with Rock. IT'S A TIE!";
       }
       else
       {
           if (compSelect == "Paper")
           {
               badObjName = "Paper covers Rock; YOU LOSE!";
           }
           else
           {
               if (compSelect == "Scissors")
               {
                   badObjName = "Rock crushes Scissors; YOU WIN!";
               }
               else
               {
                   if (compSelect == "Lizard")
                   {
                       badObjName = "Rock crushes Lizard; YOU WIN!";
                   }
                   else
                   {
                       badObjName = "Spock vaporizes Rock; YOU LOSE!";
                   }
               }
           }
       }
       return badObjName;
   }
   
   public String pickedP (String compSelect)
   {
       String badObjName = "";
       if (compSelect == "Rock")
       {
           badObjName = "Paper covers Rock; YOU WIN!";
       }
       else
       {
           if (compSelect == "Paper")
           {
               badObjName = "Paper is neutral with Paper; IT`S A TIE!";
           }
           else
           {
               if (compSelect == "Scissors")
               {
                   badObjName = "Scissors cuts Paper; YOU LOSE!";
               }
               else
               {
                   if (compSelect == "Lizard")
                   {
                       badObjName = "Lizard eats Paper; YOU LOSE!";
                   }
                   else
                   {
                       badObjName = "Paper disproves Spock; YOU WIN!";
                   }
               }
           }
       }
       return badObjName;
   }
   
   public String pickedS (String compSelect)
   {
       String badObjName = "";
       if (compSelect == "Rock")
       {
           badObjName = "Rock crushes Scissors; YOU LOSE!";
       }
       else
       {
           if (compSelect == "Paper")
           {
               badObjName = "Scissors cuts Paper; YOU WIN!";
           }
           else
           {
               if (compSelect == "Scissors")
               {
                   badObjName = "Scissors are neutral with Scissors; IT'S A TIE!";
               }
               else
               {
                   if (compSelect == "Lizard")
                   {
                       badObjName = "Scissors decapitates Lizard; YOU WIN!";
                   }
                   else
                   {
                       badObjName = "Spock smashes Scissors; YOU LOSE!";
                   }
               }
           }
       }
       return badObjName;
   }
   
   public String pickedL (String compSelect)
   {
       String badObjName = "";
       if (compSelect == "Rock")
       {
           badObjName = "Rock crushes Lizard; YOU LOSE!";
       }
       else
       {
           if (compSelect == "Paper")
           {
               badObjName = "Lizard eats Paper; YOU WIN!";
           }
           else
           {
               if (compSelect == "Scissors")
               {
                   badObjName = "Scissors decapitates Lizard; YOU LOSE!";
               }
               else
               {
                   if (compSelect == "Lizard")
                   {
                       badObjName = "Lizard is neutral with Lizard; IT'S A TIE!";
                   }
                   else
                   {
                       badObjName = "Lizard poisons Spock; YOU WIN!";
                   }
               }
           }
       }
       return badObjName;
   }
   
   public String pickedSP (String compSelect)
   {
       String badObjName = "";
       if (compSelect == "Rock")
       {
           badObjName = "Spock vaporizes Rock; YOU WIN!";
       }
       else
       {
           if (compSelect == "Paper")
           {
               badObjName = "PPaper disproves Spock; YOU LOSE!";
           }
           else
           {
               if (compSelect == "Scissors")
               {
                   badObjName = "Spock smashes Scissors; YOU WIN!";
               }
               else
               {
                   if (compSelect == "Lizard")
                   {
                       badObjName = "Lizard poisons Spock; YOU LOSE!";
                   }
                   else
                   {
                       badObjName = "Spock is neutral with Spock; IT'S A TIE!";
                   }
               }
           }
       }
       return badObjName;
   }
}
