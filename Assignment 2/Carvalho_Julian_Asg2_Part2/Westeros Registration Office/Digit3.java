
import java.util.*;
public class Digit3
{
    public int digit3Get(char w, int xyz)
    {
      int letterValue = (int)(w)-64;
      
      int digit3 = ((letterValue + xyz)%100)/10;
 
      return digit3;
    }
}

