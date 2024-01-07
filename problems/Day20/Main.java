// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        findCombinations("1?11?00?1?",0);
    }
    public static void findCombinations(String s,int index)
    {
        if(s==null || s.isEmpty())
            return;
        if(index==s.length())
        {
            System.out.println(s);
            return;
        }
        if(s.charAt(index)=='?')
        {
            findCombinations(s.substring(0,index)+0+s.substring(index+1),index+1);
            findCombinations(s.substring(0,index)+1+s.substring(index+1),index+1);
        }
        else
            findCombinations(s,index+1);
    }


}