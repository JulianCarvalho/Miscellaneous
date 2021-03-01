import java.util.*;
import java.util.GregorianCalendar;
public class GetExpiryYear
{
   public int getExpiryYear()
    {
        GregorianCalendar calendar = new GregorianCalendar();
        
        int year = calendar.get(calendar.YEAR);
        
        calendar.add(calendar.YEAR, 1);
        
        return year;
    }
}
