import java.util.ArrayList;

public class Solution {
        public static int[] moveZeros(int n, int []a) {
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(a[i]!=0)
            {
            list.add(a[i]);
            count++;
            }
        }
        for(int i=0;i<count;i++)
        {
            a[i]=list.get(i);
        }
        for(int i=count;i<n;i++)
        {
            a[i]=0;
        }
        return a;
    }
}
