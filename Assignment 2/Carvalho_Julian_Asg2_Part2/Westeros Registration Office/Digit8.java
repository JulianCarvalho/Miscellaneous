import java.util.*;
import java.util.GregorianCalendar;
public class Digit8
{
    public int digit8()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        GetExpiryYear ExpYr = new GetExpiryYear();
        
        int year = ExpYr.getExpiryYear() + 1;
        int firstyrdig = (year % 100)/10;
        int secondyrdig = (year % 10);
        int sum = (firstyrdig + secondyrdig) % 10;
        
        return sum;
    }
}
