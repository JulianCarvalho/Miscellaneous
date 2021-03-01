import java.util.*;
import java.io.*;
public class BugattiMain

{
    public static void main(String Args[])throws IOException
    {
        String fileName = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Populace Managment Program");
        PopulaceSystem popSys = new PopulaceSystem();
        
        boolean invalid = true;
        while (invalid)
        {
            System.out.print("Enter input data file name: ");
            fileName = scan.next();
            File myFile = new File (fileName);

            if (fileName.isEmpty())
                invalid = true;          
            //invalid = true/false
            else 
            {
                if (!myFile.exists())
                {
                    invalid = true;
                }
                else 
                {
                    invalid=false; 
                }
            }
        }
        FileInputStream file = new FileInputStream(fileName);
        Scanner fileInput = new Scanner(file);
        
        popSys.popLoader(fileName);
        popSys.menu();
        popSys.showList();
    }
}
