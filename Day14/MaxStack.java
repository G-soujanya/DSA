// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class MaxStack
    static Stack<Integer> stack=new Stack<>();
    static Stack<Integer> maxStack=new Stack<>();
    public static void main(String[] args)
    {
        push(10);
        push(20);
        push(15);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(max());
    }
    static void push(int data)
    {
        stack.push(data);
        if(maxStack.isEmpty())
                maxStack.push(data);
        else if(data>maxStack.peek())
        {
            maxStack.push(data);
        }
    }
    static int max()
    {
        if(stack.isEmpty())
            throw new IllegalStateException();
        return maxStack.peek();
    }
    static int pop()
    {
        if(stack.isEmpty())
            throw new IllegalStateException();
        int x= stack.pop();
        if(x==maxStack.peek())
            maxStack.pop();
        return x;
    }

}