// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java .util.*;
public class Main {
    public static void main(String[] args) {
    QueueUSingStacks q=new QueueUSingStacks();
    q.enQueue(10);
    q.enQueue(20);
    q.enQueue(30);
    /*System.out.println(q.deQueue());
    q.enQueue(40);
    System.out.println(q.deQueue());
    q.enQueue(50);
    System.out.println(q.size());
    q.display();*/
        System.out.println(q.peek());
    }
}
class QueueUSingStacks
{
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();
    int count=0;
    public void enQueue(int value)
    {
        stack1.add(value);
        count++;
    }
    public int deQueue()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
                stack2.add(stack1.pop());
        }
        count--;
        return stack2.pop();
    }
    public int peek()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }
        if(stack2.isEmpty())
        {
            while(!stack1.isEmpty())
                stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public void display()
    {
        Stack<Integer> stack3=(Stack<Integer>) stack1.clone();
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> stack4=(Stack<Integer>) stack2.clone();
        while (!stack4.isEmpty())
            list.add(stack4.pop());
        while (!stack3.isEmpty())
            stack4.push(stack3.pop());
        while (!stack4.isEmpty())
            list.add(stack4.pop());
        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
    public int size()
    {
       return count;
    }
}
