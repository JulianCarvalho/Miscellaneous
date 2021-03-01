import java.util.Scanner;

public class CostAndTax
{
   public static void main(String Args[])
   {
       double amtPaid, amtChange, taxRate, totalCost, ogCost, taxPaid;
       
       Scanner keyboard = new Scanner (System.in);
       
       // Use 25 for an example answer without a trail of decimals
       System.out.print("Enter the amount that you paid: ");
       amtPaid = keyboard.nextDouble();
       
       // Use 4 for an example answer without a trail of decimals
       System.out.print("Enter the amount you received back: ");
       amtChange = keyboard.nextDouble();
       
       // Use 5 for an axample answer without a trail of decimals
       System.out.print("Enter the tax percentage set up by your government): ");
       taxRate = keyboard.nextDouble();
       
       totalCost = amtPaid - amtChange;
       ogCost = totalCost / (taxRate / 100 + 1);
       taxPaid = totalCost - ogCost;
       
       System.out.print("The original price of the purchase is: ");
       System.out.println(ogCost);
       
       System.out.print("The tax you paid when making the purchase is: ");
       System.out.println(taxPaid);
       
       System.out.print("The total amount you paid during this purchase is: ");
       System.out.println(totalCost);
   
    }
}
