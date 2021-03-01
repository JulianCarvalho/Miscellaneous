import java.util.*;
public class Digit12
{
  public int digit12Get(int digit3, int digit6, int digit8)  
  {
     int digit12;
     
     digit12 = (digit3 + digit6 + digit8) % 10;
     
     return digit12;
  }
}
