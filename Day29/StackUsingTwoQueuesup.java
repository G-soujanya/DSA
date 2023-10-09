import java.util.*;
public class Main {
    public static void main(String[] args) {
        StackUsingTwoQueues stack=new StackUsingTwoQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
public class StackUsingTwoQueues
{
    Queue<Integer> queue1=new ArrayDeque<>();
    Queue<Integer> queue2=new ArrayDeque<>();
    int count=0;
	int top=0;
    public void push(int value)
    {
        queue1.add(value);
        count++;
    }
    public int pop()
    {
        if(isEmpty())
                throw new IllegalStateException();
        while (queue1.size()>1)
        {
            top=queue1.remove();
            queue2.add(top);
        }
        int x=queue1.remove();
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
        count--;
        return x;
    }
    public int peek()
    {
        if(isEmpty())
            throw new IllegalStateException();
        return top;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public int size()
    {
        return count;
    }
    
}

