import java.util.ArrayList;

public class StackUsingList {
    ArrayList<Integer> list=new ArrayList<>();
    public void push(int value)
    {
        list.add(value);
    }
    public int pop()
    {
        if(list.isEmpty())
            throw new IllegalStateException();
        return list.remove(list.size()-1);
    }
    public int peek()
    {
        if(list.isEmpty())
            throw new IllegalStateException();
        return list.get(list.size()-1);
    }

}
