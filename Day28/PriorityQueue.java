class PriorityQueue 
{
    public static void main(String args[])
    {
        QueueImplementation pq=new QueueImplementation();
        pq.enqueue(1);
        pq.enqueue(3);
        pq.enqueue(6);
        pq.enqueue(2);
        pq.enqueue(5);
        System.out.println(pq.dequeue());
        System.out.println(pq.peek());
        pq.display();
    }    
}
class QueueImplementation 
{
    int items[]=new int[5];
    int count=0;
    void enqueue(int value)
    {
        if(isFull())
            throw new IllegalStateException();
        int i;
        for(i=count-1;i>=0;i--)
        {
            if(items[i]>value)
            {
                items[i+1]=items[i];
            }
            else 
            {
                break;
            }
        }
        count++;
        items[i+1]=value;
    }
    int dequeue()
    {
        if(isEmpty())
            throw new IllegalStateException();
        int x=items[--count];
        items[count]=0;
        return x;
    }
    int peek()
    {
        if(isEmpty())
            throw new IllegalStateException();
        return items[count-1];
    }
    boolean isEmpty()
    {
        return count==0;
    }
    boolean isFull()
    {
        return count==items.length;
    }
    int size()
    {
        return count;
    }
    void display()
    {
        for(int i=0;i<count;i++)
        {
            System.out.print(items[i]+" ");
        }
    }
}
