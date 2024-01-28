import java.util.*;
public class Main2 {
    public static void main(String[] args)
    {
        int[] arr={160,80,60,60,60,75,85};
        spanOptimaized(arr);
    }
    public static void nearestSmallerElement(int[] arr)
    {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty())
                {
                    if(stack.peek()>arr[i])
                        stack.pop();
                    else
                        break;
                }
                if(!stack.isEmpty())
                    System.out.print(stack.peek() + " ");
                else
                    System.out.print(-1+" ");
            stack.push(arr[i]);
        }
    }
    public static void span(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            int count=0;
            for (int j = i; j>=0; j--) {
                if(arr[j]<=arr[i])
                    count++;
                else
                    break;
            }
            System.out.print(count+" ");
        }
        System.out.println();
    }
    public static void spanOptimaized(int[] arr)
    {
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()]<=arr[i])
                stack.pop();
            if(!stack.isEmpty())
                System.out.print(i-stack.peek()+" ");
            else
                System.out.print(i+1+" ");
            stack.push(i);
        }
    }
}
