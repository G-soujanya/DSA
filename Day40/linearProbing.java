import java.util.Arrays;
import java.util.NoSuchElementException;

class linearProbing 
{
    public static void main(String args[])
    {
        HashTableImp map=new HashTableImp();
        map.put(1, "hello");
        map.put(2,"hi");
        map.put(11,"light");
        map.put(3,"app");
        System.out.println(map);
        System.out.println(map.containsKey(11));
        System.out.println(map.containsValue("light"));
        map.remove(11);
        System.out.println(map.containsValue("light"));
        System.out.println(map.containsKey(11));
    }
}
class HashTableImp
{
    private class Entry 
    {
        int key;
        String value;
        Entry(int k,String v)
        {
            key=k;
            value=v;
        }
        public String toString()
        {
            return key+" : "+value;
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
    public void put(int key,String value)
    {
        if(isFull())
            throw new IllegalStateException();
        int index=hash(key);
        if(entries[index]!=null)
            entries[index].value=value;
        else
        {
        entries[index]=new Entry(key, value);
        count++;
        }
        
    }
    private int hash(int key)
    {
        int index=key%entries.length;
        int start=0;
        while(entries[start]!=null && start<entries.length)
        {
            if(entries[start].key==key)
                return key;
            start++;
        }
        while(entries[index]!=null)
        {
            index=(index+1)%entries.length;
        }
        return index;
    }
    private int getIndex(int key)
    {
        int index=key%entries.length;
        if(entries[index]==null)
            return index;
        if(entries[index].key==key)
            return index;
        int start=0;
        while(start<entries.length)
        {
            if(entries[start]!=null && entries[start].key==key)
                return start;
            start++;
        }
        return -1;
    }
    public String get(int key)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(index==-1 || entries[index]==null)
          throw new NoSuchElementException();
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
    public boolean containsValue(String va)
    {
        if(isEmpty())
            throw new IllegalStateException();
        int start=0;
        while(start<entries.length)
        {
            if(entries[start]!=null && entries[start].value==va)
            {
                return true;
            }
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
        if(isEmpty())
            throw new IllegalStateException();
        int index=getIndex(key);
        if(entries[index]==null)
            throw new NoSuchElementException();
        entries[index]=null;
        count--;
    }
}
