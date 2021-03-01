import java.util.*;
public class GetRegNum
{
   public String getRegNum(char w, int xyz)
   {
       String regNum;
       int digit1, digit2, digit3, digit4, digit5, digit6, digit7, digit8, digit9, digit10, digit11, digit12;
       
       Digit1 D1 = new Digit1();
       Digit2 D2 = new Digit2();
       Digit3 D3 = new Digit3();
       Digit4_5_6_7 D4567 = new Digit4_5_6_7();
       Digit8 D8 = new Digit8();
       Digit9_10_11 D91011 = new Digit9_10_11();
       Digit12 D12 = new Digit12();
       
       digit1 = D1.digit1Get();
       digit2 = D2.digit2Get();
       digit3 = D3.digit3Get(w, xyz);
       digit4 = D4567.digit4_5_6_7Get();
       digit5 = D4567.digit4_5_6_7Get();
       digit6 = D4567.digit4_5_6_7Get();
       digit7 = D4567.digit4_5_6_7Get();
       digit8 = D8.digit8();
       digit9 = D91011.digit9_10_11Get();
       digit10 = D91011.digit9_10_11Get();
       digit11 = D91011.digit9_10_11Get();
       digit12 = D12.digit12Get(digit3, digit6, digit8);
       
       regNum = "" + digit1 + digit2 + digit3 + digit4 + digit5 + digit6+ digit7 + digit8 + digit9 + digit10 + digit11 + digit12;
       
       return regNum;
       
   }
}
