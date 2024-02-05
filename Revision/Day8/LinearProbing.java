import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinearProbing {
    private class Entry
    {
        int key;
        int value;
        Entry(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
        public String toString()
        {
            return key+" "+value;
        }
    }
    Entry[] entries=new Entry[10];
    private int count=0;
    private boolean isFull()
    {
        return count==entries.length;
    }
    private boolean isEmpty()
    {
        return count==0;
    }
    private int hash(int key)
    {
        int index=key%entries.length;
        int start=0;
        while (start<entries.length)
        {
            if(entries[start]!=null && entries[start].key==key)
                return start;
            start++;
        }
        while (entries[index]!=null)
        {
            index=(index+1)%entries.length;
        }
        return index;
    }
    public void put(int key,int value)
    {
        if(isFull())
            throw new IllegalStateException();
        int index=hash(key);
        if(entries[index]!=null)
            entries[index].value=value;
        else {
            Entry entry = new Entry(key, value);
            entries[index] = entry;
        }
        count++;
    }
    private int getIndex(int key)
    {
        int index=key%entries.length;
        if(entries[index]==null)
            return index;
        if(entries[index].key==key)
            return entries[index].key;
        int start=0;
        while (start<entries.length && entries[start]!=null)
        {
            if(entries[start].key==key)
                return start;
            start++;
        }
        return -1;
    }
    public int get(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(index==-1 || entries[index]==null)
            throw new IllegalStateException();

        return entries[index].value;

    }
    public boolean containsKey(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(index==-1 || entries[index]==null)
            return false;
        return true;
    }
    public boolean containsValue(int value)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int start=0;
        while (start<entries.length)
        {
            if(entries[start]!=null && entries[start].value==value)
                return true;
            start++;
        }
        return false;
    }
    public String toString()
    {
        return Arrays.toString(entries);
    }
    public void remove(int key)
    {
        if(isEmpty() || !containsKey(key))
            throw new IllegalStateException();
        int index=getIndex(key);
        if(entries[index]==null)
            throw new NoSuchElementException();
        entries[index]=null;
        count--;
    }
}
