// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your co
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int []a={1,2,3,7,6,5};
        span(a);
        spanOptimaized(a);
    }
    static void span(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int span=1;
            for(int j=i-1;j>-1;j--)
            {
                if(arr[i]<arr[j])
                        break;
                span++;
            }
            System.out.println(arr[i]+" "+span);
        }
    }
    static void spanOptimaized(int []arr)
    {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!stack.isEmpty() && arr[stack.peek()]<arr[i])
                    stack.pop();
            if(stack.isEmpty())
                System.out.print(i+1+" ");
            else
                System.out.print(i-stack.peek()+" ");
            stack.push(i);
        }
    }
}
