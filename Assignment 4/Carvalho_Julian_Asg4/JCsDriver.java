/**
 * <Driver Main with Loops That Calls Upon Other Methods>
 * @Author <Julian Carvalho>
 * @Version 1.0
 * Last Modified: <November 20, 2015> <Julian Carvalho>
 */
import java.text.*;
import java.util.*;
import java.io.*;
public class JCsDriver
{
    public static void main(String Args[])throws FileNotFoundException
    {
        Scanner kybd = new Scanner(System.in);
        
        //declaring most of the variables
        int counter = 0;
        int moveMost = 0;
        double x = 0;
        double y = 0;
        double totalDistance = 0;
        double crowDistance = 0;
        double distance = 0;
        double biggest = 0;
        String teamName;
        String direction;
        String farTeam = "";
        
        DecimalFormat decAlpha = new DecimalFormat("##.##");
        DecimalFormat decOmega = new DecimalFormat("##.#");
        
        JCsMethods mthObj = new JCsMethods();
        System.out.print("Enter the name of the file:  ");
        String fileName = kybd.next();
        
        System.out.println(" ");
        boolean continueX = true;
        //loops for days
        while (continueX == true)
        {
            FileInputStream file = new FileInputStream(fileName);
            Scanner fileInput = new Scanner(file);
            
            boolean hasData = fileInput.hasNext();
            while (hasData)
            {
                teamName = fileInput.next();
                direction = fileInput.next();
                
                System.out.println("Team " + teamName);
                counter = 0;
                distance = 0;
                totalDistance = 0;
                crowDistance = 0;
                x = 0;
                y = 0;
                
                String horizontal = "";
                String vertical = "";
                
                while (!direction.equals("XX"))
                {
                    double distanceNew = 0;
                    crowDistance = 0;
                    counter++;
                    distance = fileInput.nextDouble();
                    totalDistance += distance;
                    
                    //if's and else's for days
                    if (direction.equals("N"))
                    {
                        y = y + distance;
                    }
                    else
                    {
                        if (direction.equals("S"))
                        {
                             y = Math.abs(y - distance);
                        }
                        else
                        {
                            if (direction.equals("E"))
                            {
                                x = x + distance;
                            }
                            else
                            {
                                if (direction.equals("W"))
                                {
                                    x = Math.abs(x - distance);
                                }
                                else
                                {
                                    if (direction.equals("NW"))
                                    {
                                        distanceNew = distance / Math.sqrt(2);
                                        x = Math.abs(x + distanceNew);
                                        y = y + distanceNew;
                                    }
                                    else
                                    {
                                        if (direction.equals("NE"))
                                        {
                                            distanceNew = distance / Math.sqrt(2);
                                            x = x + distanceNew;
                                            y = y + distanceNew;
                                        }
                                        else
                                        {
                                            if (direction.equals("SW"))
                                            {
                                                distanceNew = distance/Math.sqrt(2);
                                                x = Math.abs(x + distanceNew);
                                                y = Math.abs(y + distanceNew);
                                            }
                                            else
                                            {
                                                 distanceNew = distance/Math.sqrt(2);
                                                 x = x + distanceNew;
                                                 y = Math.abs(y + distanceNew);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    crowDistance = Math.sqrt((x * x) + (y * y));    
                    direction = fileInput.next();
                }
                if (totalDistance > biggest)
                {
                    biggest = totalDistance;
                    farTeam = teamName;
                }
                mthObj.horizontalDirect(x, horizontal);
                mthObj.verticalDirect(y, vertical);
                mthObj.printStmt1(x, y, horizontal, vertical, counter, crowDistance, totalDistance);
                
                hasData = fileInput.hasNext();
            }
            mthObj.printStmt2(farTeam, biggest, moveMost);
            System.out.print("Do you have another file you want to use? (Yes/No): ");                
            String userInput = kybd.next();
            if (userInput.equalsIgnoreCase("Yes"))
            {
                System.out.print("Enter the name of the file: ");
                fileName = kybd.next();
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            }
            else
            {
                continueX = false;
            }
        }
        System.out.println("GG");
        System.out.println(" ");
    }
}