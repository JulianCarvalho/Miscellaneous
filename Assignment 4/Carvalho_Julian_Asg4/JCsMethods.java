/**
 * <Driver Main with Loops That Calls Upon Other Methods>
 * @Author <Julian Carvalho>
 * @Version 1.0
 * Last Modified: <November 20, 2015> <Julian Carvalho>
 */
import java.text.*;
import java.io.*;
import java.util.*;
public class JCsMethods
//mtheods for days
{
   //The X-files -> thats a bad joke, don't even bother... :(
   public String horizontalDirect (double x, String horizontal)
   {
        if (x > 0)
            {
                horizontal = "East";
            }
        else
            {
                horizontal = "West";
            }
        
        return horizontal;
   }
   //The Y
   public String verticalDirect (double y, String vertical)
   {
        if (y > 0)
            {
                vertical = "North";
            }
        else
            {
                vertical = "South";
            }
        
        return vertical;
   }
   //Printing Stuff
   public void printStmt1(double x, double y, String vertical, String horizontal, int counter, double crowDistance, double totalDistance)
   {
       DecimalFormat decAlpha = new DecimalFormat("##.##");
       DecimalFormat decOmega = new DecimalFormat("##.#");
       
       String call1 = horizontalDirect (x, horizontal);
       String call2 = verticalDirect (y, vertical);
       System.out.println("Final location: " + decOmega.format(y) + " km " + call1 + " and " + decOmega.format(x) + " km " + call2 + " from origin");
        
       System.out.println("Number of moves: " + counter);
       System.out.println("Distance covered as the crow flies: " + decAlpha.format(crowDistance) +" kilometers");
       System.out.println("Total distance: " + totalDistance + " kilometers");
       System.out.println(" ");
       System.out.println("-");
       System.out.println(" ");
   }
   //Printing Stuff 2 Electric Boogaloo
   public void printStmt2(String farTeam, double biggest, int moveMost)
   {
       System.out.println("Team " + farTeam + " covered the most distance.");
       System.out.println("Total distance: " + biggest + " kilometers");
       System.out.println("Total number of moves: " + moveMost );
       System.out.println(" ");
   }
}
