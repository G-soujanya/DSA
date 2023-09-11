import java.util.*;
public class Solution {
    public static List< Integer > sortedArray(int []a, int []b) {
        Set<Integer> set=new HashSet<>();
        int count=0;
        for(int i=0;i<a.length;i++)
        {
            set.add(a[i]);
            count++;
        }
        for(int i=0;i<b.length;i++)
        {
            set.add(b[i]);
            count++;
        }
        ArrayList<Integer> list=new ArrayList<>();
        Iterator value=set.iterator();
        while(value.hasNext())
        {
            list.add((int)value.next());
        }
        return list;
    }
}
