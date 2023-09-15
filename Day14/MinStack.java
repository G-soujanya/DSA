import java.util.*;
class minStack
{
    static Stack<Integer> stack=new Stack<>();
    static Stack<Integer> minStack=new Stack<>();
    public static void main(String args[])
    {
        push(10);
        push(5);
        push(30);
        push(3);
        pop();
        System.out.println(min());
    }
    static void push(int data)
    {
        stack.push(data);
        if(minStack.isEmpty())
            minStack.push(data);
        else if(data<(int)minStack.peek())
        {
            minStack.push(data);
        }
    }
    static int min()
    {
        if(stack.isEmpty())
                throw new IllegalStateException();
        return (int)minStack.peek();
    }
    static int pop(){
        if(stack.isEmpty())
            throw new IllegalStateException();
        int x=stack.peek();
        if(x==minStack.peek())
            minStack.pop();
        return x;
    }
}
