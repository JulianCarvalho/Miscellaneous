
/**
* <Generates a registration number and an expiration date for a new driver in Westeros>
* @<Julian Carvalho>
* @version 1.0
* Last Modified: <October 24, 2015> - <Compiling> <Julian Carvalho>
*/
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class WesterosRegistration
{
    public static void main(String Args[])
    {
        String regNum;
        GetRegNum getReg = new GetRegNum();
        GetExpiryYear getExp = new GetExpiryYear();
        GregorianCalendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat ("MMM YYYY");
        
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        calendar.add(Calendar.YEAR, 1);
        
        String firstName, lastName, licPlate;
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("Enter Your First Name: ");
        firstName = keyboard.next();
        
        System.out.print("Enter Your Last Name: ");
        lastName = keyboard.next();
        
        System.out.print("Enter your License Plate Number ex: abc-123 : ");
        licPlate = keyboard.next();
        
        licPlate = licPlate.substring(0).toUpperCase();
        
        char w = licPlate.charAt(1);
        char x = licPlate.charAt(4);
        char y = licPlate.charAt(5);
        char z = licPlate.charAt(6);
        String lastDigs = "" + x + y + z;
        int xyz =Integer.parseInt(lastDigs);
        
        
        regNum = getReg.getRegNum(w, xyz);
        
        System.out.println("");
        System.out.println("");
        System.out.println("Registration Number: " + regNum);
        System.out.println("License Plate Number: " + licPlate);
        System.out.println("Owner: " + lastName + ", " + firstName);
        System.out.println("Renewal Date: " + sdf.format(calendar.getTime()));
        
    }
}