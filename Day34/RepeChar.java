import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class FIrstNonRepChar 
{
    public static void main(String args[])
    {
        System.out.println(firstNonRepChar("hello world"));
        System.out.println(firstNonRepCharB("hello world"));
        System.out.println(firstRepCharB("hello world"));
        System.out.println(firstRepChar("hello world"));
    }    
    static char firstNonRepChar(String s)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for(var x:s.toCharArray())
        {
            int count;
            count=(map.containsKey(x)) ? map.get(x):0;
            map.put(x, count+1);
        }
        for(var x:s.toCharArray())
        {
            if(map.get(x)==1)
                return x;
        }
        return ' ';
    }
    static char firstNonRepCharB(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(j)==s.charAt(i))
                    break;
            }
            return s.charAt(i);
        }
        return ' ';

    }
    static char firstRepCharB(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<s.length();j++)
            {
                if(s.charAt(j)==s.charAt(i))
                    return s.charAt(i);
            }
        }
        return ' ';
    }
    static char firstRepChar(String s)
    {
        Set<Character> set=new HashSet<>();
        for(var x:s.toCharArray())
        {
            if(set.contains(x))
                return x;
            set.add(x);
        }
        return ' ';
    }
}
