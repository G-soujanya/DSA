import java.util.Arrays;

public class QueueUsingArray {
    int items[];
    int rear=0;
    int front=0;
    int count=0;
    QueueUsingArray(int size)
    {
        items=new int[size];
    }
    public void enqueue(int value)
    {
        if(isFull())
            throw new IllegalStateException();
        items[rear]=value;
        rear=(rear+1)%items.length;
        count++;
    }
    public int dequeue()
    {
        if(isEmpty())
            throw new IllegalStateException();
        int value=items[front];
        items[front]=0;
        front=(front+1)%items.length;
        count--;
        return value;
    }
    public boolean isFull()
    {
        return count==items.length;
    }
    public boolean isEmpty()
    {
        return count==0;
    }
    public int size()
    {
        return count;
    }
    public String display()
    {
        return Arrays.toString(items);
    }
    public int peek()
    {
        if(isEmpty())
            throw new IllegalStateException();
        return items[front];
    }

}
