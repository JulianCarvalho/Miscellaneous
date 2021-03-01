import java.util.*;
import java.util.Random;
public class Digit2
{
   public int digit2Get()
   {
       int digit2;
       
       Random generator = new Random();
       
       digit2 = generator.nextInt(10);
       
       return digit2;
   }
}
