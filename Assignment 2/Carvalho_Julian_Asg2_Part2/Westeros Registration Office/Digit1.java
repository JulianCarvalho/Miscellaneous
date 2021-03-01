import java.util.*;
import java.util.Random;
public class Digit1
{
   public int digit1Get()
   {
       int digit1;
       
       Random generator = new Random();
       
       digit1 = generator.nextInt(8) + 2;
       
       return digit1;
   }
}
