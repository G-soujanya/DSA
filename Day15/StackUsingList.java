import java.util.*;
class StackUsingList 
{
    static ArrayList<Integer> list;
    public static void main(String args[])
    {
        list=new ArrayList<>();
        push(10);
        push(20);
        pop();
        System.out.println(peek());

    }
    static void push(int data)
    {
        list.add(data);
    }
    static int pop()
    {
        int x;
        if(list.size()==0)
        {
            throw new EmptyStackException();
        }
        x=list.get(list.size()-1);
        list.remove(list.size()-1);
        return x;
    }
    static int peek()
    {
        int x;
        if(list.size()==0)
        {
            throw new EmptyStackException();
        }
        x=list.get(list.size()-1);
        return x;
    }
}