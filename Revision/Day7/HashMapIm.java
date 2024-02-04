import java.util.*;
public class HashMapIm {
    private class Entry
    {
        int data;
        String value;
        Entry(int data,String value)
        {
            this.data=data;
            this.value=value;
        }
    }
    LinkedList<Entry>[] entries=new  LinkedList[5];
    private int hash(int key)
    {
        return key%entries.length;
    }
    public void put(int key,String value)
    {
        int index=hash(key);
        if(entries[index]==null)
            entries[index]=new LinkedList<>();
        var current=entries[index];
        if(entries[index]!=null)
        {
            for (Entry x:current)
            {
                if(x.data==key)
                {
                    x.value=value;
                    return;
                }
            }
        }
        Entry entry=new Entry(key,value);
        current.addLast(entry);
    }
    public String get(int key)
    {
        int index=hash(key);
        var current=entries[index];
        if(entries[index]!=null)
        {
            for(Entry x:current)
            {
                if(x.data==key)
                    return x.value;
            }
        }
        throw new IllegalStateException();
    }
    public void remove(int key)
    {
        int index=hash(key);
        var current=entries[index];
        if(entries[index]!=null)
        {
            for(Entry x:current)
            {
                if(x.data==key)
                    current.remove(x);
            }
        }
    }
    public boolean containsKey(int key)
    {
        int index=hash(key);
        var current=entries[index];
        if(entries[index]!=null)
        {
            for(Entry x:current)
            {
                if(x.data==key)
                    return true;
            }
        }
        return false;
    }
    public boolean containsValue(String value)
    {
        for (int i = 0; i < entries.length; i++) {
            var current=entries[i];
            if(entries[i]!=null)
            {
                for(Entry x:current)
                {
                    if(x.value==value)
                        return true;
                }
            }
        }
        return false;
    }
}
