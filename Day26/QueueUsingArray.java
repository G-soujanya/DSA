import java.util.Arrays;

class QueueUsingArray 
{
    public static void main(String args[])
    {
        ArrayQueue queue=new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.dequeue();
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.size());
        System.out.println(queue.display());
    }    
}
class ArrayQueue 
{
    int items[];
    int front=0;
    int rear=0;
    int count=0;
    ArrayQueue(int size)
    {
        items=new int[size];
    }
    void enqueue(int value)
    {
        if(count==items.length)
            throw new IllegalStateException();
        items[rear]=value;
        rear=(rear+1)%items.length;
        count++;
    }
    int dequeue()
    {
        if(count==0)
            throw new IllegalStateException();
        int value=items[front];
        items[front]=0;
        front=(front+1)%items.length;
        count--;
        return value;
    }
    int size()
    {
        return count;
    }
    int peek()
    {
        if(count==0)
            throw new IllegalStateException();
        return items[front];
    }
    boolean isEmpty()
    {
        return count==0;
    }
    boolean isFull()
    {
        return count==items.length;
    }
    String display()
    {
        return Arrays.toString(items);
    }
}
