import java.util.Scanner;

public class dimesnsionsRect
{
    public static void main(String Args[])
    {
        double bigX, bigY, smallX, smallY, length, width, perimeter, area;
        
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("Enter the higher x-value: ");
        bigX = keyboard.nextDouble();
        
        System.out.print("Enter the lower x-value: ");
        smallX = keyboard.nextDouble();
        
        System.out.print("Enter the higher y-value: ");
        bigY = keyboard.nextDouble();
        
        System.out.print("Enter the lower y-value: ");
        smallY = keyboard.nextDouble();
        
        
        length = bigX - smallX;
        width = bigY - smallY;
        perimeter = 2 * (length + width);
        area = length * width;
        
        
        System.out.print("The length of the rectangle is: " );
        System.out.println(length);
        
        System.out.print("The width of the rectangle is: ");
        System.out.println(width);
        
        System.out.print("The perimeter of the rectangle is: ");
        System.out.println(perimeter);
        
        System.out.print("The area of the rectangle is: ");
        System.out.println(area);
    }
}